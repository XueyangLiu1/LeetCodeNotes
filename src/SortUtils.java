import java.util.Random;

public class SortUtils {
    public static void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    public static void quickSort(int[] nums,int left,int right){
        if(left>=right) return;
        Random r = new Random();
        int pivotIndex = r.nextInt(right-left) + left;
        swap(nums,pivotIndex,right);
        int writeHead = left;
        for(int i = left; i < right;i++){
            if(nums[i]<nums[right]){
                swap(nums,writeHead,i);
                writeHead++;
            }
        }
        swap(nums,writeHead,right);
        quickSort(nums,left,writeHead-1);
        quickSort(nums,writeHead+1,right);
    }

    private static void swap(int[] nums,int i,int j){
        assert(i>=0 && j>=0 && i<nums.length && j<nums.length);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
