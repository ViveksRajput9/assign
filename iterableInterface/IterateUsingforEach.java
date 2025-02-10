package iterableInterface;

//Java Program to demonstrate iterate 
//an Iterable using forEach method 

import java.io.*; 
import java.util.*; 

public class IterateUsingforEach { 
	public static void main(String[] args) 
	{ 
		// create a list 
		List<String> list = new ArrayList<>(); 

		// add elements to the list 
		list.add("Geeks"); 
		list.add("for"); 
		list.add("Geeks"); 
		list.forEach((element)-> {System.out.println(element);});
	} 
}

