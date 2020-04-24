package exercise5_filltext;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FillText extends Application {
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
		String s = "Datamatiker";
		int position = 50;
		int y = 1;
		while (y <= s.length()) {
			gc.fillText(s.substring(0, y), 20, position);
			y++;
			position = position + 20;
		}
	}
}
