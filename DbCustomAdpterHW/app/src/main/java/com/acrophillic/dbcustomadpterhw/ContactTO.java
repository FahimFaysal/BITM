package com.acrophillic.dbcustomadpterhw;

/**
 * Created by fahim on 7/11/2016.
 */
public class ContactTO {

    private int id;
    private String name;
    private String groupName;
    private String phoneNo;
    private String emailId;

    public ContactTO(String name, String groupName, String phoneName, String emailId) {
        this.name = name;
        this.groupName = groupName;
        this.phoneNo = phoneName;
        this.emailId = emailId;
    }

    public ContactTO(int id, String name,  String groupName, String phoneName, String emailId) {
        this.name = name;
        this.id = id;
        this.groupName = groupName;
        this.phoneNo = phoneName;
        this.emailId = emailId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return id+", "+name+", "+groupName+","+phoneNo+", "+emailId+"\n";
    }
}
