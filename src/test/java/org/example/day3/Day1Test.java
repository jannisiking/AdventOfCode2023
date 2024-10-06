package org.example.day3;

import org.example.day1.Day1;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day1Test {

    @Test
    void testPart1WithSampleData(){
        String result = Day1.day1(1, "src/test/resources/day1.txt");
        assertThat(result).isEqualTo("54968");
    }

    @Test
    void testPart2WithSampleData(){
        String result = Day1.day1(2, "src/test/resources/day1.txt");
        assertThat(result).isEqualTo("54094");
    }

}