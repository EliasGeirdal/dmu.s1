package gui;

import java.util.Optional;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Hotel;

public class HotelPane extends GridPane {
	private TextField txfNavn, txfEmail, txfTelefon, txfAdresse;
	private ListView<Hotel> lvwHotel;

	public HotelPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblHotel = new Label("Hoteller");
		lblHotel.setFont(Font.font(null, FontWeight.BOLD, 32));
		this.add(lblHotel, 0, 0);

		lvwHotel = new ListView<>();
		this.add(lvwHotel, 0, 1, 1, 15);
		lvwHotel.getItems().setAll(Controller.getHoteller());

		ChangeListener<Hotel> listener = (ov, oldHotel, newHotel) -> this.selectedHotelChanged();
		lvwHotel.getSelectionModel().selectedItemProperty().addListener(listener);

		// fornavn
		Label lblNavn = new Label("Navn");
		this.add(lblNavn, 3, 1);

		txfNavn = new TextField();
		this.add(txfNavn, 3, 2);
		txfNavn.setEditable(false);

		// Adresse
		Label lblAdresse = new Label("Adresse");
		this.add(lblAdresse, 3, 3);

		txfAdresse = new TextField();
		this.add(txfAdresse, 3, 4);
		txfAdresse.setEditable(false);

		// Telefon
		Label lblTelefon = new Label("Telefon");
		this.add(lblTelefon, 3, 5);

		txfTelefon = new TextField();
		this.add(txfTelefon, 3, 6);
		txfTelefon.setEditable(false);

		// Telefon
		Label lblEmail = new Label("Email");
		this.add(lblEmail, 3, 7);

		txfEmail = new TextField();
		this.add(txfEmail, 3, 8);
		txfEmail.setEditable(false);

		// Hotel knapper
		HBox hbxKonfButtons = new HBox(40);
		this.add(hbxKonfButtons, 0, 20, 3, 1);
		hbxKonfButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxKonfButtons.setAlignment(Pos.BASELINE_LEFT);

		Button btnOpret = new Button("Opret");
		hbxKonfButtons.getChildren().add(btnOpret);
		btnOpret.setOnAction(event -> this.createAction());

		Button btnOpdater = new Button("Opdater");
		hbxKonfButtons.getChildren().add(btnOpdater);
		btnOpdater.setOnAction(event -> this.updateAction());

		Button btnSlet = new Button("Slet");
		hbxKonfButtons.getChildren().add(btnSlet);
		btnSlet.setOnAction(event -> this.deleteAction());

		if (lvwHotel.getItems().size() > 0) {
			lvwHotel.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void createAction() {
		HotelWindow dia = new HotelWindow("Opret Hotel");
		dia.showAndWait();

		// Wait for the modal dialog to close

		lvwHotel.getItems().setAll(Controller.getHoteller());
		int index = lvwHotel.getItems().size() - 1;
		lvwHotel.getSelectionModel().select(index);
	}

	private void updateAction() {
		Hotel hotel = lvwHotel.getSelectionModel().getSelectedItem();
		if (hotel == null) {
			return;
		}

		HotelWindow dia = new HotelWindow("Opdater Hotel", hotel);
		dia.showAndWait();

		// Wait for the modal dialog to close

		int selectIndex = lvwHotel.getSelectionModel().getSelectedIndex();
		lvwHotel.getItems().setAll(Controller.getHoteller());
		lvwHotel.getSelectionModel().select(selectIndex);
	}

	private void deleteAction() {
		Hotel hotel = lvwHotel.getSelectionModel().getSelectedItem();
		if (hotel == null) {
			return;
		}
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Slet Konference");
		// alert.setContentText("Are you sure?");
		alert.setHeaderText("Er du sikker?");
		Optional<ButtonType> result = alert.showAndWait();
		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
			Controller.deleteHotel(hotel);
			lvwHotel.getItems().setAll(Controller.getHoteller());
			this.updateControls();
		}
	}

	// -------------------------------------------------------------------------

	private void selectedHotelChanged() {
		this.updateControls();
	}

	public void updateControls() {
		Hotel hotel = lvwHotel.getSelectionModel().getSelectedItem();
		if (hotel != null) {
			txfNavn.setText(hotel.getNavn());
			txfEmail.setText(hotel.getEmail());
			txfAdresse.setText(hotel.getAdresse());
			txfTelefon.setText(hotel.getTlf());
		} else {
			txfNavn.clear();
			txfEmail.clear();
			txfAdresse.clear();
			txfTelefon.clear();
		}
	}
}
