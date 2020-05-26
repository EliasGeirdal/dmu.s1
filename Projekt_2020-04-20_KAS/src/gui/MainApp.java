package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
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
		Controller.init();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Konference administrations system");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) {
		TabPane tabPane = new TabPane();
		this.initTabPane(tabPane);
		pane.setCenter(tabPane);
	}

	private void initTabPane(TabPane tabPane) {
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		Tab tabKonference = new Tab("Konference");
		tabPane.getTabs().add(tabKonference);

		KonferencePane konferencePane = new KonferencePane();
		tabKonference.setContent(konferencePane);
		tabKonference.setOnSelectionChanged(event -> konferencePane.updateControls());

		Tab tabDeltageroplysninger = new Tab("Deltageroversigt");
		tabPane.getTabs().add(tabDeltageroplysninger);

		DeltageroversigtPane deltageroplysningerPane = new DeltageroversigtPane();
		tabDeltageroplysninger.setContent(deltageroplysningerPane);
		tabDeltageroplysninger.setOnSelectionChanged(event -> deltageroplysningerPane.updateKonfControls());

		Tab tabDeltagere = new Tab("Rediger Deltagere");
		tabPane.getTabs().add(tabDeltagere);

		DeltagerPane deltagerePane = new DeltagerPane();
		tabDeltagere.setContent(deltagerePane);
		tabDeltagere.setOnSelectionChanged(event -> deltagerePane.updateControls());

		Tab tabHoteloplysninger = new Tab("hoteloversigt");
		tabPane.getTabs().add(tabHoteloplysninger);

		HoteloversigtPane hoteloplysningerPane = new HoteloversigtPane();
		tabHoteloplysninger.setContent(hoteloplysningerPane);
		tabHoteloplysninger.setOnSelectionChanged(event -> hoteloplysningerPane.updateControls());
		tabHoteloplysninger.setOnSelectionChanged(event -> hoteloplysningerPane.updateHotelListView());

		Tab tabHotel = new Tab("Rediger Hoteller");
		tabPane.getTabs().add(tabHotel);

		HotelPane hotelPane = new HotelPane();
		tabHotel.setContent(hotelPane);
		tabHotel.setOnSelectionChanged(event -> hotelPane.updateControls());

		Tab tabTilmelding = new Tab("Tilmelding");
		tabPane.getTabs().add(tabTilmelding);

		TilmeldingPane tilmeldingPane = new TilmeldingPane();
		tabTilmelding.setContent(tilmeldingPane);
		tabTilmelding.setOnSelectionChanged(event -> tilmeldingPane.updateControls());

	}

}
