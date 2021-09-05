import java.util.List;

public class TreeNodeUtils {
    void printTreeNodeList(List<TreeNode> treeNodes){
        for(TreeNode head : treeNodes){
            String representation = buildStringFromHeadNode(head);
            System.out.println(representation);
        }
    }

    String buildStringFromHeadNode(TreeNode head){
        StringBuilder sb = new StringBuilder();
        recursiveHelper(head,sb);
        return sb.toString();
    }

    void recursiveHelper(TreeNode curr, StringBuilder sb){
        if(curr==null){
            sb.append("null");
            sb.append(" ");
            return;
        }
        sb.append(curr.val);
        sb.append(" ");
        recursiveHelper(curr.left,sb);
        recursiveHelper(curr.right,sb);
    }
}
