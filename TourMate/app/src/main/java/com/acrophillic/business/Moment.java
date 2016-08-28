package com.acrophillic.business;

import java.util.Arrays;

/**
 * Created by fahim on 8/27/2016.
 */
public class Moment {

    private int momentId;
    private int tourId;
    private String note;
    private byte[] picture;


    public String getNote() {
        return note;
    }

    public int getMomentId() {
        return momentId;
    }

    public void setMomentId(int momentId) {
        this.momentId = momentId;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }


    @Override
    public String toString() {
        return "Moment{" +
                "momentId=" + momentId +
                ", tourId=" + tourId +
                ", note='" + note + '\'' +
                ", picture=" + Arrays.toString(picture) +
                '}';
    }
}
