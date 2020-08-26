/**
 * Question: given no of eggs and floors, find the max floor from which if the egg drops then the egg does not break
 *
 * Brute force: start from bottom and keep checking until the egg breaks and return the below floor. - No of attempts -O(N)
 * we have to find perfect position of the floor from which if the egg drops, we ll be closer to finding the soln with least no of attempts.
 *
 * which floor is the question?
 * Intuition: Start from bottom up approach(base cases) : with 1 egg and 1 floor -cal attempts next with 1 egg and 2 floors until N floors
 *
 * Time: O(K*N^2) N & K are inputs given
 * Space:(N*K)
 */
class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp =new int[K+1][N+1];
        for(int i=0;i<=N;i++)
            dp[1][i] = i;

        for(int i=2;i<=K;i++){
            for(int j=1;j<=N;j++){
                dp[i][j] = N;
                for(int k=1;k<=j;k++){
                    dp[i][j] = Math.min(dp[i][j] , 1+Math.max(dp[i-1][k-1],dp[i][j-k]));
                }
            }
        }
        return dp[K][N];
    }
}

