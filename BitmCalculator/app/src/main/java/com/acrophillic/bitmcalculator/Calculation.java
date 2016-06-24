package com.acrophillic.bitmcalculator;

public class Calculation {

    public String multiplication(String mainEquation) throws Exception {

        for (int i = 0; i < mainEquation.length(); i++) { // x
            if (mainEquation.charAt(i) == 'x') {
                String s1 = "", s2 = "";
                int p, n;

                for (p = i - 1; p >= 0; p--) {

                    if (!Character.isDigit(mainEquation.charAt(p)) && mainEquation.charAt(p) != '.') {
                        break;
                    }
                }
                p++;
                s1 = mainEquation.substring(p, i);
                System.out.println(s1 + "-----------------------------s1");

                for (n = i + 1; n < mainEquation.length(); n++) {// *********************************************
                    if (!Character.isDigit(mainEquation.charAt(n)) && mainEquation.charAt(n) != '.') {
                        break;
                    }

                }

                s2 = mainEquation.substring(i + 1, n);
                System.out.println(s2 + "______________________________s2");

                if (s1.isEmpty() || s2.isEmpty()) {
                    continue;
                }

                Double res = Double.parseDouble(s1) * Double.parseDouble(s2);
                System.out.println("res " + res);
                s1 = "";
                s1 += res;

                System.out.println("s1************" + s1);

                s2 = mainEquation.substring(0, p);
                System.out.println("s2************" + s2);

                mainEquation = s2 + s1 + mainEquation.substring(n, mainEquation.length());

                System.out.println("************" + mainEquation);
                i = p - 1;
            }
        }

        return mainEquation;
    }

    public String division(String mainEquation) throws Exception {

        for (int i = 0; i < mainEquation.length(); i++){
            if (mainEquation.charAt(i) == '/') {
                String s1 = "", s2 = "";
                int p, n;

                for (p = i - 1; p >= 0; p--) {

                    if (!Character.isDigit(mainEquation.charAt(p)) && mainEquation.charAt(p) != '.') {
                        break;
                    }
                }
                p++;
                s1 = mainEquation.substring(p, i);
                System.out.println(s1 + "-----------------------------s1");

                for (n = i + 1; n < mainEquation.length(); n++) {
                    if (!Character.isDigit(mainEquation.charAt(n)) && mainEquation.charAt(n) != '.') {

                        break;
                    }
                    // System.out.println(mainEquation.charAt(n));
                }

                s2 = mainEquation.substring(i + 1, n);
                System.out.println(s2 + "______________________________s2");

                if (s1.isEmpty() || s2.isEmpty()) {
                    continue;
                }
                Double res = Double.parseDouble(s1) / Double.parseDouble(s2);
                System.out.println("res " + res);
                s1 = "";
                s1 += res;

                System.out.println("s1************" + s1);

                s2 = mainEquation.substring(0, p);
                System.out.println("s2************" + s2);

                mainEquation = s2 + s1 + mainEquation.substring(n, mainEquation.length());

                System.out.println("************" + mainEquation);
                i = p - 1;
            }
        }
        return mainEquation;
    }

    public String summation(String mainEquation) throws Exception {

        for (int i = 0; i < mainEquation.length(); i++) {

            if (mainEquation.charAt(i) == '+' && i != 0) {

                String s1 = "", s2 = "";
                int p, n;

                for (p = i - 1; p >= 0; p--) {

                    if (!Character.isDigit(mainEquation.charAt(p)) && mainEquation.charAt(p) != '.') {
                        break;
                    }
                }

                p++;
                if (p != 0 && (mainEquation.charAt(p - 1) == '-' || mainEquation.charAt(p - 1) == '+')) {
                    p--;
                }
                s1 = mainEquation.substring(p, i);
                System.out.println(s1 + "-----------------------------s1");

                for (n = i + 1; n < mainEquation.length(); n++) {
                    if (!Character.isDigit(mainEquation.charAt(n)) && mainEquation.charAt(n) != '.') {
                        break;
                    }
                }

                s2 = mainEquation.substring(i + 1, n);
                System.out.println(s2 + "______________________________s2");

                if (s1.isEmpty() || s2.isEmpty()) {
                    continue;
                }
                Double res = Double.parseDouble(s1) + Double.parseDouble(s2);

                if (res > 0) {
                    s1 = "+";
                    s1 += res;
                } else {
                    s1 = "";
                    s1 += res;
                }

                System.out.println("res " + res);

                System.out.println("s1************" + s1);

                s2 = mainEquation.substring(0, p);
                System.out.println("s2************" + s2);

                i = p - 1;

                mainEquation = s2 + s1 + mainEquation.substring(n, mainEquation.length());

                System.out.println("************" + mainEquation);
            }
        }
        return mainEquation;
    }

    public String subtraction(String mainEquation) throws Exception {

        for (int i = 0; i < mainEquation.length(); i++) {
            if (mainEquation.charAt(i) == '-' && i != 0) {
                String s1 = "", s2 = "";
                int p, n;

                for (p = i - 1; p >= 0; p--) {

                    if (!Character.isDigit(mainEquation.charAt(p)) && mainEquation.charAt(p) != '.') {
                        break;
                    }
                }
                p++;
                if (p != 0 && (mainEquation.charAt(p - 1) == '-' || mainEquation.charAt(p - 1) == '+')) {
                    p--;
                }
                s1 = mainEquation.substring(p, i);
                System.out.println(s1 + "-----------------------------s1");

                for (n = i + 1; n < mainEquation.length(); n++) {
                    if (!Character.isDigit(mainEquation.charAt(n)) && mainEquation.charAt(n) != '.') {
                        break;
                    }
                }

                s2 = mainEquation.substring(i + 1, n);
                System.out.println(s2 + "______________________________s2");

                if (s1.isEmpty() || s2.isEmpty()) {
                    continue;
                }
                Double res = Double.parseDouble(s1) - Double.parseDouble(s2);

                if (res > 0) {
                    s1 = "+";
                    s1 += res;
                } else {
                    s1 = "";
                    s1 += res;
                }

                System.out.println("res " + res);
                System.out.println("s1************" + s1);

                s2 = mainEquation.substring(0, p);
                System.out.println("s2************" + s2);

                mainEquation = s2 + s1 + mainEquation.substring(n, mainEquation.length());

                System.out.println("************" + mainEquation);
                i = p - 1;
            }
        }
        return mainEquation;
    }

}
