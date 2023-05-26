package com.dh.TODO.dao;
import java.sql.*;
import java.util.ArrayList;

import com.dh.TODO.model.list;
import com.dh.TODO.model.user;
import com.dh.TODO.util.DBUtil;
import com.dh.TODO.util.Reader;


public class listDao {
    Reader sc = new Reader();
    DBUtil db = new DBUtil();
    Connection conn=db.getConnection();
        
    
    public void addTask(list l){
        ResultSet set = null;
        try{
            String sql = "insert into list (user_id,task_name) values (?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql); 
            pstm.setInt(1,userDao.us.getUserId());
            pstm.setString(2,l.getTaskName());
            pstm.executeUpdate();
            db.closePSandRS(pstm,set);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteTask(user u){
        ResultSet set = null;
        try{
            String sql = "delete from list where user_id=?";
            PreparedStatement pstm = conn.prepareStatement(sql); 
            pstm.setInt(1,u.getUserId());
            pstm.executeUpdate();
            db.closePSandRS(pstm,set);

        }catch(Exception e){
            e.printStackTrace();
        }

       
    }
    public void view(user u){
        ArrayList<list> out=new ArrayList<>();
            try{
                String sql ="select task_id,task_name from list where user_id=?";
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.setInt(1,u.getUserId());
                ResultSet set =  pstm.executeQuery();
                
                while(set.next()){
                    list l=new list();
                    l.setTaskId(set.getInt(1));
                    l.setTaskName(set.getString(2));

                    out.add(l);
                    System.out.println("Task_id:"+set.getInt(1));
                    System.out.println("Task_name:"+set.getString(2));
                }
                db.closePSandRS(pstm,set);

            }catch(Exception e){
                e.printStackTrace();
            }
    }

  
    
}
