package ArrayListPractice;

import java.util.ArrayList;
import java.util.List;

public class p3 {
public static void main(String[] args) {
	List<Integer> l = new ArrayList<>();
	l.add(15);
	l.add(20);
	l.add(25);
	l.add(254);
	l.add(2);
	l.set(1,55);
	l.remove(2);
	System.out.println(l);
	
	
}
}
