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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Deltager;
import model.Konference;

public class DeltagerPane extends GridPane {
	private TextField txfFornavn, txfEfternavn, txfTelefon, txfAdresse, txfHotel, txfAnkomst, txfAfrejse, txfLedsager;
	private ListView<Deltager> lvwDeltagere;
	private CheckBox chbForedragsholder;
	private ComboBox<Konference> cbbKonferencer;

	public DeltagerPane() {
		this.setPadding(new Insets(20));
		this.setHgap(50);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblVælgKonference = new Label("Vælg Konference");
		this.add(lblVælgKonference, 0, 0);

		cbbKonferencer = new ComboBox<Konference>();
		this.add(cbbKonferencer, 0, 1);
		cbbKonferencer.getItems().setAll(Controller.getKonferencer());
		cbbKonferencer.setMaxWidth(250);
		ChangeListener<Konference> listener = (ov, oldDeltager, newDeltager) -> this.selectedKonferenceChanged();
		cbbKonferencer.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblDeltagere = new Label("Deltagere");
		this.add(lblDeltagere, 0, 2);

		lvwDeltagere = new ListView<>();
		this.add(lvwDeltagere, 0, 3, 1, 10);
//		lvwDeltagere.getItems().setAll(Controller.getDeltagere());

		ChangeListener<Deltager> listenerDeltager = (ov, oldDeltager, newDeltager) -> this.selectedDeltagerChanged();
		lvwDeltagere.getSelectionModel().selectedItemProperty().addListener(listenerDeltager);

		// overskrift
		Label lblOsDeltager = new Label("Deltageroplysninger");
		this.add(lblOsDeltager, 1, 2);

		// fornavn
		Label lblFornavn = new Label("Fornavn");
		this.add(lblFornavn, 1, 3);

		txfFornavn = new TextField();
		this.add(txfFornavn, 1, 4);
		txfFornavn.setEditable(false);

		// efternavn
		Label lblEfternavn = new Label("Efternavn");
		this.add(lblEfternavn, 1, 5);

		txfEfternavn = new TextField();
		this.add(txfEfternavn, 1, 6);
		txfEfternavn.setEditable(false);

		// adresse
		Label lblAdresse = new Label("Adresse");
		this.add(lblAdresse, 1, 7);

		txfAdresse = new TextField();
		this.add(txfAdresse, 1, 8);
		txfAdresse.setEditable(false);

		// telefon
		Label lblTelefon = new Label("Telefon nummer");
		this.add(lblTelefon, 1, 9);

		txfTelefon = new TextField();
		this.add(txfTelefon, 1, 10);
		txfTelefon.setEditable(false);

		// tilmeldingsoplysninger
		Label lblTilmeldsoplysninger = new Label("Tilmeldingsoplysninger");
		this.add(lblTilmeldsoplysninger, 2, 2);

		// ankomstdato
		Label lblAnkomst = new Label("Ankomstdato");
		this.add(lblAnkomst, 2, 3);

		txfAnkomst = new TextField();
		this.add(txfAnkomst, 2, 4);
		txfAnkomst.setEditable(false);

		// afrejsedato
		Label lblAfrejse = new Label("Afrejsedato");
		this.add(lblAfrejse, 2, 5);

		txfAfrejse = new TextField();
		this.add(txfAfrejse, 2, 6);
		txfAfrejse.setEditable(false);

		// foredragsholder
		Label lblForedragsholder = new Label("Foredragsholder");
		this.add(lblForedragsholder, 2, 7);

		chbForedragsholder = new CheckBox();
		this.add(chbForedragsholder, 2, 8);

		// ledsager
		Label lblLedsager = new Label("Ledsager");
		this.add(lblLedsager, 2, 9);

		txfLedsager = new TextField();
		this.add(txfLedsager, 2, 10);
		txfLedsager.setEditable(false);

		// ledsager
		Label lblHotel = new Label("Hotel");
		this.add(lblHotel, 2, 11);

		txfHotel = new TextField();
		this.add(txfHotel, 2, 12);
		txfHotel.setEditable(false);

		// Deltager knapper
		HBox hbxDelButtons = new HBox(40);
		this.add(hbxDelButtons, 0, 15, 3, 1);
		hbxDelButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxDelButtons.setAlignment(Pos.BASELINE_LEFT);

		Button btnCreate = new Button("Opret Deltager");
		hbxDelButtons.getChildren().add(btnCreate);
		btnCreate.setOnAction(event -> this.createAction());

		Button btnUpdate = new Button("Opdater deltager");
		hbxDelButtons.getChildren().add(btnUpdate);
		btnUpdate.setOnAction(event -> this.updateAction());

		Button btnDelete = new Button("Slet Deltager");
		hbxDelButtons.getChildren().add(btnDelete);
		btnDelete.setOnAction(event -> this.deleteAction());

		if (lvwDeltagere.getItems().size() > 0) {
			lvwDeltagere.getSelectionModel().select(0);
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
		Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
		if (deltager == null) {
			return;
		}

		Konference konference = cbbKonferencer.getSelectionModel().getSelectedItem();
		if (konference == null) {
			return;
		}

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Slet Konference");
		// alert.setContentText("Are you sure?");
		alert.setHeaderText("Er du sikker?");
		Optional<ButtonType> result = alert.showAndWait();
		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
			// deltager is attached to the konference through the tilmelding.
			Controller.deleteTilmeldingFromKonference(Controller.getTilmeldingForKonference(konference, deltager),
					konference);
			lvwDeltagere.getItems().setAll(Controller.getDeltagereForKonference(konference));
			this.updateControls();
		}
	}

	// -------------------------------------------------------------------------

	private void selectedKonferenceChanged() {
		this.updateKonfControls();
	}

	private void updateKonfControls() {
		Konference konf = cbbKonferencer.getSelectionModel().getSelectedItem();
		lvwDeltagere.getItems().setAll(Controller.getDeltagereForKonference(konf));
	}

	private void selectedDeltagerChanged() {
		this.updateControls();
	}

	public void updateControls() {
		Konference konf = cbbKonferencer.getSelectionModel().getSelectedItem();
		Deltager del = lvwDeltagere.getSelectionModel().getSelectedItem();
		if (del != null) {
			txfAdresse.setText(del.getAdresse());
			txfFornavn.setText(del.getFornavn());
			txfEfternavn.setText(del.getEfternavn());
			txfTelefon.setText(del.getTlf());
			txfAnkomst.setText(Controller.getTilmeldingForKonference(konf, del).getAnkomstDato().toString());
			txfAfrejse.setText(Controller.getTilmeldingForKonference(konf, del).getAfrejseDato().toString());
			if (Controller.getTilmeldingForKonference(konf, del).isForedragsholder()) {
				chbForedragsholder.setSelected(true);
			} else
				chbForedragsholder.setSelected(false);
			if (Controller.getTilmeldingForKonference(konf, del).getLedsager() != null) {
				txfLedsager.setText(Controller.getTilmeldingForKonference(konf, del).getLedsager().getNavn());
			} else
				txfLedsager.setText(null);
			if (Controller.getTilmeldingForKonference(konf, del).getVærelse() != null)
				txfHotel.setText(Controller.getTilmeldingForKonference(konf, del).getVærelse().getHotel().toString());
			else
				txfHotel.setText(null);
		} else {
			txfAdresse.setText(null);
			txfFornavn.setText(null);
			txfEfternavn.setText(null);
			txfTelefon.setText(null);
			txfAnkomst.setText(null);
			txfAfrejse.setText(null);
			chbForedragsholder.setSelected(false);
		}
	}

}
