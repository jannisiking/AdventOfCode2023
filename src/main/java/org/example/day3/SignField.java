package org.example.day3;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SignField {
    final Character sign;
    final Coordinate coordinate;
}
