
/**
 * Winter is coming! During the contest, your first job is to design a standard
 * heater with a fixed warm radius to warm all the houses.
 * 
 * Every house can be warmed, as long as the house is within the heater's warm
 * radius range.
 * 
 * Given the positions of houses and heaters on a horizontal line, return the
 * minimum radius standard of heaters so that those heaters could cover all
 * houses.
 * 
 * Notice that all the heaters follow your radius standard, and the warm radius
 * will the same.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: houses = [1,2,3], heaters = [2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the
 * radius 1 standard, then all the houses can be warmed.
 * Example 2:
 * 
 * Input: houses = [1,2,3,4], heaters = [1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to
 * use radius 1 standard, then all the houses can be warmed.
 * Example 3:
 * 
 * Input: houses = [1,5], heaters = [2]
 * Output: 3
 * 
 * 
 * Constraints:
 * 
 * 1 <= houses.length, heaters.length <= 3 * 104
 * 1 <= houses[i], heaters[i] <= 109
 * Accepted
 * 93,906
 * Submissions
 * 261,570
 */
import java.util.*;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int radius = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int diff1 = Integer.MAX_VALUE, diff2 = Integer.MAX_VALUE;
            int l = 0, r = heaters.length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (heaters[mid] == house) {
                    diff1 = 0;
                    break;
                } else if (heaters[mid] > house) {
                    r = mid - 1;
                    diff2 = Math.min(diff2, heaters[mid] - house);
                } else {
                    l = mid + 1;
                    diff1 = Math.min(diff1, house - heaters[mid]);
                }
            }
            radius = Math.max(radius, Math.min(diff1, diff2));
        }
        return radius;

    }
}