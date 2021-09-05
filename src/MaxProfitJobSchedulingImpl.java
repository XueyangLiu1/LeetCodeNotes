import java.util.*;

public class MaxProfitJobSchedulingImpl implements TakeThreeArraysRtnIntSolutionService{
    @Override
    public int returnAns(int[] a, int[] b, int[] c) {
        return jobScheduling(a,b,c);
    }

    private int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        HashMap<Integer, Integer> maxProfitJobsSoFar = new HashMap<>();
        List<Integer> endTimesSoFar = new ArrayList<>();
        PriorityQueue<Job> jobs = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.getEndTime() - o2.getEndTime();
            }
        });

        for(int i = 0; i < startTime.length; i++){
            Job curr = new Job(startTime[i],endTime[i],profit[i]);
            jobs.add(curr);
        }
        maxProfitJobsSoFar.put(0,0);
        endTimesSoFar.add(0);
        while(!jobs.isEmpty()){
            Job curr = jobs.poll();
            int currStartTime = curr.getStartTime();
            int endTimeListSize = endTimesSoFar.size();
            int currAccumulatedProfit = maxProfitJobsSoFar.get(endTimesSoFar.get(endTimeListSize-1));
            for(int i = endTimeListSize-1;i>=0;i--){
                int backForwardEndTime = endTimesSoFar.get(i);
                if(backForwardEndTime<=currStartTime){
                    int moreProfit = curr.profit - (currAccumulatedProfit - maxProfitJobsSoFar.get(backForwardEndTime));
                    if(moreProfit>0){
                        while(endTimesSoFar.size()>i+2){
                            int removedEndTime = endTimesSoFar.get(i+1);
                            endTimesSoFar.remove(i+1);
                            maxProfitJobsSoFar.remove(removedEndTime);
                        }
                        endTimesSoFar.add(curr.getEndTime());
                        maxProfitJobsSoFar.put(curr.getEndTime(),currAccumulatedProfit+moreProfit);
                    }
                    break;
                }
            }
        }
        return maxProfitJobsSoFar.get(endTimesSoFar.get(endTimesSoFar.size()-1));
    }


    private static class Job{
        private int startTime;
        private int endTime;
        private int profit;

        Job(int startTime, int endTime, int profit){
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

        public int getStartTime(){
            return this.startTime;
        }

        public int getEndTime(){
            return this.endTime;
        }

        public int getProfit(){
            return this.profit;
        }
    }
}
