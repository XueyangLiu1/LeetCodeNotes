import java.util.HashMap;

public class MaxProfitJobSchedulingImpl implements TakeThreeArraysRtnIntSolutionService{
    @Override
    public int returnAns(int[] a, int[] b, int[] c) {
        return jobScheduling(a,b,c);
    }

    private int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        HashMap<Integer, Integer> maxProfitJobsSoFar = new HashMap<>();
        return 0;
    }
}
