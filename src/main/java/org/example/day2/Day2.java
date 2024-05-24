package org.example.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public interface Day2 {

    final Integer MAX_CUBES_RED = 12;
    final Integer MAX_CUBES_GREEN = 13;
    final Integer MAX_CUBES_BLUE = 14;

    static String day2(int part){
        String result = "";

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/day2.txt"))) {
            ArrayList<Game> games = new ArrayList<>();
            for (String line : br.lines().toList()) {
                games.add(Game.createFromLine(line));
            }

            if(part == 1) result = part1(games);
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


}
