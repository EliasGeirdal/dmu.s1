package guifx;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Bil;
import model.Parkeringshus;
import model.Parkeringsplads;

public class ParkeringshusPane extends GridPane {
	private Label lblParkeringshuse, lblOptagnepladser, lblOpretBil, lblError;
	private ListView<Parkeringshus> lvwParkeringshuse;
	private ListView<Parkeringsplads> lvwPladser;
	private TextField txfBil;
	private Button btnOpret;

	public ParkeringshusPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		lblParkeringshuse = new Label("Parkeringshuse");
		this.add(lblParkeringshuse, 0, 0);

		lvwParkeringshuse = new ListView<>();
		this.add(lvwParkeringshuse, 0, 1);
		lvwParkeringshuse.setPrefHeight(200);
		lvwParkeringshuse.getItems().setAll(Controller.getParkeringshuse());

		ChangeListener<Parkeringshus> listenerParkeringshus = (ov, oldParkeringshus, newParkeringshus) -> this
				.selectedParkeringshusChanged();
		lvwParkeringshuse.getSelectionModel().selectedItemProperty().addListener(listenerParkeringshus);

		lblOpretBil = new Label("Opret bil med nummer: ");
		this.add(lblOpretBil, 0, 2);

		lblOptagnepladser = new Label("Optagne pladser");
		this.add(lblOptagnepladser, 1, 0);

		lvwPladser = new ListView<>();
		this.add(lvwPladser, 1, 1);
		lvwPladser.setPrefHeight(200);

		txfBil = new TextField();
		this.add(txfBil, 1, 2);

		btnOpret = new Button("Opret");
		this.add(btnOpret, 1, 3);
		btnOpret.setDisable(true);

		btnOpret.setOnAction(event -> this.opretAction());

		lblError = new Label();
		this.add(lblError, 0, 4);
		lblError.setStyle("-fx-text-fill: red");

		// remember this code.
		if (lvwParkeringshuse.getItems().size() > 0) {
			lvwParkeringshuse.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------------------

	public void selectedParkeringshusChanged() {
		// TODO
		Parkeringshus p = lvwParkeringshuse.getSelectionModel().getSelectedItem();
		lvwPladser.getItems().setAll(p.optagnePladser());
		btnOpret.setDisable(false);
	}

	public void opretAction() {
		Parkeringshus p = lvwParkeringshuse.getSelectionModel().getSelectedItem();
		if (txfBil.getLength() >= 10) {
			lblError.setText("Ugyldig registreringsnummer");
			return;
		}

		String regNr = txfBil.getText().trim();
		Bil bil = Controller.createBil(regNr);
		Controller.addBilToPlads(Controller.getLedigPlads(p), bil);
		lvwPladser.getItems().setAll(p.optagnePladser());
		txfBil.clear();
	}

}
