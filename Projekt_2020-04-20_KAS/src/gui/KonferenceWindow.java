package gui;

import java.time.LocalDate;

import controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Konference;

public class KonferenceWindow extends Stage {
	private Konference konference;

	public KonferenceWindow(String title, Konference konference) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.konference = konference;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public KonferenceWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private TextField txfNavn, txfAdresse, txfPris;
	private DatePicker dpStart, dpSlut;
	private Label lblError;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblNavn = new Label("Navn");
		pane.add(lblNavn, 0, 0);

		txfNavn = new TextField();
		pane.add(txfNavn, 0, 1);
		txfNavn.setPrefWidth(200);

		Label lblAdresse = new Label("Adresse");
		pane.add(lblAdresse, 0, 2);

		txfAdresse = new TextField();
		pane.add(txfAdresse, 0, 3);

		Label lblStartdato = new Label("Startdato");
		pane.add(lblStartdato, 0, 4);

		dpStart = new DatePicker();
		pane.add(dpStart, 0, 5);

		Label lblSlutdato = new Label("Slutdato");
		pane.add(lblSlutdato, 0, 6);

		dpSlut = new DatePicker();
		pane.add(dpSlut, 0, 7);

		Label lblPris = new Label("Pris");
		pane.add(lblPris, 0, 8);

		txfPris = new TextField();
		pane.add(txfPris, 0, 9);

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 10);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 10);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());

		lblError = new Label();
		pane.add(lblError, 0, 11);
		lblError.setStyle("-fx-text-fill: red");

		this.initControls();
	}

	private void initControls() {
		// private TextField txfNavn, txfAdresse, txfPris;
		if (konference != null) {
			txfNavn.setText(konference.getNavn());
			txfAdresse.setText("" + konference.getAdresse());
			txfPris.setText("" + konference.getDagspris());
			dpStart.setValue(konference.getStartDato());
			dpSlut.setValue(konference.getSlutDato());
		} else {
			txfNavn.clear();
			txfAdresse.clear();
			txfPris.clear();
			dpStart.setValue(null);
			dpSlut.setValue(null);
		}
	}

	// -------------------------------------------------------------------------

	private void cancelAction() {
		this.hide();
	}

	private void okAction() {
		String name = txfNavn.getText().trim();
		if (name.length() == 0) {
			lblError.setText("Navn er tomt");
			return;
		}

		String adress = txfAdresse.getText().trim();
		if (adress.length() == 0) {
			lblError.setText("Adresse er tomt");
			return;
		}

		LocalDate start = dpStart.getValue();

		LocalDate slut = dpSlut.getValue();

		double pris = Double.parseDouble(txfPris.getText().trim());
		if (pris == 0) {
			lblError.setText("Pris er tomt");
			return;
		}

		// Call controller methods
		if (konference != null) {
			Controller.updateKonference(konference, name, adress, start, slut, pris);
		} else {
			Controller.createKonference(name, adress, start, slut, pris);
		}

		this.hide();
	}
}
