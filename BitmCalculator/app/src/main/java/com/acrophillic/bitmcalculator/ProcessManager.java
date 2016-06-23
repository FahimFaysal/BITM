package com.acrophillic.bitmcalculator;

public class ProcessManager {

    private Validation validation = new Validation();
    private Calculation calculation = new Calculation();

    public String process(String mainEquation){

        try {
            if(validation.preValidation(mainEquation)) {

                mainEquation = calculation.multiplication(mainEquation);

                mainEquation = calculation.division(mainEquation);

                mainEquation = calculation.summation(mainEquation);

                mainEquation = calculation.subtraction(mainEquation);


            }
        }catch (Exception e){
            return e.getMessage();
        }

        return mainEquation;
    }
}
