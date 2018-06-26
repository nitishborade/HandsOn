package com.nitish.app.lambda;

/**
 * @author Nitish
 * 1. Lambdas allow you to focus on behaviour and functionality rather than needing the state in form of objects.
 * Like anonymous classes can be substituted with lambdas. Using anonymous classes what we ended up doing was passing an object
 * (state) as argument. Now with lamdas we can pass the behaviour to a method rather than anonymous class.
 * 
 * 2. 
 * 
 */
public class LambdaTest {

	public static void main(String args[]) {
		new LambdaTest().test();
	}
	
	public void test() {
		// With Interface #1
		/*Greetings gm = () -> "Good Morning";
		System.out.println(gm.greet());*/
		
		// With Interface #2
		/*Greetings ge = (name) -> System.out.println("Good evening");
		ge.greet("Nitish");*/
		
		// With Interface #3
		/*Greetings g = (name, time) -> { if(time.equals("Morning")) { return "Good morning, " + name; } else { return "Good evening, " + name; }};
		System.out.println(g.greet("Nitish", "Evening"));*/
		
		// With Interface #3 and function
		/*Greetings g = (name, time) -> message(name, time);
		System.out.println(g.greet("Nitish", "Morning"));*/
		
		//Using variable and Interface 2
		String time = "Morning";
		//time = "Evening"; // Compiler Error, the variable is effectively final
		Greetings ge = (name) -> System.out.println("Good " + time + " " + name);
		ge.greet("Nitish");
		
	}
	
	/*private String message(String name, String time) {
		return time.equals("Morning") ? "Good morning, " + name : "Good evening, " + name;
	}*/
}

interface Greetings {
	//1 
	// String greet();
	
	//2
	void greet(String name);
	
	// 3
	//String greet(String name, String time);
}