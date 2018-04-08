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
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 745522dbe3f750d648165168decb16ee94de3b19
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images(*.jpg, *.png, *.tiff, *.bmp)", "jpg",
				"png", "bmp", "tiff");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(chooser);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
		}


>>>>>>> 0a2b654c056e44f58649b0f39f72f522e32f2224
=======
>>>>>>> good
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
<<<<<<< HEAD
				Pixelator art;
				Color[][] colors;

		primaryStage.setTitle("Form");

=======
>>>>>>> good
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
<<<<<<< HEAD
										art = new Pixelator(chooser.getSelectedFile(), 10);
										colors = art.getColor();
=======
					art = new Pixelator(chooser.getSelectedFile(), 8);
					colors = art.getColor();
					new Canvas(primaryStage, gPane, colors);
>>>>>>> good
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
