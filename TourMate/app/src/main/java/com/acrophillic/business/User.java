package com.acrophillic.business;

import android.graphics.Bitmap;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by fahim on 7/23/2016.
 */

public class User implements Serializable {


   private int id;

    private String firstName;
    private String secondName;
    private String email;
    private String phone;

    private String passWord;
    private String confirmPassWord;

    private Calendar DOB;
    private String sex;

    private byte[] picture;




 public User(String firstName, String secondName, String email, String phone, String passWord, String confirmPassWord, Calendar DOB, String sex, byte[] picture) {
  this.firstName = firstName;
  this.secondName = secondName;
  this.email = email;
  this.phone = phone;
  this.passWord = passWord;
  this.confirmPassWord = confirmPassWord;
  this.DOB = DOB;
  this.sex = sex;
  this.picture = picture;
 }

 public User(String firstName, String secondName, String email, String phone, String passWord, Calendar DOB, String sex, byte[] picture) {
  this.firstName = firstName;
  this.secondName = secondName;
  this.email = email;
  this.phone = phone;
  this.passWord = passWord;
  this.DOB = DOB;
  this.sex = sex;
  this.picture = picture;
 }

 public User(int id, String firstName, String secondName, String email, String phone, String passWord, Calendar DOB, String sex, byte[] picture) {
  this.id = id;
  this.firstName = firstName;
  this.secondName = secondName;
  this.email = email;
  this.phone = phone;
  this.passWord = passWord;
  this.DOB = DOB;
  this.sex = sex;
  this.picture = picture;
 }

 public User(int id, String firstName, String secondName, String email, String phone, String passWord,String confirmPassWord, Calendar DOB, String sex, byte[] picture) {
  this.id = id;
  this.firstName = firstName;
  this.secondName = secondName;
  this.email = email;
  this.phone = phone;
  this.passWord = passWord;
  this.confirmPassWord = confirmPassWord;
  this.DOB = DOB;
  this.sex = sex;
  this.picture = picture;
 }

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getFirstName() {
  return firstName;
 }

 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }

 public byte[] getPicture() {
  return picture;
 }

 public void setPicture(byte[] picture) {
  this.picture = picture;
 }

 public String getSex() {
  return sex;
 }

 public void setSex(String sex) {
  this.sex = sex;
 }

 public Calendar getDOB() {
  return DOB;
 }

 public void setDOB(Calendar DOB) {
  this.DOB = DOB;
 }

 public String getConfirmPassWord() {
  return confirmPassWord;
 }

 public void setConfirmPassWord(String confirmPassWord) {
  this.confirmPassWord = confirmPassWord;
 }

 public String getPassWord() {
  return passWord;
 }

 public void setPassWord(String passWord) {
  this.passWord = passWord;
 }

 public String getPhone() {
  return phone;
 }

 public void setPhone(String phone) {
  this.phone = phone;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public String getSecondName() {
  return secondName;
 }

 public void setSecondName(String secondName) {
  this.secondName = secondName;
 }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", passWord='" + passWord + '\'' +
                ", confirmPassWord='" + confirmPassWord + '\'' +
                ", DOB=" + DOB +
                ", sex='" + sex + '\'' +
                ", picture=" + Arrays.toString(picture) +
                '}';
    }
}
