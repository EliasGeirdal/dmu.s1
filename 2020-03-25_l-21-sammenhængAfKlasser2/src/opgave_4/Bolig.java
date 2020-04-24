package opgave_4;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bolig {

	private int kvm;
	private String adresse;
	private int prisPrMåned;
	// simpel link attribut - bolig kan kun tilhøre ét kollegie.
	private Kollegie kollegie;
	// Link attribut - én bolig kan have mange lejeaftaler.
	private final ArrayList<Lejeaftale> lejeaftaler = new ArrayList<>();

	public Bolig(int kvm, String adresse, int prisPrMåned, Kollegie kollegie) {
		this.setAdresse(adresse);
		this.setKvm(kvm);
		this.setPrisPrMåned(prisPrMåned);
		this.kollegie = kollegie;
	}

	@Override
	public String toString() {
		return "Bolig [kvm=" + kvm + ", adresse=" + adresse + ", prisPrMåned=" + prisPrMåned + ", kollegie=" + kollegie
				+ "Lejeaftaler" + "]";
	}

	/**
	 * Initialise lejeaftale, adds it to the lejeaftaler array and returns the
	 * created lejeaftale.
	 * 
	 * @param fraDato
	 * @return
	 */
	public Lejeaftale createLejeaftale(Bolig bolig, LocalDate fraDato) {
		Lejeaftale lejeaftale = new Lejeaftale(bolig, fraDato);
		lejeaftaler.add(lejeaftale);
		return lejeaftale;
	}

	public ArrayList<Lejeaftale> getLejeaftaler() {
		return new ArrayList<>(lejeaftaler);
	}

	public int getKvm() {
		return kvm;
	}

	public void setKvm(int kvm) {
		this.kvm = kvm;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getPrisPrMåned() {
		return prisPrMåned;
	}

	public void setPrisPrMåned(int prisPrMåned) {
		this.prisPrMåned = prisPrMåned;
	}

	public Kollegie getKollegie() {
		return kollegie;
	}
}
