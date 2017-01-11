package uebung11;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

// Das ist ein Loesungsvorschlag.
public class RoadTrafficSimulatorGui1 extends Application {

	private final RoadTrafficSimulator trafficSim;
	private final RoadTrafficViewer trafficViewer;
	private BorderPane mainPanel;
	private Button increaseTrafficVolumeButton;
	private Button decreaseTrafficVolumeButton;
	private Label header;
	
	public RoadTrafficSimulatorGui1() {
		trafficSim = new RoadTrafficSimulator();
		trafficViewer = new RoadTrafficViewer(trafficSim);
	}

	@Override
	public void start(Stage stage) throws Exception {
		mainPanel = new BorderPane();

		header = new Label();
		header.setText("Aktuelles Verkehrsaufkommen: " + trafficSim.getTrafficVolume());

		FlowPane controlPanel = new FlowPane();
		increaseTrafficVolumeButton = new Button("Verkehrsaufkommen erh�hen");
		increaseTrafficVolumeButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
			@Override
			public void handle(javafx.event.ActionEvent event) {
				trafficSim.increaseTrafficVolume();
				header.setText("Aktuelles Verkehrsaufkommen: " + trafficSim.getTrafficVolume());
				trafficViewer.repaint();
			}
		});
		decreaseTrafficVolumeButton = new Button("Verkehrsaufkommen senken");
		decreaseTrafficVolumeButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
			@Override
			public void handle(javafx.event.ActionEvent event) {
				trafficSim.decreaseTrafficVolume();
				header.setText("Aktuelles Verkehrsaufkommen: " + trafficSim.getTrafficVolume());
				trafficViewer.repaint();
			}
		});
		controlPanel.getChildren().add(increaseTrafficVolumeButton);
		controlPanel.getChildren().add(decreaseTrafficVolumeButton);

		mainPanel.setTop(header);
		mainPanel.setCenter(trafficViewer);
		mainPanel.setBottom(controlPanel);

		stage.setTitle("Mini-Verkehrsmodell");
		stage.setScene(new Scene(mainPanel, 1000, 300));
		stage.show();
	}


	    public static void main(String[] args) {
           	launch(args);
	    }

}
