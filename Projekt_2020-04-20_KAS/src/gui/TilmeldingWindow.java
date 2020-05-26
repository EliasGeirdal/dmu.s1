package gui;

import java.time.LocalDate;

import controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Deltager;
import model.Hotel;
import model.Konference;
import model.Ledsager;
import model.Tilmelding;
import model.Værelse;

public class TilmeldingWindow extends Stage {
	private Tilmelding tilmelding;

	public TilmeldingWindow(String title, Tilmelding tilmelding) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.tilmelding = tilmelding;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public TilmeldingWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private TextField txfLedsager;
	private ComboBox<Konference> cbbKonference;
	private ComboBox<Deltager> cbbDeltager;
	private ComboBox<Hotel> cbbHotel;
	private ComboBox<Værelse> cbbVærelse;
	private CheckBox chbForedragsholder;
	private DatePicker dpAnkomst, dpAfrejse;
	private Label lblError;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		// konference
		Label lblKonference = new Label("Konference");
		pane.add(lblKonference, 0, 0);

		cbbKonference = new ComboBox<Konference>();
		pane.add(cbbKonference, 0, 1);
		cbbKonference.getItems().setAll(Controller.getKonferencer());

		// deltager
		Label lblDeltager = new Label("Deltager");
		pane.add(lblDeltager, 0, 2);

		cbbDeltager = new ComboBox<Deltager>();
		pane.add(cbbDeltager, 0, 3);
		cbbDeltager.getItems().setAll(Controller.getDeltagere());

		// ankomst
		Label lblAnkomst = new Label("Ankomstdato");
		pane.add(lblAnkomst, 0, 4);

		dpAnkomst = new DatePicker();
		pane.add(dpAnkomst, 0, 5);

		// afrejse
		Label lblAfrejse = new Label("Afrejsedato");
		pane.add(lblAfrejse, 0, 6);

		dpAfrejse = new DatePicker();
		pane.add(dpAfrejse, 0, 7);

		// foredragsholder
		Label lblForedragsholder = new Label("Foredragholder");
		pane.add(lblForedragsholder, 0, 8);

		chbForedragsholder = new CheckBox();
		pane.add(chbForedragsholder, 0, 9);

		// ledsager
		Label lblLedsager = new Label("Ledsagernavn");
		pane.add(lblLedsager, 0, 10);

		txfLedsager = new TextField();
		pane.add(txfLedsager, 0, 11);

		// hotel
		Label lblHotel = new Label("Hotel");
		pane.add(lblHotel, 0, 12);

		cbbHotel = new ComboBox<Hotel>();
		pane.add(cbbHotel, 0, 13);
		cbbHotel.getItems().setAll(Controller.getHoteller());
		cbbHotel.getSelectionModel().select(0);

		// værelse
		Label lblVærelsestype = new Label("Værelsestype");
		pane.add(lblVærelsestype, 0, 14);

		cbbVærelse = new ComboBox<Værelse>();
		pane.add(cbbVærelse, 0, 15);
		cbbVærelse.getItems().setAll(cbbHotel.getSelectionModel().getSelectedItem().getVærelser());

		// knapper

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 16);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 16);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());

		lblError = new Label();
		pane.add(lblError, 0, 17);
		lblError.setStyle("-fx-text-fill: red");

		this.initControls();
	}

	private void initControls() {
		if (tilmelding != null) {
			if (tilmelding.getLedsager() != null) {
				txfLedsager.setText(tilmelding.getLedsager().getNavn());
			} else
				txfLedsager.clear();
			cbbKonference.setValue(tilmelding.getKonference());
			cbbDeltager.setValue(tilmelding.getDeltager());
			if (tilmelding.getVærelse() != null) {
				cbbHotel.setValue(tilmelding.getVærelse().getHotel());
				cbbVærelse.setValue(tilmelding.getVærelse());
			} else {
				cbbHotel.setValue(null);
				cbbVærelse.setValue(null);
			}
			if (chbForedragsholder.isSelected()) {
				chbForedragsholder.setSelected(true);
			} else {
				chbForedragsholder.setSelected(false);
			}
			dpAnkomst.setValue(tilmelding.getAnkomstDato());
			dpAfrejse.setValue(tilmelding.getAfrejseDato());

			// setting everything except dates to disabled.
			txfLedsager.setDisable(true);
			cbbKonference.setDisable(true);
			cbbDeltager.setDisable(true);
			cbbHotel.setDisable(true);
			cbbVærelse.setDisable(true);
			chbForedragsholder.setDisable(true);

		} else {
			cbbKonference.setValue(null);
			cbbDeltager.setValue(null);

			dpAnkomst.setValue(null);
			dpAfrejse.setValue(null);
		}

	}

	// -------------------------------------------------------------------------

	private void cancelAction() {
		this.hide();
	}

	private void okAction() {

		Konference konference = cbbKonference.getSelectionModel().getSelectedItem();
		if (konference.equals(null)) {
			lblError.setText("Konference ikke valgt");
			return;
		}

		Deltager deltager = cbbDeltager.getSelectionModel().getSelectedItem();
		if (deltager.equals(null)) {
			lblError.setText("Deltager ikke valgt");
			return;
		}

		LocalDate ankomstdato = dpAnkomst.getValue();
		LocalDate afrejsedato = dpAfrejse.getValue();

		boolean foredragsholder = false;
		if (chbForedragsholder.isSelected()) {
			foredragsholder = true;
		}

		String ledsager = txfLedsager.getText().trim();
		if (ledsager != null) {
			lblError.setText("Ledsagernavn tomt.");
		}

		Værelse værelse = cbbVærelse.getValue();

		// Call controller methods
		if (tilmelding != null) {
			Controller.updateTilmelding(tilmelding, ankomstdato, afrejsedato);
		} else {
			Controller.createTilmelding(ankomstdato, afrejsedato, foredragsholder, deltager, new Ledsager(ledsager),
					konference, værelse);
		}

		this.hide();
	}
}
