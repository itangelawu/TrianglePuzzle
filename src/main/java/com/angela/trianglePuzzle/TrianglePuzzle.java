package com.angela.trianglePuzzle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Angela on 4/14/2017.
 */
public class TrianglePuzzle {

    public static void main(String args[]) {

        String fileName = null;
        //if (0 < args.length) {
            //fileName = args[0];
            fileName = "C:\\workspace\\Triangle\\src\\main\\resources\\triangle_test_100rows.txt";
        //} else {
      //      System.err.println("Invalid arguments count:" + args.length);
      //      return;
      //  }

        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            //input every line to a List
            list = stream
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        Node n = loadPuzzle(list);

        Puzzle puzzle = new Puzzle(n);

        List<Integer> path = puzzle.findMax(n);

        int sum = 0;
        for(Integer i:path){
            if(sum==0) {
                System.out.print(i);
                sum+=i;
            }
            else
                System.out.print("+"+i);
        }

        System.out.println("="+sum);

    }

    public static Node loadPuzzle(List lines){

        Node start=null;
        List<Node> pLine = new ArrayList<Node>(); //hold previous line of input file, need to create children for each node later


            for(Object line:lines) {
                String[] splited = ((String)line).split("\\s+");

                if(pLine.size()==0){ //begining
                    Node n = new Node(new Integer(splited[0]).intValue());
                    start = n;
                    pLine.add(n);
                }else{
                    int i = 0;
                    List<Node> cLine = new ArrayList<Node>(); //hold current line of input file, need to create children for each node later
                    Node nl = null;
                    for (Node n: pLine){
                        if(nl == null) {
                            nl = new Node(new Integer(splited[i]).intValue());
                            cLine.add(nl);
                        }
                        Node nr = new Node(new Integer(splited[++i]).intValue());
                        cLine.add(nr);

                        n.setLeft(nl);
                        n.setRight(nr);
                        nl = nr;
                    }
                    pLine=cLine;

                }


            }


        return start;
    }


}
