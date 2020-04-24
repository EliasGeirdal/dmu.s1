package opgaver;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Opg2App extends Application {

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

	private final TextField txfUpper = new TextField();
	private final TextField txfLower = new TextField();

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
		pane.add(txfUpper, 0, 0, 1, 1);
		pane.add(txfLower, 0, 1, 1, 1);

		// add a button to the pane (at col=1, row=1)
		Button btnSwap = new Button("Swap");
		pane.add(btnSwap, 0, 2);
		GridPane.setMargin(btnSwap, new Insets(10, 10, 0, 0));

		btnSwap.setOnAction(event -> swapName());
	}

	// -------------------------------------------------------------------------
	private void swapName() {
		String upper = txfUpper.getText().trim();
		String lower = txfLower.getText().trim();
		txfUpper.setText(lower);
		txfLower.setText(upper);
	}
}
