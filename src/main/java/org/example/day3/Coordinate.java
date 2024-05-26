package org.example.day3;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Builder
@Data
public class Coordinate {
    final Integer x;
    final Integer y;

    public boolean equalsOtherCoordinate(Coordinate coordinate){
        return Objects.equals(this.x, coordinate.x) && Objects.equals(this.y, coordinate.y);
    }

    public List<Coordinate> getAllSurroundingCoordinates(){
        return List.of(
                Coordinate.builder().x(this.x).y(this.y-1).build(), // Oben
                Coordinate.builder().x(this.x+1).y(this.y-1).build(), // Oben Rechts
                Coordinate.builder().x(this.x+1).y(this.y).build(), // Rechts
                Coordinate.builder().x(this.x+1).y(this.y+1).build(), // Unten Rechts
                Coordinate.builder().x(this.x).y(this.y+1).build(), // Unten
                Coordinate.builder().x(this.x-1).y(this.y+1).build(), // Unten Rechts
                Coordinate.builder().x(this.x-1).y(this.y).build(), // Links
                Coordinate.builder().x(this.x-1).y(this.y-1).build() // Oben Links
        );
    }
}
