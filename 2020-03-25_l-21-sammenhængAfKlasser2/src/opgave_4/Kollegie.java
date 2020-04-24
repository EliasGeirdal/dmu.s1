package opgave_4;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Kollegie {

	private String navn;
	private String adresse;
	// tvungen aggregering --> 0..* Bolig.
	private final ArrayList<Bolig> boliger = new ArrayList<>();

	public Kollegie(String navn, String adresse) {
		this.setAdresse(adresse);
		this.setNavn(navn);
	}

	@Override
	public String toString() {
		return "Kollegie [navn=" + navn + ", adresse=" + adresse + "]";
	}

	public double gennemsnitligAntalDage() {
		long between = 0;
		for (Bolig elements : boliger) {
			for (Lejeaftale lejeaftaleElements : elements.getLejeaftaler()) {
				if (lejeaftaleElements.getTilDato() != null)
					between += ChronoUnit.DAYS.between(lejeaftaleElements.getFraDato(),
							lejeaftaleElements.getTilDato());
			}
		}
		return between / (this.antalLejeAftaler());
	}

	/**
	 * Return amount of lejeaftaler the kollegie has had in total.
	 * 
	 * @return
	 */
	public int antalLejeAftaler() {
		int sum = 0;
		for (Bolig bolig : boliger) {
			sum += bolig.getLejeaftaler().size();
		}
		return sum;
	}

	public Bolig createBolig(int kvm, String adresse, int prisPrMåned, Kollegie kollegie) {
		Bolig bolig = new Bolig(kvm, adresse, prisPrMåned, kollegie);
		boliger.add(bolig);
		return bolig;
	}

	public ArrayList<Bolig> getBoliger() {
		return new ArrayList<>(boliger);
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}
