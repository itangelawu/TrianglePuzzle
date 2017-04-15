package com.angela.trianglePuzzle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Angela on 4/14/2017.
 */
class PuzzleTest {

    private Node n;
    @BeforeEach
    void setUp() {

        PuzzleLoader loader = new PuzzleLoader("triangle_test_4rows");
        n = loader.loadPuzzle();

    }

    @Test
    void findMax() {
        Puzzle puzzle = new Puzzle(n);
        List<Integer> result =  puzzle.findMax(n);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(5);
        expected.add(9);
        expected.add(6);
        expected.add(7);

        assertEquals(expected, result);

    }

}