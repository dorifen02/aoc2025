package fr.dorian.days.day3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import fr.dorian.Main;

public class Day3 {
    public String readInputFile() {
        String inputFile = null;
        try {
            inputFile = new String(Main.class.getClassLoader().getResourceAsStream("input_day3.txt").readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputFile;
    }

    public int getSumOfMaxJoltagePerBank() {
        return Arrays.stream(readInputFile().split("\n"))
                .mapToInt(this::maxJoltage)
                .sum();
    }

    public long getSumOfMaxDynamicJoltagePerBank(int nbDigits) {
        return Arrays.stream(readInputFile().split("\n"))
                .mapToLong(bank -> maxDynamicJoltage(bank, nbDigits))
                .sum();
    }

    //part 1
    private int maxJoltage(String bank) {
        int max = 0;
        int n = bank.length();

        for (int i = 0; i < n - 1; i++) {
            int digit1 = bank.charAt(i) - '0';

            for (int j = i + 1; j < n; j++) {
                int digit2 = bank.charAt(j) - '0';
                int jolt = digit1 * 10 + digit2;
                if (jolt > max) {
                    max = jolt;
                }
            }
        }
        return max;
    }

    // part2
    private long maxDynamicJoltage(String bank, int nbDigits) {
        long[] highestDigits = new long[nbDigits];

        for (char c : bank.toCharArray()) {
            long digit = c - '0';
            for (int i = nbDigits -1; i >= 1; i--) {
                long newDigit = highestDigits[i - 1] * 10 + digit;
                highestDigits[i] = Math.max(highestDigits[i], newDigit);
            }
            highestDigits[0] = Math.max(highestDigits[0], digit);
        }
        return highestDigits[nbDigits - 1];
    }
}
