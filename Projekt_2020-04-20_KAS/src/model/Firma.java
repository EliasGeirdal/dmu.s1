package model;

public class Firma {
	// instance variables.
	private String navn, tlf, adresse;

	public Firma(String navn, String tlf) {
		super();
		this.navn = navn;
		this.tlf = tlf;
	}

	// ----------------instance-----------------------
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
