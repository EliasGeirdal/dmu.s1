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
import model.Deltager;

public class DeltagerPane extends GridPane {
	private TextField txfFornavn, txfEfternavn, txfTelefon, txfAdresse, txfId;
	private ListView<Deltager> lvwDeltagere;

	public DeltagerPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblKonferencer = new Label("Deltagere");
		lblKonferencer.setFont(Font.font(null, FontWeight.BOLD, 32));
		this.add(lblKonferencer, 0, 0);

		lvwDeltagere = new ListView<>();
		this.add(lvwDeltagere, 0, 1, 1, 15);
		lvwDeltagere.getItems().setAll(Controller.getDeltagere());

		ChangeListener<Deltager> listener = (ov, oldDeltager, newDeltager) -> this.selectedDeltagerChanged();
		lvwDeltagere.getSelectionModel().selectedItemProperty().addListener(listener);

		// fornavn
		Label lblFornavn = new Label("Fornavn");
		this.add(lblFornavn, 3, 1);

		txfFornavn = new TextField();
		this.add(txfFornavn, 3, 2);
		txfFornavn.setEditable(false);

		// efternavn
		Label lblEfternavn = new Label("Efternavn");
		this.add(lblEfternavn, 3, 3);

		txfEfternavn = new TextField();
		this.add(txfEfternavn, 3, 4);
		txfEfternavn.setEditable(false);

		// Adresse
		Label lblAdresse = new Label("Adresse");
		this.add(lblAdresse, 3, 5);

		txfAdresse = new TextField();
		this.add(txfAdresse, 3, 6);
		txfAdresse.setEditable(false);

		// Telefon
		Label lblTelefon = new Label("Telefon");
		this.add(lblTelefon, 3, 7);

		txfTelefon = new TextField();
		this.add(txfTelefon, 3, 8);
		txfTelefon.setEditable(false);

		// Id
		Label lblId = new Label("Id");
		this.add(lblId, 3, 9);

		txfId = new TextField();
		this.add(txfId, 3, 10);
		txfId.setEditable(false);

		// Deltager knapper
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

		if (lvwDeltagere.getItems().size() > 0) {
			lvwDeltagere.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void createAction() {
		DeltagerWindow dia = new DeltagerWindow("Opret Deltager");
		dia.showAndWait();

		// Wait for the modal dialog to close

		lvwDeltagere.getItems().setAll(controller.Controller.getDeltagere());
		int index = lvwDeltagere.getItems().size() - 1;
		lvwDeltagere.getSelectionModel().select(index);
	}

	private void updateAction() {
		Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
		if (deltager == null) {
			return;
		}

		DeltagerWindow dia = new DeltagerWindow("Opdater Deltager", deltager);
		dia.showAndWait();

		// Wait for the modal dialog to close

		int selectIndex = lvwDeltagere.getSelectionModel().getSelectedIndex();
		lvwDeltagere.getItems().setAll(Controller.getDeltagere());
		lvwDeltagere.getSelectionModel().select(selectIndex);
	}

	private void deleteAction() {
		Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
		if (deltager == null) {
			return;
		}

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Delete Deltager");
		// alert.setContentText("Are you sure?");
		alert.setHeaderText("Er du sikker på, at du vil slette denne deltager?");
		Optional<ButtonType> result = alert.showAndWait();
		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
			Controller.deleteDeltager(deltager);
			lvwDeltagere.getItems().setAll(Controller.getDeltagere());
			this.updateControls();
		}
	}

	// -------------------------------------------------------------------------

	private void selectedDeltagerChanged() {
		this.updateControls();
	}

	public void updateControls() {
		Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
		if (deltager != null) {
			txfFornavn.setText(deltager.getFornavn());
			txfEfternavn.setText(deltager.getEfternavn());
			txfAdresse.setText(deltager.getAdresse());
			txfTelefon.setText(deltager.getTlf());
			txfId.setText(deltager.getId() + "");
		} else {
			txfFornavn.clear();
			txfEfternavn.clear();
			txfAdresse.clear();
			txfTelefon.clear();
		}
	}

}
