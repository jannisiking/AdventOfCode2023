package org.example.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public interface Day2 {

    Integer MAX_CUBES_RED = 12;
    Integer MAX_CUBES_GREEN = 13;
    Integer MAX_CUBES_BLUE = 14;

    static String day2(int part, String filePath){
        String result = "";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            ArrayList<Game> games = new ArrayList<>();
            for (String line : br.lines().toList()) {
                games.add(Game.createFromLine(line));
            }

            switch (part){
                case 1: result = part1(games);
                case 2: result = part2(games);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return result;
    }

    static String part1(List<Game> games){
        ArrayList<Game> gamesThatArePossible = new ArrayList<>();
        for(Game game : games){
            boolean isPossible = true;
            for (Reveal reveal: game.getReveals()){
                if(reveal.getRed()!=null && reveal.getRed()>MAX_CUBES_RED) isPossible = false;
                if(reveal.getGreen()!=null && reveal.getGreen()>MAX_CUBES_GREEN) isPossible = false;
                if(reveal.getBlue()!=null && reveal.getBlue()>MAX_CUBES_BLUE) isPossible = false;
            }
            if(isPossible) gamesThatArePossible.add(game);
        }

        Integer result = 0;

        for(Game game : gamesThatArePossible){
            result += game.getGameNumber();
        }
        return result.toString();
    }

    static String part2(List<Game> games){
        Integer result = 0;

        for(Game game: games){
            Integer minNeedRed = 0;
            Integer minNeedGreen = 0;
            Integer minNeedBlue = 0;
            for( Reveal reveal : game.getReveals()){
                if(reveal.getRed() != null && reveal.getRed() > minNeedRed) minNeedRed = reveal.getRed();
                if(reveal.getGreen() != null && reveal.getGreen() > minNeedGreen) minNeedGreen = reveal.getGreen();
                if(reveal.getBlue() != null && reveal.getBlue() > minNeedBlue) minNeedBlue = reveal.getBlue();
            }
            result += (minNeedRed * minNeedBlue * minNeedGreen);
        }

        return result.toString();
    }


}
