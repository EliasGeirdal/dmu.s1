package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Opgave103 extends Application {
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
		Circle circle = new Circle(200, 200, 100);
		pane.getChildren().add(circle);
		circle.setFill(Color.TRANSPARENT);
		circle.setStroke(Color.BLACK);

		Circle circle1 = new Circle(230, 180, 10);
		pane.getChildren().add(circle1);
		circle1.setFill(Color.TRANSPARENT);
		circle1.setStroke(Color.BLACK);

		Circle circle2 = new Circle(170, 180, 10);
		pane.getChildren().add(circle2);
		circle2.setFill(Color.TRANSPARENT);
		circle2.setStroke(Color.BLACK);

		Line line = new Line(200, 250, 250, 250);
		pane.getChildren().add(line);

	}
}
