package fr.dorian.days.day2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Day2Part2 {
     public long solve(String inputFile) {
        Map<Long, Long> idMap = Arrays.stream(inputFile.split(","))
            .map(range -> range.split("-"))
            .collect(Collectors.toMap(
                bounds -> Long.parseLong(bounds[0].trim()),
                bounds -> Long.parseLong(bounds[1].trim())
            ));
        
        Set<Long> invalidIds = new HashSet<>();

        idMap.forEach((lowerBound, upperBound) -> {
            while (lowerBound <= upperBound) { 
                checkForInvalidId(invalidIds, lowerBound);
                lowerBound++;
            }
        });
        
        return invalidIds.stream().mapToLong(Long::longValue).sum();
    }

    private void checkForInvalidId(Set<Long> invalidIds, Long lowerBound) {
        String id = String.valueOf(lowerBound);
        int length = id.length();
        
        // Check all possible pattern lengths from 1 to length/2
        for (int patternLength = 1; patternLength <= length / 2; patternLength++) {
            if (length % patternLength == 0) {
                String pattern = id.substring(0, patternLength);
                if (isRepeatingPattern(id, pattern)) {
                    invalidIds.add(lowerBound);
                    return;
                }
            }
        }
    }

    private boolean isRepeatingPattern(String id, String pattern) {
        int patternLength = pattern.length();
        for (int i = 0; i < id.length(); i += patternLength) {
            if (!id.substring(i, i + patternLength).equals(pattern)) {
                return false;
            }
        }
        return true;
    }
}
