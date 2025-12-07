package fr.dorian.days.day1;

import java.util.Arrays;

public class Day1Part1 {
    private static final int pointerMax = 100;

    public static int solve(String input) {
        String[] rotations = input.split("\n");

        State state = new State();
        Arrays.stream(rotations).forEach(rotation -> {
            char direction = rotation.charAt(0);
            int clics = Integer.parseInt(rotation.substring(1));

            if (direction == 'L')
                state.pointer = (state.pointer - clics) % pointerMax;
            else if (direction == 'R')
                state.pointer = (state.pointer + clics) % pointerMax;

            if (state.pointer == 0)
                state.pointerToZeroCount++;                
        });

        return state.pointerToZeroCount;
    }

    static class State {
        int pointer = 50;
        int pointerToZeroCount = 0;
    }
}
