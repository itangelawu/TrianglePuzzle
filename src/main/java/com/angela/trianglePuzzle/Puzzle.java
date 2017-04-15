package com.angela.trianglePuzzle;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Angela on 4/14/2017.
 */
public class Puzzle {

    private Node start;

    public Puzzle(Node n){
        this.start = n;
    }


    public List<Integer> findMax(Node n) {
        int path[] = new int[10000];;

        List<List<Integer>> paths = new ArrayList<List<Integer>>();

        findMaxRecursive(n, path, paths, 0);


        return paths.get(0);
    }

    public void findMaxRecursive(Node n, int[] path, List<List<Integer>> paths, int pathLen) {
        if (n == null)
            return;

        /* append this node to the path */
        path[pathLen] = n.getWeight();
        pathLen++;

        /* it's a leaf*/
        if (n.getLeft() == null && n.getRight() == null) {
            addPath(path,paths,pathLen);
        }

        else
        {
            /* otherwise try both subtrees */
            findMaxRecursive(n.getLeft(), path, paths, pathLen);
            findMaxRecursive(n.getRight(), path, paths, pathLen);
        }
    }

    public void addPath(int[] path, List<List<Integer>> paths, int pathLen){

        int i;
        long cSum = 0;
        long pSum = 0;

        List<Integer> l = new ArrayList<Integer>();

        for (i = 0; i < pathLen; i++){
            l.add(path[i]);
            cSum+=path[i];
        }

        //always put largest series in the collection
        if(paths.size()>0){
            for(int j = 0; j < paths.get(0).size(); j++)
                pSum+= (paths.get(0)).get(j);
            if(cSum>pSum) {
                paths.set(0, l);
                return;
            }
        }else
            paths.add(l);

    }

}
