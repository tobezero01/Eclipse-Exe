package Main;
 // leatcode easy
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MainTest {
// bai so 13
//	public static int romanToInt(String s) {
//		Map<Character, Integer> m = new HashMap<>();
//		m.put('I', 1);
//        m.put('V', 5);
//        m.put('X', 10);
//        m.put('L', 50);
//        m.put('C', 100);
//        m.put('D', 500);
//        m.put('M', 1000);
//        
//        int ans = 0;
//        int n = s.length();
//        for (int i= 0 ; i < n; i++) {
//        	if (i < n-1 && m.get(s.charAt(i)) < m.get(s.charAt(i +1))) {
//        		ans -= m.get(s.charAt(i));
//        	}else {
//        		ans += m.get(s.charAt(i));
//        	}
//        }
//        return ans;
//    }
	
	
 // bai so 14
//	public static String longestCommonPrefix(String[] strs) {
//		String s = new String();
//		s = "";
//				Arrays.sort(strs);
//				String f = strs[0];
//				String l = strs[strs.length-1];
//				for (int i = 0; i < Math.min(f.length(), l.length()); i++) {
//					if(f.charAt(i) == l.charAt(i) ) {
//						String s1 = String.valueOf(f.charAt(i));
//						s = s + s1;
//					}
//					
//				}
//		        return s;
//		    
//    }
	
// bai 20
	public static  boolean isValid(String s) {
		Stack<Character> stack = new  Stack<Character>();
		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') stack.push(ch);
			else {
				if (stack.isEmpty() ) {
					return false;
				}
				char top = stack.pop();
				if((ch == ')' && top != '(') ||(ch == '}' && top != '{') ||(ch == ']' && top != '[') ) return false;
			}
		}
	    return stack.isEmpty();    
	}
	public static void main(String[] args) {
		String s = new String("(){}[]");
		if(isValid(s)) System.out.println(1); 
		else System.out.println(0);
//		String [] s = new String[]{"flower","flow","flight"};
//		System.out.println(longestCommonPrefix(s));

	}

	
	
	
}
