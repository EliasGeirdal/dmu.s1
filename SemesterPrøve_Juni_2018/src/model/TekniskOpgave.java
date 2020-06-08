package model;

public class TekniskOpgave extends PraktikOpgave {
	private String programmeringsSprog;

	public TekniskOpgave(String navn, int semester, PraktikVirksomhed praktikVirksomhed, String programmeringsSprog) {
		super(navn, semester, praktikVirksomhed);
		this.programmeringsSprog = programmeringsSprog;
	}

	public String getProgrammeringsSprog() {
		return programmeringsSprog;
	}

	public void setProgrammeringsSprog(String programmeringsSprog) {
		this.programmeringsSprog = programmeringsSprog;
	}

	@Override
	public String toString() {
		return "TekniskOpgave [programmeringsSprog=" + programmeringsSprog + ", getNavn()=" + getNavn()
				+ ", getSemester()=" + getSemester() + "]";
	}

}
