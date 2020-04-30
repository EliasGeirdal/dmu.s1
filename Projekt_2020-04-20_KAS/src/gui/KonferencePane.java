package gui;

import java.util.Optional;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Konference;
import model.Udflugt;

public class KonferencePane extends GridPane {
	private TextField txfNavn, txfAdresse, txfPris, txfStartdato, txfSlutdato;
	private ListView<Konference> lvwKonferencer;
	private ListView<Udflugt> lvwUdflugter;

	public KonferencePane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblKonferencer = new Label("Konferencer");
		lblKonferencer.setFont(Font.font(null, FontWeight.BOLD, 32));
		this.add(lblKonferencer, 0, 0);

		lvwKonferencer = new ListView<>();
		this.add(lvwKonferencer, 0, 1, 1, 20);
		lvwKonferencer.getItems().setAll(Controller.getKonferencer());

		ChangeListener<Konference> listener = (ov, oldKonference, newKonference) -> this.selectedKonferenceChanged();
		lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(listener);

		// navn
		Label lblNavn = new Label("Navn");
		this.add(lblNavn, 3, 1);

		txfNavn = new TextField();
		this.add(txfNavn, 3, 2);
		txfNavn.setEditable(false);

		// adresse
		Label lblAdresse = new Label("Adresse");
		this.add(lblAdresse, 3, 3);

		txfAdresse = new TextField();
		this.add(txfAdresse, 3, 4);
		txfAdresse.setEditable(false);

		// startDato
		Label lblStartdato = new Label("Startdato");
		this.add(lblStartdato, 3, 5);

		txfStartdato = new TextField();
		this.add(txfStartdato, 3, 6);
		txfStartdato.setEditable(false);

		// slutdato
		Label lblSlutdato = new Label("Slutdato");
		this.add(lblSlutdato, 3, 7);

		txfSlutdato = new TextField();
		this.add(txfSlutdato, 3, 8);
		txfSlutdato.setEditable(false);

		// pris
		Label lblPris = new Label("Pris");
		this.add(lblPris, 3, 9);

		txfPris = new TextField();
		this.add(txfPris, 3, 10);
		txfPris.setEditable(false);

		// buttons for konference
		Button btnCreateKon = new Button("Opret konference");
		this.add(btnCreateKon, 0, 22);
		btnCreateKon.setOnAction(event -> this.createAction());

		Button btnUpdateKon = new Button("Opdater konference");
		this.add(btnUpdateKon, 3, 22);
		btnUpdateKon.setOnAction(event -> this.updateAction());

		Button btnDeleteKon = new Button("Slet konference");
		this.add(btnDeleteKon, 5, 22);
		btnDeleteKon.setOnAction(event -> this.deleteAction());

		// udflugter
		Label lblUdflugt = new Label("Udflugter");
		this.add(lblUdflugt, 5, 1);

		lvwUdflugter = new ListView<>();
		this.add(lvwUdflugter, 5, 2, 1, 4);
		lvwUdflugter.setMaxHeight(130);
		lvwUdflugter.setPrefWidth(500);

		// button for udflugter
		Button btnCreateUdf = new Button("Tilføj udflugt");
		this.add(btnCreateUdf, 5, 6);
		btnCreateUdf.setOnAction(event -> this.createUdfAction()); // remember to change to its own action action
		btnCreateUdf.setMinWidth(130);

		Button btnUpdateUdf = new Button("Opdater udflugt");
		this.add(btnUpdateUdf, 5, 7);
		btnUpdateUdf.setOnAction(event -> this.updateUdfAction()); // remember to change to its own update action
		btnUpdateUdf.setMinWidth(130);

		Button btnDeleteUdf = new Button("Slet udflugt");
		this.add(btnDeleteUdf, 5, 8);
		btnDeleteUdf.setOnAction(event -> this.deleteUdfAction()); // remember to change to its own delete action
		btnDeleteUdf.setMinWidth(130);

