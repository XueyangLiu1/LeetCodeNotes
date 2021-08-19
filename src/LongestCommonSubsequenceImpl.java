public class LongestCommonSubsequenceImpl implements TakeTwoStringRtnIntSolutionService{
    /**
     * 剑指 Offer II 095. 最长公共子序列
     * https://leetcode-cn.com/problems/qJnOS7/
     */

    @Override
    public int returnAns(String first, String second) {
        return longestCommonSubsequence(first,second);
    }

    private int longestCommonSubsequence(String text1, String text2) {
        String emptyString=  "";
        if(emptyString.equals(text1) || emptyString.equals(text2)) return 0;
        char[] firstString = text1.toCharArray();
        char[] secondString = text2.toCharArray();
        int[][] dp = new int[firstString.length][secondString.length];

        for(int i = 0;i<firstString.length;i++){
            for(int j=0;j<secondString.length;j++){
                boolean sameChar = firstString[i]==secondString[j];
                int currentContribution = sameChar ? 1:0;
                if(i==0 && j==0){
                    dp[i][j] = currentContribution;
                }else if(j==0){
                    dp[i][j] = dp[i-1][j]==1 ? 1:currentContribution;
                }else if(i==0){
                    dp[i][j] = dp[i][j-1]==1 ? 1:currentContribution;
                }else{
                    if(sameChar){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[firstString.length-1][secondString.length-1];
    }
}
