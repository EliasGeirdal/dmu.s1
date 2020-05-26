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
import model.Hotel;

public class HotelWindow extends Stage {
	private Hotel hotel;

	public HotelWindow(String title, Hotel hotel) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.hotel = hotel;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public HotelWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private TextField txfNavn, txfEmail, txfTelefon, txfAdresse;
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

		Label lblTelefon = new Label("Telefon");
		pane.add(lblTelefon, 0, 4);

		txfTelefon = new TextField();
		pane.add(txfTelefon, 0, 5);

		Label lblEmail = new Label("Email");
		pane.add(lblEmail, 0, 6);

		txfEmail = new TextField();
		pane.add(txfEmail, 0, 7);

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
		if (hotel != null) {
			txfNavn.setText(hotel.getNavn());
			txfEmail.setText(hotel.getAdresse());
			txfTelefon.setText("" + hotel.getTlf());
			txfAdresse.setText(hotel.getEmail());
		} else {
			txfNavn.clear();
			txfEmail.clear();
			txfTelefon.clear();
			txfAdresse.clear();
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

		String email = txfEmail.getText().trim();
		if (email.length() == 0) {
			lblError.setText("Email er tomt");
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
		if (hotel != null) {
			Controller.updateHotel(hotel, navn, adresse, telefon, email);
		} else {
			Controller.createHotel(navn, adresse, telefon, email);
		}

		this.hide();
	}
}
