package exercise;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise_6 extends Application {
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
		int y1 = 100;
		int y2 = 105;
		int x = 0;
		for (int i = 0; i < 11; i++) {
			x = 10 + i * 16;
			// Every 5th line is 10 pixels taller
			if (i % 5 == 0) {
				gc.strokeLine(x, y1, x, y2 + 5);
				if (i == 0)
					gc.fillText("0", x, y2 + 20);
				if (i == 5)
					gc.fillText("5", x, y2 + 20);
				if (i == 10)
					gc.fillText("10", x, y2 + 20);
			} else
				gc.strokeLine(x, y1, x, y2);
		}
		double linePosition = 102.5;
		// create line
		gc.strokeLine(10, linePosition, x + 20, linePosition);
		// create arrowhead
		gc.strokeLine(x + 20, linePosition, x + 10, linePosition - 4);
		gc.strokeLine(x + 20, linePosition, x + 10, linePosition + 4);

	}

}
