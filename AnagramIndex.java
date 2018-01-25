import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramIndex {
	
	public static void main(String[] args) {
		indices("AB", "ABCDBACDAB");
	}
	
	public static void indices(String a, String b){
        double hash = hash(a);
        int n = b.length();
        for(int i = 0; i < n-a.length()+1; i++){
            String s = b.substring(i, a.length()+i);
            double h = hash(s);
            if(h == hash)
                System.out.print(i + " ");
        }
    }
    
    public static double hash(String str){
        int n = str.length();
        double k = 9.3451;
        double h = 0;
        for(int i = 0; i < n; i++)
            h += str.charAt(i)*k;
        return h;
    }

	public static List<Integer> getAnagrams(String s, String word) {
		Map<Character, Integer> letters = new HashMap<>();
		int distinct_letters = 0;
		for(char c: word.toCharArray()) {
			if(!letters.containsKey(c)) distinct_letters++;
			letters.put(c, letters.getOrDefault(c, 0) + 1);
		}

		//search for anagrams with two pointers
		List<Integer> res = new ArrayList<>();
		int lo = 0, hi = 0;
		while(hi < s.length()) {
			if(!letters.containsKey(s.charAt(hi))) {
				while(lo < hi) {
					char c = s.charAt(lo);
					if(letters.get(c) == 0) distinct_letters++;
					letters.put(c, letters.get(c) + 1);
					lo++;
				}
				hi++;
				lo = hi;
			} else if(letters.get(s.charAt(hi)) == 0){
				while(s.charAt(lo) != s.charAt(hi)) {
					char c = s.charAt(lo);
					if(letters.get(c) == 0) distinct_letters++;
					letters.put(c, letters.get(c) + 1);
					lo++;
				}
				lo++;
			} else {
				char c = s.charAt(hi);
				letters.put(c, letters.get(c) - 1);
				if(letters.get(c) == 0) distinct_letters--;
				if(distinct_letters == 0) {
					res.add(lo);
				}
				hi++;
			}
		}
		return res;
	}
}
