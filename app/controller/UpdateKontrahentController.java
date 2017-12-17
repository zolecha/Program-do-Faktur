package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.database.DBConnector;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class UpdateKontrahentController {

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

    @FXML
    void updateKontrahentAction(MouseEvent event) {
    	connection();
    	
    	if (!tf_nazwa.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update kontrahent set nazwa_k = ? where nip_k = ?;");
				ps.setString(1, tf_nazwa.getText());
				ps.setString(2, KontrahentController.id_kk);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!tf_adres.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update kontrahent set adres_k = ? where nip_k = ?;");
				ps.setString(1, tf_adres.getText());
				ps.setString(2, KontrahentController.id_kk);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!tf_miejscowosc.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update kontrahent set miejscowosc_k = ? where nip_k = ?;");
				ps.setString(1, tf_miejscowosc.getText());
				ps.setString(2, KontrahentController.id_kk);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!tf_kod_pocztowy.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update kontrahent set kod_pocztowy_k = ? where nip_k = ?;");
				ps.setString(1, tf_kod_pocztowy.getText());
				ps.setString(2, KontrahentController.id_kk);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!tf_nip.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update kontrahent set nip_k = ? where nip_k = ?;");
				ps.setString(1, tf_nip.getText());
				ps.setString(2, KontrahentController.id_kk);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		((Node) (event.getSource())).getScene().getWindow().hide();
	

    }

}