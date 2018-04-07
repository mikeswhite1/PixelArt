import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images(*.jpg, *.png, *.tiff, *.bmp)", "jpg",
				"png", "bmp", "tiff");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(chooser);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
		}


		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Form");
		GridPane gPane = new GridPane();
		Scene scene = new Scene(gPane, 600, 600, Color.DARKGRAY);
		new Canvas(primaryStage, gPane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
