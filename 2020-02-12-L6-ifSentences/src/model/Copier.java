package model;

public class Copier {

	// instance variable:
	private int paper = 0;
	private boolean paperStuck;

	// constructor:
	public Copier() {
		if (paper >= 500)
			System.out.println("Max limit of paper is hit.");

	}

	public Copier(int paper) {
		if (paper < 500)
			this.paper = paper;
		else
			System.out.println("Max limit of paper is hit.");
	}

	// method: insert a paper in the copier by the method: insertPaper();.
	public void insertPaper(int insertedPaper) {
		if (paper >= 500)
			System.out.println("Max limit of paper is hit.");
		else
			this.paper = paper + insertedPaper;
	}

	// method: get paper is accessed by getPaper(); method.
	public int getPaper() {
		return paper;
	}

	// method: make copy mutated by makeCopy(); method. If there's no paper, word
	// this by print method.
	public void makeCopy(int copy) {

		if (paperStuck) {
			System.out.println("There is a paper jam");
		} else {
			if (paper > 0)
				if (copy > paper) {
					int missing = copy % paper;
					System.out.println("Not enough papers. Please insert: " + missing);
					this.paper = copy / paper - 1;
				} else
					this.paper = paper - copy;
			else
				System.out.println("Paper missing");
		}
	}

	public void makePaperJam() {
		paperStuck = true;
		if (paperStuck = true)
			System.out.println("Paper is stuck in copier.");
	}

	public void fixJam() {
		paperStuck = false;
	}

}
