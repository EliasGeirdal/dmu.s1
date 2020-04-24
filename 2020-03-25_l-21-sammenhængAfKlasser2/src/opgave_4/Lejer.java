package opgave_4;

public class Lejer {
	private String navn;
	private String uddannelse;

	public Lejer(String navn, String uddannelse) {
		this.setNavn(navn);
		this.setUddannelse(uddannelse);
	}

	public String getNavn() {
		return navn;
	}

	@Override
	public String toString() {
		return "Lejer [navn=" + navn + ", uddannelse=" + uddannelse + "]";
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getUddannelse() {
		return uddannelse;
	}

	public void setUddannelse(String uddannelse) {
		this.uddannelse = uddannelse;
	}
}
