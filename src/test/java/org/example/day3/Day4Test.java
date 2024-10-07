package org.example.day3;

import org.example.day4.Card;
import org.example.day4.Day4;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day4Test {

    @Test
    public void canParseInputStringToCard(){
        String inputString = "Card   1: 69 72 87 33 61 15  8 78 43 50 | 96 33 86 53 15 82 50 85 61  8 98 72 43 63 45 78 87 69 10 34 73 88 65 27 19";
        Card card = Card.createCardFromInput(inputString);

        assertThat(card.getCardId()).isEqualTo(1);
        assertThat(card.getWinningNumbers()).isEqualTo(List.of(69, 72, 87, 33, 61, 15, 8, 78, 43, 50));
        assertThat(card.getNumbersYouHave()).isEqualTo(List.of(96, 33, 86, 53, 15, 82, 50, 85, 61, 8, 98, 72, 43, 63, 45, 78, 87, 69, 10, 34, 73, 88, 65, 27, 19));
    }

    @Test
    public void canParseWholePuzzleInputToListOfCards(){
        List<Card> cards = Day4.createCardsFromFileInput("src/test/resources/day4.txt");
        assertThat(cards.size()).isEqualTo(196);
    }

}