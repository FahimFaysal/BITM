package com.acrophillic.business;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by fahim on 8/26/2016.
 */
public class Tour {

    private int usrId;
    private int tourId;

    private String tourName;
    private String toPlace;
    private String fromPlace;
    private long budget;
    private Calendar startDate;
    private Calendar endDate;
    private ArrayList<Cost> costArrayList;


    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public ArrayList<Cost> getCostArrayList() {
        return costArrayList;
    }

    public void setCostArrayList(ArrayList<Cost> costArrayList) {
        this.costArrayList = costArrayList;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }
}
