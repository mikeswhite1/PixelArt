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


public class Main extends Application  {

	public static void main(String[] args) {
//		try {
//			Runtime.getRuntime().exec("explorer.exe /select," + "C:/");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		  JFileChooser chooser = new JFileChooser();
<<<<<<< HEAD
		  chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(".jpg", ".png");
=======
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Images(*.jpg, *.png, *.tiff, *.bmp)", "jpg", "png", "bmp", "tiff");
>>>>>>> 3ab1da4b5e1cd6a38fe29dbb4cae1d520b35ed31
		    chooser.setFileFilter(filter);
		    int returnVal = chooser.showOpenDialog(chooser);
		    
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		       System.out.println("You chose to open this file: " +
		            chooser.getSelectedFile().getName());
		    }
		    
//		String fileName = "file.txt";
//		File inputFile = null;
//		Scanner sc = null;
//
//		try {
//			inputFile = new File(fileName);
//			sc = new Scanner(inputFile);
//			sc.close();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.exit(-1);
//		}

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
