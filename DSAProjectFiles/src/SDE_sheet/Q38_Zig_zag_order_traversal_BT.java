package SDE_sheet;

import BT.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q38_Zig_zag_order_traversal_BT {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }

        Deque<TreeNode> deque=new LinkedList<>();
        deque.offer(root);
        boolean reverse=false;
        while(!deque.isEmpty()){
            int levelsize=deque.size();
            List<Integer> levellist=new ArrayList<>(levelsize);
            for(int i=0;i<levelsize;i++){

                if(!reverse){

                    TreeNode currnode=deque.pollFirst();
                    levellist.add(currnode.val);

                    if(currnode.left!=null){
                        deque.addLast(currnode.left);
                    }

                    if(currnode.right!=null){
                        deque.addLast(currnode.right);
                    }
                }
                else{
                    TreeNode currnode=deque.pollLast();
                    levellist.add(currnode.val);
                    if(currnode.right!=null){
                        deque.addFirst(currnode.right);
                    }

                    if(currnode.left!=null){
                        deque.addFirst(currnode.left);
                    }


                }

            }
            reverse=!reverse;
            result.add(levellist);


        }
        return result;

    }
}
