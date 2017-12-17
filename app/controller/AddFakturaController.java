package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.database.DBConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class AddFakturaController {

	@FXML
	private TextField tf_nip;

	@FXML
	private TextField tf_nr_f;

	@FXML
	private TextField tf_data_wystawienia;

	@FXML
	private TextField tf_ms_wyst;

	@FXML
	private TextField tf_towar;

	@FXML
	private TextField tf_ilosc;

	@FXML
	private TextField tf_jm;

	@FXML
	private TextField tf_cena_jednotsk;

	ObservableList<String> stawki = FXCollections.observableArrayList("0%", "5%", "8%", "23%");
	@FXML
	private ComboBox<String> c_vat;

	@FXML
	private TextField tf_tp;

	@FXML
	private TextField tf_fp;

	Connection conn;

	private void connection() {
		DBConnector db = new DBConnector();
		db = new DBConnector();
		conn = db.connInit();
	}

	public double vat() {
		double vat = 1;
		connection();
		String oc = c_vat.getValue();
		if (oc.equals("0%")) {
			vat = 0.00;
		} else if (oc.equals("5%")) {
			vat = 0.05;
		} else if (oc.equals("8%")) {
			vat = 0.08;
		} else if (oc.equals("23%")) {
			vat = 0.23;
		}
		return vat;
	}

	@FXML
	void addIAction(MouseEvent event) {
		connection();

		if (!tf_nip.getText().equals("") && !tf_nr_f.getText().equals("") && !tf_ms_wyst.getText().equals("")
				&& !tf_towar.getText().equals("") && !tf_ilosc.getText().equals("") && !tf_jm.getText().equals("")
				&& !tf_cena_jednotsk.getText().equals("") && !c_vat.getValue().equals("") && !tf_tp.getText().equals("")
				&& !tf_fp.getText().equals("")) {
			try {
				PreparedStatement ps = conn.prepareStatement(
						"insert into faktura values (null,?,(select id_k from kontrahent where nip_k =?),?,?,?,?,?,?,?,?,?,?,?,?,?);");
				ps.setInt(1, LogController.id_ss);
				ps.setString(2, tf_nip.getText());
				ps.setString(3, tf_nr_f.getText());
				ps.setString(4, tf_data_wystawienia.getText());
				ps.setString(5, tf_ms_wyst.getText());
				ps.setString(6, tf_towar.getText());
				ps.setString(7, tf_ilosc.getText());
				ps.setString(8, tf_jm.getText());
				ps.setDouble(9, Double.parseDouble(tf_cena_jednotsk.getText()));
				double netto = Double.parseDouble(tf_cena_jednotsk.getText()) * Double.parseDouble(tf_ilosc.getText());
				ps.setString(10, String.valueOf(netto));
				double k_vat = netto * vat();
				ps.setString(11, c_vat.getValue());
				ps.setDouble(12, k_vat);
				ps.setDouble(13, netto + k_vat);
				ps.setString(14, tf_tp.getText());
				ps.setString(15, tf_fp.getText());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("B³¹d przy dodawaniu faktury");
			a.setHeaderText("B³¹d przy dodawaniu faktury");
			a.setContentText("Aby dodaæ fakturê nalezy wprowadziæ wszystkie z niniejszych pól");
			a.showAndWait();
		}

	}

	@FXML
	void clearIAction(MouseEvent event) {
		tf_nip.clear();
		tf_nr_f.clear();
		tf_data_wystawienia.clear();
		tf_ms_wyst.clear();
		tf_towar.clear();
		tf_ilosc.clear();
		tf_jm.clear();
		tf_cena_jednotsk.clear();
		tf_tp.clear();
		tf_fp.clear();

	}

	public void initialize() throws SQLException {
		c_vat.setItems(stawki);

	}

}
