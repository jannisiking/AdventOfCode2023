package org.example.day3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day3Test {

    @Test
    void testPart1WithSampleData(){
        String result = Day3.day3(1, "src/test/resources/day3_part1.txt");
        assertThat(result).isEqualTo("4361");
    }

    @Test
    void testPart2WithSampleData(){
        String result = Day3.day3(2, "src/test/resources/day3_part2.txt");
        assertThat(result).isEqualTo("467835");
    }

}