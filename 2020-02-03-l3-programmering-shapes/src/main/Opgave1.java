package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

public class Opgave1 extends Application
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
        Circle circle = new Circle(70, 70, 30);
        pane.getChildren().add(circle);
        circle.setFill(Color.CORNFLOWERBLUE);
        circle.setStroke(Color.BLACK);
        
        Rectangle rectangle = new Rectangle();
        pane.getChildren().add(rectangle);
        rectangle.setFill(Color.AQUA);
        rectangle.setX(50);
        rectangle.setY(50);
        rectangle.setWidth(200);
        rectangle.setHeight(100);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
        
        Line line = new Line(0,0,500,500);
        pane.getChildren().add(line);
        
    }
}