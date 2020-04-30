package gui;

import java.time.LocalDate;

import controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Konference;
import model.Udflugt;

public class UdflugtWindow extends Stage {
	private Udflugt udflugt;
	private Konference konference;

	public UdflugtWindow(String title, Udflugt udflugt, Konference konference) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.udflugt = udflugt;
		this.konference = konference;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public UdflugtWindow(String title) {
		this(title, null, null);
	}

	// -------------------------------------------------------------------------

	private TextField txfNavn, txfAdresse, txfPris;
	private TextArea txaBeskrivelse;
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

		// beskrivelse
		Label lblBeskrivelse = new Label("Beskrivelse");
		pane.add(lblBeskrivelse, 0, 2);

		txaBeskrivelse = new TextArea();
		pane.add(txaBeskrivelse, 0, 3);
		txaBeskrivelse.setMaxSize(200, 130);

		Label lblAdresse = new Label("Adresse");
		pane.add(lblAdresse, 0, 4);

		txfAdresse = new TextField();
		pane.add(txfAdresse, 0, 5);

		Label lblStartdato = new Label("Startdato");
		pane.add(lblStartdato, 0, 6);

		dpStart = new DatePicker();
		pane.add(dpStart, 0, 7);

		Label lblSlutdato = new Label("Slutdato");
		pane.add(lblSlutdato, 0, 8);

		dpSlut = new DatePicker();
		pane.add(dpSlut, 0, 9);

		Label lblPris = new Label("Pris");
		pane.add(lblPris, 0, 10);

		txfPris = new TextField();
		pane.add(txfPris, 0, 11);

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 12);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 12);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());

		lblError = new Label();
		pane.add(lblError, 0, 14);
		lblError.setStyle("-fx-text-fill: red");

		this.initControls();
	}

	private void initControls() {
		// private TextField txfNavn, txfAdresse, txfPris;
		if (udflugt != null) {
			txfNavn.setText(udflugt.getNavn());
			txfAdresse.setText("" + udflugt.getAdresse());
			txaBeskrivelse.setText("" + udflugt.getBeskrivelse());
			txfPris.setText("" + udflugt.getPris());
			dpStart.setValue(udflugt.getStartDato());
			dpSlut.setValue(udflugt.getSlutDato());
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
		String navn = txfNavn.getText().trim();
		if (navn.length() == 0) {
			lblError.setText("Navn er tomt");
			return;
		}

		String adresse = txfAdresse.getText().trim();
		if (adresse.length() == 0) {
			lblError.setText("Adresse er tomt");
			return;
		}

		String beskrivelse = txaBeskrivelse.getText().trim();

//		String beskrivelse = txfBeskrivelse

		LocalDate start = dpStart.getValue();

		LocalDate slut = dpSlut.getValue();

		double pris = Double.parseDouble(txfPris.getText().trim());
		if (pris == 0) {
			lblError.setText("Pris er tomt");
			return;
		}

		// Call controller methods
		if (udflugt != null) {
			Controller.updateUdflugt(navn, adresse, beskrivelse, pris, start, slut, konference, udflugt);
		} else {
			Controller.createUdflugt(navn, adresse, beskrivelse, pris, start, slut, konference);
		}

		this.hide();
	}
}
