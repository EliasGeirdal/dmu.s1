package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Deltager;
import model.Hotel;

public class HotelPane extends GridPane {
	private TextField txfNavn, txfAdresse, txfTelefon, txfEmail;
	ListView<Hotel> lvwHotel;
	ListView<Deltager> lvwDeltagere;

	public HotelPane() {
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

		// Hotel knapper
		HBox hbxDelButtons = new HBox(40);
		this.add(hbxDelButtons, 0, 15, 3, 1);
		hbxDelButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxDelButtons.setAlignment(Pos.BASELINE_LEFT);

		Button btnCreate = new Button("Opret Hotel");
		hbxDelButtons.getChildren().add(btnCreate);
		btnCreate.setOnAction(event -> this.createAction());

		Button btnUpdate = new Button("Opdater hotel");
		hbxDelButtons.getChildren().add(btnUpdate);
		btnUpdate.setOnAction(event -> this.updateAction());

		Button btnDelete = new Button("Slet Hotel");
		hbxDelButtons.getChildren().add(btnDelete);
		btnDelete.setOnAction(event -> this.deleteAction());

		if (lvwHotel.getItems().size() > 0) {
			lvwHotel.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void createAction() {
//		KonferenceWindow dia = new KonferenceWindow("Opret konference");
//		dia.showAndWait();
//
//		// Wait for the modal dialog to close
//
//		lvwKonferencer.getItems().setAll(controller.Controller.getKonferencer());
//		int index = lvwKonferencer.getItems().size() - 1;
//		lvwKonferencer.getSelectionModel().select(index);
	}

	private void updateAction() {
	}

	private void deleteAction() {
//		Hotel hotel = lvwHotel.getSelectionModel().getSelectedItem();
//		if (hotel == null) {
//			return;
//		}
//
//		Konference konference = cbbKonferencer.getSelectionModel().getSelectedItem();
//		if (konference == null) {
//			return;
//		}
//
//		Alert alert = new Alert(AlertType.CONFIRMATION);
//		alert.setTitle("Slet Konference");
//		// alert.setContentText("Are you sure?");
//		alert.setHeaderText("Er du sikker?");
//		Optional<ButtonType> result = alert.showAndWait();
//		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
//			// hotel is attached to the konference through the tilmelding.
//			Controller.deleteTilmeldingFromKonference(Controller.getTilmeldingForKonference(konference, hotel),
//					konference);
//			lvwHotel.getItems().setAll(Controller.getHoteleForKonference(konference));
//			this.updateControls();
//		}
	}

	// -------------------------------------------------------------------------

	private void selectedHotelChanged() {
		this.updateControls();
	}

	public void updateControls() {
		Hotel hotel = lvwHotel.getSelectionModel().getSelectedItem();

		if (hotel != null) {
			txfNavn.setText(hotel.getNavn());
			txfAdresse.setText(hotel.getAdresse());
			txfEmail.setText(hotel.getEmail());
			txfTelefon.setText(hotel.getTlf());
			lvwDeltagere.getItems().setAll(Controller.getDeltagereFromSpecificHotel(hotel));
		}

//		Konference konf = cbbKonferencer.getSelectionModel().getSelectedItem();
//		Hotel del = lvwHotel.getSelectionModel().getSelectedItem();
//		if (del != null) {
//			txfAdresse.setText(del.getAdresse());
//			txfNavn.setText(del.getFornavn());
//			txfAdresse.setText(del.getEfternavn());
//			txfTelefon.setText(del.getTlf());
//			txfAnkomst.setText(Controller.getTilmeldingForKonference(konf, del).getAnkomstDato().toString());
//			txfAfrejse.setText(Controller.getTilmeldingForKonference(konf, del).getAfrejseDato().toString());
//			if (Controller.getTilmeldingForKonference(konf, del).isForedragsholder()) {
//				chbForedragsholder.setSelected(true);
//			} else
//				chbForedragsholder.setSelected(false);
//			if (Controller.getTilmeldingForKonference(konf, del).getLedsager() != null) {
//				txfLedsager.setText(Controller.getTilmeldingForKonference(konf, del).getLedsager().getNavn());
//			} else
//				txfLedsager.setText(null);
//			if (Controller.getTilmeldingForKonference(konf, del).getVærelse() != null)
//				txfHotel.setText(Controller.getTilmeldingForKonference(konf, del).getVærelse().getHotel().toString());
//			else
//				txfHotel.setText(null);
//		} else {
//			txfAdresse.setText(null);
//			txfNavn.setText(null);
//			txfAdresse.setText(null);
//			txfTelefon.setText(null);
//			txfAnkomst.setText(null);
//			txfAfrejse.setText(null);
//			chbForedragsholder.setSelected(false);
//		}
	}

}
