package app.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuController {

	@FXML
	private Button btn_log;

	@FXML
	private Button btn_add;

	@FXML
	private Button btn_q;
	
	Stage stage;
	Parent parent;

	@FXML
	void addAction(MouseEvent event) {
		Stage addStage = new Stage();
		try {
			parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/AddView.fxml"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(parent);
		addStage.setScene(scene);
		addStage.setTitle("Sprzedawca - panel logowania");
		addStage.show();

	}

	
	@FXML
	void logAction(MouseEvent event) {
		Stage logStage = new Stage();
		try {
			parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/LogView.fxml"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(parent);
		logStage.setScene(scene);
		logStage.setTitle("Sprzedawca - panel logowania");
		logStage.show();
		((Node)(event.getSource())).getScene().getWindow().hide();

	}

	@FXML
	void quitAction(MouseEvent event) {
		Alert a1 = new Alert(AlertType.INFORMATION);
		a1.setTitle("Podziêkowania");
		a1.setHeaderText("Dziekujemy za skorzystanie z Naszego programu");
		a1.setContentText("Potwierdz wyjœcie klikaj¹c ok.");
		a1.showAndWait();
		
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

}
