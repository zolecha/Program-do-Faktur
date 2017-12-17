package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.database.DBConnector;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class AddKontrahentController {

	@FXML
	private TextField tf_nip;

	@FXML
	private TextField tf_nazwa;

	@FXML
	private TextField tf_adres;

	@FXML
	private TextField tf_miejscowosc;

	@FXML
	private TextField tf_kod_pocztowy;

	PreparedStatement ps;
	Connection conn;

	private void connection() {
		DBConnector db = new DBConnector();
		db = new DBConnector();
		conn = db.connInit();
	}
	private void alert() {
		Alert a1 = new Alert(AlertType.ERROR);
		a1.setTitle("B³¹d");
		a1.setHeaderText("B³¹d przy dodawaniu Kontrahenta!");
		a1.setContentText("Wszystkie pola musz¹ zostaæ wype³nione!\nUpewnij siê czy nr NIP zawiera 10 cyfr a kod pocztowy nie jest d³u¿szy ni¿ 6 znaków");
		a1.showAndWait();
	}

	@FXML
	void AddKontrahentAction(MouseEvent event) {
		if (!tf_nip.getText().equals("") && !tf_nazwa.getText().equals("") && !tf_adres.getText().equals("")
				&& !tf_miejscowosc.getText().equals("") && !tf_kod_pocztowy.getText().equals("")) {
			connection();
			try {
				ps = conn.prepareStatement("insert into kontrahent values (null, ?,?,?,?,?,?);");
				ps.setString(1, tf_nip.getText());
				ps.setString(2, tf_nazwa.getText());
				ps.setString(3, tf_adres.getText());
				ps.setString(4, tf_miejscowosc.getText());
				ps.setString(5, tf_kod_pocztowy.getText());
				ps.setInt(6, LogController.id_ss);
				ps.executeUpdate();
				Alert a1 = new Alert(AlertType.INFORMATION);
				a1.setTitle("Kontrahent dodany do bazy prawid³owo");
				a1.setHeaderText("Kontrahent dodany do bazy prawid³owo");
				a1.showAndWait();
			} catch (SQLException e) {
				alert();

			}
		} else {
			alert();
		}
	}

	@FXML
	void clearAction(MouseEvent event) {
		tf_nip.clear();
		tf_nazwa.clear();
		tf_adres.clear();
		tf_miejscowosc.clear();
		tf_kod_pocztowy.clear();

	}

}
