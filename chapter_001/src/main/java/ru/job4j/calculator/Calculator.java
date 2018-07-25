package ru.job4j.calculator;

/**
 *This is my first simple calculator.
 *@author Sabirov Svytoslav
 *@since 23.01.2017 22:09
 *@version 1
 */
public class Calculator {
    
	private double result;
    
	/**
	 *Method sumirzes two numbers.
	 *@param first number.
	 *@param second number.
	 */
    public void add(double first, double second) {
        this.result = first + second;
    }
	
	/**
	 *Method subtracts two numbers.
	 *@param first number.
	 *@param second number.
	 */
	public void subtract(double first, double second) {
        this.result = first - second;
    }

	/**
	 * Method setting result.
	 * @param result
	 */
	public void setResult(double result) {
		this.result = result;
	}

	/**
	 *Method divides two numbers.
	 *@param first number.
	 *@param second number.
	 */
	public void div(double first, double second) {
        this.result = first / second;
    }
	
	/**
	 *Method multiples two numbers.
	 *@param first number.
	 *@param second number.
	 */
	public void multiple(double first, double second) {
        this.result = first * second;
    }
    
	/**
	 *Method gets result.
	 *@return current result.
	 */	
    public double getResult() {
        return this.result;
    }
		
}