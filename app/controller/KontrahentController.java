package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;
import app.model.Kontrahent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class KontrahentController {

    @FXML
    private TableView<Kontrahent> t_kontrahent;

    @FXML
    private TableColumn<Kontrahent, String> t_nip_k;

    @FXML
    private TableColumn<Kontrahent, String>  t_nazwa_k;

    @FXML
    private TableColumn<Kontrahent, String> t_adres_k;

    @FXML
    private TableColumn<Kontrahent, String>  t_miejscowosc_k;

    @FXML
    private TableColumn<Kontrahent, String>  t_kod_pocztowy_k;

    @FXML
    private Button btn_update;
    
    Parent parent;
    static String id_kk;
    @FXML
    void updateKAction(MouseEvent event) {
    	
    	id_kk = t_kontrahent.getSelectionModel().getSelectedItem().getNip_k();
    	System.out.println(id_kk);
    	Stage stage = new Stage();

		try {
			parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/UpdateKontrahentView.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Poprawianie danych Kontrahenta");
		stage.show();
		
		((Node) (event.getSource())).getScene().getWindow().hide();

    }
    @FXML
    void deleteKAction(MouseEvent event) {
		try {
			String id_k = t_kontrahent.getSelectionModel().getSelectedItem().getNip_k();
			connection();
			ps = conn.prepareStatement("delete from kontrahent where nip_k=?");
			ps.setString(1, id_k);
			ps.executeUpdate();
		} catch (SQLException e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("B³¹d przy usuwaniu kontrahenta");
			a.setHeaderText("Nie mo¿na usun¹æ kontrahenta, do którego przypisane s¹ faktury.");
			a.showAndWait();
			
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("B³¹d przy usuwaniu kontrahenta");
			a.setHeaderText("Przed usuniêciem nale¿y zaznaczyæ kontrahenta, którego chce siê usun¹æ.");
			a.showAndWait();
		}finally {
			select();
		}

	}

    
    
	Connection conn;

	private void connection() {
		DBConnector db = new DBConnector();
		db = new DBConnector();
		conn = db.connInit();
	}

	PreparedStatement ps;
	public ObservableList<Kontrahent> kontrahenci = FXCollections.observableArrayList();

	private void select() {
		connection();
		kontrahenci.clear();
		t_kontrahent.setItems(kontrahenci);
		try {
			ps = conn.prepareStatement("select nip_k, nazwa_k, adres_k, miejscowosc_k, kod_pocztowy_k from kontrahent where id_s=?;");
			ps.setInt(1, LogController.id_ss);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				kontrahenci.add(new Kontrahent(rs.getString("nip_k"), rs.getString("nazwa_k"), rs.getString("adres_k"),
						rs.getString("miejscowosc_k"), rs.getString("kod_pocztowy_k")));
			}

			
			t_nip_k.setCellValueFactory(new PropertyValueFactory<Kontrahent, String>("nip_k"));
			t_nazwa_k.setCellValueFactory(new PropertyValueFactory<Kontrahent, String>("nazwa_k"));
			t_adres_k.setCellValueFactory(new PropertyValueFactory<Kontrahent, String>("adres_k"));
			t_miejscowosc_k.setCellValueFactory(new PropertyValueFactory<Kontrahent, String>("miejscowosc_k"));
			t_kod_pocztowy_k.setCellValueFactory(new PropertyValueFactory<Kontrahent, String>("kod_pocztowy_k"));
			
			t_kontrahent.setItems(kontrahenci);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void initialize() {
		select();
	}

}
