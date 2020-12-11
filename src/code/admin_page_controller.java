package code;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class admin_page_controller {

    List<LiveStock_dao> liveStockDaoList = new LinkedList<>();
    private int currently_loaded = 0;

    @FXML
    Button btn_logout;
    @FXML
    Button btn_next;
    @FXML
    Button btn_prev;

    @FXML
    TextField name;
    @FXML
    TextArea food;
    @FXML
    TextArea health;
    @FXML
    TextArea product;
    @FXML
    TextArea tips;


    public void next(){
        if (currently_loaded == liveStockDaoList.size()-1 ){
            name.setText("You are at the last record");
            return;
        }
        currently_loaded ++;
        load(liveStockDaoList.get(currently_loaded));
    }

    public void previous(){
        if (currently_loaded ==0 ){
            name.setText("You are at the first record");
            return;
        }
        currently_loaded --;
        load(liveStockDaoList.get(currently_loaded));
    }


    public void initialize(){
        datamanager datamanager = new datamanager();
        try {
            liveStockDaoList = datamanager.fetch_livestock();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        load(liveStockDaoList.get(currently_loaded));
    }

    public void load(LiveStock_dao current){
        name.setText(current.getStock_name());
        food.setText(current.getStock_food());
        health.setText(current.getStock_health());
        product.setText(current.getStock_product());
        tips.setText(current.getStock_tips());

    }

    public void refresh(){
        datamanager datamanager = new datamanager();
        liveStockDaoList.clear();
        try {
            liveStockDaoList.addAll(datamanager.fetch_livestock());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void back_to_main(){
        Stage thisStage = (Stage) btn_logout.getScene().getWindow();
        try{
            thisStage.setTitle("login");
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root);
            thisStage.setScene(scene);
            thisStage.show();
            thisStage.centerOnScreen();
        }catch(Exception e ){e.printStackTrace();}
    }

    public void save(){
        datamanager datamanager = new datamanager();
        String sname = name.getText();
        String sproduct = product.getText();
        String sfood = food.getText();
        String stip = tips.getText();
        String shealth = health.getText();
        LiveStock_dao add_me = new LiveStock_dao(sname,sfood,shealth,sproduct,stip);
        try {
            datamanager.add_record(add_me);
            refresh();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
