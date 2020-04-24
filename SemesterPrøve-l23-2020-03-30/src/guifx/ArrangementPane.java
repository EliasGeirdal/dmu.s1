package guifx;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Område;
import model.Plads;

public class ArrangementPane extends GridPane {

	private ListView<Plads> lvwPladser;
	private TextField txfNummer;
	private final ToggleGroup group = new ToggleGroup();

	public ArrangementPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblPladser = new Label("Pladser: ");
		this.add(lblPladser, 0, 0);

		lvwPladser = new ListView<>();
		this.add(lvwPladser, 0, 1, 3, 3);
		lvwPladser.setPrefHeight(200);
		lvwPladser.setPrefWidth(200);
		lvwPladser.getItems().setAll(Controller.getPladser());

		Label lblOmråde = new Label("Område: ");
		this.add(lblOmråde, 0, 7);

		VBox box = new VBox();
		this.add(box, 2, 7);

		String[] områdeStrings = { "Standard", "VIP", "Børne", "Turnering" };
		Område[] område = { Område.STANDARD, Område.VIP, Område.BØRNE, Område.TURNERING };

		for (int i = 0; i < områdeStrings.length; i++) {
			RadioButton rb = new RadioButton();
			box.getChildren().add(rb);
			rb.setText(områdeStrings[i]);
			rb.setUserData(område[i]);
			// only one button is in selected state.
			rb.setToggleGroup(group);
		}

		Label lblNummer = new Label("Nummer: ");
		this.add(lblNummer, 0, 8);

		txfNummer = new TextField();
		this.add(txfNummer, 1, 8, 2, 1);

		Button btnOpret = new Button("Opret");
		this.add(btnOpret, 1, 9);

		btnOpret.setOnAction(event -> this.opretAction());
	}

	// -------------------------------------------------------------------------------------

	public void opretAction() {
		int nummer = Integer.parseInt(txfNummer.getText());
		Område område = (Område) group.getSelectedToggle().getUserData();
		Controller.createPlads(nummer, område);

		lvwPladser.getItems().setAll(Controller.getPladser());
		txfNummer.clear();
		group.getSelectedToggle().setSelected(false);
	}

}
