package NeetCode_150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q68_Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Form a graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for(int i = 0; i < m; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int indegree[] = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            for(int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<Integer>();
        // o(v + e)
        while(!q.isEmpty()) {
            int node = q.peek();

            q.remove();
            topo.add(node);
            // node is in your topo sort
            // so please remove it from the indegree

            for(int it : adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        if(topo.size() == numCourses) return true;
        return false;

    }
}
