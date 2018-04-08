import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.awt.color.*;
import javafx.stage.Stage;

public class Main extends Application {
	Pixelator art;
	java.awt.Color[][] colors;

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane borderPane = new BorderPane();
		GridPane gPane = new GridPane();

		Scene scene = new Scene(borderPane, 600, 630, Color.WHITE);

		Button open = new Button("Open file");
		open.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Images(*.jpg, *.png, *.tiff, *.bmp)", "jpg", "png", "bmp", "tiff");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(chooser);

				if(returnVal == JFileChooser.APPROVE_OPTION) {
					art = new Pixelator(chooser.getSelectedFile(), 8);
					colors = art.getColor();
					new Canvas(primaryStage, gPane, colors);
				}
			}
		});

		Button save = new Button("Save image");

		ToolBar toolbar = new ToolBar();
		toolbar.getItems().addAll(open, save);


		borderPane.setTop(toolbar);

		borderPane.setTop(toolbar);
		borderPane.setCenter(gPane);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
