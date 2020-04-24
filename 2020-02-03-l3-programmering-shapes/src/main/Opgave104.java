package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Opgave104 extends Application {
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
		pane.setPrefSize(800, 800);
		this.drawShapes(pane);
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(Pane pane) {

		/**
		 * Bullseye
		 * 
		 * 
		 * Circle circle = new Circle(200, 200, 100); pane.getChildren().add(circle);
		 * circle.setFill(Color.BLACK); circle.setStroke(Color.BLACK);
		 * 
		 * Circle circle1 = new Circle(200, 200, 80); pane.getChildren().add(circle1);
		 * circle1.setFill(Color.WHITE); circle1.setStroke(Color.BLACK);
		 * 
		 * Circle circle2 = new Circle(200, 200, 60); pane.getChildren().add(circle2);
		 * circle2.setFill(Color.BLACK); circle2.setStroke(Color.WHITE);
		 * 
		 * Circle circle3 = new Circle(200, 200, 40); pane.getChildren().add(circle3);
		 * circle3.setFill(Color.WHITE); circle3.setStroke(Color.BLACK);
		 * 
		 * Circle circle4 = new Circle(200, 200, 20); pane.getChildren().add(circle4);
		 * circle4.setFill(Color.BLACK); circle4.setStroke(Color.WHITE);
		 * 
		 * Ellipse elipse = new Ellipse();
		 * 
		 */

		int width = 12;
		int height = 15;
		int x = 10;
		int y = 0;
		int ystart = 0;
		int dy = 20;
		int dx = 20;
		Rectangle v = null;

		// række 1
		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		// række 2

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		x = x + dx;
		y = ystart;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		// række 3

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		x = x + dx;
		y = ystart;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		// række 4

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		x = x + dx;
		y = ystart;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		// række 5

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		x = x + dx;
		y = ystart;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		// række 6

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		x = x + dx;
		y = ystart;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		v = new Rectangle(x, y, width, height);
		pane.getChildren().add(v);
		v.setFill(Color.BLACK);
		y = y + dy;

		double a = 680.5;
		double b = 420.2;
		System.out.print(a * b);

	}
}
