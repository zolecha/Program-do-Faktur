package app.model;

public class Sprzedawca {
	private int id_s;
	private String nazwa_s;
	private String adres_s;
	private String miejscowosc_s;
	private String kod_pocztowy_s;
	private String nip_s;
	private String regon_s;
	private String rachunek_s;
	private String login;
	private String haslo;

	public Sprzedawca() {
	}

	public Sprzedawca(int id_s, String nazwa_s, String adres_s, String miejscowosc_s, String kod_pocztowy_s,
			String nip_s, String regon_s, String rachunek_s, String login, String haslo) {
		this.id_s = id_s;
		this.nazwa_s = nazwa_s;
		this.adres_s = adres_s;
		this.miejscowosc_s = miejscowosc_s;
		this.kod_pocztowy_s = kod_pocztowy_s;
		this.nip_s = nip_s;
		this.regon_s = regon_s;
		this.rachunek_s = rachunek_s;
		this.login = login;
		this.haslo = haslo;
	}

	public int getId_s() {
		return id_s;
	}

	public void setId_s(int id_s) {
		this.id_s = id_s;
	}

	public String getNazwa_s() {
		return nazwa_s;
	}

	public void setNazwa_s(String nazwa_s) {
		this.nazwa_s = nazwa_s;
	}

	public String getAdres_s() {
		return adres_s;
	}

	public void setAdres_s(String adres_s) {
		this.adres_s = adres_s;
	}

	public String getMiejscowosc_s() {
		return miejscowosc_s;
	}

	public void setMiejscowosc_s(String miejscowosc_s) {
		this.miejscowosc_s = miejscowosc_s;
	}

	public String getKod_pocztowy_s() {
		return kod_pocztowy_s;
	}

	public void setKod_pocztowy_s(String kod_pocztowy_s) {
		this.kod_pocztowy_s = kod_pocztowy_s;
	}

	public String getNip_s() {
		return nip_s;
	}

	public void setNip_s(String nip_s) {
		this.nip_s = nip_s;
	}

	public String getRegon_s() {
		return regon_s;
	}

	public void setRegon_s(String regon_s) {
		this.regon_s = regon_s;
	}

	public String getRachunek_s() {
		return rachunek_s;
	}

	public void setRachunek_s(String rachunek_s) {
		this.rachunek_s = rachunek_s;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

}
