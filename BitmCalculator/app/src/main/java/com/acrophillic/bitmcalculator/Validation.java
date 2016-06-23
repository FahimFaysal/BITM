package com.acrophillic.bitmcalculator;

public class Validation {

    public Boolean preValidation(String mainEquation) throws Exception{

        if (mainEquation.charAt(0) == 'x' || mainEquation.charAt(0) == '/') {
//            return "wrong equation";
            throw  new Exception("wrong equation");
        } else if (!Character.isDigit(mainEquation.charAt(mainEquation.length() - 1)) && mainEquation.charAt(mainEquation.length() - 1) != '.') {

            throw  new Exception("wrong equation");
        } /* else {
            for (int i = 0; i < mainEquation.length() - 1; i++) {
                if (!Character.isDigit(mainEquation.charAt(i)) && !Character.isDigit(mainEquation.charAt(i + 1))) {
                    return "wrong equation3";
                }
            }*/


        return true;
    }

}
