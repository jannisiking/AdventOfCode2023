package org.example.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public interface Day3 {

    static String day3(int part){
        String result = "";

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/day3.txt"))) {
            List<String> lines = br.lines().toList();
            ArrayList<NumberField> numberFields = new ArrayList<>();
            for (int i = 0; i < lines.size(); i++) {
                numberFields.addAll(detectNumberFieldsOfLine(lines.get(i),i));
            }
            numberFields.forEach(System.out::println);

            switch (part){
                case 1: result = "Part1"; break;
                case 2: result = "Part2"; break;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return result;
    }

    private static List<NumberField> detectNumberFieldsOfLine(String line, Integer y){
        ArrayList<NumberField> result = new ArrayList<>();
        String[] characters = line.split("");
        List<String> numberChars = List.of("0","1","2","3","4","5","6","7","8","9");
        String number = "";
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        for(int x = 0; x < characters.length; x++){
            if(numberChars.contains(characters[x])){
                coordinates.add(Coordinate.builder().x(x).y(y).build());
                number += characters[x];
            }else{
                if(!number.isEmpty()){
                    result.add(
                            NumberField.builder()
                                    .value(Integer.parseInt(number))
                                    .occupiedCoordinates(coordinates)
                                    .build()
                    );
                    number = "";
                    coordinates = new ArrayList<>();
                }
            }
        }
        return result;
    }



}
