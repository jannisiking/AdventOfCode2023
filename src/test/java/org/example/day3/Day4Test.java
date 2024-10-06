package org.example.day3;

import org.example.day4.Day4;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day4Test {

    @Test
    void testPart1WithSampleData(){
        String result = Day4.day4(1, "src/test/resources/day4.txt");
        assertThat(result).isEqualTo("4361");
    }

    @Test
    void testPart2WithSampleData(){
        String result = Day4.day4(2, "src/test/resources/day4.txt");
        assertThat(result).isEqualTo("467835");
    }

}