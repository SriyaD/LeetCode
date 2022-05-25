public class Solution {
    public int longestValidParentheses(String s) {
        // int maxans = 0;
        // int dp[] = new int[s.length()];
        // for (int i = 1; i < s.length(); i++) {
        //     if (s.charAt(i) == ')') {
        //         if (s.charAt(i - 1) == '(') {
        //             dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
        //         } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
        //             dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
        //         }
        //         maxans = Math.max(maxans, dp[i]);
        //     }
        // }
        // return maxans;
        
        
        
        
        Stack<Integer>st=new Stack<>();
        st.add(-1);
        int maxl=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                st.add(i);
            }
            else
            {
                st.pop();
                if(st.isEmpty())
                {
                    st.add(i);
                }
                else
                {
                    maxl=Math.max(maxl,i-st.peek());
                }
            }
        }
        return maxl;
    }
}