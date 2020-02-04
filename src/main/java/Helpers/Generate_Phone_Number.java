package Helpers;

import java.util.Random;

public class Generate_Phone_Number {

    public String getRandomNumber()
    {
        int number1, number2;
        int set2, set3;
        Random generator = new Random();
        number1 = 0;
        number2 = generator.nextInt(8) + 1;
        set2 = generator.nextInt(999) + 100;
        set3 = generator.nextInt(999) + 1000;
        String phoneNumber = number1 + "" + number2 + "" + number1 + " " + set2 + " " + set3;
        return phoneNumber;
    }
}
