package fr.dorian;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import fr.dorian.days.day1.Day1Part1;
import fr.dorian.days.day1.Day1part2;
import fr.dorian.days.day2.Day2Part1;
import fr.dorian.days.day2.Day2Part2;
import fr.dorian.days.day3.Day3;

public class Main {
    public static void main(String[] args) throws IOException {
    String Day1Input = new String(Main.class.getClassLoader().getResourceAsStream("input_day1.txt").readAllBytes(), StandardCharsets.UTF_8);
    System.out.println("AoC 2025 - Day 1 - part 1");
    int resultPart1 = Day1Part1.solve(Day1Input);
    System.out.println("Result: " + resultPart1);



    
    
    System.out.println("AoC 2025 - Day 1 - part 2");
    int resultDay1part2 = Day1part2.solve(Day1Input);
    System.out.println("Result: " + resultDay1part2);
    
    String Day2InputFile = new String(Main.class.getClassLoader().getResourceAsStream("input_day2.txt").readAllBytes(), StandardCharsets.UTF_8);
    System.out.println("AoC 2025 - Day 2 - part 1");        
    long resultDay2part1 = new Day2Part1().solve(Day2InputFile);        
    System.out.println("Result: " + resultDay2part1);

    System.out.println("AoC 2025 - Day 2 - part 2");
    long resultDay2part2 = new Day2Part2().solve(Day2InputFile);
    System.out.println("Result: " + resultDay2part2);

    System.out.println("AoC 2025 - Day 3 - part 1");
    Day3 day3 = new Day3();
    int resultDay3part1 = day3.getSumOfMaxJoltagePerBank();
    System.out.println("Result: " + resultDay3part1);
    System.out.println("AoC 2025 - Day 3 - part 2");
    long resultDay3part2 = day3.getSumOfMaxDynamicJoltagePerBank(12);
    System.out.println("Result: " + resultDay3part2);
}

}