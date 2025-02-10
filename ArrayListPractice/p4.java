package ArrayListPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> l= new ArrayList<>();
		l.add("vivek rajput");
		l.add("mohit dogaya");
		l.add("abhishek rajput");
		l.add("badal patel");
		System.out.print("Enter the name for searching :- ");
		String name = scanner.nextLine();
		if(l.contains(name)) {
			System.out.println(l.indexOf(name));
		}
	}
}
