package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PraktikVirksomhed {
	private String navn, feedback, kontaktperson;
	private final ArrayList<PraktikKontrakt> praktikKontrakter = new ArrayList<>();
	private final ArrayList<PraktikOpgave> praktikOpgaver = new ArrayList<>();

	public PraktikVirksomhed(String navn, String feedback, String kontaktperson) {
		this.navn = navn;
		this.feedback = feedback;
		this.kontaktperson = kontaktperson;
	}

	// ---------------------------------------------------------------

	public int antalPraktikOpgaverPåSemester(int semester) {
		int antal = 0;
		for (PraktikOpgave praktikOpgave : praktikOpgaver) {
			if (praktikOpgave.getSemester() == semester) {
				antal++;
			}
		}

		return antal;
	}

	public int getTotalAntalUgentligeTimerIPeriode(LocalDate start, LocalDate slut) {
		int sum = 0;
		for (PraktikKontrakt praktikKontrakt : praktikKontrakter) {
			// Use compareTo in the following.
			if (praktikKontrakt.getPeriodeStart().isAfter(start) && praktikKontrakt.getPeriodeSlut().isBefore(slut)) {
				long antalUger = ChronoUnit.WEEKS.between(praktikKontrakt.getPeriodeStart(),
						praktikKontrakt.getPeriodeSlut());
				sum += antalUger * praktikKontrakt.getTimerPerUge();
			}
		}
		return sum;
	}

	public ArrayList<PraktikKontrakt> sorterKontrakter() {
		for (int index = 1; index < praktikKontrakter.size(); index++) {
			Comparable<PraktikKontrakt> key = praktikKontrakter.get(index);
			int position = index;

			// shift larger values to the right.
			while (position > 0 && praktikKontrakter.get(position - 1).compareTo((PraktikKontrakt) key) > 0) {
				praktikKontrakter.set(position, praktikKontrakter.get(position - 1));
				position--;
			}
			praktikKontrakter.set(position, (PraktikKontrakt) key);
		}
		return new ArrayList<>(praktikKontrakter);
	}

	public void skrivTilFilKontrakter() throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(new File("src\\model\\" + this.navn + ".txt"))) {
			for (PraktikKontrakt praktikKontrakt : praktikKontrakter) {
				pw.println(praktikKontrakt);
			}
		}
	}

	// -----------------------sammenhænge------------------------------

	public AnalyseOpgave createAnalyseOpgave(String navn, int semester, String analyseModel) {
		AnalyseOpgave analyseOpgave = new AnalyseOpgave(navn, semester, analyseModel);
		praktikOpgaver.add(analyseOpgave);
		return analyseOpgave;
	}

	public TekniskOpgave createTekniskOpgave(String navn, int semester, String programmeringsSprog) {
		TekniskOpgave tekniskOpgave = new TekniskOpgave(navn, semester, programmeringsSprog);
		praktikOpgaver.add(tekniskOpgave);
		return tekniskOpgave;
	}

	public void addPraktikKontrakt(PraktikKontrakt praktikKontrakt) {
		if (!praktikKontrakter.contains(praktikKontrakt)) {
			praktikKontrakter.add(praktikKontrakt);
			praktikKontrakt.setPraktikVirksomhed(this); // remember this!!
		}
	}

	public void removePraktikKontrakt(PraktikKontrakt praktikKontrakt) {
		if (praktikKontrakter.contains(praktikKontrakt)) {
			praktikKontrakter.remove(praktikKontrakt);
			praktikKontrakt.setPraktikVirksomhed(null); // remember this!!
		}
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getKontaktperson() {
		return kontaktperson;
	}

	public void setKontaktperson(String kontaktperson) {
		this.kontaktperson = kontaktperson;
	}

	public ArrayList<PraktikKontrakt> getPraktikKontrakter() {
		return new ArrayList<>(praktikKontrakter);
	}

	public ArrayList<PraktikOpgave> getPraktikOpgaver() {
		return new ArrayList<>(praktikOpgaver);
	}

	@Override
	public String toString() {
		return "PraktikVirksomhed [navn=" + navn + ", feedback=" + feedback + ", kontaktperson=" + kontaktperson + "]";
	}

}
