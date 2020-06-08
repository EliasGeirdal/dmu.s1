package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PraktikVirksomhed {
	private String navn, feedback, kontaktperson;
	private ArrayList<PraktikKontrakt> praktikKontrakter = new ArrayList<>();
	private ArrayList<PraktikOpgave> praktikOpgaver = new ArrayList<>();

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
			if (praktikKontrakt.getPeriodeStart().isAfter(start) && praktikKontrakt.getPeriodeSlut().isBefore(slut)) {
				long antalUger = ChronoUnit.WEEKS.between(praktikKontrakt.getPeriodeStart(),
						praktikKontrakt.getPeriodeSlut());
				sum += antalUger * praktikKontrakt.getTimerPerUge();
			}
		}
		return sum;
	}

	public ArrayList<PraktikKontrakt> soterKontraker() {
		ArrayList<PraktikKontrakt> kontrakter = new ArrayList<>();
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
		return new ArrayList<>(kontrakter);
	}

	public void skrivTilFilKontrakter() throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(new File(this.navn))) {
			for (PraktikKontrakt praktikKontrakt : praktikKontrakter) {
				pw.println(praktikKontrakt);
			}
		}
	}

	// -----------------------sammenhænge------------------------------

	public PraktikOpgave createPraktikOpgave(String navn, int semester) {
		PraktikOpgave praktikOpgave = new PraktikOpgave(navn, semester, this);
		praktikOpgaver.add(praktikOpgave);
		return praktikOpgave;
	}

	public AnalyseOpgave createAnalyseOpgave(String navn, int semester, String analyseModel) {
		AnalyseOpgave analyseOpgave = new AnalyseOpgave(navn, semester, this, analyseModel);
		praktikOpgaver.add(analyseOpgave);
		return analyseOpgave;
	}

	public TekniskOpgave createTekniskOpgave(String navn, int semester, String programmeringsSprog) {
		TekniskOpgave tekniskOpgave = new TekniskOpgave(navn, semester, this, programmeringsSprog);
		praktikOpgaver.add(tekniskOpgave);
		return tekniskOpgave;
	}

	public void addPraktikKontrakt(PraktikKontrakt praktikKontrakt) {
		if (!praktikKontrakter.contains(praktikKontrakt)) {
			praktikKontrakter.add(praktikKontrakt);
		}
	}

	public void removePraktikKontrakt(PraktikKontrakt praktikKontrakt) {
		if (praktikKontrakter.contains(praktikKontrakt)) {
			praktikKontrakter.remove(praktikKontrakt);
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

	@Override
	public String toString() {
		return "PraktikVirksomhed [navn=" + navn + ", feedback=" + feedback + ", kontaktperson=" + kontaktperson + "]";
	}

}
