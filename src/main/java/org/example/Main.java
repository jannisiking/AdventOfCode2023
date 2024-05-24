package org.example;

import static org.example.day1.Day1.day1;
import static org.example.day2.Day2.day2;

public class Main {
    public static void main(String[] args) {
        String result = "";

        switch (args[0]){
            case "1": result = day1(Integer.parseInt(args[1]));
            case "2": result = day2(Integer.parseInt(args[1]));
        }

        System.out.println("######################");
        System.out.printf("Result: %s%n", result);
        System.out.println("######################");
    }


}