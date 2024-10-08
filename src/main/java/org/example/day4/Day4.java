package org.example.day4;

import org.example.day3.Coordinate;
import org.example.day3.NumberField;
import org.example.day3.SignField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public interface Day4 {

    static Double part1(String filePath){
        Double result = 0d;
        for(Card card: createCardsFromFileInput(filePath)){
            result += card.calculatePointsOfCard();
        }
        return result;
    }

    static List<Card> createCardsFromFileInput(String filePath){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<String> lines = br.lines().toList();
            ArrayList<Card> cards = new ArrayList<>();

            for(String line:lines){
                cards.add(Card.createCardFromInput(line));
            }
            return cards;
        } catch (Exception e) {
            System.err.println(e);
        }
        return List.of();
    }
}
