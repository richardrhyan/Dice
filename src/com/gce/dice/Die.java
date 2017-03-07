package com.gce.dice;

import java.util.Random;

public class Die {
	private int numSides;
	private int value;
	
	/**
	 * Constructor for a standard 6-sided die.
	 */
	public Die() {
		this(6);
	}
	
	/**
	 * Constructor for a die with a maximum value of numSides.
	 * @param numSides
	 */
	public Die(int numberOfSides) {
		this.numSides = numberOfSides;
		this.value = numSides;
	}
	
	
	/**
	 * Rolls the die, generates a random number from 1 to numSides. 
	 * @return int
	 */
	public int roll() {
		value = new Random().nextInt(numSides) + 1;
		return value; 
	}
	
	/**
	 * Returns the number of sides the die has, also the maximum value.
	 * @return int
	 */
	public int sides() {
		return numSides;
	}
	
	/**
	 * Returns the value of the last roll of the die. If the die has not been rolled yet, 
	 * returns the max value.
	 * @return int
	 */
	public int value() {
		return value;
	}
	
	public String toString() {
		return Integer.toString(value);
	}
}
