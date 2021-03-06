package exercise4_loop_circles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Circle_3App extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		GridPane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Loops");
		stage.setScene(scene);
		stage.show();
	}

	private GridPane initContent() {
		GridPane pane = new GridPane();
		Canvas canvas = new Canvas(400, 400);
		pane.add(canvas, 0, 0);
		this.drawShapes(canvas.getGraphicsContext2D());
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(GraphicsContext gc) {
		// Replace the statement here with your code.
		int x = 100;
		int y = 100;
		int r = 20;
		int delta_x1 = 8;
//    	int delta_x2 = 1;
		while (delta_x1 >= 2 || x <= 140) {
			gc.strokeOval(x - r, y - r, delta_x1 * r, 2 * r);
			delta_x1 = delta_x1 - 2;
			x = x + 20;
		}
	}

}
