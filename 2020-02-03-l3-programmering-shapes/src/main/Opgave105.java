package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Opgave105 extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		Pane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Shapes");
		stage.setScene(scene);
		stage.show();
	}

	private Pane initContent() {
		Pane pane = new Pane();
		pane.setPrefSize(400, 400);
		this.drawShapes(pane);
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(Pane pane) {
		Circle circle = new Circle(100, 200, 50);
		pane.getChildren().add(circle);
		circle.setFill(Color.TRANSPARENT);
		circle.setStroke(Color.BLUE);

		Circle circle1 = new Circle(175, 200, 50);
		pane.getChildren().add(circle1);
		circle1.setFill(Color.TRANSPARENT);
		circle1.setStroke(Color.BLACK);

		Circle circle2 = new Circle(250, 200, 50);
		pane.getChildren().add(circle2);
		circle2.setFill(Color.TRANSPARENT);
		circle2.setStroke(Color.RED);

		Circle circle3 = new Circle(150, 275, 50);
		pane.getChildren().add(circle3);
		circle3.setFill(Color.TRANSPARENT);
		circle3.setStroke(Color.YELLOW);

		Circle circle4 = new Circle(200, 275, 50);
		pane.getChildren().add(circle4);
		circle4.setFill(Color.TRANSPARENT);
		circle4.setStroke(Color.GREEN);
	}
}
