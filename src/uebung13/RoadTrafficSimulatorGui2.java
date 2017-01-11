package uebung13;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

// Das ist die Klasse, die ich in der Uebung live entwickelt habe.
public class RoadTrafficSimulatorGui2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        RoadTrafficSimulator roadTrafficSimulator = new RoadTrafficSimulator();

        BorderPane mainPane = new BorderPane();

        Pane simulationPane = new Pane();
        Map<Integer, Text> texts = new HashMap<>();

        for (Node node : roadTrafficSimulator.getNodes().values()) {
            Circle circle = new Circle(node.getCoordinateX(), node.getCoordinateY(), 5);
            simulationPane.getChildren().add(circle);
        }

        for (Link link : roadTrafficSimulator.getLinks().values()) {
            Node startNode = link.getStartNode();
            Node endNode = link.getEndNode();
            Line line = new Line(startNode.getCoordinateX(), startNode.getCoordinateY(),
                    endNode.getCoordinateX(), endNode.getCoordinateY());
            simulationPane.getChildren().add(line);
            Text text = new Text(startNode.getCoordinateX(), startNode.getCoordinateY(),
                    "Occupancy: "+link.getOccupation());
            texts.put(link.getId(), text);
            simulationPane.getChildren().add(text);
        }
        Button button = new Button("Increase volume");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                roadTrafficSimulator.increaseTrafficVolume();
                for (Link link : roadTrafficSimulator.getLinks().values()) {
                    Text text = texts.get(link.getId());
                    text.setText("Occupancy: "+link.getOccupation());
                }
            }
        });

        mainPane.setTop(button);
        mainPane.setCenter(simulationPane);

        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
