package app.model;

public class Faktura {

	private String nip_k;
	private String nr_f;
	private String data_wystawienia;
	private String miejsce_wystawienia;
	private String towar;
	private int ilosc;
	private String jm;
	private double cena_j;
	private double netto;
	private String s_vat;
	private double vat;
	private double brutto;
	private String t_platnosci;
	private String forma_platnosci;

	public Faktura() {
	}

	public Faktura(String nip_k, String nr_f, String data_wystawienia, String miejsce_wystawienia, String towar,
			int ilosc, String jm, double cena_j, double netto, String s_vat, double vat, double brutto,
			String t_platnosci, String forma_platnosci) {
		this.nip_k = nip_k;
		this.nr_f = nr_f;
		this.data_wystawienia = data_wystawienia;
		this.miejsce_wystawienia = miejsce_wystawienia;
		this.towar = towar;
		this.ilosc = ilosc;
		this.jm = jm;
		this.cena_j = cena_j;
		this.netto = netto;
		this.s_vat = s_vat;
		this.vat = vat;
		this.brutto = brutto;
		this.t_platnosci = t_platnosci;
		this.forma_platnosci = forma_platnosci;
	}

	public String getNip_k() {
		return nip_k;
	}

	public void setNip_k(String nip_k) {
		this.nip_k = nip_k;
	}

	public String getNr_f() {
		return nr_f;
	}

	public void setNr_f(String nr_f) {
		this.nr_f = nr_f;
	}

	public String getData_wystawienia() {
		return data_wystawienia;
	}

	public void setData_wystawienia(String data_wystawienia) {
		this.data_wystawienia = data_wystawienia;
	}

	public String getMiejsce_wystawienia() {
		return miejsce_wystawienia;
	}

	public void setMiejsce_wystawienia(String miejsce_wystawienia) {
		this.miejsce_wystawienia = miejsce_wystawienia;
	}

	public String getTowar() {
		return towar;
	}

	public void setTowar(String towar) {
		this.towar = towar;
	}

	public int getIlosc() {
		return ilosc;
	}

	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

	public String getJm() {
		return jm;
	}

	public void setJm(String jm) {
		this.jm = jm;
	}

	public double getCena_j() {
		return cena_j;
	}

	public void setCena_j(double cena_j) {
		this.cena_j = cena_j;
	}

	public double getNetto() {
		return netto;
	}

	public void setNetto(double netto) {
		this.netto = netto;
	}

	public String getS_vat() {
		return s_vat;
	}

	public void setS_vat(String s_vat) {
		this.s_vat = s_vat;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getBrutto() {
		return brutto;
	}

	public void setBrutto(double brutto) {
		this.brutto = brutto;
	}

	public String getT_platnosci() {
		return t_platnosci;
	}

	public void setT_platnosci(String t_platnosci) {
		this.t_platnosci = t_platnosci;
	}

	public String getForma_platnosci() {
		return forma_platnosci;
	}

	public void setForma_platnosci(String forma_platnosci) {
		this.forma_platnosci = forma_platnosci;
	}

	
	
}
