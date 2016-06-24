package com.acrophillic.bitmcalculator;

import android.util.Log;

public class ProcessManager {

    private Validation validation = new Validation();
    private Calculation calculation = new Calculation();

    public String process(String mainEquation) {

        try {
            if (validation.preValidation(mainEquation)) {

                mainEquation = calculation.multiplication(mainEquation);

                mainEquation = calculation.division(mainEquation);

                mainEquation = calculation.summation(mainEquation);

                mainEquation = calculation.subtraction(mainEquation);


            }
        } catch (Exception e) {
            return e.getMessage();
        }
        return finalForm(mainEquation);
    }

    private String finalForm(String mainEquation) {

        while (mainEquation.contains(".")) {

            if (mainEquation.equals(".")) {
                mainEquation = "";
                break;
            } else if (mainEquation.charAt(mainEquation.length() - 1) == '0') {
                mainEquation = mainEquation.substring(0, mainEquation.length() - 2);

            } else if (mainEquation.charAt(mainEquation.length() - 1) == '.') {
                System.out.println("i am here................");
                mainEquation.replace(".", "");
                break;
            } else {
                break;
            }
        }

        if (!mainEquation.isEmpty() && mainEquation.charAt(0) == '+') {
            mainEquation = mainEquation.substring(1, mainEquation.length());
        }

        if (mainEquation.equalsIgnoreCase("Infinity")) {
            return "x/0 ! does not make sense";
        }

        Log.d("final raw return", mainEquation);
        return mainEquation;
    }
}
