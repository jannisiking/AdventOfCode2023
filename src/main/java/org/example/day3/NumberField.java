package org.example.day3;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class NumberField {
    final Integer value;
    final List<Coordinate> occupiedCoordinates;
}
