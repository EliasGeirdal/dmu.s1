package model;

public class Værelse {

	private String type;
	private double dagspris;
	private int sengepladser;
	private Hotel hotel;

	public Værelse(String type, double pris, int sengepladser, Hotel hotel) {
		super();
		this.type = type;
		this.dagspris = pris;
		this.sengepladser = sengepladser;
		setHotel(hotel);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPris() {
		return dagspris;
	}

	public void setPris(double pris) {
		this.dagspris = pris;
	}

	public int getSengepladser() {
		return sengepladser;
	}

	public void setSengepladser(int sengepladser) {
		this.sengepladser = sengepladser;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
