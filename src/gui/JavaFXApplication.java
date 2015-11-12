/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author naum
 */
public class JavaFXApplication extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Route.fxml"));
		Parent root = (Parent)loader.load();
		
		Scene scene = new Scene(root);
		
		stage.setTitle("Olimpíadas");
		stage.setScene(scene);
		stage.show();

		RouteController controller = (RouteController)loader.getController();
		controller.Render();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}
