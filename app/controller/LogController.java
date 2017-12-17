package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LogController {

	@FXML
	private TextField tf_login;

	@FXML
	private PasswordField tf_pass;

	@FXML
	private Button btn_logs;
	// utworzenie zmiennej statycznej w celu przekazania id_s do innej klasy po logowaniu
	static int id_ss;
	
	DBConnector db;
	Parent parent;
	PreparedStatement ps;

	private void loginMethod() {
		db = new DBConnector();
		Connection conn = db.connInit();

		try {
			ps = conn.prepareStatement("select id_s from sprzedawca where login=? and haslo = ?;");
			ps.setString(1, tf_login.getText());
			ps.setString(2, tf_pass.getText());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id_ss = rs.getInt("id_s"); 
				if (id_ss > 0) {
					Stage stageUser = new Stage();

					try {
						parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/SprzedawcaView.fxml"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					Scene scene = new Scene(parent);
					stageUser.setScene(scene);
					stageUser.setTitle("Menu Sprzedawcy");
					stageUser.show();
				}
			} else {
				Alert loginError = new Alert(AlertType.ERROR);
				loginError.setTitle("B³¹d logowania");
				loginError.setHeaderText("B³¹d logowania!");
				loginError.setContentText(
						"Has³o lub login s¹ niepoprwane. \nSpróbuj ponownie lub skontatktuj siê z Administratorem.");
				loginError.showAndWait();
				Stage stageUser = new Stage();

				try {
					parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/MenuView.fxml"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(parent);
				stageUser.setScene(scene);
				stageUser.setTitle("Menu G³owne");
				stageUser.show();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void logSAction(MouseEvent event) {
		loginMethod();
		((Node)(event.getSource())).getScene().getWindow().hide();
	}


}
