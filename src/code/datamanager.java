package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class datamanager {

    public String verify_credentials(String username , String password ) throws ClassNotFoundException, SQLException {
        Connection con = database_connection.database_connection();
        String sql_query = "select * from (users) where username = ? and pass= ? ;";
        PreparedStatement pst = con.prepareStatement(sql_query) ;
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs1 = pst.executeQuery();
        //rs1.first();

        //System.out.print(rs1);
        if (rs1.next()) {

            String type = rs1.getString("user_type");
            con.close();
            pst.close();
            return type;
        }else {

            String not_found = "none";
            con.close();
            pst.close();
            return not_found;
        }
    }

    public List<LiveStock_dao> fetch_livestock() throws SQLException {
        List<LiveStock_dao> liveStockDaoList = new LinkedList<>();
        Connection con = database_connection.database_connection();
        String sql = "select * from livestock_details;";
        PreparedStatement pst1 = con.prepareStatement(sql);
        ResultSet rs2 = pst1.executeQuery();
        /**
        String sname = rs2.getString("stock_name");
        String sfood = rs2.getString("stock_food");
        String shealth = rs2.getString("stock_health");
        String sproduct = rs2.getString("stock_product");
        String stips = rs2.getString("stock_tips");
        LiveStock_dao curr = new LiveStock_dao(sname,sfood,shealth,sproduct,stips);
        liveStockDaoList.add(curr);
         **/
        while(rs2.next()){
            //stock_name,stock_food,stock_health,stock_product,stock_tips
            String stock_name = rs2.getString("stock_name");
            String stock_food = rs2.getString("stock_food");
            String stock_health = rs2.getString("stock_health");
            String stock_product = rs2.getString("stock_product");
            String stock_tips = rs2.getString("stock_tips");
            LiveStock_dao current = new LiveStock_dao(stock_name,stock_food,stock_health,stock_product,stock_tips);
            liveStockDaoList.add(current);

        }


        return liveStockDaoList;
    }

    public String delete_record(String name ){
        Connection con = database_connection.database_connection();
        String sql = "";

        return "success";
    }

    public void add_record(LiveStock_dao add_me ) throws SQLException {
        Connection  con = database_connection.database_connection();
        String sql ="insert into livestock_details(stock_name,stock_food,stock_health,stock_product,stock_tips ) " +
                "values('"+add_me.getStock_name()+"', '"+add_me.getStock_food()+"', '"+add_me.getStock_health()+"'," +
                " '"+add_me.getStock_product()+"','"+add_me.getStock_tips()+"');";
        PreparedStatement pst= con.prepareStatement(sql);
        pst.execute();
    }

}
