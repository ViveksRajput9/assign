package ArrayListPractice;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class p2 implements Cloneable {
	public static void main(String[] args) throws CloneNotSupportedException{
		List <String > l = new ArrayList<>();
		l.add("vivek");
		l.add("vivek singh rajput");
		l.add("anand");
		l.add("ashu");
		l.add("akansha");
		for(int i = 0;i<l.size();i++) {
			if(l.get(i).startsWith("a")) {
				l.set(i,l.get(i).toUpperCase());
			}
		}
//		l.forEach(i->{if(i.startsWith("a")) l.set(l.indexOf(i),i.toUpperCase());});
		System.out.println(l);
		System.out.println(l.size());
	}
}