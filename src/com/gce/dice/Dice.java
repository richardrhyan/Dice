package com.gce.dice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dice {
	Die[] dice;
	
	/**
	 * Constructor for a group of dice, the array int[] determines the number of sides of each die.
	 * @param int sides
	 */
	public Dice(int ... numberOfSides) {
		dice = new Die[numberOfSides.length];
		for (int i = 0; i < numberOfSides.length; i++)
			dice[i] = new Die(numberOfSides[i]);
	}
	
	/**
	 * Constructor for a group of dice, the array Die[] determines the dice types
	 * @param Die dice
	 */
	public Dice(Die ... dice) {
		this.dice = dice;
	}
	
	/**
	 * Rolls all of the dice, and returns the total.
	 * @return int
	 */
	public int roll() {
		int total = 0;
		for (Die d : dice)  
			total += d.roll();
		
		return total;
	}
	
	/**
	 * Returns the total value of all dice.
	 * @return int
	 */
	public int value() {
		int sum = Arrays.asList(dice).stream()
				.mapToInt(e -> e.value())
				.reduce(0, Integer::sum);
		return sum;
	}
	
	/**
	 * Returns an array of all the dice.
	 * @return Die[]
	 */
	public Die[] getDice() {
		return dice;
	}
	
	public String toString() {
		// Example from: https://docs.oracle.com/javase/8/docs/api/java/util/StringJoiner.html
		List<Die> myDice = Arrays.asList(dice);
		String commaSeparated = myDice.stream()
			.map(i -> i.toString())
			.collect(Collectors.joining(", "));
		return commaSeparated;				
	}
}
