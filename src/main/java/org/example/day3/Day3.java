package org.example.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public interface Day3 {

    static String day3(int part, String filePath) {
        String result = "";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<String> lines = br.lines().toList();
            ArrayList<NumberField> numberFields = new ArrayList<>();
            ArrayList<SignField> signFields = new ArrayList<>();
            for (int i = 0; i < lines.size(); i++) {
                numberFields.addAll(detectNumberFieldsOfLine(lines.get(i), i));
                signFields.addAll(detectSignFieldsOfLine(lines.get(i), i));
            }

            switch (part) {
                case 1:
                    result = part1(numberFields, signFields);
                    break;
                case 2:
                    result = "Part2";
                    break;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return result;
    }

    private static List<NumberField> detectNumberFieldsOfLine(String line, Integer y) {
        ArrayList<NumberField> result = new ArrayList<>();
        String[] characters = line.split("");
        List<String> numberChars = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        String number = "";
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        for (int x = 0; x < characters.length; x++) {
            if (numberChars.contains(characters[x])) {
                coordinates.add(Coordinate.builder().x(x).y(y).build());
                number += characters[x];
            } else {
                if (!number.isEmpty()) {
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
        if (!number.isEmpty()) {
            result.add(
                    NumberField.builder()
                            .value(Integer.parseInt(number))
                            .occupiedCoordinates(coordinates)
                            .build()
            );
        }
        return result;
    }

    private static List<SignField> detectSignFieldsOfLine(String line, Integer y) {
        ArrayList<SignField> result = new ArrayList<>();
        String[] characters = line.split("");
        List<String> signChars = List.of("%","=","*","#","$","&","/","-","+","@",",");
        for (int x = 0; x < characters.length; x++) {
            if (signChars.contains(characters[x])) {
                result.add(
                        SignField.builder()
                                .sign(characters[x].charAt(0))
                                .coordinate(Coordinate.builder().x(x).y(y).build())
                                .build()
                );
            }
        }
        return result;
    }

    private static String part1(List<NumberField> numberFields, List<SignField> signFields) {
        ArrayList<NumberField> numberFieldsWithContactToSign = new ArrayList<>();
        for (NumberField numberField : numberFields) {
            boolean hasContactToAnySign = false;
            for (SignField signField : signFields) {
                if (numberField.hasContactToThisCoordiante(signField.coordinate)) hasContactToAnySign = true;
            }
            if (hasContactToAnySign) numberFieldsWithContactToSign.add(numberField);
        }
        numberFieldsWithContactToSign.forEach(System.out::println);
        Integer resultSum = 0;
        for(NumberField numberField: numberFieldsWithContactToSign){
            resultSum += numberField.value;
        }
        return resultSum.toString();
    }
}
