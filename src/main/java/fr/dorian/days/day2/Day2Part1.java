package fr.dorian.days.day2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Day2Part1 {
    
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
        if (String.valueOf(lowerBound).length() % 2 == 0) {
            if (getLeftHalf(lowerBound).equals(getRightHalf(lowerBound))) {
                invalidIds.add(lowerBound);
            }
        }
    }

    private String getRightHalf(Long lowerBound) {
        return String.valueOf(lowerBound).substring(String.valueOf(lowerBound).length()/2);
    }

    private String getLeftHalf(Long lowerBound) {
        return String.valueOf(lowerBound).substring(0, String.valueOf(lowerBound).length()/2);
    }
}
