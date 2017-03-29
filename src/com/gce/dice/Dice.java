package com.gce.dice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dice {
	ArrayList<Die> dice = new ArrayList<>();
	
	/**
	 * Constructor for a group of dice, the array int[] determines the number of sides of each die.
	 * @param int sides
	 */
	public Dice(int ... numberOfSides) {
		for (int i = 0; i < numberOfSides.length; i++)
			dice.add(new Die(numberOfSides[i]));
	}
	
	/**
	 * Constructor for a group of dice, the array Die[] determines the dice types
	 * @param Die dice
	 */
	public Dice(Die ... dice) {
		for (int i = 0; i < dice.length; i++)
			this.dice.add(dice[i]);
	}
	
	/**
	 * Constructor for a group of dice, the ArrayList determines the dice.
	 * @param ArrayList<Dice> dice
	 */
	public Dice(ArrayList<Die> dice) {
		this.dice = dice;
	}
	
	/**
	 * Add a die to the Dice
	 * @param int numberOfSides
	 */
	public void add(int numberOfSides) {
		this.add(new Die(numberOfSides));
	}
	
	/**
	 * Add a Die to the Dice
	 * @param Die die
	 */
	public void add(Die die) {
		dice.add(die);
	}
	
	/**
	 * Removes the first die with numberOfSides
	 * @param int numberOfSides
	 */
	public void remove(int numberOfSides) {
		for (Die d : dice) {
			if (d.sides() == numberOfSides) {
				dice.remove(d);
				return;
			}
		}
	}
	
	/**
	 * Removes the first die with smae number of sides as Die
	 * @param Die die
	 */
	public void remove(Die die) {
		for (Die d : dice) {
			if (d.sides() == die.sides()) {
				dice.remove(d);
				return;
			}
		}
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
		int sum = dice.stream()
				.mapToInt(e -> e.value())
				.reduce(0, Integer::sum);
		return sum;
	}
	
	/**
	 * Returns an array of all the dice.
	 * @return Die[]
	 */
	public ArrayList<Die> getDice() {
		return dice;
	}
	
	public String toString() {
		// Example from: https://docs.oracle.com/javase/8/docs/api/java/util/StringJoiner.html
		String commaSeparated = dice.stream()
			.map(i -> i.toString())
			.collect(Collectors.joining(", "));
		return commaSeparated;				
	}
}