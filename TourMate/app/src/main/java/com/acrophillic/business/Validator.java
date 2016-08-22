package com.acrophillic.business;

import android.util.Log;

/**
 * Created by fahim on 7/23/2016.
 */
public class Validator {



    public boolean checkPassWord(User user)throws Exception{

        if(user.getPassWord() != null && !user.getPassWord().isEmpty() && user.getPassWord().equals(user.getConfirmPassWord())){
            return true;
        }else {
//            Log.d("check pass",user.getPassWord()+"======="+user.getConfirmPassWord() );
            throw new Exception("please recheck you password");

        }


    }

    public boolean checkUser(User user) throws Exception{
/*if(){

}*/
      return true;
    }


    public boolean checkPasswod(User user) throws Exception{
/*if(){

}*/
        return true;
    }




}
