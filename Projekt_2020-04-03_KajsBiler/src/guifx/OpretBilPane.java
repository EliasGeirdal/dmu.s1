package guifx;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import model.Bil;
import model.Prisgruppe;

public class OpretBilPane extends GridPane {

	private Label lblBiler, lblPrisgruppe, lblRegisteringsNummer, lblMaerke;
	private ListView<Bil> lvwBiler;
	private ComboBox<Prisgruppe> cbbPrisgrupper;

	public OpretBilPane() {
		this.setPadding(new Insets(20));
		this.setHgap(50);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblBiler = new Label("Biler");
		this.add(lblBiler, 0, 0);

		lvwBiler = new ListView<>();
		this.add(lvwBiler, 0, 1, 4, 2);
		lvwBiler.setPrefHeight(200);
		lvwBiler.setPrefWidth(200);
		lvwBiler.getItems().setAll(Controller.getBiler());

		lblPrisgruppe = new Label("Prisgruppe");
		this.add(lblPrisgruppe, 4, 0);

		cbbPrisgrupper = new ComboBox<>();
		this.add(cbbPrisgrupper, 4, 1, 1, 1);
		cbbPrisgrupper.getItems().addAll(Controller.getPrisgrupper());

//		lvwPladser.setPrefHeight(200);
//		lvwPladser.setPrefWidth(200);
//		lvwPladser.getItems().setAll(Controller.getPladser());

	}
}
