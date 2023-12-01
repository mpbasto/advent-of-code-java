package aoc.day01;

import aoc.Day;

import java.util.List;

public class Day01 implements Day {

    @Override
    public String part1(List<String> input) {
        if ( input == null  || input.isEmpty() )
        {
            throw new IllegalArgumentException( "Input is empty" );
        }

        int sum = 0;
        for ( String line : input ){
            sum += getValues( line );
        }

        return String.valueOf( sum );
    }

    @Override
    public String part2(List<String> input) {
        return input.isEmpty() ? "" : input.get(0);
    }

    private int getValues(String line) {
        if ( line == null  || line.isEmpty())
        {
            throw new IllegalArgumentException( "Line is empty" );
        }

        // Find location of digits
        int firstDigitIndex = findFirstDigitIndex(line);
        int lastDigitIndex = findLastDigitIndex(line);

        // Extract digits
        char firstDigit = line.charAt( firstDigitIndex );
        char lastDigit = line.charAt( lastDigitIndex );

        // Convert to int and combine them
        return Integer.parseInt( "" + firstDigit + lastDigit );

    }

    private int findFirstDigitIndex(String line){
        for ( int i = 0; i < line.length(); i++ )
        {
            if ( Character.isDigit( line.charAt( i ) ) ) {
                return i;
            }
        }
        throw new IllegalArgumentException("Line does not contain any digits");
    }

    private int findLastDigitIndex(String line){
        for ( int i = line.length() - 1; i >= 0; i-- )
        {
            if ( Character.isDigit( line.charAt( i ) ) ){
                return i;
            }
        }
        throw new IllegalArgumentException("Line does not contain any digits");
    }

}
