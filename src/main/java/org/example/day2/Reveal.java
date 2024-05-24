package org.example.day2;

import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Builder
@Data
public class Reveal {
    private Integer red;
    private Integer green;
    private Integer blue;


    public static Reveal createFromLine(String line){
        RevealBuilder builder = Reveal.builder();
        List<String> splittedStrings = Arrays.stream(line.split(",")).map(String::strip).toList();
        for (String colorString : splittedStrings){
            if(colorString.contains("red")) builder.red(Integer.parseInt(colorString.split(" ")[0]));
            if(colorString.contains("green")) builder.green(Integer.parseInt(colorString.split(" ")[0]));
            if(colorString.contains("blue")) builder.blue(Integer.parseInt(colorString.split(" ")[0]));
        }
        return builder.build();
    }
}
