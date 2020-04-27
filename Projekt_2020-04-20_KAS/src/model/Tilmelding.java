package model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Tilmelding {

	// instance variables
	private LocalDateTime ankomstDato, afrejseDato;
	private boolean foredragsholder;

	// link instance variables
	private Ledsager ledsager; // nullable
	private Deltager deltager;
	private Konference konference;
	private Værelse værelse; // nullable
	private ArrayList<Tillæg> tillæg = new ArrayList<>();;

	public Tilmelding(LocalDateTime ankomstDato, LocalDateTime afrejseDato, boolean foredragsholder, Deltager deltager,
			Ledsager ledsager, Konference konference, Værelse værelse) {
		this.ankomstDato = ankomstDato;
		this.afrejseDato = afrejseDato;
		this.foredragsholder = foredragsholder;
		setDeltager(deltager);
		setKonference(konference);
		setVærelse(værelse);
		setLedsager(ledsager);
	}

	// ------------beregninger for priser--------------------

	/**
	 * returns the accumulated prices.
	 * 
	 * @return price for the entirety of the konference.
	 */
	public double beregnPris() {
		double sum = beregnTillægspris() + beregnKonferencepris();
		if (ledsager != null) {
			sum += ledsager.beregnPrisForUdflugter();
		}
		if (værelse != null) {
			sum += (getAntalDage() - 1) * værelse.getPris();
		}
		return sum;
	}

	/**
	 * returns the price of the konference; 0 if deltager is a foredragsholder.
	 * 
	 * @return price for konference
	 */
	public double beregnKonferencepris() {
		double sum = 0.0;
		if (!foredragsholder) {
			sum = getAntalDage() * konference.getDagspris();
		}
		return sum;
	}

	/**
	 * price for each tillæg accumulated.
	 * 
	 * @return price for tillæg.
	 */
	public double beregnTillægspris() {
		double sum = 0.0;
		for (Tillæg tillæg2 : tillæg) {
			sum += tillæg2.getPris();
		}
		if (ledsager != null) {
			sum *= 2;
		}
		return sum;
	}

	public long getAntalDage() {
		return 1 + ChronoUnit.DAYS.between(ankomstDato, afrejseDato);
	}

	// ----------------konference metoder-----------------------

	/**
	 * Sætter konferencen samt tilføjer tilmelding til konferencen og fjerne
	 * tilmelding fra forrige konference.
	 * 
	 * @param konference konference objekt.
	 */
	public void setKonference(Konference konference) {
		if (this.konference != konference) {
			Konference oldKonference = this.konference;
			if (oldKonference != null) {
				oldKonference.removeTilmelding(this);
			}
			this.konference = konference;
			if (konference != null)
				this.konference.addTilmelding(this);
		}
	}

	public Konference getKonference() {
		return konference;
	}

	// ------------deltager metoder-----------------------

	/**
	 * sætter deltageren som denne tilmeldingsdeltager, hvis de ikke allerede er
	 * forbundet. Opdaterer også deltager objektet, i.e. sætter tilmelding og fjerne
	 * tilmelding.
	 * 
	 * @param deltager deltager objekt.
	 */
	public void setDeltager(Deltager deltager) {
		if (this.deltager != deltager) {
			Deltager oldDeltager = this.deltager;
			if (oldDeltager != null) {
				oldDeltager.removeTilmelding(this);
			}
			this.deltager = deltager;
			if (deltager != null) {
				deltager.addTilmelding(this);
			}
		}
	}

	/**
	 * returnerer deltager.
	 * 
	 * @return
	 */
	public Deltager getDeltager() {
		return deltager;
	}

	// ---------------ledsager---------------------

	/**
	 * Sætter ledsageren til at tilhøre denne tilmelding.
	 * 
	 * @param ledsager ledsager objekt. Nullable parameter.
	 */
	public void setLedsager(Ledsager ledsager) {
		if (this.ledsager != ledsager) {
			this.ledsager = ledsager;
		}
	}

	/**
	 * Returnerer ledsager.
	 * 
	 * @return ledsager.
	 */
	public Ledsager getLedsager() {
		return ledsager;
	}

	// -----------------værelse---------------------
	public Værelse getVærelse() {
		return værelse;
	}

	public void setVærelse(Værelse værelse) {
		if (this.værelse != værelse) {
			this.værelse = værelse;
		}
	}

	// ---------------tillæg---------------------------------

	public void addTillæg(Tillæg tillæg) {
		if (!this.tillæg.contains(tillæg)) {
			this.tillæg.add(tillæg);
		}
	}

	public ArrayList<Tillæg> getTillæg() {
		return new ArrayList<>(tillæg);
	}

	// ---------------instance-------------------------

	public LocalDateTime getAnkomstDato() {
		return ankomstDato;
	}

	public void setAnkomstDato(LocalDateTime ankomstDato) {
		this.ankomstDato = ankomstDato;
	}

	public LocalDateTime getAfrejseDato() {
		return afrejseDato;
	}

	public void setAfrejseDato(LocalDateTime afrejseDato) {
		this.afrejseDato = afrejseDato;
	}

	public boolean isForedragsholder() {
		return foredragsholder;
	}

}
