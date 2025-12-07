package fr.dorian.days.day1;
import java.util.Arrays;

public class Day1part2 {
    private static final int pointerMax = 100;

    public static int solve(String inputFilePath) {

        String[] rotations = inputFilePath.split("\n");

        State state = new State();

        Arrays.stream(rotations).forEach(rotation -> {
            char direction = rotation.charAt(0);
            int clics = Integer.parseInt(rotation.substring(1));

            if (direction == 'L'){
                if ((state.pointer - clics) <= 0) {     
                    System.out.println("L " + "clics " + clics + " state.pointer " + state.pointer + " pointerToZeroCount + " + Math.abs(state.pointer - clics) / pointerMax);               
                    state.pointerToZeroCount += Math.abs(state.pointer - clics) / pointerMax;
                }
            state.pointer = (state.pointer - clics) % pointerMax;
        
            } else if (direction == 'R'){
                if ((state.pointer + clics) >= pointerMax) {    
                    System.out.println("R " + "clics " + clics + " state.pointer " + state.pointer +  " pointerToZeroCount + " + (state.pointer + clics) / pointerMax);            
                    state.pointerToZeroCount += (state.pointer + clics) / pointerMax;
                }
            state.pointer = (state.pointer + clics) % pointerMax;
            
            }
            if (state.pointer == 0)
                state.pointerToZeroCount++; 
        });

        System.out.println("Pointer reached zero " + state.pointerToZeroCount + " times.");
        return state.pointerToZeroCount;
    }

    static class State {
        int pointer = 50;
        int pointerToZeroCount = 0;
    }
}
