package model;

public class Bil {
	private String maerke, model, regNr;
	private Prisgruppe prisgr; // nullable.
	private Status status;

	public Bil(String mærke, Prisgruppe prisgr, String regNr) {
		this.maerke = mærke;
		this.setPrisgr(prisgr);
		this.regNr = regNr;
	}

	public Prisgruppe getPrisgr() {
		return prisgr;
	}

	public void setPrisgr(Prisgruppe prisgr) {
		if (this.prisgr != prisgr) {
			Prisgruppe oldGruppe = this.prisgr;
			if (oldGruppe != null) {
				oldGruppe.removeBil(this);
			}
			this.prisgr = prisgr;
			if (prisgr != null) {
				prisgr.addBil(this);
			}
		}
	}

	public String getMærke() {
		return maerke;
	}

	public String getRegNr() {
		return regNr;
	}

	public void setRegNr(String regNr) {
		this.regNr = regNr;
	}
}
