package uebung11;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;

public class RoadTrafficViewer extends Pane {
	
	private final RoadTrafficSimulator trafficSim;
	private final Map<Integer, Line> lines = new HashMap<>();

	RoadTrafficViewer(RoadTrafficSimulator trafficSim){
		this.trafficSim = trafficSim;
//		setBackground(new Background(new BackgroundImage(new Image("Hintergrundkarte.png"), null, null, null, null)));
		for(Node node: trafficSim.getNodes().values()){
			int x = node.getCoordinateX();
			int y = node.getCoordinateY();
			getChildren().add(new Ellipse(x,y,10,10));
			Text text = new Text(x, y, "Knoten " + node.getId());
			text.setFont(new Font(20));
			getChildren().add(text);
		}
		for(Link link: trafficSim.getLinks().values()){
			int startX = link.getStartNode().getCoordinateX();
			int startY = link.getStartNode().getCoordinateY();
			int endX = link.getEndNode().getCoordinateX();
			int endY = link.getEndNode().getCoordinateY();
			Line line = new Line(startX, startY, endX, endY);
			getChildren().add(line);
			lines.put(link.getId(), line);
			line.setStroke(determineOccupationColor(link));
			Text text = new Text((startX + endX)/2-10, (startY + endY)/2-10, "Kapazit�t " + link.getCapacity());
			getChildren().add(text);
		}


	}

	public void repaint() {
		for(Link link: trafficSim.getLinks().values()){
			Line line = lines.get(link.getId());
			line.setStroke(determineOccupationColor(link));
		}

	}
	
//	@Override
//    public void paintComponent(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g;
//
//		int w = getWidth();
//		int h = getHeight();
//
//		if (background == null || w != background.getWidth() || h != background.getHeight()) {
//			background = (BufferedImage) createImage(w, h);
//			drawBackground((Graphics2D) background.getGraphics());
//		}
//		g2.drawImage(background, null, 0, 0);
//        drawLinks(g2);
//    }


	private Color determineOccupationColor(Link link){
		if(link.getOccupation() < 0.5) {
			return Color.GREEN;
		} else if(link.getOccupation() < 1.0){
			return Color.YELLOW;
		} else {
			return Color.RED;
		}
	}
}
