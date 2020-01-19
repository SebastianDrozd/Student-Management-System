package loginapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.dbConnection;
public class LoginModel {
    Connection connection;

    public LoginModel(){
        try {
            this.connection = dbConnection.getConnection();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        if (this.connection == null){
            System.out.println("fuck");
        }
    }

    public boolean isDatabaseConnected(){
        return this.connection != null;

    }

    public boolean isLogin(String user, String password, String opt) throws Exception{
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM login where username = ? and password = ? and division = ?";
        try{
            pr = this.connection.prepareStatement(sql);
            pr.setString(1,user);
            pr.setString(2, password);
            pr.setString(3, opt);

            rs = pr.executeQuery();

            boolean bool1;

            if (rs.next()){
                return true;
            }
            return false;

        }catch(Exception ex){
            return false;

        }
        finally{
            pr.close();
            rs.close();
        }
    }
}
