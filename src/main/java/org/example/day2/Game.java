package org.example.day2;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Game {
    private Integer gameNumber;
    private List<Reveal> reveals;

    public static Game createFromLine(String line){
        // GameNumber auslesen
        Integer gameNumber = Integer.parseInt(line.split(":")[0].split(" ")[1]);
        // String der Reveals parsen und das zum Erstellen an die Reveal Methode geben
        ArrayList<Reveal> revealList = new ArrayList<>();
        for(String subline : line.split(":")[1].split(";")){
            revealList.add(Reveal.createFromLine(subline));
        }

        return Game.builder()
                .gameNumber(gameNumber)
                .reveals(revealList)
                .build();
    }
}
