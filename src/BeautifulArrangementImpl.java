public class BeautifulArrangementImpl implements TakeIntRtnIntSolutionService{
    /**
     * 526. 优美的排列
     * https://leetcode-cn.com/problems/beautiful-arrangement/
     */

    @Override
    public int returnAns(int n) {
        return countArrangementRecursive(n);
    }

    int count = 0;

    private int countArrangementRecursive(int n) {
        // 回溯算法
        boolean[] used = new boolean[n];
        boolean[][] matchMatrix = new boolean[n][n];
        // used[i] means int i+1 has been used
        // match[i][j] means int i+1 can be put to position j+1
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                int currentNum = i+1;
                int position = j+1;
                if(currentNum%position==0 || position%currentNum==0){
                    matchMatrix[i][j] = true;
                }
            }
        }
        recursiveHelper(used,matchMatrix,1,n);
        return count;
    }

    private void recursiveHelper(boolean[] used, boolean[][] matchMatrix, int currentPosition, int limit){
        if(currentPosition==limit+1){
            count++;
            return;
        }
        for(int i=0;i<limit;i++){
            if(!used[i] && matchMatrix[i][currentPosition-1]){
                used[i] = true;
                recursiveHelper(used,matchMatrix,currentPosition+1,limit);
                used[i] = false;
            }
        }
    }
}
