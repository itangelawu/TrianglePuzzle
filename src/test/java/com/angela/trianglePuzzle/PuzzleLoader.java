package com.angela.trianglePuzzle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Angela on 4/14/2017.
 */
public class PuzzleLoader {
    private String fileName;

    public PuzzleLoader(String fName){
        this.fileName = fName;
    }

    public Node loadPuzzle(){

        Node start = null;
        List<Node> pLine = new ArrayList<Node>(); //hold previous line of input file, need to create children for each node later
        //Get file from resources folder
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());


        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splited = line.split("\\s+");

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

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return start;
    }
}
