/*
A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */

package DailyChallenge.November2020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Nov4_MinHeightTrees
{
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = null;
        if (n <= 2) {
            leaves = new ArrayList<Integer>();

            for (int i = 0; i < n; i++) {
                leaves.add(i);
            }

            return leaves;
        }

        List<Set<Integer>> adjacencyLists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyLists.add(new HashSet<Integer>());
        }
        for (int[] edge : edges) {
            adjacencyLists.get(edge[0]).add(edge[1]);
            adjacencyLists.get(edge[1]).add(edge[0]);
        }

        leaves = new ArrayList<Integer>();
        for (int i = 0; i < adjacencyLists.size(); i++) {
            if (adjacencyLists.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        int remainingNodes = n;

        while(remainingNodes > 2) {
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                for (int adjacent : adjacencyLists.get(leaf)) {
                    adjacencyLists.get(adjacent).remove(leaf);
                    if (adjacencyLists.get(adjacent).size() == 1) {
                        newLeaves.add(adjacent);
                    }
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}
