package soegningelevopgaver;

import java.util.ArrayList;

public class Spillermetoder {
	public Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
		// TODO Opgave 4.1
		int i = 0;
		while (i < spillere.size()) {
			int k = spillere.get(i).getMaal();
			if (k == score) {
				return spillere.get(i);
			}
			i++;
		}
		return null;
	}

	public Spiller findScoreBinær(ArrayList<Spiller> spillere, int score) {
		int left = 0;
		int right = spillere.size() - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			Spiller k = spillere.get(middle);
			if (k.getMaal() == score) {
				return k;
			}
			if (k.getMaal() > score) {
				left = middle + 1;
			} else
				right = middle - 1;
		}
		return null;
	}

	public String godSpiller(ArrayList<Spiller> spillere) {
		int i = 0;
		while (i < spillere.size()) {
			if (spillere.get(i).getHoejde() < 170 && spillere.get(i).getMaal() > 50) {
				return spillere.get(i).getNavn();
			}
			i++;
		}
		return null;
	}

	// Her tilføjes metoder der løser opgve 4.2 og 4.3

	public static void main(String[] args) {
		Spillermetoder metoder = new Spillermetoder();

		// Her afprøves opgave 4.1
		ArrayList<Spiller> spillerListe = new ArrayList<>();
		spillerListe.add(new Spiller("Hans", 196, 99, 45));
		spillerListe.add(new Spiller("Bo", 203, 89, 60));
		spillerListe.add(new Spiller("Jens", 188, 109, 32));
		spillerListe.add(new Spiller("Finn", 194, 102, 12));
		spillerListe.add(new Spiller("Lars", 192, 86, 35));
		spillerListe.add(new Spiller("Mads", 200, 103, 37));

		System.out.println("Spiller der har scoret 35 mål: " + metoder.findScoreLinear(spillerListe, 35));
		System.out.println("Spiller der har scoret 30 mål: " + metoder.findScoreLinear(spillerListe, 30));

		ArrayList<Spiller> spillerListe2 = new ArrayList<>();
		spillerListe2.add(new Spiller("Hans", 196, 99, 60));
		spillerListe2.add(new Spiller("Bo", 203, 89, 45));
		spillerListe2.add(new Spiller("Jens", 188, 109, 37));
		spillerListe2.add(new Spiller("Finn", 194, 102, 35));
		spillerListe2.add(new Spiller("Lars", 192, 86, 32));
		spillerListe2.add(new Spiller("Mads", 200, 103, 12));
		System.out.println("Opgave 4.2");
		System.out.println("Find score i sorteret liste: " + metoder.findScoreBinær(spillerListe2, 12));

		ArrayList<Spiller> spillerListe3 = new ArrayList<>();
		spillerListe3.add(new Spiller("Hans", 160, 99, 51));
		spillerListe3.add(new Spiller("Bo", 150, 89, 60));
		spillerListe3.add(new Spiller("Jens", 188, 109, 32));
		spillerListe3.add(new Spiller("Finn", 194, 102, 12));
		spillerListe3.add(new Spiller("Lars", 192, 86, 35));
		spillerListe3.add(new Spiller("Mads", 200, 103, 37));
		System.out.println("Opgave 4.2");
		System.out.println(metoder.godSpiller(spillerListe3));
	}

	// Tilføj kode der afprøver opgaver 4.2 og 4.3

	// opgave 2

}
