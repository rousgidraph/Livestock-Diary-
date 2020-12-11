package code;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class login_controller {
    datamanager datamanager;
    @FXML
    Button btn_login;
    @FXML
    Button btn_cancel;
    @FXML
    TextField username;
    @FXML
    PasswordField password;

    public void user_page(){
        Stage thisStage = (Stage) btn_login.getScene().getWindow();
        try{
            thisStage.setTitle("User");
            Parent root = FXMLLoader.load(getClass().getResource("user_page.fxml"));
            Scene scene = new Scene(root);
            thisStage.setScene(scene);
            thisStage.show();
            thisStage.centerOnScreen();
        }catch(Exception e ){e.printStackTrace();}
    }

    public void admin_page(){
        Stage thisStage = (Stage) btn_login.getScene().getWindow();
        try{
            thisStage.setTitle("Admin");
            Parent root = FXMLLoader.load(getClass().getResource("admin_page.fxml"));
            Scene scene = new Scene(root);
            thisStage.setScene(scene);
            thisStage.show();
            thisStage.centerOnScreen();
        }catch(Exception e ){e.printStackTrace();}
    }

    public void verify_credentials(){
        String name = username.getText();
        String pass = password.getText();
        datamanager = new datamanager();
        try {
            String result = datamanager.verify_credentials(name, pass);
            if (result.compareTo("administrator") == 0){
                admin_page();
                return;
            }else if (result.compareTo("User") == 0){
                user_page();
            }else{
                username.setText("Invalid credentials");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("problem logging in");
        }
    }
}
