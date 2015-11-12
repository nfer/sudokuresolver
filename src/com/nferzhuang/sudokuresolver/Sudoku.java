package com.nferzhuang.sudokuresolver;

public class Sudoku {
	private int data[] = new int[81];
	private int dataTips[][] = new int[81][9];

	public void init(int data[]) {
		this.data = data;

		for (int i = 0; i < 81; i++) {
			int value = data[i];
			if (value != 0) {
				dataTips[i][value - 1] = value;
			} else {
				for (int j = 0; j < 9; j++) {
					dataTips[i][j] = j + 1;
				}
			}
		}
	}

	public void output() {
		outputData();
		outputDataTips();
	}

	public void stepBox() {
		for (int i = 0; i < 81; i++) {
			int indexs[] = getBoxIndex(i);
			updateDataTips(i, indexs);
		}
	}

	public void stepRow() {
		for (int i = 0; i < 81; i++) {
			int indexs[] = getRowIndex(i);
			updateDataTips(i, indexs);
		}
	}

	public void stepColumn() {
		for (int i = 0; i < 81; i++) {
			int indexs[] = getColumnIndex(i);
			updateDataTips(i, indexs);
		}
	}

	private void outputBox(int index, int box[]) {
		System.out.println("©°©¤©¤©¤©Ğ©¤" + (index % 9 + 1) + "©¤©Ğ©¤©¤©¤©´");

		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0) {
				if (i % 6 != 0)
					System.out.print(index / 9 +1);
				else
					System.out.print("©¦");
			}

			int temp = box[i];
			if (temp == 0)
				System.out.print("   ");
			else
				System.out.print(" " + temp + " ");

			if (i % 3 == 2 && i != 9 - 1) {
				System.out.print("©¦");
				System.out.println("\n©À©¤©¤©¤©à©¤©¤©¤©à©¤©¤©¤©È");
			} else
				System.out.print("©¦");
		}

		System.out.println("\n©¸©¤©¤©¤©Ø©¤©¤©¤©Ø©¤©¤©¤©¼");
	}

	private void outputDataTips() {
		int start = 0;
		for (int i = start; i < start + 81; i++) {
			if (data[i] != 0)
				continue;

			outputBox(i, dataTips[i]);
		}
	}

	private void outputData() {
		System.out.println("©°©¤©¤©¤©¤©¤©¤©¤©Ğ©¤©¤©¤©¤©¤©¤©¤©Ğ©¤©¤©¤©¤©¤©¤©¤©´");

		for (int i = 0; i < 81; i++) {
			if (i % 9 == 0)
				System.out.print("©¦");
			int temp = data[i];
			if (temp == 0)
				System.out.print(" " + " ");
			else
				System.out.print(" " + temp);

			if (i % 3 == 2) {
				System.out.print(" ©¦");
				if (i % 9 == 8 && i % 27 != 26)
					System.out.println("");

				if (i % 27 == 26 && i != 81 - 1)
					System.out.println("\n©À©¤©¤©¤©¤©¤©¤©¤©à©¤©¤©¤©¤©¤©¤©¤©à©¤©¤©¤©¤©¤©¤©¤©È");
			}
		}

		System.out.println("\n©¸©¤©¤©¤©¤©¤©¤©¤©Ø©¤©¤©¤©¤©¤©¤©¤©Ø©¤©¤©¤©¤©¤©¤©¤©¼");
	}

	private int[] getBoxIndex(int index) {
		int result[] = { 0, 1, 2, 9, 10, 11, 18, 19, 20 };
		for (int i = 0; i < 9; i++) {
			result[i] += (index / 27) * 27 + index % 9 - index % 3;
		}
		return result;
	}

	public int[] getRowIndex(int index) {
		int result[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		for (int i = 0; i < 9; i++) {
			result[i] += (index / 9) * 9;
		}
		return result;
	}

	public int[] getColumnIndex(int index) {
		int result[] = { 0, 9, 18, 27, 36, 45, 54, 63, 72 };
		for (int i = 0; i < 9; i++) {
			result[i] += index % 9;
		}
		return result;
	}

	private int[] getBoxIndex2(int index) {
		if (index % 9 < 3) {
			int base[] = { 0, 1, 2, 9, 10, 11, 18, 19, 20 };
			for (int i = 0; i < 9; i++) {
				base[i] += (index / 27) * 27;
			}
			return base;
		} else if (index % 9 < 6) {
			int base[] = { 3, 4, 5, 12, 13, 14, 21, 22, 23 };
			for (int i = 0; i < 9; i++) {
				base[i] += (index / 27) * 27;
			}
			return base;
		} else {
			int base[] = { 6, 7, 8, 15, 16, 17, 24, 25, 26 };
			for (int i = 0; i < 9; i++) {
				base[i] += (index / 27) * 27;
			}
			return base;
		}
	}

	private int[] getBoxIndex1(int index) {
		if (index % 9 < 3) {
			if (index / 9 < 3) {
				int result[] = { 0, 1, 2, 9, 10, 11, 18, 19, 20 };
				return result;
			} else if (index / 9 < 6) {
				int result[] = { 27, 28, 29, 36, 37, 38, 45, 46, 47 };
				return result;
			} else {
				int result[] = { 54, 55, 56, 63, 64, 65, 72, 73, 74 };
				return result;
			}
		} else if (index % 9 < 6) {
			if (index / 9 < 3) {
				int result[] = { 3, 4, 5, 12, 13, 14, 21, 22, 23 };
				return result;
			} else if (index / 9 < 6) {
				int result[] = { 30, 31, 32, 39, 40, 41, 48, 49, 50 };
				return result;
			} else {
				int result[] = { 57, 58, 59, 66, 67, 68, 75, 76, 77 };
				return result;
			}
		} else {
			if (index / 9 < 3) {
				int result[] = { 6, 7, 8, 15, 16, 17, 24, 25, 26 };
				return result;
			} else if (index / 9 < 6) {
				int result[] = { 33, 34, 35, 42, 43, 44, 51, 52, 53 };
				return result;
			} else {
				int result[] = { 60, 61, 62, 69, 70, 71, 78, 79, 80 };
				return result;
			}
		}
	}

	private void updateDataTips(int i, int indexs[]) {
		if (data[i] != 0)
			return;

		for (int j = 0; j < 9; j++) {
			int index = indexs[j];
			int value = data[index];
			if (value != 0)
				dataTips[i][value - 1] = 0;
		}
	}
}
