package com.dh.TODO;

import com.dh.TODO.service.taskService;
import com.dh.TODO.service.userService;
import com.dh.TODO.util.Reader;


public class TODO {
    public static void main(String[] args) {
        Reader sc = new Reader();
        userService us = new userService();
        taskService t = new taskService();
        //user u =new user();
        int option1 = 0;
        while(option1 !=-1){
            System.out.println("1. USER LOGIN");
            System.out.println("2. NEW USER");
            System.out.println("3. EXIT");
            int option = sc.nextInt();

            if(option ==1){
                us.loginUser();
       
                    us.user();
                
                int option2=sc.nextInt();
                if(option2 ==1){
                    t.addTask();
                }else if(option2 == 2){
                    t.view();
                }else if(option2 == 3){
                    t.deleteTask();
                }else{
                    return;
                }
            }else if(option ==2){
                us.newUser();
            }else {
                return;
            }
        }
    }
}


