package com.tw;

public class MultiplicationTable {

    public static final String multipliedBy = "*";
    public static final String equals = "=";
    public static final String emptyString = "";
    public static final String doubleSpace = "  ";

    public String generateMultiplicationTable(int startNum, int endNum){
        boolean validateStartNumEndNum = validateStartNumEndNum(startNum, endNum);

        boolean validateStartNumRange = validateRange(endNum);

        boolean validateEndNumRange = validateRange(startNum);

        boolean validateRange = validateStartNumRange && validateEndNumRange;

        boolean isValid = validateStartNumEndNum && validateRange;

        return getMultiplicationTable(startNum, endNum, isValid);
    }

    private String getMultiplicationTable(int startNum, int endNum, boolean isValid) {
        String result = null;
        if(isValid){
            for (int secondNumber = startNum; secondNumber < endNum +1; secondNumber++) {
                for(int firstNumber = startNum; firstNumber <= secondNumber; firstNumber++){
                    result += firstNumber + multipliedBy + secondNumber + equals +(firstNumber*secondNumber);
                    result += secondNumber==firstNumber ? emptyString : doubleSpace;
                }
                if(secondNumber<endNum){
                    result += "\r\n";
                }
            }
            result = result.trim();
        }
        return result;
    }

    private boolean validateRange(int num) {
        if((num >= 1) && num <= 1000){
            return true;
        }

        return false;
    }

    private boolean validateStartNumEndNum(int startNum, int endNum) {
        if(startNum <= endNum){
            return true;
        }
        return false;
    }
}
