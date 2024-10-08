package org.example.day4;

import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@Builder
public class Card {

    private Integer cardId;
    private List<Integer> winningNumbers;
    private List<Integer> numbersYouHave;

    public static Card createCardFromInput(String input){
        Integer cardId = Integer.valueOf(input.split(":")[0].replace("Card", "").trim());

        List<Integer> winningNumbers = Arrays.stream(input.split(":")[1].split("\\|")[0].split(" ")).filter(possibleEmpty -> !possibleEmpty.isEmpty()).map(Integer::valueOf).toList();
        List<Integer> numbersYouHave = Arrays.stream(input.split(":")[1].split("\\|")[1].split(" ")).filter(possibleEmpty -> !possibleEmpty.isEmpty()).map(Integer::valueOf).toList();

        return Card.builder()
                .cardId(cardId)
                .winningNumbers(winningNumbers)
                .numbersYouHave(numbersYouHave)
                .build();

    }

    private List<Integer> getNumbersInBothLists(){
        return winningNumbers
                .stream()
                .filter(winningNumber -> numbersYouHave.contains(winningNumber))
                .toList();
    }

    public Double calculatePointsOfCard(){
        List<Integer> numbersInBothLists = this.getNumbersInBothLists();
        if(numbersInBothLists.isEmpty()) return 0d;
        return Math.pow(2, (numbersInBothLists.size()-1));
    }
}
