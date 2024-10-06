package org.example.day3;

import org.example.day1.Day1;
import org.example.day2.Day2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day2Test {

    @Test
    void testPart1WithSampleData(){
        String result = Day2.day2(1, "src/test/resources/day2.txt");
        assertThat(result).isEqualTo("62811");
    }

    @Test
    void testPart2WithSampleData(){
        String result = Day2.day2(2, "src/test/resources/day2.txt");
        assertThat(result).isEqualTo("62811");
    }

}