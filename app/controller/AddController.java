package app.controller;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.database.DBConnector;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddController {

	@FXML
	private TextField tf_s_nazwa;

	@FXML
	private TextField tf_s_adres;

	@FXML
	private TextField tf_s_miejscowosc;

	@FXML
	private TextField tf_s_kod;

	@FXML
	private TextField tf_s_nip;

	@FXML
	private TextField tf_s_regon;

	@FXML
	private TextField tf_s_nrrach;

	@FXML
	private TextField tf_s_login;

	@FXML
	private TextField tf_s_pass;

	@FXML
	private Button btn_add;

	@FXML
	private Button btn_close;

	@FXML
	void addAction(MouseEvent event) {
		DBConnector db = new DBConnector();
		Connection conn = db.connInit();
		
		if (!tf_s_nazwa.getText().equals("") && !tf_s_adres.getText().equals("") && !tf_s_miejscowosc.getText().equals("") && !tf_s_kod.getText().equals("")
				&& !tf_s_nip.getText().equals("") && !tf_s_regon.getText().equals("") && !tf_s_login.getText().equals("") && !tf_s_pass.getText().equals("")) {
			try {
				PreparedStatement ps = conn.prepareStatement("insert into sprzedawca values (null,?,?,?,?,?,?,?,?,?);");
				ps.setString(1, tf_s_nazwa.getText());
				ps.setString(2, tf_s_adres.getText());
				ps.setString(3, tf_s_miejscowosc.getText());
				ps.setString(4, tf_s_kod.getText());
				ps.setString(5, tf_s_nip.getText());
				ps.setString(6, tf_s_regon.getText());
				ps.setString(7, tf_s_nrrach.getText());
				ps.setString(8, tf_s_login.getText());
				ps.setString(9, tf_s_pass.getText());
				ps.executeUpdate();
				// Alert dodanosprzedawc�
				Alert a = new Alert(AlertType.INFORMATION);
				a.setTitle("Dodano Sprzedawc� do bazy");
				a.setHeaderText("Dodano Sprzedawc� do bazy");
				a.setContentText("sprzedawca dodany do bazy prawid�owo");
				a.showAndWait();
				

			} catch (SQLException e) {
				// e.printStackTrace();
				Alert a = new Alert(AlertType.ERROR);
				a.setTitle("B��d przy dodawaniu sprzedawcy");
				a.setHeaderText("B��d przy dodawaniu sprzedawcy do bazy");
				a.setContentText("Czy jeste� pewien, �e nie istnieje ju� konto na podany NIP? Nie mog� istnie� dwa konta z jednakowym nr NIP!!!"
						+ "\nNie mog� r�wnie� istnie� dwa konta o tym samym loginie - spr�buj poda� inny.");
				a.showAndWait();
			}
		} else {
			Alert a1 = new Alert(AlertType.ERROR);
			a1.setTitle("B��d przy dodawaniu sprzedawcy");
			a1.setHeaderText("B��d przy dodawaniu sprzedawcy do bazy");
			a1.setContentText("Nale�y wype�ni� wszytskie pola poza nr rachunku bankowego.");
			a1.showAndWait();
		}

	}

	@FXML
	void closeAction(MouseEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

}