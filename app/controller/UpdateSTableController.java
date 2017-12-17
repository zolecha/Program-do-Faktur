package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.TextField;
import app.database.DBConnector;
import app.model.Sprzedawca;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class UpdateSTableController {

	@FXML
	private TableView<Sprzedawca> t_sprzedawca;

	@FXML
	private TableColumn<Sprzedawca, Integer> t_id_s;

	@FXML
	private TableColumn<Sprzedawca, String> t_nazwa_s;

	@FXML
	private TableColumn<Sprzedawca, String> t_adres_s;

	@FXML
	private TableColumn<Sprzedawca, String> t_miejscowosc_s;

	@FXML
	private TableColumn<Sprzedawca, String> t_kod_pocztowy_s;

	@FXML
	private TableColumn<Sprzedawca, String> t_nip_s;

	@FXML
	private TableColumn<Sprzedawca, String> t_regon_s;

	@FXML
	private TableColumn<Sprzedawca, String> t_rachunek_s;

	@FXML
	private TableColumn<Sprzedawca, String> t_login;

	@FXML
	private TableColumn<Sprzedawca, String> t_haslo;

	@FXML
	private Button btn_refresh;

	@FXML
	private Button btn_update;

	@FXML
	private TextField tf_nazwa;

	@FXML
	private TextField tf_adres;

	@FXML
	private TextField tf_miejscowosc;

	@FXML
	private TextField tf_kod;

	@FXML
	private TextField tf_nip;

	@FXML
	private TextField tf_regon;

	@FXML
	private TextField tf_nr_rachunku;

	@FXML
	private TextField tf_login;

	@FXML
	private TextField tf_haslo;

	Connection conn;

	private void connection() {
		DBConnector db = new DBConnector();
		db = new DBConnector();
		conn = db.connInit();
	}

	PreparedStatement ps;
	public ObservableList<Sprzedawca> dane = FXCollections.observableArrayList();

	private void select() {
		connection();
		dane.clear();
		t_sprzedawca.setItems(dane);
		try {
			ps = conn.prepareStatement("select*from sprzedawca where id_s=?;");
			ps.setInt(1, LogController.id_ss);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				dane.add(new Sprzedawca(rs.getInt("id_s"), rs.getString("nazwa_s"), rs.getString("adres_s"),
						rs.getString("miejscowosc_s"), rs.getString("kod_pocztowy_s"), rs.getString("nip_s"),
						rs.getString("regon_s"), rs.getString("rachunek_s"), rs.getString("login"),
						rs.getString("haslo")));
			}

			// id z tabeli, <Model, typ> ("nazwa kolumny w bazie danych")
			t_id_s.setCellValueFactory(new PropertyValueFactory<Sprzedawca, Integer>("id_s"));
			t_nazwa_s.setCellValueFactory(new PropertyValueFactory<Sprzedawca, String>("nazwa_s"));
			t_adres_s.setCellValueFactory(new PropertyValueFactory<Sprzedawca, String>("adres_s"));
			t_miejscowosc_s.setCellValueFactory(new PropertyValueFactory<Sprzedawca, String>("miejscowosc_s"));
			t_kod_pocztowy_s.setCellValueFactory(new PropertyValueFactory<Sprzedawca, String>("kod_pocztowy_s"));
			t_nip_s.setCellValueFactory(new PropertyValueFactory<Sprzedawca, String>("nip_s"));
			t_regon_s.setCellValueFactory(new PropertyValueFactory<Sprzedawca, String>("regon_s"));
			t_rachunek_s.setCellValueFactory(new PropertyValueFactory<Sprzedawca, String>("rachunek_s"));
			t_login.setCellValueFactory(new PropertyValueFactory<Sprzedawca, String>("login"));
			t_haslo.setCellValueFactory(new PropertyValueFactory<Sprzedawca, String>("haslo"));
			// dodanie danych do TableView w postaci utworzenia obiektu ObservableList
			t_sprzedawca.setItems(dane);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void initialize() {
		select();
	}

	@FXML
	void refreshAction(MouseEvent event) {
		select();
	}

	@FXML
	void updateAction(MouseEvent event) {
		if (!tf_nazwa.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update sprzedawca set nazwa_s = ? where id_s = ?;");
				ps.setString(1, tf_nazwa.getText());
				ps.setInt(2, LogController.id_ss);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!tf_adres.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update sprzedawca set adres_s = ? where id_s = ?;");
				ps.setString(1, tf_adres.getText());
				ps.setInt(2, LogController.id_ss);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!tf_miejscowosc.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update sprzedawca set miejscowosc_s = ? where id_s = ?;");
				ps.setString(1, tf_miejscowosc.getText());
				ps.setInt(2, LogController.id_ss);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!tf_kod.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update sprzedawca set kod_pocztowy_s = ? where id_s = ?;");
				ps.setString(1, tf_kod.getText());
				ps.setInt(2, LogController.id_ss);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!tf_nip.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update sprzedawca set nip_s = ? where id_s = ?;");
				ps.setString(1, tf_nip.getText());
				ps.setInt(2, LogController.id_ss);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!tf_regon.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update sprzedawca set regon_s = ? where id_s = ?;");
				ps.setString(1, tf_regon.getText());
				ps.setInt(2, LogController.id_ss);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!tf_nr_rachunku.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update sprzedawca set rachunek_s = ? where id_s = ?;");
				ps.setString(1, tf_nr_rachunku.getText());
				ps.setInt(2, LogController.id_ss);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!tf_login.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update sprzedawca set login = ? where id_s = ?;");
				ps.setString(1, tf_login.getText());
				ps.setInt(2, LogController.id_ss);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!tf_haslo.getText().equals("")) {
			try {
				ps = conn.prepareStatement("update sprzedawca set haslo = ? where id_s = ?;");
				ps.setString(1, tf_haslo.getText());
				ps.setInt(2, LogController.id_ss);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		select();
	}

}
