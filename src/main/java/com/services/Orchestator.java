package com.services;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import org.springframework.stereotype.Service;

@Service
public class Orchestator implements IOrchestator {

	private static final String FILE_NAME = "celebrityInputFile.txt";

	private static int people[][];

	@Override
	public int execute(int testCasesId) throws IOException {
		people = readInputFile(testCasesId);
//		people = createMatrix(fileContent);
		int celebrityId = findTheCelebrityId(people);
		return celebrityId;
	}

	private int[][] readInputFile(int testCasesId) throws IOException {
		File file = new File(FILE_NAME); // filename is a user input
	    Scanner fileScan = new Scanner(file);   

	    // determine the board size
	    int rows = fileScan.nextInt();
	    int cols = fileScan.nextInt();
	    fileScan.nextLine();

	    int[][] board = new int[rows][cols];    

	    for( int row = 0; row < board.length; row++){
	        for (int col = 0; col < board[row].length ; col++){
	            if (fileScan.hasNext()) {
	                board[row][col] = new Integer(fileScan.next());
	                System.out.print(board[row][col] + "");
	            }
	        }
	        System.out.println("");
	    }
	    return board;
	}

	private int findTheCelebrityId(int[][] arrayFromFile) {
		people = arrayFromFile;
		// Matrix size
		int n = 2;

		// Returns -1 if celebrity
		// is not present. If present,
		// returns id (value from 0 to n-1).
		Stack<Integer> st = new Stack<>();
		int c;

		// Step 1 :Push everybody
		// onto stack
		for (int i = 0; i < n; i++) {
			st.push(i);
		}

		while (st.size() > 1) {
			// Step 2 :Pop off top
			// two persons from the
			// stack, discard one
			// person based on return
			// status of knows(A, B).
			int a = st.pop();
			int b = st.pop();

			// Step 3 : Push the
			// remained person onto stack.
			if (checkPeople(a, b)) {
				System.out.print("a y b: "+a+" "+b);
				st.push(b);
			}

			else
				st.push(a);
		}

		c = st.pop();

		// Step 5 : Check if the last
		// person is celebrity or not
		for (int i = 0; i < n; i++) {
			// If any person doesn't
			// know 'c' or 'a' doesn't
			// know any person, return -1
			if (i != c && (checkPeople(c, i) || !checkPeople(i, c)))
				return -1;
		}
		return c;
	}

	private boolean checkPeople(int a, int b) {
		boolean res = (people[a][b] == 1) ? true : false;
		return res;
	}
}
