import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MinimumRemoveMakeValidParenthesesImpl implements TakeStringRtnStringService{
    @Override
    public String returnAns(String s) {
        return minRemoveToMakeValid(s);
    }

    /**
     * 1249. Minimum Remove to Make Valid Parentheses
     * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
     */

    private String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        Set<Integer> removeIndex = new HashSet<>();
        Deque<Integer> indexStack = new LinkedList<>();

        for(int i = 0; i< chars.length;i++){
            if(chars[i]=='('){
                indexStack.offerLast(i);
            }else if(chars[i]==')'){
                if(indexStack.isEmpty()){
                    removeIndex.add(i);
                }else{
                    indexStack.pollLast();
                }
            }
        }
        while(!indexStack.isEmpty()){
            removeIndex.add(indexStack.pollLast());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<chars.length;i++){
            if(!removeIndex.contains(i)){
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
