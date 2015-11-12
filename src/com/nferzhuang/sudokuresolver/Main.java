package com.nferzhuang.sudokuresolver;

public class Main {

	public static void main(String[] args) {
		Sudoku sudoku = new Sudoku();
		int data[] = { 0, 1, 0, 8, 0, 5, 0, 3, 0, 0, 7, 0, 9, 0, 2, 0, 1, 0, 0,
				0, 8, 1, 0, 6, 7, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 1, 3, 5, 0, 0,
				0, 0, 0, 8, 2, 7, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 4, 6, 0, 1, 2,
				0, 0, 0, 6, 0, 3, 0, 4, 0, 5, 0, 0, 9, 0, 7, 0, 8, 0, 4, 0 };
		int countBefore = -1, countAfter = 0, loop = 0;

		sudoku.init(data);
		sudoku.outputData();
		countBefore = sudoku.count();
		System.out.println("data count:" + countBefore);

		while (countBefore != countAfter && countAfter != 81) {
			countBefore = countAfter;
			sudoku.stepBox();
			sudoku.stepRow();
			sudoku.stepColumn();
			sudoku.updateDataFromTips();
			sudoku.outputData();
			countAfter = sudoku.count();
			System.out.println("data count:" + countAfter);
			loop++;
		}
		System.out.println("loop count:" + loop);
	}

}
