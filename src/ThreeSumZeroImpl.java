import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSumZeroImpl implements TakeIntArrayRtnNestedIntListService {
    @Override
    public List<List<Integer>> returnAns(int[] nums) {
        return threeSum(nums);
    }

    @Override
    public void printResult(List<List<Integer>> ans) {
        for(List<Integer> lst : ans){
            for(Integer num : lst){
                System.out.print(num+"\t");
            }
            System.out.println();
        }
    }

    private List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<Integer> sortedNums = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();
        if(length<=2 || sortedNums.get(0)>0) return result;
        int readHead = 0;
        while(readHead<length-2){
            if(readHead>0 && sortedNums.get(readHead)==sortedNums.get(readHead-1)){
                readHead++;
                continue;
            }
            int target = - sortedNums.get(readHead);
            int left = readHead+1, right = length-1;
            while(left<right){
                int sum = sortedNums.get(left)+sortedNums.get(right);
                if(sum==target){
                    result.add(new ArrayList<>(Arrays.asList(-target,sortedNums.get(left),sortedNums.get(right))));
                    while (left < right && nums[left] == nums[left+1]){
                        right++;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }

                }else if(sum<target){
                    left++;
                }else{
                    right--;
                }
            }
            readHead++;
        }
        return result;
    }
}
