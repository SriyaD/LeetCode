// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    
    public static void solve(int i, int j, int[][] m, int n,ArrayList<String> ans, int[][] vis,String move){
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }
        //down
        if(i<n-1  && vis[i][j]==0 && m[i + 1][j] == 1){
            vis[i][j]=1;
            solve(i+1,j,m,n,ans,vis,move+"D");
            vis[i][j]=0;
        }
        
        //right
        if(j<n-1  && vis[i][j]==0 && m[i][j+1] == 1){
            vis[i][j]=1;
            solve(i,j+1,m,n,ans,vis,move+"R");
             vis[i][j]=0;
        }
        //top
        if(i-1>=0  && vis[i][j]==0 && m[i - 1][j] == 1){
            vis[i][j]=1;
            solve(i-1,j,m,n,ans,vis,move+"U");
            vis[i][j]=0;
        }
        //left
        if(j-1>=0  && vis[i][j]==0 && m[i][j-1] == 1){
            vis[i][j]=1;
            solve(i,j-1,m,n,ans,vis,move+"L");
            vis[i][j]=0;
        }
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        int vis[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                vis[i][j]=0;
            }
        }
        String move="";
        ArrayList<String> ans=new ArrayList<>();    
        if (m[0][0] == 1) solve(0, 0, m, n, ans,vis,move);
        return ans;
    }
}