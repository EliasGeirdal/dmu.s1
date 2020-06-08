package model;

public class AnalyseOpgave extends PraktikOpgave {

	private String analyseModel;

	public AnalyseOpgave(String navn, int semester, PraktikVirksomhed praktikVirksomhed, String analyseModel) {
		super(navn, semester, praktikVirksomhed);
		this.analyseModel = analyseModel;
	}

	public String getAnalyseModel() {
		return analyseModel;
	}

	public void setAnalyseModel(String analyseModel) {
		this.analyseModel = analyseModel;
	}

	@Override
	public String toString() {
		return "AnalyseOpgave [analyseModel=" + analyseModel + ", getNavn()=" + getNavn() + ", getSemester()="
				+ getSemester() + "]";
	}

}
