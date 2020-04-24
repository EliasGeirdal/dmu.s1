package tidsregistrering;

import java.time.LocalDate;

public class Projekt {

	private String titel;
	private String status;
	private String projekleder;
	private String projektBeskrivelse;
	private LocalDate deadline;
	private LocalDate date;

	public Projekt(String titel, LocalDate date, LocalDate deadline) {
		this.titel = titel;
		this.status = "åben";
		this.date = date;
		this.deadline = deadline;
	}

	public void setProjektBeskrivelse(String beskrivelse) {
		projektBeskrivelse = beskrivelse;
	}

	public String getProjektBeskrivelse() {
		return projektBeskrivelse;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getTite() {
		return titel;
	}

	public void lukProjekt() {
		if (status == "åben")
			status = "lukket";
	}

	public void åbenProjekt() {
		if (status != "åben")
			status = "åben";
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

}