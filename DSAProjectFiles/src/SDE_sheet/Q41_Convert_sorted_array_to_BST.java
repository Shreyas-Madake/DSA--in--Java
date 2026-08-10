package SDE_sheet;

import BT.TreeNode;

public class Q41_Convert_sorted_array_to_BST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        return constructTreeFromArray(nums,0,nums.length-1);

    }
    public TreeNode constructTreeFromArray(int[] nums,int l,int r){
        if(l>r) return null;
        int mid= l + (r-l ) / 2;
        TreeNode node =new TreeNode(nums[mid]);
        node.left=constructTreeFromArray(nums,l,mid-1);
        node.right=constructTreeFromArray(nums,mid+1,r);
        return node;
    }
}
