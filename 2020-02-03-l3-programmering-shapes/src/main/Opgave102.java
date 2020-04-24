package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Opgave102 extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent()
    {
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane)
    {
        
        Rectangle rectangle = new Rectangle();
        pane.getChildren().add(rectangle);
        rectangle.setFill(Color.RED);
        rectangle.setX(50);
        rectangle.setY(50);
        rectangle.setWidth(200);
        rectangle.setHeight(100);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
        
        Text name = new Text("Elias");
        pane.getChildren().add(name);
        name.setX(70);
        name.setY(100);
        
    }
}
