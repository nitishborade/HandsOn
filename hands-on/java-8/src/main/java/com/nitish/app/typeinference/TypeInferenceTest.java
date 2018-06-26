package com.nitish.app.typeinference;

import java.util.HashMap;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class TypeInferenceTest {

	public static void main(String[] args) {
		TypeInferenceTest t = new TypeInferenceTest();

		// 1 - Type Inference, you dont have to explicitly mention the generic types
		// here, the compiler figers it out
		// The generic types to HashMap can be inferred from the type of the parameter
		// in method signature
		t.doSomething(new HashMap<>());

		// 2 Same as 1. The generic types to HashMap can be inferred from the type of
		// the intMap
		HashMap<String, Integer> intMap = new HashMap<>();
		t.doSomething(intMap);

		// 3. Wouldn't compile in Java 7
		t.doSomething(new HashMap());

		// 4. Dont have to explicitly mention Long for the parameters, the compiler figers
		// it out looking at the type of bo
		BinaryOperator<Long> bo = (x, y) -> x * y;
		Predicate<Integer> p = x -> x > 5;

		// 5. Throws compiler error. The compiler by default understands it as raw type
		// java.lang.Object
		// Raw Type - When you dont mention the generic type, the compiler treats it as
		// a raw type, eg HashMap() of rawtype i.e. java.lang.Object
		// Error - The operator * is undefined for the argument type(s)
		// java.lang.Object, java.lang.Object
		// BinaryOperator bo1 = (x, y) -> x * y;
		// Predicate p = x -> x > 5;
		
		// 6. Works both for check(IntPred) and check(Predicate<Integer>). Fails for check(Predicate), as compiler treats as java.lang.Object
		// t.check(x -> x > 5); 
	}

	public void doSomething(HashMap<String, Integer> map) {

	}
	
	boolean check(IntPred predicate) {
		return true;
	}
	
	boolean check(Predicate<Integer> predicate) {
		return true;
	}

}

interface IntPred {
	boolean test(Integer value);
}