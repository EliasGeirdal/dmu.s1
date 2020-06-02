package guifx;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() {
		Controller.createSomeObjects();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Parkeringshus Demo");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private void initContent(BorderPane pane) {
//		TabPane tabPane = new TabPane();
		ParkeringshusPane parkeringshusPane = new ParkeringshusPane();

//		this.initTabPane(tabPane);
		pane.setCenter(parkeringshusPane);
	}

	private void initTabPane(TabPane tabPane) {
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

//		Tab tabParkeringshuseOgPladser = new Tab("Parkeringshuse og pladser");
//		tabPane.getTabs().add(tabParkeringshuseOgPladser);
//
//		ParkeringshusPane parkeringshusPane = new ParkeringshusPane();
//		tabParkeringshuseOgPladser.setContent(parkeringshusPane);

	}
}
