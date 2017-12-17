package app.controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;
import app.model.Faktura;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FakturaController {

	@FXML
	private TableView<Faktura> t_faktura;

	@FXML
	private TableColumn<Faktura, String> t_nip;

	@FXML
	private TableColumn<Faktura, String> t_nr_f;

	@FXML
	private TableColumn<Faktura, String> t_data_wystawienia;

	@FXML
	private TableColumn<Faktura, String> t_miejsce_wystawienia;

	@FXML
	private TableColumn<Faktura, String> t_towar;

	@FXML
	private TableColumn<Faktura, Integer> t_ilosc;

	@FXML
	private TableColumn<Faktura, String> t_jm;

	@FXML
	private TableColumn<Faktura, Double> t_cena_j;

	@FXML
	private TableColumn<Faktura, Double> t_netto;

	@FXML
	private TableColumn<Faktura, String> t_s_vat;

	@FXML
	private TableColumn<Faktura, Double> t_vat;

	@FXML
	private TableColumn<Faktura, Double> t_brutto;

	@FXML
	private TableColumn<Faktura, String> t_t_platnosci;

	@FXML
	private TableColumn<Faktura, String> t_forma_platnosci;

	PreparedStatement ps;
	Parent parent;
	static String nr_f;
	static double cena_j;
	static int ilosc;
	static String st_vat;

	@FXML
	void UpdateFAction(MouseEvent event) {
		try {
			nr_f = t_faktura.getSelectionModel().getSelectedItem().getNr_f();
			cena_j = t_faktura.getSelectionModel().getSelectedItem().getCena_j();
			ilosc = t_faktura.getSelectionModel().getSelectedItem().getIlosc();
			st_vat = t_faktura.getSelectionModel().getSelectedItem().getS_vat();
			Stage stage = new Stage();

			parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/UpdateFakturaView.fxml"));

			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setTitle("Menu Sprzedawcy");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
			Alert a1 = new Alert(AlertType.ERROR);
			a1.setTitle("B³¹d przy próbie poprawienia faktury");
			a1.setHeaderText("Nale¿y zaznaczyæ, która fakturê chce siê poprawiæ");
			a1.showAndWait();
		}

	}

	@FXML
	void deleteAction(MouseEvent event) {
		try {
			String id_s = t_faktura.getSelectionModel().getSelectedItem().getNr_f();
			connection();
			ps = conn.prepareStatement("delete from faktura where nr_f=?");
			ps.setString(1, id_s);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("B³¹d przy usuwaniu faktury");
			a.setHeaderText("Przed usuniêciem nale¿y zaznaczyæ fakturê, któr¹ chce siê usun¹æ");
			a.showAndWait();
		} finally {
			select();
		}

	}

	@FXML
	void closeFAction(MouseEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	@FXML
	void refreshFAction(MouseEvent event) {
		select();
	}

	Connection conn;

	private void connection() {
		DBConnector db = new DBConnector();
		db = new DBConnector();
		conn = db.connInit();
	}

	public ObservableList<Faktura> faktury = FXCollections.observableArrayList();

	private void select() {
		connection();
		faktury.clear();
		t_faktura.setItems(faktury);
		try {
			ps = conn.prepareStatement("select k.nip_k, f.nr_f, f.data_wystawienia, f.miejsce_wystawienia,"
					+ "f.towar, f.ilosc, f.jm,f.cena_j, f.netto, f.s_vat, f.vat, f.brutto, f.t_platnosci,"
					+ "f.forma_platnosci from faktura f natural join kontrahent k where id_s = ?;");
			ps.setInt(1, LogController.id_ss);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				faktury.add(new Faktura(rs.getString("nip_k"), rs.getString("nr_f"), rs.getString("data_wystawienia"),
						rs.getString("miejsce_wystawienia"), rs.getString("towar"), rs.getInt("ilosc"),
						rs.getString("jm"), rs.getDouble("cena_j"), rs.getDouble("netto"), rs.getString("s_vat"),
						rs.getDouble("vat"), rs.getDouble("brutto"), rs.getString("t_platnosci"),
						rs.getString("forma_platnosci")));
			}

			t_nip.setCellValueFactory(new PropertyValueFactory<Faktura, String>("nip_k"));
			t_nr_f.setCellValueFactory(new PropertyValueFactory<Faktura, String>("nr_f"));
			t_data_wystawienia.setCellValueFactory(new PropertyValueFactory<Faktura, String>("data_wystawienia"));
			t_miejsce_wystawienia.setCellValueFactory(new PropertyValueFactory<Faktura, String>("miejsce_wystawienia"));
			t_towar.setCellValueFactory(new PropertyValueFactory<Faktura, String>("towar"));
			t_ilosc.setCellValueFactory(new PropertyValueFactory<Faktura, Integer>("ilosc"));
			t_jm.setCellValueFactory(new PropertyValueFactory<Faktura, String>("jm"));
			t_cena_j.setCellValueFactory(new PropertyValueFactory<Faktura, Double>("cena_j"));
			t_netto.setCellValueFactory(new PropertyValueFactory<Faktura, Double>("netto"));
			t_s_vat.setCellValueFactory(new PropertyValueFactory<Faktura, String>("s_vat"));
			t_vat.setCellValueFactory(new PropertyValueFactory<Faktura, Double>("vat"));
			t_brutto.setCellValueFactory(new PropertyValueFactory<Faktura, Double>("brutto"));
			t_t_platnosci.setCellValueFactory(new PropertyValueFactory<Faktura, String>("t_platnosci"));
			t_forma_platnosci.setCellValueFactory(new PropertyValueFactory<Faktura, String>("forma_platnosci"));
			t_faktura.setItems(faktury);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void initialize() {
		select();
	}

}