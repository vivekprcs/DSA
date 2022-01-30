
/**
 * 1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed a single transaction.

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10

Format
Input
A number n
.. n more elements

Output
A number representing the maximum profit you can make if you are allowed a single transaction.

Example
Sample Input

9
11
6
7
19
4
1
6
18
4

Sample Output
17
 */
import java.util.*;

public class Buy_And_Sell_Stocks_One_Transaction_Allowed {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int maxProfit = 0;
        int min = scan.nextInt();
        for (int i = 1; i < n; i++) {
            int val = scan.nextInt();
            maxProfit = Math.max(maxProfit, val - min);
            min = Math.min(val, min);
        }
        System.out.println(maxProfit);
        scan.close();
    }

}