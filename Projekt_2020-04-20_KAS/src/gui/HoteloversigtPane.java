package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Deltager;
import model.Hotel;

public class HoteloversigtPane extends GridPane {
	private TextField txfNavn, txfAdresse, txfTelefon, txfEmail;
	ListView<Hotel> lvwHotel;
	ListView<Deltager> lvwDeltagere;

	public HoteloversigtPane() {
		this.setPadding(new Insets(20));
		this.setHgap(50);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblHotel = new Label("Alle hoteller");
		this.add(lblHotel, 0, 2);

		lvwHotel = new ListView<>();
		this.add(lvwHotel, 0, 3, 1, 10);
		lvwHotel.getItems().setAll(Controller.getHoteller());

		ChangeListener<Hotel> listenerHotel = (ov, oldHotel, newHotel) -> this.selectedHotelChanged();
		lvwHotel.getSelectionModel().selectedItemProperty().addListener(listenerHotel);

		// hotel oplysninger
		Label lblOsHotel = new Label("Hoteloplysninger");
		this.add(lblOsHotel, 1, 2);

		// navn
		Label lblNavn = new Label("Navn");
		this.add(lblNavn, 1, 3);

		txfNavn = new TextField();
		this.add(txfNavn, 1, 4);
		txfNavn.setEditable(false);

		// adresse
		Label lblAdresse = new Label("Adresse");
		this.add(lblAdresse, 1, 5);

		txfAdresse = new TextField();
		this.add(txfAdresse, 1, 6);
		txfAdresse.setEditable(false);

		// telefon
		Label lblTelefon = new Label("Telefon nummer");
		this.add(lblTelefon, 1, 7);

		txfTelefon = new TextField();
		this.add(txfTelefon, 1, 8);
		txfTelefon.setEditable(false);

		// e
		Label lblEmail = new Label("Email");
		this.add(lblEmail, 1, 9);

		txfEmail = new TextField();
		this.add(txfEmail, 1, 10);
		txfEmail.setEditable(false);

		// deltagere
		Label lblDeltager = new Label("Deltagere");
		this.add(lblDeltager, 2, 2);

		lvwDeltagere = new ListView<>();
		this.add(lvwDeltagere, 2, 3, 1, 10);

	}

	// -------------------------------------------------------------------------

	private void selectedHotelChanged() {
		this.updateControls();
	}

	public void updateHotelListView() {
		lvwHotel.getItems().setAll(Controller.getHoteller());
	}

	public void updateControls() {
		Hotel hotel = lvwHotel.getSelectionModel().getSelectedItem();

		if (hotel != null) {
			txfNavn.setText(hotel.getNavn());
			txfAdresse.setText(hotel.getAdresse());
			txfEmail.setText(hotel.getEmail());
			txfTelefon.setText(hotel.getTlf());
			lvwDeltagere.getItems().setAll(Controller.getDeltagereFromSpecificHotel(hotel));
		} else {
			txfNavn.clear();
			txfAdresse.clear();
			txfEmail.clear();
			txfTelefon.clear();
		}
	}

}
