package app.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SprzedawcaController {

	@FXML
	private Button btn_update;

	@FXML
	private Button btn_c_custom;

	@FXML
	private Button btn_add_custom;

	@FXML
	private Button btn_c_invoice;

	@FXML
	private Button btn_add_invoice;

	@FXML
	private Button btn_logOut;

	@FXML
	void addCustomerAction(MouseEvent event) {
		Stage stage = new Stage();
		try {
			parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/AddKontrahentView.fxml"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Dodawanie Kontrahenta");
		stage.show();

	}

	@FXML
	void addInvoceAction(MouseEvent event) {
		Stage stage = new Stage();
		try {
			parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/AddFakturaView.fxml"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Dodawanie Kontrahenta");
		stage.show();

	}

	@FXML
	void checkCustomerAction(MouseEvent event) {
		Stage stage = new Stage();
		try {
			parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/KontrahentView.fxml"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Kontrahenci - dane");
		stage.show();

	}

	@FXML
	void checkInvoceAction(MouseEvent event) {
		Stage stage = new Stage();
		try {
			parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/FakturaView.fxml"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Faktury");
		stage.show();

	}

	@FXML
	void logOutAction(MouseEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
		
		Stage stage = new Stage();
		try {
			Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/MenuView.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setTitle("Aplikacja faktura - menu");
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();

			
		}

	}

	Parent parent;

	@FXML
	void updateAction(MouseEvent event) {
		Stage addStage = new Stage();
		try {
			parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/UpdateSTableView.fxml"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(parent);
		addStage.setScene(scene);
		addStage.setTitle("Sprzedawca - dane");
		addStage.show();
	}

}
