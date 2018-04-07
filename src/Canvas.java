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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Canvas {
	Canvas(Stage primaryStage, GridPane gPane) {

	    gPane.setPrefSize(600, 600);
	    gPane.setGridLinesVisible(true);

		Button[][] TileArray = new Button[5][5]; 
        
		for (int i = 0; i < 5; i++) {
			 ColumnConstraints column = new ColumnConstraints(120);
	         gPane.getColumnConstraints().add(column);
			 RowConstraints row = new RowConstraints(120);
	         gPane.getRowConstraints().add(row);
			for (int ii = 0; ii < 5; ii++) {
				Button tile = new Button();
				tile.setStyle("-fx-border-color: #FFFFFF; -fx-border-width: .25px; -fx-font: 22 arial; -fx-base: #000000;");
				tile.setMaxWidth(Double.MAX_VALUE);
				tile.setMaxHeight(Double.MAX_VALUE);
				tile.setText("" + (i*5 + ii + 1));
				TileArray[i][ii] = tile;
				gPane.add(tile, ii, i);
			}
		}
	}
}
