package SDE_sheet;

import BT.TreeNode;

import java.util.Stack;

public class Q46_BST_iterator {
    private Stack<TreeNode> stack=new Stack<TreeNode>();
    public Q46_BST_iterator(TreeNode root) {
        pushall(root);
    }

    public int next() {
        TreeNode temp=stack.pop();
        pushall(temp.right);
        return temp.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
    private void pushall(TreeNode node){
        while(node!=null){
            stack.push(node);
            node=node.left;
        }
    }
}
