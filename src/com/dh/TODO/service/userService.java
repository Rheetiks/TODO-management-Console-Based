package com.dh.TODO.service;

import com.dh.TODO.dao.userDao;
import com.dh.TODO.model.user;
import com.dh.TODO.util.Reader;

public class userService {
    user u = new user();
    userDao d = new userDao();
    Reader sc = new Reader();

    public void newUser() {

        System.out.println("Enter your username");
        u.setUserName(sc.nextLine());
        System.out.println("Enter your gmail");
        u.setUserGmail(sc.nextLine());
        System.out.println("Enter your password");
        u.setUserPassword(sc.nextLine());
        System.out.println("Enter your phone no");
        u.setPhoneNo(sc.nextLong());
        d.newuser(u);
        System.out.println("\nUSER ADDED");

    }

    public void loginUser() {
        user out = new user();
        while (out.getResult() != "success") {
            System.out.println("Enter your username");
            u.setUserName(sc.nextLine());
            System.out.println("Enter your password");
            u.setUserPassword(sc.nextLine());
            out = d.loginUser(u);
        }

    }

    public void user() {
        System.out.println("1. ENTER YOUR TASK");
        System.out.println("2. VIEW YOUR TASKS");
        System.out.println("3. DELETE YOUR TASKS");
        System.out.println("4. EXIT");
    }

}
