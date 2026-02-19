package NeetCode_150;

public class Q43_count_goodnodes_inBT {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public int goodNodes(TreeNode root) {
        return helper(root,root.val);
    }
    int helper(TreeNode root, int currentpathmax){
        if(root==null){
            return 0;
        }
        if(root.val>=currentpathmax){
            return 1+helper(root.left,root.val)+helper(root.right,root.val);
        }
        return helper(root.left,currentpathmax)+helper(root.right,currentpathmax);
    }
}
