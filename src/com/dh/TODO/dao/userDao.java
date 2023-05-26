package com.dh.TODO.dao;
import com.dh.TODO.model.user;
import com.dh.TODO.util.DBUtil;
import java.sql.*;
import java.sql.Connection;


public class userDao {
    //user u = new user();
  
    DBUtil db=new DBUtil();
    Connection conn=db.getConnection();
    public static user us=new user();
   

    public void newuser(user u){
        ResultSet set = null;
        try{
            String sql = "insert into user(username,gmail,password,phone_no) values(?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql); 
            pstm.setString(1,u.getUserName());
            pstm.setString(2,u.getUserGmail());
            pstm.setString(3,u.getUserPassword());
            pstm.setLong(4,u.getPhoneNo());
            
            pstm.executeUpdate();
            db.closePSandRS(pstm,set);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public user loginUser(user u){
        
        user out = new user();
        try{
                String sql = "select user_id from user where username=? and password = ?";
                PreparedStatement pstm = conn.prepareStatement(sql); 
                pstm.setString(1,u.getUserName());
                pstm.setString(2,u.getUserPassword());
                ResultSet set = pstm.executeQuery();
                if(set.next()){
                    System.out.println("user authenticated successfully");
                    
                    us.setUserId(set.getInt("user_id"));
                    out.setResult("success");
              
                }else{
                    System.out.println("USER NAME OR PASSWORD WRONG");
                
                    out.setResult("failure");
                }
            
              db.closePSandRS(pstm,set);
              
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return out;
    }

    
}
