package opgaver;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Opg4App extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Gui Demo 2");
		GridPane pane = new GridPane();
		this.initContent(pane);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final TextField txfName = new TextField();

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		// add a label to the pane (at col=0, row=0)
		Label lblName = new Label("Number:");
		pane.add(lblName, 0, 1);

		// add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
		// Deleted here is:
		// TextField txfName = new TextField();
		pane.add(txfName, 1, 1, 1, 1);

		// add a button to the pane (at col=1, row=1)
		Button btnPlus = new Button("+");
		pane.add(btnPlus, 2, 0);
		GridPane.setMargin(btnPlus, new Insets(10, 10, 0, 10));

		// connect a method to the button
		btnPlus.setOnAction(event -> this.plus());

		// add a button to the pane (at col=2, row=1)
		Button btnMinus = new Button("-");
		pane.add(btnMinus, 2, 2);
		GridPane.setMargin(btnMinus, new Insets(10, 10, 0, 10));

		// connect a method to the button
		btnMinus.setOnAction(event -> this.minus());
	}

	// -------------------------------------------------------------------------

	private void plus() {
		String input = txfName.getText();
		int tal = Integer.parseInt(input);
		tal++;
		txfName.setText(tal + "");
	}

	private void minus() {
		String input = txfName.getText();
		int tal = Integer.parseInt(input);
		tal--;
		txfName.setText(tal + "");
	}
}
