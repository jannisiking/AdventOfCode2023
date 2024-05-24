package org.example;

import static org.example.Day1.day1;

public class Main {
    public static void main(String[] args) {
        String result = "";

        switch (args[0]){
            case "1": result = day1(Integer.parseInt(args[1]));
        }

        System.out.println("######################");
        System.out.printf("Result: %s%n", result);
        System.out.println("######################");
    }


}