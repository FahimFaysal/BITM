package com.acrophillic.listviewcustomadamperdemo;

/**
 * Created by fahim on 7/11/2016.
 */
public class ContactTO {

    private String name;
    private String groupName;
    private String phoneName;
    private String emailId;

    public ContactTO(String name, String groupName, String phoneName, String emailId) {
        this.name = name;
        this.groupName = groupName;
        this.phoneName = phoneName;
        this.emailId = emailId;
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

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
