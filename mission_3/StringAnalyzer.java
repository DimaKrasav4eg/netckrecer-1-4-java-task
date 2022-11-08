package mission_3;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StringAnalyzer {

	private Set<Character> chars;
	public void charsInFirstAndSecond(String first, String second) {
		Filter f = new Filter() {
			@Override
			public boolean filter(String f, String s, int index) {
				return f.charAt(index) == s.charAt(index);
			}
		};
		this.chars = stringFilter(first, second, f);
	}
	public void charsInFirstOnly(String first, String second) {
		Filter f = new Filter() {
			@Override
			public boolean filter(String f, String s, int index) {
				return s.indexOf(f.charAt(index)) == -1;
			}
		};
		Set<Character> prod = stringFilter(first, second, f);
		if (first.length() > second.length()) {
			String tail = first.substring(second.length()-1);
			for (int i = 0; i < tail.length(); ++i) {
				prod.add(tail.charAt(i));
			}
		}
		this.chars = prod;
	}
	public void charsInAny(String first, String second) {
		Filter f = new Filter() {
			@Override
			public boolean filter(String f, String s, int index) {
				return true;
			}
		};
		this.chars = stringFilter(first, first, f);
		this.chars.addAll(stringFilter(second, second, f));
	}
	
	private interface Filter{
		boolean filter(String f, String s, int index);
	}
	private Set<Character> stringFilter(String first, String second, Filter f){
		Set<Character> prod = new HashSet<>();
		int minLen = Math.min(first.length(), second.length());
		for (int i = 0; i < minLen; ++i) {
			if (f.filter(first, second, i)) {
				prod.add(first.charAt(i));
			}
		}
		return prod;
	}
	
	public ArrayList<Character> getCharsNormal() {
		ArrayList<Character> prod = new ArrayList<>(this.chars);
		prod.sort((Character a, Character b) -> Character.compare(a, b));
		return prod;
	}
	public ArrayList<Character> getCharsReverse() {
		ArrayList<Character> prod = new ArrayList<>(this.chars);
		prod.sort((Character a, Character b) -> -Character.compare(a, b));
		return prod;
	}
	public ArrayList<Character> getCharsHash(int n) {
		ArrayList<Character> prod = new ArrayList<>(this.chars);
		prod.sort((Character a, Character b) -> Integer.compare(a.hashCode()<<n, b.hashCode()<<n));
		return prod;
	}
}
