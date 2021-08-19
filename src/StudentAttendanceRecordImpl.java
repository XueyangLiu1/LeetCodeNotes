public class StudentAttendanceRecordImpl implements TakeIntRtnIntSolutionService {
    /**
     *  552. 学生出勤记录 II
     *  https://leetcode-cn.com/problems/student-attendance-record-ii/
     */
    int allPossibility = 0;
    int MOD = 1000000007;

    @Override
    public int returnAns(int n) {
        return checkRecordDynamic(n);
    }

    private int checkRecordDynamic(int n){
        //all "absent" means consecutive absent

        //dp: (LateTimes, absentTimes) 0  1  2  3  4  5  ...  n-1
        //            (0, 0)           1  2 ...
        //            (0, 1)           1  3 ...
        //            (1, 0)           1  1 ...
        //            (1, 1)           0  1 ...
        //            (2, 0)           0  1 ...
        //            (2, 1)           0  0 ...
        int[][] dp = new int[6][n];
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[3][0] = 0;
        dp[4][0] = 0;
        dp[5][0] = 0;
        for(int i = 1;i<n;i++){
            int neverLateOrAbsent = dp[0][i-1];
            int neverLateAbsentOnce = dp[1][i-1];
            int lateOnceNeverAbsent = dp[2][i-1];
            int lateOnceAbsentOnce = dp[3][i-1];
            int lateTwiceNeverAbsent = dp[4][i-1];
            int lateTwiceAbsentOnce = dp[5][i-1];
            dp[0][i] = mySum(neverLateOrAbsent,lateOnceNeverAbsent,lateTwiceNeverAbsent);
            dp[1][i] = mySum(neverLateOrAbsent,neverLateAbsentOnce,lateOnceNeverAbsent,lateOnceAbsentOnce,lateTwiceNeverAbsent,lateTwiceAbsentOnce);
            dp[2][i] = neverLateOrAbsent;
            dp[3][i] = neverLateAbsentOnce;
            dp[4][i] = lateOnceNeverAbsent;
            dp[5][i] = lateOnceAbsentOnce;
        }
        int sum = mySum(dp[0][n-1],dp[1][n-1],dp[2][n-1],dp[3][n-1],dp[4][n-1],dp[5][n-1]);
        return sum;
        //this function can be optimized by using only one column to store 6 numbers
        //reduce the space complexity from O(n) to O(1)
    }

    private int mySum(Integer...nums){
        int sum = 0;
        for(int num : nums){
            sum = (sum+num)%MOD;
        }
        return sum;
    }


    private int checkRecordRecursive(int n){
        // 回溯算法
        recursiveHelper(0,0,0,n);
        return allPossibility;
    }

    private void recursiveHelper(int currentLength, int consecutiveLateTimes, int absentTimes, int limit){
        if(currentLength==limit){
            allPossibility += 1;
            if(allPossibility==MOD){
                allPossibility = 0;
            }
            return;
        }
        if(consecutiveLateTimes==2 && absentTimes==1){
            //next one can only be present
            recursiveHelper(currentLength+1,0,absentTimes,limit);
        }else if(consecutiveLateTimes<2 && absentTimes==1){
            //next one can be late or present
            recursiveHelper(currentLength+1,consecutiveLateTimes+1,absentTimes,limit);
            recursiveHelper(currentLength+1,0,absentTimes,limit);
        }else if(consecutiveLateTimes==2 && absentTimes<1){
            //next one can be present or absent
            recursiveHelper(currentLength+1,0,absentTimes,limit);
            recursiveHelper(currentLength+1,0,absentTimes+1,limit);
        }else{
            //next one can be any one of the three
            recursiveHelper(currentLength+1,0,absentTimes,limit);
            recursiveHelper(currentLength+1,0,absentTimes+1,limit);
            recursiveHelper(currentLength+1,consecutiveLateTimes+1,absentTimes,limit);
        }
    }
}