		if (lvwKonferencer.getItems().size() > 0) {
			lvwKonferencer.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void createAction() {
		KonferenceWindow dia = new KonferenceWindow("Opret konference");
		dia.showAndWait();

		// Wait for the modal dialog to close

		lvwKonferencer.getItems().setAll(controller.Controller.getKonferencer());
		int index = lvwKonferencer.getItems().size() - 1;
		lvwKonferencer.getSelectionModel().select(index);
	}

	private void updateAction() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference == null) {
			return;
		}

		KonferenceWindow dia = new KonferenceWindow("Opdater Udflugt", konference);
		dia.showAndWait();

		// Wait for the modal dialog to close

		int selectIndex = lvwKonferencer.getSelectionModel().getSelectedIndex();
		lvwKonferencer.getItems().setAll(Controller.getKonferencer());
		lvwKonferencer.getSelectionModel().select(selectIndex);
	}

	private void deleteAction() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference == null) {
			return;
		}

		if (konference.getTilmeldinger().size() == 0) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Slet Konference");
			// alert.setContentText("Are you sure?");
			alert.setHeaderText("Er du sikker?");
			Optional<ButtonType> result = alert.showAndWait();
			if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
				Controller.deleteKonference(konference);
				lvwKonferencer.getItems().setAll(Controller.getKonferencer());
				this.updateControls();
			}

		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Slet Konference");
			alert.setHeaderText("Kan ikke slette en konferencer med tilmeldinger");
			// wait for the modal dialog to close
			alert.show();
		}
	}

	// udflugt knapper..

	public void createUdfAction() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference == null) {
			return;
		}

		UdflugtWindow dia = new UdflugtWindow("Opret udflugt", null, konference);
		dia.showAndWait();

		// Wait for the modal dialog to close

		lvwUdflugter.getItems().setAll(konference.getUdflugter());
		int index = lvwUdflugter.getItems().size() - 1;
		lvwUdflugter.getSelectionModel().select(index);
	}

	public void updateUdfAction() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference == null) {
			return;
		}
		Udflugt udflugt = lvwUdflugter.getSelectionModel().getSelectedItem();
		if (udflugt == null) {
			return;
		}

		UdflugtWindow dia = new UdflugtWindow("Opdater udflugt", udflugt, konference);
		dia.showAndWait();

		// Wait for the modal dialog to close

		int selectIndex = lvwUdflugter.getSelectionModel().getSelectedIndex();
		lvwUdflugter.getItems().setAll(konference.getUdflugter());
		lvwUdflugter.getSelectionModel().select(selectIndex);
	}

	public void deleteUdfAction() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference == null) {
			return;
		}

		Udflugt udflugt = lvwUdflugter.getSelectionModel().getSelectedItem();
		if (udflugt == null) {
			return;
		}

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Slet Konference");
		alert.setContentText("Kan ikke gøres om");
		alert.setHeaderText("Er du sikker?");
		Optional<ButtonType> result = alert.showAndWait();
		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
			Controller.deleteUdflugtFromKonference(konference, udflugt);
			lvwUdflugter.getItems().setAll(konference.getUdflugter());
			this.updateControls();
		}
	}

	// -------------------------------------------------------------------------

	private void selectedKonferenceChanged() {
		this.updateControls();
	}

	public void updateControls() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference != null) {
			txfNavn.setText(konference.getNavn());
			txfAdresse.setText(konference.getAdresse());
			txfStartdato.setText(konference.getStartDato().toString());
			txfSlutdato.setText(konference.getSlutDato().toString());
			txfPris.setText(konference.getDagspris() + "");
			lvwUdflugter.getItems().setAll(konference.getUdflugter());
		} else {
			txfNavn.clear();
			txfAdresse.clear();
			txfStartdato.clear();
			txfSlutdato.clear();
			txfPris.clear();
		}
	}

}
