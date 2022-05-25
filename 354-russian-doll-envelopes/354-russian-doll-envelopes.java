class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //sort the enevelope
        //as increasing of width, when both width is same, then sort  by decreasing order heights
        Arrays.sort(envelopes, (a, b) ->  (a[0] == b[0]) ? (b[1] - a[1]) : (a[0] - b[0]));
        
        //just extarct the height
        int[] heights = new int[envelopes.length];
        for(int i = 0; i < heights.length; i++){
            heights[i] = envelopes[i][1];
        }
        
        //find the longest increasing subsequen on heights
        return getLIS(heights);
    }
    
    private int getLIS(int[] nums){
        int[] dp = new int[nums.length];
        int len = 0;
        
        for(int num : nums){
            int index = Arrays.binarySearch(dp, 0, len, num);
            
            if(index < 0){
                index = -(index + 1);
            }
            
            dp[index] = num;
            
            if(index == len)
                len++;
        }
        
        return len;
    }
}