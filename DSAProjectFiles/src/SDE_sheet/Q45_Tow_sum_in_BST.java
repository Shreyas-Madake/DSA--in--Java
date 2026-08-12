package SDE_sheet;

import BT.TreeNode;

import java.util.HashSet;

public class Q45_Tow_sum_in_BST {
    HashSet<Integer> set=new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        if(set.contains(k-root.val)) return true;
        set.add(root.val);
        return findTarget(root.left,k) || findTarget(root.right,k);


    }
}
