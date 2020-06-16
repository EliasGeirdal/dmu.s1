package model;

import java.time.LocalDate;

public class PraktikKontrakt implements Comparable<PraktikKontrakt> {
	private String opgavebeskrivelse;
	private int timerPerUge;
	private LocalDate periodeStart, periodeSlut;
	private PraktikVirksomhed praktikVirksomhed;

	public PraktikKontrakt(String opgavebeskrivelse, int timerPerUge, LocalDate periodeStart, LocalDate periodeSlut) {
		this.opgavebeskrivelse = opgavebeskrivelse;
		this.timerPerUge = timerPerUge;
		this.periodeStart = periodeStart;
		this.periodeSlut = periodeSlut;
	}

	public void setPraktikVirksomhed(PraktikVirksomhed praktikVirksomhed) {
		if (this.praktikVirksomhed != praktikVirksomhed) {
			PraktikVirksomhed OldpraktikVirksomhed = this.praktikVirksomhed;
			if (OldpraktikVirksomhed != null) {
				OldpraktikVirksomhed.removePraktikKontrakt(this);
			}
			this.praktikVirksomhed = praktikVirksomhed;
			if (praktikVirksomhed != null) {
				praktikVirksomhed.addPraktikKontrakt(this);
			}
		}
	}

	public String getOpgavebeskrivelse() {
		return opgavebeskrivelse;
	}

	public void setOpgavebeskrivelse(String opgavebeskrivelse) {
		this.opgavebeskrivelse = opgavebeskrivelse;
	}

	public int getTimerPerUge() {
		return timerPerUge;
	}

	public void setTimerPerUge(int timerPerUge) {
		this.timerPerUge = timerPerUge;
	}

	public LocalDate getPeriodeStart() {
		return periodeStart;
	}

	public void setPeriodeStart(LocalDate periodeStart) {
		this.periodeStart = periodeStart;
	}

	public LocalDate getPeriodeSlut() {
		return periodeSlut;
	}

	public void setPeriodeSlut(LocalDate periodeSlut) {
		this.periodeSlut = periodeSlut;
	}

	public PraktikVirksomhed getPraktikVirksomhed() {
		return praktikVirksomhed;
	}

	@Override
	public String toString() {
		return "PraktikKontrakt [opgavebeskrivelse=" + opgavebeskrivelse + ", timerPerUge=" + timerPerUge
				+ ", periodeStart=" + periodeStart + ", periodeSlut=" + periodeSlut + "]\n";
	}

	@Override
	public int compareTo(PraktikKontrakt o) {
		// TODO Auto-generated method stub
		int cmp = periodeStart.compareTo(o.getPeriodeStart());
		if (cmp == 0) {
			cmp = opgavebeskrivelse.compareTo(o.opgavebeskrivelse);
		}
		return cmp;

//		if (this.periodeStart.isBefore(o.periodeStart)) {
//			return -1;
//		} else if (this.periodeStart.isAfter(o.periodeStart)) {
//			return 1;
//		} else if (this.periodeStart.equals(o.periodeStart)) {
//			return opgavebeskrivelse.compareTo(o.opgavebeskrivelse);
//		}
//		return 0;
	}
}
