package ub.cse.algo;

import java.util.*;

/**
 * For use in CSE 331
 */
public class Solution {

    private ArrayList<ArrayList<Integer>> adj_matrix;

    public Solution(ArrayList<ArrayList<Integer>> adj_matrix) {
        this.adj_matrix = adj_matrix;
    }

    public int[] outputEdges() {
        int sizer = adj_matrix.get(0).size();
        int[] ret_val = new int[sizer];
        ret_val[0] = -1;
        int[] shortest_weight = new int[sizer];
        int[] best_possible_parent = new int[sizer];
        boolean[] no_fomo=new boolean [sizer];
        no_fomo[0]=true;
        int min_weight = Integer.MAX_VALUE;
        int next_node_id = -1;
        for (int i = 0; i < sizer; i++) {
            int hold_1=adj_matrix.get(0).get(i);
            if (hold_1 != -1 && hold_1 < min_weight) {
                min_weight = hold_1;
                next_node_id = i;
            }
        }
        ret_val[next_node_id] = 0;
        no_fomo[next_node_id]=true;
        for (int i = 0; i < sizer; i++) {
            if (!no_fomo[i]) {
                int a=adj_matrix.get(i).get(0);
                int b=adj_matrix.get(i).get(next_node_id);
                if (a == -1 && b== -1) {
                    shortest_weight[i] = Integer.MAX_VALUE;
                    continue;
                }
                if (a != -1 && b != -1) {
                    if (a < b) {
                        shortest_weight[i] = a;
                        best_possible_parent[i] = 0;
                    } else {
                        shortest_weight[i] = b;
                        best_possible_parent[i] = next_node_id;
                    }
                    continue;
                }
                if (a != -1 || b!= -1) {
                    if (a != -1) {
                        shortest_weight[i] = a;
                        best_possible_parent[i] = 0;
                    } else {
                        shortest_weight[i] = b;
                        best_possible_parent[i] = next_node_id;
                    }
                }
            }
        }
        int counter = 2;
        while (counter != sizer) {
            int minimum = Integer.MAX_VALUE;
            int saver = -2;
            for (int i = 0; i < sizer; i++) {
                if (no_fomo[i]) {
                    continue;
                }
                if (shortest_weight[i] < minimum) {
                    minimum = shortest_weight[i];
                    saver = i;
                }
            }
            no_fomo[saver]=true;
            counter++;
            ret_val[saver] = best_possible_parent[saver];
            for (int i = 0; i < sizer; i++) {
                if (no_fomo[i]) {
                    continue;
                }
                int p=adj_matrix.get(saver).get(i);
                if ( p != -1 && p< shortest_weight[i]) {
                    shortest_weight[i] = p;
                    best_possible_parent[i] = saver;
                }
            }

        }
        return ret_val;
    }
}

