package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import app.database.DBConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class UpdateFakturaController {

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
	PreparedStatement ps;
	Connection conn;
	double kw_netto;

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
	void updateIAction(MouseEvent event) {
		connection();

		if (!tf_nip.getText().equals("")) {
			try {
				ps = conn.prepareStatement(
						"update faktura set id_k = (select id_k from kontrahent where nip_k = ?) where nr_f = ? and id_s = ?;");
				ps.setString(1, tf_nip.getText());
				ps.setString(2, FakturaController.nr_f);
				ps.setInt(3, LogController.id_ss);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (!tf_data_wystawienia.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update faktura set data_wystawienia = ? where nr_f = ? and id_s = ?;");
				ps.setString(1, tf_data_wystawienia.getText());
				ps.setString(2, FakturaController.nr_f);
				ps.setInt(3, LogController.id_ss);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!tf_ms_wyst.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update faktura set miejsce_wystawienia = ? where nr_f = ? and id_s = ?;");
				ps.setString(1, tf_ms_wyst.getText());
				ps.setString(2, FakturaController.nr_f);
				ps.setInt(3, LogController.id_ss);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!tf_towar.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update faktura set towar = ? where nr_f = ? and id_s = ?;");
				ps.setString(1, tf_towar.getText());
				ps.setString(2, FakturaController.nr_f);
				ps.setInt(3, LogController.id_ss);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		try {
			double netto;
			if (!tf_ilosc.getText().equals("")) {
				ps = conn.prepareStatement("update faktura set ilosc = ? where nr_f = ? and id_s = ?;");
				ps.setString(1, tf_ilosc.getText());
				ps.setString(2, FakturaController.nr_f);
				ps.setInt(3, LogController.id_ss);
				ps.executeUpdate();
				if (!tf_cena_jednotsk.getText().equals("")) {
					ps = conn.prepareStatement("update faktura set cena_j = ?, netto = ? where nr_f = ? and id_s = ?;");
					ps.setString(1, tf_cena_jednotsk.getText());
					netto = Double.parseDouble(tf_cena_jednotsk.getText()) * Double.parseDouble(tf_ilosc.getText());
					ps.setString(2, String.valueOf(netto));
					ps.setString(3, FakturaController.nr_f);
					ps.setInt(4, LogController.id_ss);
					ps.executeUpdate();
				} else {
					ps = conn.prepareStatement("update faktura set netto = ? where nr_f = ? and id_s = ?;");
					netto = Double.parseDouble(tf_ilosc.getText()) * FakturaController.cena_j;
					ps.setDouble(1, netto);
					ps.setString(2, FakturaController.nr_f);
					ps.setInt(3, LogController.id_ss);
					ps.executeUpdate();
				}
			} else {
				if (!tf_cena_jednotsk.getText().equals("")) {
					ps = conn.prepareStatement("update faktura set cena_j = ?, netto = ? where nr_f = ? and id_s = ?;");
					ps.setString(1, tf_cena_jednotsk.getText());
					netto = Double.parseDouble(tf_cena_jednotsk.getText()) * FakturaController.ilosc;
					ps.setString(2, String.valueOf(netto));
					ps.setString(3, FakturaController.nr_f);
					ps.setInt(4, LogController.id_ss);
					ps.executeUpdate();
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (!tf_jm.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update faktura set jm = ? where nr_f = ? and id_s = ?;");
				ps.setString(1, tf_jm.getText());
				ps.setString(2, FakturaController.nr_f);
				ps.setInt(3, LogController.id_ss);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		try {
			ps = conn.prepareStatement("select netto from faktura where nr_f = ? and id_s = ?;");
			ps.setString(1, FakturaController.nr_f);
			ps.setInt(2, LogController.id_ss);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				kw_netto = rs.getDouble("netto");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		if (!c_vat.getValue().equals("")) {

			try {
				ps = conn.prepareStatement(
						"update faktura set s_vat = ?, vat = ?, brutto = ? where nr_f = ? and id_s = ?;");

				ps.setString(1, c_vat.getValue());
				double k_vat = kw_netto * vat();
				ps.setDouble(2, k_vat);
				ps.setDouble(3, kw_netto + k_vat);
				ps.setString(4, FakturaController.nr_f);
				ps.setInt(5, LogController.id_ss);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (!tf_tp.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update faktura set t_platnosci = ? where nr_f = ? and id_s = ?;");
				ps.setString(1, tf_tp.getText());
				ps.setString(2, FakturaController.nr_f);
				ps.setInt(3, LogController.id_ss);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!tf_fp.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update faktura set forma_platnosci = ? where nr_f = ? and id_s = ?;");
				ps.setString(1, tf_fp.getText());
				ps.setString(2, FakturaController.nr_f);
				ps.setInt(3, LogController.id_ss);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!tf_nr_f.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update faktura set nr_f = ? where nr_f = ? and id_s = ?;");
				ps.setString(1, tf_nr_f.getText());
				ps.setString(2, FakturaController.nr_f);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				Alert a1 = new Alert(AlertType.ERROR);
				a1.setTitle("B³¹d przy zmianie nr faktury");
				a1.setHeaderText("B³¹d przy zmianie nr faktury");
				a1.setContentText("Nie mog¹ istnieæ dwie faktury o tym samym numerze!");
				a1.showAndWait();
				
			}
		}
		((Node) (event.getSource())).getScene().getWindow().hide();

	}

	public void initialize() throws SQLException {
		c_vat.setItems(stawki);
		c_vat.setValue(FakturaController.st_vat);

	}

}
