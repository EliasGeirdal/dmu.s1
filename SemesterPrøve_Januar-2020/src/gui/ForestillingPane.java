package gui;

import java.time.LocalDate;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Forestilling;
import model.Kunde;
import model.Plads;

public class ForestillingPane extends GridPane {
	private Label lblForestilligner, lblKunder, lblKundeNavn, lblKundeMobil, lblDato, lblBestiltePladser, lblError;
	private ListView<Forestilling> lvwForestillinger;
	private ListView<Kunde> lvwKunder;
	private ListView<Plads> lvwPladser;
	private TextField txfKundeNavn, txfKundeMobil, txfDato;
	private Button btnOpretKunde, btnVisBestiltePladser;

	public ForestillingPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		lblForestilligner = new Label("Forestillinger");
		this.add(lblForestilligner, 0, 0);

		lvwForestillinger = new ListView<>();
		this.add(lvwForestillinger, 0, 1, 1, 4);
		lvwForestillinger.setPrefHeight(200);
		lvwForestillinger.getItems().setAll(Controller.getForestillinger());

		ChangeListener<Forestilling> listenerForestilling = (ov, oldForestilling, newForestilling) -> this
				.selectedForestillingChanged();
		lvwForestillinger.getSelectionModel().selectedItemProperty().addListener(listenerForestilling);

		lblKunder = new Label("Kunder");
		this.add(lblKunder, 1, 0);

		lvwKunder = new ListView<>();
		this.add(lvwKunder, 1, 1, 1, 4);
		lvwKunder.setPrefHeight(200);
//		lvwKunder.setMaxHeight(200);
		lvwKunder.getItems().setAll(Controller.getKunder());

		lblKundeNavn = new Label("Kunde navn: ");
		this.add(lblKundeNavn, 1, 5);

		txfKundeNavn = new TextField();
		this.add(txfKundeNavn, 1, 6);

		lblKundeMobil = new Label("Kunde mobil: ");
		this.add(lblKundeMobil, 1, 7);

		txfKundeMobil = new TextField();
		this.add(txfKundeMobil, 1, 8);

		btnOpretKunde = new Button("Opret kunde");
		this.add(btnOpretKunde, 1, 9);
		btnOpretKunde.setOnAction(event -> this.opretAction());

		// column 3

		lblDato = new Label("Dato: ");
		this.add(lblDato, 2, 0);

		txfDato = new TextField();
		this.add(txfDato, 2, 1);
		txfDato.setPromptText("YYYY/MM/DD");

		btnVisBestiltePladser = new Button("Vis bestilte pladser");
		this.add(btnVisBestiltePladser, 2, 2);
		btnVisBestiltePladser.setOnAction(event -> this.visBestiltePladser());

		lblBestiltePladser = new Label("Bestilte pladser");
		this.add(lblBestiltePladser, 2, 3);

		lvwPladser = new ListView<>();
		this.add(lvwPladser, 2, 4);
		lvwPladser.setPrefHeight(100);

		lblError = new Label();
		this.add(lblError, 1, 10);
		lblError.setStyle("-fx-text-fill: red");

		if (lvwForestillinger.getItems().size() > 0) {
			lvwForestillinger.getSelectionModel().select(0);
		}
		if (lvwKunder.getItems().size() > 0) {
			lvwKunder.getSelectionModel().select(0);
		}

		selectedForestillingChanged();
	}

	// -------------------------------------------------------------------------------------

	public void selectedForestillingChanged() {
		// TODO
	}

	public void opretAction() {
		String navn = txfKundeNavn.getText().trim();
		if (navn.isEmpty()) {
			lblError.setText("Wrong input");
			return;
		}
		String mobil = txfKundeMobil.getText().trim();
		if (mobil.length() > 8) {
			lblError.setText("Not a danish phone number.");
			return;
		}
		Controller.createKunde(navn, mobil);

		// end with.
		lvwKunder.getItems().setAll(Controller.getKunder());
		txfKundeMobil.clear();
		txfKundeNavn.clear();
	}

	public void visBestiltePladser() {
		String[] s = txfDato.getText().split("/");
		Forestilling forestilling = lvwForestillinger.getSelectionModel().getSelectedItem();
		Kunde kunde = lvwKunder.getSelectionModel().getSelectedItem();
		int year = Integer.parseInt(s[0]);
		int month = Integer.parseInt(s[1]);
		int day = Integer.parseInt(s[2]);
		lvwPladser.getItems()
				.setAll(Controller.getPladserForDateAndKunde(LocalDate.of(year, month, day), forestilling, kunde));
	}

}
