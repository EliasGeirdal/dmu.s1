package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Opgave3 extends Application {
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
		Rectangle rectangle = new Rectangle();
		pane.getChildren().add(rectangle);
		rectangle.setX(100);
		rectangle.setY(200);
		rectangle.setWidth(100);
		rectangle.setHeight(125);
		// rectangle.setArcWidth(20);
		// rectangle.setArcHeight(20);
		rectangle.setFill(Color.RED);

		Polygon polygon = new Polygon(150, 100, 80, 200, 220, 200);
		pane.getChildren().add(polygon);
		polygon.setFill(Color.GREEN);

		Rectangle r1 = new Rectangle();
		pane.getChildren().add(r1);
		r1.setX(110);
		r1.setY(250);
		r1.setWidth(35);
		r1.setHeight(40);
		r1.setFill(Color.BLACK);

		Circle c1 = new Circle(220, 50, 30);
		pane.getChildren().add(c1);
		c1.setFill(Color.YELLOW);
		c1.setStroke(Color.BLACK);

		Line line = new Line(80, 325, 300, 325);
		pane.getChildren().add(line);
	}
}
