// Time Complexity : O(n), n - > number of children
// Space Complexity : O(n), auxiliary space required for processing intermediate results for each child
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// Each child's rating is compared with both its neighbor and number of candy is incremented. This is a two step process.
// First the child's rating is compared with the left neighbor and respective candy count is incremented.
// Once left comparisons are done, child's rating is compared with the right neighbors. Whichever count is maximum i.e. the existing candy count or right neighbor's candy count +1, that value is retained.

class Solution {
    public int candy(int[] ratings) {
        // edge case check
        if(ratings == null || ratings.length == 0)
            return 0;
        int n = ratings.length;
        int candies = 0;
        int[] result = new int[n]; // to store candy count for each child
        Arrays.fill(result, 1); // default candy count to 1
        for(int i = 1; i < n; i++) { // left neighbor comparison
            if(ratings[i] > ratings[i-1])
                result[i] = result[i-1]+1;
        }
        for(int i = n-2; i >= 0; i--) { // right neighbor comparison
            if(ratings[i] > ratings[i+1])
                result[i] = Math.max(result[i+1]+1, result[i]);
        }
        
        for(int i = 0; i < n; i++) { 
            candies += result[i]; // calculating sum of candies
        }
        return candies;
    }
}
