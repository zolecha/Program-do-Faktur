package app.model;

public class Kontrahent {
	private String nip_k, nazwa_k, adres_k, miejscowosc_k, kod_pocztowy_k;
	
	public Kontrahent() {
		
	}

	public Kontrahent(String nip_k, String nazwa_k, String adres_k, String miejscowosc_k, String kod_pocztowy_k) {
		this.nip_k = nip_k;
		this.nazwa_k = nazwa_k;
		this.adres_k = adres_k;
		this.miejscowosc_k = miejscowosc_k;
		this.kod_pocztowy_k = kod_pocztowy_k;
	}

	public String getNip_k() {
		return nip_k;
	}

	public void setNip_k(String nip_k) {
		this.nip_k = nip_k;
	}

	public String getNazwa_k() {
		return nazwa_k;
	}

	public void setNazwa_k(String nazwa_k) {
		this.nazwa_k = nazwa_k;
	}

	public String getAdres_k() {
		return adres_k;
	}

	public void setAdres_k(String adres_k) {
		this.adres_k = adres_k;
	}

	public String getMiejscowosc_k() {
		return miejscowosc_k;
	}

	public void setMiejscowosc_k(String miejscowosc_k) {
		this.miejscowosc_k = miejscowosc_k;
	}

	public String getKod_pocztowy_k() {
		return kod_pocztowy_k;
	}

	public void setKod_pocztowy_k(String kod_pocztowy_k) {
		this.kod_pocztowy_k = kod_pocztowy_k;
	}
	

}
