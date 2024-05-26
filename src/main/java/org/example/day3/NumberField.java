package org.example.day3;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class NumberField {
    final Integer value;
    final List<Coordinate> occupiedCoordinates;

    public boolean hasContactToThisCoordiante(Coordinate possiblyContactedCoordinate){
        List<Coordinate> allSurroundingCoordinates = occupiedCoordinates.stream()
                .flatMap(coordinate -> coordinate.getAllSurroundingCoordinates()
                        .stream()
                )
                .filter(everyCoordinate -> {
                    boolean isNotExactlyOneOfOccupiedCoordinates = true;
                    for (Coordinate exactlyOccupiedCoordinate : occupiedCoordinates){
                        if(exactlyOccupiedCoordinate.equalsOtherCoordinate(everyCoordinate)) isNotExactlyOneOfOccupiedCoordinates = false;
                    }
                    return isNotExactlyOneOfOccupiedCoordinates;
                })
                .toList();
        boolean isInContact = false;
        for(Coordinate coordinate : allSurroundingCoordinates){
            if(coordinate.equalsOtherCoordinate(possiblyContactedCoordinate)) isInContact = true;
        }
        return isInContact;
    }
}
