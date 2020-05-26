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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Tilmelding;

public class TilmeldingPane extends GridPane {
	private TextField txfKonference, txfDeltager, txfAnkomst, txfAfrejse, txfLedsager, txfHotel, txfVærelsestype;
	private CheckBox chbForedragsholder;
	private ListView<Tilmelding> lvwTilmeldinger;

	public TilmeldingPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblTilmelding = new Label("Tilmeldingsformular");
		lblTilmelding.setFont(Font.font(null, FontWeight.BOLD, 32));
		this.add(lblTilmelding, 0, 0);

		lvwTilmeldinger = new ListView<>();
		this.add(lvwTilmeldinger, 0, 1, 1, 15);
		lvwTilmeldinger.getItems().setAll(Controller.getTilmeldinger());

		ChangeListener<Tilmelding> listener = (ov, oldTilmelding, newTilmelding) -> this.selectedTilmeldingChanged();
		lvwTilmeldinger.getSelectionModel().selectedItemProperty().addListener(listener);

		// Konference
		Label lblKonference = new Label("Konference");
		this.add(lblKonference, 3, 1);

		txfKonference = new TextField();
		this.add(txfKonference, 3, 2);
		txfKonference.setEditable(false);

		// Deltager
		Label lblDeltager = new Label("Deltager");
		this.add(lblDeltager, 3, 3);

		txfDeltager = new TextField();
		this.add(txfDeltager, 3, 4);
		txfDeltager.setEditable(false);

		// Ankomst
		Label lblAnkomst = new Label("Ankomst");
		this.add(lblAnkomst, 3, 5);

		txfAnkomst = new TextField();
		this.add(txfAnkomst, 3, 6);
		txfAnkomst.setEditable(false);

		// Afrejse
		Label lblAfrejse = new Label("Afrejse");
		this.add(lblAfrejse, 3, 7);

		txfAfrejse = new TextField();
		this.add(txfAfrejse, 3, 8);
		txfAfrejse.setEditable(false);

		// Foredrag
		Label lblForedragsholder = new Label("Foredragsholder");
		this.add(lblForedragsholder, 3, 9);

		chbForedragsholder = new CheckBox();
		this.add(chbForedragsholder, 3, 10);

		// Ledsager
		Label lblLedsager = new Label("Ledsager");
		this.add(lblLedsager, 3, 11);

		txfLedsager = new TextField();
		this.add(txfLedsager, 3, 12);
		txfLedsager.setEditable(false);

		// Hotel
		Label lblHotel = new Label("Hotel");
		this.add(lblHotel, 3, 13);

		txfHotel = new TextField();
		this.add(txfHotel, 3, 14);
		txfHotel.setEditable(false);

		// Værelse
		Label lblVærelse = new Label("Værelsestype");
		this.add(lblVærelse, 3, 15);

		txfVærelsestype = new TextField();
		this.add(txfVærelsestype, 3, 16);
		txfVærelsestype.setEditable(false);

		// Tilmelding knapper
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

//		if (lvwTilmeldinger.getItems().size() > 0) {
//			lvwTilmeldinger.getSelectionModel().select(0);
//		}
	}

	// -------------------------------------------------------------------------

	private void createAction() {
		TilmeldingWindow dia = new TilmeldingWindow("Opret Tilmelding");
		dia.showAndWait();

		// Wait for the modal dialog to close

		lvwTilmeldinger.getItems().setAll(controller.Controller.getTilmeldinger());
		int index = lvwTilmeldinger.getItems().size() - 1;
		lvwTilmeldinger.getSelectionModel().select(index);
	}

	private void updateAction() {
		Tilmelding tilmelding = lvwTilmeldinger.getSelectionModel().getSelectedItem();
		if (tilmelding == null) {
			return;
		}

		TilmeldingWindow dia = new TilmeldingWindow("Opdater Tilmelding", tilmelding);
		dia.showAndWait();

		// Wait for the modal dialog to close

		int selectIndex = lvwTilmeldinger.getSelectionModel().getSelectedIndex();
		lvwTilmeldinger.getItems().setAll(Controller.getTilmeldinger());
		lvwTilmeldinger.getSelectionModel().select(selectIndex);
	}

	private void deleteAction() {
		Tilmelding tilmelding = lvwTilmeldinger.getSelectionModel().getSelectedItem();
		if (tilmelding == null) {
			return;
		}

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Delete Tilmelding");
		// alert.setContentText("Are you sure?");
		alert.setHeaderText("Er du sikker på, at du vil slette denne tilmelding?");
		Optional<ButtonType> result = alert.showAndWait();
		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
			Controller.deleteTilmelding(tilmelding, tilmelding.getKonference());
			lvwTilmeldinger.getItems().setAll(Controller.getTilmeldinger());
			this.updateControls();
		}
	}

	// -------------------------------------------------------------------------

	private void selectedTilmeldingChanged() {
		this.updateControls();
	}

	public void updateControls() {
		Tilmelding tilmelding = lvwTilmeldinger.getSelectionModel().getSelectedItem();
		if (tilmelding != null) {
			txfKonference.setText(tilmelding.getKonference().toString());
			txfDeltager.setText(tilmelding.getDeltager().toString());
			txfAfrejse.setText(tilmelding.getAfrejseDato().toString());
			txfAnkomst.setText(tilmelding.getAnkomstDato().toString());
			if (tilmelding.isForedragsholder()) {
				chbForedragsholder.setSelected(true);
			} else {
				chbForedragsholder.setSelected(false);
			}

			if (tilmelding.getLedsager() != null) {
				txfLedsager.setText(tilmelding.getLedsager().getNavn());
			} else {
				txfLedsager.setText(null);
			}
			if (tilmelding.getVærelse() != null) {
				txfHotel.setText(tilmelding.getVærelse().getHotel().getNavn());
				txfVærelsestype.setText(tilmelding.getVærelse().getType());
			} else {
				txfHotel.setText(null);
				txfVærelsestype.setText(null);
			}
		} else {
			txfKonference.clear();
			txfDeltager.clear();
			txfAfrejse.clear();
			txfAnkomst.clear();
			txfHotel.clear();
			txfVærelsestype.clear();
		}
	}

}
