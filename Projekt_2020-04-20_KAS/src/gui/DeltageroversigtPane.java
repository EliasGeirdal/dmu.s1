package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Deltager;
import model.Konference;

public class DeltageroversigtPane extends GridPane {
	private TextField txfFornavn, txfEfternavn, txfTelefon, txfAdresse, txfHotel, txfAnkomst, txfAfrejse, txfLedsager;
	private ListView<Deltager> lvwDeltagere;
	private CheckBox chbForedragsholder;
	private ComboBox<Konference> cbbKonferencer;

	public DeltageroversigtPane() {
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

		if (cbbKonferencer.getItems().size() > 0) {
			cbbKonferencer.getSelectionModel().select(0);
		}

		if (lvwDeltagere.getItems().size() > 0) {
			lvwDeltagere.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void selectedKonferenceChanged() {
		this.updateKonfControls();
	}

	public void updateKonfControls() {
		Konference konf = cbbKonferencer.getSelectionModel().getSelectedItem();
		if (konf != null) {
			lvwDeltagere.getItems().setAll(Controller.getDeltagereForKonference(konf));
		}
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
