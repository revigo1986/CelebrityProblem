package com.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class Orchestator implements IOrchestator {

	private static final String INPUT_FILE = "celebrityInputFile.txt";

	private static int people[][];
	
	@Override
	public int execute() throws IOException {
		people = readInputFile();
		int celebrityId = findTheCelebrityId(people);
		return celebrityId;
	}

	private int[][] readInputFile() throws IOException {
		File file = new File(INPUT_FILE);
	    Scanner fileScan = new Scanner(file);   

	    int rows = fileScan.nextInt();
	    int cols = fileScan.nextInt();
	    fileScan.nextLine();

	    int[][] square = new int[rows][cols];    

	    for( int row = 0; row < square.length; row++){
	        for (int col = 0; col < square[row].length ; col++){
	            if (fileScan.hasNext()) {
	                square[row][col] = new Integer(fileScan.next());
	            }
	        }
	    }
	    return square;
	}

	private int findTheCelebrityId(int[][] arrayFromFile) {
		people = arrayFromFile;

		List<Integer> list = new ArrayList<>();
		int celebrityId;

		for (int i = 0; i < people.length; i++) {
			list.add(i);
		}

		while (list.size() > 1) {
			int a = list.get(0);
			int b = list.get(1);
			list.remove(1);
			list.remove(0);
			
			if (doesAKnowsB(a, b)) {
				list.add(b);
			}else {
				list.add(a);
			}
		}

		celebrityId = list.get(0);

		for (int i = 0; i < people.length; i++) {
			if (i != celebrityId) {
				if (doesAKnowsB(celebrityId, i) || !doesAKnowsB(i, celebrityId)) {
					return -1;
				}
			}
		}
		return celebrityId;
	}

	private boolean doesAKnowsB(int a, int b) {
		Boolean result;
		if (people[a][b] == 1) {
			result = true;
		}else {
			result = false;
		}
		return result;
	}
}
