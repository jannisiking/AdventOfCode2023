package org.example.day3;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Coordinate {
    final Integer x;
    final Integer y;
}
