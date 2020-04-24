package opgaver;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Opg1App extends Application {

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

	private final TextField txfLastName = new TextField();
	private final TextField txfFirstName = new TextField();
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

		// add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
		// Deleted here is:
		pane.add(txfFirstName, 0, 0, 1, 1);
		pane.add(txfLastName, 2, 0, 1, 1);
		pane.add(txfName, 0, 1, 3, 1);

		// add a button to the pane (at col=1, row=1)
		Button btnCombine = new Button("Combine");
		pane.add(btnCombine, 0, 2);
		GridPane.setMargin(btnCombine, new Insets(10, 10, 0, 0));

		btnCombine.setOnAction(event -> combineName());
	}

	// -------------------------------------------------------------------------
	private void combineName() {
		String firstName = txfFirstName.getText().trim();
		String lastName = txfLastName.getText().trim();
		txfName.setText(firstName + " " + lastName);
	}
}
