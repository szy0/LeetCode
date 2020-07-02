// m, n >= 1
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        int[][] dp = new int[m + 1][n + 1]; // how many paths to current cell[i ,j]
        dp[1][1] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != 1 || j != 1) 
                    dp[i][j] = dp[i][j-1] + dp[i-1][j]; // left and up
            }
        }
        return dp[m][n];
    }
}