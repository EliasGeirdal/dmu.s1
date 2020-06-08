package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.PraktikVirksomhed;

public class PraktikVirksomhedPane extends GridPane {
	private Label lblNavn, lblFeedback, lblKontakt, lblPraktikVirksomhed, lblPraktikVirksomheder, lblError;
	private TextField txfNavn, txfFeedback, txfKontakt;
	private ListView<PraktikVirksomhed> lvwPraktikVirksomheder;
	private Button btnAdd, btnUpdate;

	public PraktikVirksomhedPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		// Column 0.
		lblNavn = new Label("Navn: ");
		this.add(lblNavn, 0, 1);

		lblFeedback = new Label("Feedback: ");
		this.add(lblFeedback, 0, 2);

		lblKontakt = new Label("Kontakt: ");
		this.add(lblKontakt, 0, 3);

		btnAdd = new Button("Add");
		this.add(btnAdd, 0, 5);
		btnAdd.setOnAction(event -> addAction());

		btnUpdate = new Button("Update");
		this.add(btnUpdate, 0, 6);
		btnUpdate.setOnAction(event -> updateAction());

		// Column 1
		lblPraktikVirksomhed = new Label("PraktikVirksomhed:");
		this.add(lblPraktikVirksomhed, 1, 0);

		txfNavn = new TextField();
		this.add(txfNavn, 1, 1);

		txfFeedback = new TextField();
		this.add(txfFeedback, 1, 2);

		txfKontakt = new TextField();
		this.add(txfKontakt, 1, 3);

		// Column 2.

		lblPraktikVirksomheder = new Label("Praktikvirksomheder:");
		this.add(lblPraktikVirksomheder, 2, 0);

		lvwPraktikVirksomheder = new ListView<>();
		this.add(lvwPraktikVirksomheder, 2, 1, 1, 6);
		lvwPraktikVirksomheder.setPrefHeight(200);
		lvwPraktikVirksomheder.getItems().setAll(Controller.getPraktikVirksomheder());

		ChangeListener<PraktikVirksomhed> listenerForestilling = (ov, oldVirksomhed, newVirksomhed) -> this
				.selectedVirksomhedChanged();
		lvwPraktikVirksomheder.getSelectionModel().selectedItemProperty().addListener(listenerForestilling);

		lblError = new Label();
		this.add(lblError, 1, 4);
		lblError.setStyle("-fx-text-fill: red");

	}

	// -------------------------------------------------------------------------------------

	public void selectedVirksomhedChanged() {
		// TODO
		PraktikVirksomhed praktikVirksomhed = lvwPraktikVirksomheder.getSelectionModel().getSelectedItem();
		txfFeedback.setText(praktikVirksomhed.getFeedback());
		txfNavn.setText(praktikVirksomhed.getNavn());
		txfKontakt.setText(praktikVirksomhed.getKontaktperson());
	}

	public void addAction() {

		String navn = txfNavn.getText().trim();
		if (navn.isEmpty()) {
			lblError.setText("Navn er tomt.");
			return;
		}

		String feedback = txfFeedback.getText().trim();
		if (feedback.isEmpty()) {
			lblError.setText("Feedback er tomt.");
			return;
		}

		String kontakt = txfKontakt.getText().trim();
		if (kontakt.isEmpty()) {
			lblError.setText("Kontakt er tomt.");
			return;
		}

		Controller.createPraktikVirksomhed(navn, feedback, kontakt);
		lvwPraktikVirksomheder.getItems().setAll(Controller.getPraktikVirksomheder());

		// clear fields.

		txfFeedback.clear();
		txfKontakt.clear();
		txfNavn.clear();
		lblError.setText("");
	}

	public void updateAction() {
		PraktikVirksomhed praktikVirksomhed = lvwPraktikVirksomheder.getSelectionModel().getSelectedItem();

		String navn = txfNavn.getText().trim();
		if (navn.isEmpty()) {
			lblError.setText("Navn er tomt.");
			return;
		}

		String feedback = txfFeedback.getText().trim();
		if (feedback.isEmpty()) {
			lblError.setText("Feedback er tomt.");
			return;
		}

		String kontakt = txfKontakt.getText().trim();
		if (kontakt.isEmpty()) {
			lblError.setText("Kontakt er tomt.");
			return;
		}

		Controller.updatePraktikVirksomhed(praktikVirksomhed, navn, feedback, kontakt);

		lvwPraktikVirksomheder.getItems().setAll(Controller.getPraktikVirksomheder());
	}

}
