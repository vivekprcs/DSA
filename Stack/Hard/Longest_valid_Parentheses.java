
/*
Given a string S consisting of opening and closing parenthesis '(' and ')'. 
Find length of the longest valid parenthesis substring.

Input:
First line contains number of test cases T. 
 Each test case have one line string S of character '(' and ')' of length  N.

Constraints:
1 <= T <= 500
1 <= N <= 105

Example:
Input:
2
((()
)()())

Output:
2
4

Explanation:
Testcase 1: Longest valid balanced parantheses is () and its length is 2. 
*/
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Longest_valid_Parentheses {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = Integer.parseInt(scan.nextLine());
        while (t-- > 0) {
            String str = scan.nextLine();
            Stack<Character> stChar = new Stack<>();
            Stack<Integer> stInt = new Stack<>();
            stInt.push(-1);
            int max = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    stChar.push('(');
                    stInt.push(i);
                } else {
                    if (!stChar.empty() && stChar.peek() == '(') {
                        stChar.pop();
                        stInt.pop();
                        max = Math.max(max, i - stInt.peek());

                    } else {
                        stInt.push(i);
                    }
                }

            }
            System.out.println(max);

        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}