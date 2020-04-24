package opgaver;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Opgave1 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("ListView Demo4");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final TextField txfName = new TextField();
	private final TextField txfTitle = new TextField();
	private final ListView<Person> lvwPersons = new ListView<>();
	private final ArrayList<Person> persons = new ArrayList<>();
	private CheckBox chkSenior = new CheckBox();

	private void initContent(GridPane pane) {
		this.initPersons();

		// pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 0);

		Label lblTitle = new Label("Title");
		pane.add(lblTitle, 0, 1);

		Label lblPersons = new Label("Persons:");
		pane.add(lblPersons, 0, 3);
		GridPane.setValignment(lblPersons, VPos.TOP);

		pane.add(txfName, 1, 0);

		pane.add(txfTitle, 1, 1);

		pane.add(lvwPersons, 1, 3);
		lvwPersons.setPrefWidth(200);
		lvwPersons.setPrefHeight(200);
		lvwPersons.getItems().setAll(persons);

		ChangeListener<Person> listener = (ov, o, n) -> this.personsItemSelected();
		lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

		Button btnAdd = new Button("Add person");
		pane.add(btnAdd, 2, 2);
		btnAdd.setOnAction(event -> this.addAction());

		chkSenior.setText("Senior");
		pane.add(chkSenior, 1, 2);

	}

	// -------------------------------------------------------------------------

	private void initPersons() {
	}

	// -------------------------------------------------------------------------
	// Selected item changed in lvwPersons

	private void personsItemSelected() {
		Person selected = lvwPersons.getSelectionModel().getSelectedItem();
		if (selected != null) {
			txfName.setText(selected.toString());
		} else {
			txfName.clear();
		}
	}

	// -------------------------------------------------------------------------
//	 Button actions

	private void addAction() {
		String name = txfName.getText().trim();
		String title = txfTitle.getText().trim();
		if (name.length() > 0) {
			Person p = new Person(title, name, chkSenior.isSelected());
			persons.add(p);
			lvwPersons.getItems().setAll(persons);
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Add person");
			alert.setHeaderText("Missing information");
			alert.setContentText("Missing either name or title.");
			alert.show();

			// wait for the modal dialog to close
		}
	}
}
