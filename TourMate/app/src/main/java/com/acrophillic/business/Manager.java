package com.acrophillic.business;

import android.content.Context;
import android.util.Log;


import com.acrophillic.persistence.Service;

/**
 * Created by fahim on 7/23/2016.
 */
public class Manager {

    String message;// = "Registration Successful";

    public String addNewUser(Context context, User user) throws Exception{


            if (new Validator().checkPassWord(user)) {

                message = new Service(context).addUser(user);
            }


        return message;
    }

    public String updateUserManager(Context context, User user) throws Exception {


            if (new Validator().checkPassWord(user)) {

                message = new Service(context).updateUser(user);
            }


        return message;
    }

    public int getUserByNamePass(Context context, String name, String pass)throws Exception {
//        Log.d("manager", "i am here-----------------1");
        int id = 0;
         id = new Service(context).getUserByNamePass(name, pass);
//        Log.d("manager", "i am here-----------------2");
        if(id == 0){
            throw new Exception("No id found !!");
        }

        return id;
    }

    public User getUserByIdManger(Context context, int id) throws Exception{
        User user = null;
//        Log.d("man====", "let me set here*****************************");
        user = new Service(context).getUserByID(id);


        if (user == null){
            throw new Exception("No user found :( ");
        }
        else{
            return user;
        }
    }

}
