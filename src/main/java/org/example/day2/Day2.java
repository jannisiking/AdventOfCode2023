package org.example.day2;

import java.io.BufferedReader;
import java.io.FileReader;

public interface Day2 {

    static String day2(int part){

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/day2.txt"))) {
            for (String line : br.lines().toList()) {
                Game game = Game.createFromLine(line);
            }
        } catch (Exception e) {
            System.err.println(e);
        }


        return "";
    }


}
