package Day4;

import java.util.Scanner;
import java.util.Stack;

public class HtmlParser {
    private static void parse(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '<') {
                st.push(ch);
            }
            else if (ch == '>') {
                st.clear();
            }
            else {
                if (st.isEmpty()) 
                    sb.append(ch);
                    
            }
            // System.out.println(st);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        parse(s);
        sc.close();
    }
}
