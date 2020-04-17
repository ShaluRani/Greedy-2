// Time Complexity : O(l), l-> length of task
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// The decision on number of intervals will be based on the task which occurs the most. So, we'll create a frequency map of the characters we have. The total number of slots between two tasks will be updated with another task if possible otherwise, the slot will be idle.

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // edge case check
        if(tasks == null || tasks.length == 0) {
            return 0;
        }
        
        int max = 0;
        int excludeTask = 0;
        int l = tasks.length;
        // create frequency map
        int[] freqMap = new int[26]; 
        for(int i = 0; i < l; i++) {
            char ch = tasks[i];
            freqMap[ch-'A']++;
            // get the max frequency
            max = Math.max(max, freqMap[ch-'A']);
            if(max == freqMap[ch-'A']) {
                excludeTask = ch-'A';
            }
        }

        // maximum possible idle slot
        int slots = (max-1)*n;
        
        // Now we'll try to fill each available slot with other characters apart from the one having maximum frequency
        
        for(int i = 0; i < 26; i++)  { // excluding the most frequent item
            if(i != excludeTask)
                slots -= Math.min(max-1, freqMap[i]);
        }
        
        return slots > 0 ? l+slots : l;
    }
}
