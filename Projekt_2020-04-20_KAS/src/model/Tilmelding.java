package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Tilmelding {

	// instance variables
	private LocalDateTime ankomstDato, afrejseDato;
	private boolean foredragsholder;

	// link variables
	private Ledsager ledsager;
	private Deltager deltager;
	private Konference konference;
	private Værelse værelse;
	private ArrayList<Tillæg> tillæg;

	public Tilmelding(LocalDateTime ankomstDato, LocalDateTime afrejseDato, boolean foredragsholder, Deltager deltager,
			Ledsager ledsager, Konference konference, Værelse værelse) {
		super();
		this.ankomstDato = ankomstDato;
		this.afrejseDato = afrejseDato;
		this.foredragsholder = foredragsholder;
		setDeltager(deltager);
		setKonference(konference);
		setVærelse(værelse);
		setLedsager(ledsager);
		tillæg = new ArrayList<>();
	}

	// ------------beregninger for priser--------------------

	/**
	 * returns the accumulated prices.
	 * 
	 * @return price for the entirety of the konference.
	 */
	public double beregnPris() {
		return beregnTillægspris() + beregnKonferencepris() + værelse.getPris() + ledsager.beregnPrisForUdflugter();
	}

	/**
	 * returns the price of the konference; 0 if deltager is a foredragsholder.
	 * 
	 * @return price for konference
	 */
	public double beregnKonferencepris() {
		double sum = 0;
		if (!foredragsholder) {
			sum = konference.getPris();
		}
		return sum;
	}

	/**
	 * price for each tillæg accumulated.
	 * 
	 * @return price for tillæg.
	 */
	public double beregnTillægspris() {
		double sum = 0;
		for (Tillæg tillæg2 : tillæg) {
			sum += tillæg2.getPris();
		}
		return sum;
	}

	// ----------------konference metoder-----------------------

	// set konference and remove this tilmelding from old konference, and add
	// tilmelding to new konference.
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

	public Deltager getDeltager() {
		return deltager;
	}

	// ---------------ledsager---------------------

	/**
	 * the ledsager associated with deltager at specific konference.
	 * 
	 * @param ledsager nullable parameter
	 */
	public void setLedsager(Ledsager ledsager) {
		if (this.ledsager != ledsager) {
			this.ledsager = ledsager;
		}
	}

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
