package com.dh.TODO.service;


import com.dh.TODO.model.list;
import com.dh.TODO.model.user;
import com.dh.TODO.util.Reader;
import  com.dh.TODO.dao.*;

public class taskService {
    user u = new user();
    list l = new list();
    listDao d = new listDao();
    Reader sc = new Reader();

    public void addTask(){

        System.out.println("PLEASE ENTER YOUR TODO TASK");
        l.setTaskName(sc.nextLine());
        d.addTask(l);

    }
    public void deleteTask(){
        Reader sc = new Reader();
        System.out.println("ENTER USER ID");
        u.setUserId(sc.nextInt());
        d.deleteTask(u);

    }

    public void view(){
        System.out.println("ENTER USER ID");
        u.setUserId(sc.nextInt());
        d.view(u);

    }
}
