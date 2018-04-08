import javax.imageio.ImageIO;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import java.awt.Color;
import javafx.stage.Stage;

public class Canvas {
	Color[][] colors;
	
	Canvas(Stage primaryStage, GridPane gPane, Color[][] colors) {
		this.colors = colors;
		
		gPane.setPrefSize(600, 600);
		gPane.setGridLinesVisible(true);

		Button[][] TileArray = new Button[colors.length][colors[0].length]; 

		System.out.println(colors[0][0].getRGB());
		System.out.println(colors[0].length);
//		for (int i = 0; i < colors[0].length; i++) {
//			ColumnConstraints column = new ColumnConstraints(600/colors.length);
//			gPane.getColumnConstraints().add(column);
//		}
//		for (int i = 0; i < colors.length; i++) {
//			RowConstraints row = new RowConstraints(600/colors.length);
//			gPane.getRowConstraints().add(row);
//		}
		for (int y = 0; y < colors.length; y++) {
			for (int x = 0; x < colors[0].length; x++) {
				Button tile = new Button();
				//tile.setStyle("-fx-border-color: #FFFFFF; -fx-border-width: .25px; -fx-font: 22 arial; -fx-base: #000000;");
				int r = colors[y][x].getRed();
				int g = colors[y][x].getGreen();
				int b = colors[y][x].getBlue();
				int avg = (r + g + b)/3;
				tile.setStyle("-fx-background-color: rgb(" + avg + "," + avg + ", " + avg + ");");
				//tile.setMaxWidth(Double.MAX_VALUE);
				//tile.setMaxHeight(Double.MAX_VALUE);
				tile.setText("" + (y*5 + x + 1));
				//TileArray[y][x] = tile;
				gPane.add(tile, y, x);
			}
		}
	}
}
