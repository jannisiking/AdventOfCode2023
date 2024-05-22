package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/day1.txt"))) {
            String result = day1(br, 1);
            System.out.println(result);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            System.out.println("FINISHED");
        }
    }

    private static String day1(BufferedReader bufferedReader, int part) {
        Integer result = 0;

        for (String line : bufferedReader.lines().toList()) {
            Integer evaluatedLine = evaluateLine(line, part);
            result += evaluatedLine;
        }
        return result.toString();
    }

    private static Integer evaluateLine(String line, int part) {
        Integer firstNumber = null;
        Integer lastNumber = null;
        while (!line.isEmpty()) {
            Integer checkedNumber = 0;
            if (part == 1) checkedNumber = checkIfStringStartsWithNumberStringPart1(line);
            if (part == 2) checkedNumber = checkIfStringStartsWithNumberStringPart2(line);
            if (firstNumber == null && checkedNumber != null) firstNumber = checkedNumber;
            if (checkedNumber != null) lastNumber = checkedNumber;
            line = line.substring(1);
        }

        // String Contains only numbers. Only leave first and last and return as integer
        return Integer.parseInt((firstNumber.toString()) + (lastNumber.toString()));
    }


    private static Integer checkIfStringStartsWithNumberStringPart1(String line) {
        Map<Integer, Set<String>> numberStrings = Map.of(
                1, Set.of("1"),
                2, Set.of("2"),
                3, Set.of("3"),
                4, Set.of("4"),
                5, Set.of("5"),
                6, Set.of("6"),
                7, Set.of("7"),
                8, Set.of("8"),
                9, Set.of("9")
        );

        for (var entry : numberStrings.entrySet()) {
            for (String numberString : entry.getValue()) {
                if (line.toLowerCase().startsWith(numberString)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    private static Integer checkIfStringStartsWithNumberStringPart2(String line) {
        Map<Integer, Set<String>> numberStrings = Map.of(
                1, Set.of("1", "one"),
                2, Set.of("2", "two"),
                3, Set.of("3", "three"),
                4, Set.of("4", "four"),
                5, Set.of("5", "five"),
                6, Set.of("6", "six"),
                7, Set.of("7", "seven"),
                8, Set.of("8", "eight"),
                9, Set.of("9", "nine")
        );

        for (var entry : numberStrings.entrySet()) {
            for (String numberString : entry.getValue()) {
                if (line.toLowerCase().startsWith(numberString)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }
}