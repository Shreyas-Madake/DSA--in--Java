package NeetCode_150;

import BT.TreeNode;

public class Q30_sumroot {



        public int sumNumbers(TreeNode root) {
            return helper(root,0);
        }
        int helper(TreeNode node, int sum){
            if(node==null){
                return 0;
            }
            sum=sum*10 + node.val;
            if(node.left==null && node.right==null){
                return sum;
            }
            return helper(node.left,sum) + helper(node.right,sum);
        }
    }


