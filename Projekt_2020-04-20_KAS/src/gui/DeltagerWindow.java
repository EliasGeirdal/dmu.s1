package gui;

import controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Deltager;

public class DeltagerWindow extends Stage {
	private Deltager deltager;

	public DeltagerWindow(String title, Deltager deltager) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.deltager = deltager;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public DeltagerWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private TextField txfFornavn, txfEfternavn, txfTelefon, txfAdresse;
	private Label lblError;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblFornavn = new Label("Fornavn");
		pane.add(lblFornavn, 0, 0);

		txfFornavn = new TextField();
		pane.add(txfFornavn, 0, 1);
		txfFornavn.setPrefWidth(200);

		Label lblEfternavn = new Label("Efternavn");
		pane.add(lblEfternavn, 0, 2);

		txfEfternavn = new TextField();
		pane.add(txfEfternavn, 0, 3);

		Label lblTelefon = new Label("Telefon");
		pane.add(lblTelefon, 0, 4);

		txfTelefon = new TextField();
		pane.add(txfTelefon, 0, 5);

		Label lblAdresse = new Label("Adresse");
		pane.add(lblAdresse, 0, 6);

		txfAdresse = new TextField();
		pane.add(txfAdresse, 0, 7);

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
		if (deltager != null) {
			txfFornavn.setText(deltager.getFornavn());
			txfEfternavn.setText(deltager.getEfternavn());
			txfTelefon.setText("" + deltager.getTlf());
			txfAdresse.setText(deltager.getAdresse());
		} else {
			txfFornavn.clear();
			txfEfternavn.clear();
			txfTelefon.clear();
			txfAdresse.clear();
		}
	}

	// -------------------------------------------------------------------------

	private void cancelAction() {
		this.hide();
	}

	private void okAction() {
		String fornavn = txfFornavn.getText().trim();
		if (fornavn.length() == 0) {
			lblError.setText("Fornavn er tomt");
			return;
		}

		String efternavn = txfEfternavn.getText().trim();
		if (efternavn.length() == 0) {
			lblError.setText("Efternavn er tomt");
			return;
		}

		String telefon = txfTelefon.getText().trim();
		if (telefon.length() == 0) {
			lblError.setText("Telefon er tomt");
			return;
		}
		String adresse = txfAdresse.getText().trim();
		if (adresse.length() == 0) {
			lblError.setText("Adresse er tomt");
			return;
		}

		// Call controller methods
		if (deltager != null) {
			Controller.updateDeltager(deltager, fornavn, efternavn, telefon, adresse, null);
			;
		} else {
			Controller.createDeltager(fornavn, efternavn, telefon, adresse);
		}

		this.hide();
	}
}
