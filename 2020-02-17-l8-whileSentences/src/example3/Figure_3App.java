package example3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Figure_3App extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent()
    {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(400, 400);
        pane.add(canvas, 0, 0);
        this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(GraphicsContext gc)
    {
        int x1 = 80; // start point: (x1,y1)
        int y1 = 10;
        int x2 = 100; // end point: (x2,y2)
        int y2 = 10;
        while (y2 <= 180 && x1 >= 0) {
            gc.strokeLine(x1, y1, x2, y2);
            y1 = y1 + 20;
            y2 = y2 + 20;
            x1 = x1 - 20;
            x2 = x2 + 20;
        }
    }

}
