package harjoitustyo.musiikkikokoelma.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class LevyImpl implements Levy {
	
	private int id;
	
	@Size(min = 0, max = 20)
	private String tunnus;
	
	@Size(min = 1, max = 255)
	private String otsikko;
	
	@Size(min = 1, max = 1)
	@Pattern(regexp = "^[0-5]*$")
	private int arvosana;
	
	@Size(min = 4, max = 4)
	@Pattern(regexp = "^[0-9]*$")
	private String julkaisuVuosi;
	
	@Size(min = 1, max = 2)
	@Pattern(regexp = "^[0-9]*$")
	private int levyMaara;
	
	@Size(min = 1, max = 1)
	@Pattern(regexp = "^[0-5]*$")
	private int levyKunto;
	
	@Size(min = 1, max = 1)
	@Pattern(regexp = "^[0-5]*$")
	private int kansiKunto;
	
	@Size(min = 0, max = 255)
	private String muutaTietoa;

	private LevyArtisti levyArtisti;
	/*@Size(min = 0, max = 255)
	private String levyArtistiNimi;*/

	
	private LevyGenre levyGenre;
	private LevyTyyppi levyTyyppi;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTunnus() {
		return tunnus;
	}
	public void setTunnus(String tunnus) {
		this.tunnus = tunnus;
	}
	public String getOtsikko() {
		return otsikko;
	}
	public void setOtsikko(String otsikko) {
		this.otsikko = otsikko;
	}
	public LevyArtisti getLevyArtisti() {
		return levyArtisti;
	}
	public void setLevyArtisti(LevyArtisti levyArtisti) {
		this.levyArtisti = levyArtisti;
	}
	/*public String getLevyArtistiNimi() {
		return levyArtistiNimi;
	}
	public void setLevyArtistiNimi(String levyArtistiNimi) {
		this.levyArtistiNimi = levyArtistiNimi;
	}*/
	public LevyGenre getLevyGenre() {
		return levyGenre;
	}
	public void setLevyGenre(LevyGenre levyGenre) {
		this.levyGenre = levyGenre;
	}
	public int getArvosana() {
		return arvosana;
	}
	public void setArvosana(int arvosana) {
		this.arvosana = arvosana;
	}
	public String getJulkaisuVuosi() {
		return julkaisuVuosi;
	}
	public void setJulkaisuVuosi(String julkaisuVuosi) {
		this.julkaisuVuosi = julkaisuVuosi;
	}
	public LevyTyyppi getLevyTyyppi() {
		return levyTyyppi;
	}
	public void setLevyTyyppi(LevyTyyppi levyTyyppi) {
		this.levyTyyppi = levyTyyppi;
	}
	public int getLevyMaara() {
		return levyMaara;
	}
	public void setLevyMaara(int levyMaara) {
		this.levyMaara = levyMaara;
	}
	public int getLevyKunto() {
		return levyKunto;
	}
	public void setLevyKunto(int levyKunto) {
		this.levyKunto = levyKunto;
	}
	public int getKansiKunto() {
		return kansiKunto;
	}
	public void setKansiKunto(int kansiKunto) {
		this.kansiKunto = kansiKunto;
	}
	public String getMuutaTietoa() {
		return muutaTietoa;
	}
	public void setMuutaTietoa(String muutaTietoa) {
		this.muutaTietoa = muutaTietoa;
	}
	@Override
	public String toString() {
		return "LevyImpl [id=" + id + ", tunnus=" + tunnus + ", otsikko=" + otsikko + ", arvosana=" + arvosana
				+ ", julkaisuVuosi=" + julkaisuVuosi + ", levyMaara=" + levyMaara + ", levyKunto=" + levyKunto
				+ ", kansiKunto=" + kansiKunto + ", muutaTietoa=" + muutaTietoa + ", levyArtisti=" + levyArtisti
				+ ", levyGenre=" + levyGenre + ", levyTyyppi=" + levyTyyppi + "]";
	}
	
	/*public String toString() {
		return "LevyImpl [id=" + id + ", tunnus=" + tunnus + ", otsikko=" + otsikko + ", arvosana=" + arvosana
				+ ", julkaisuVuosi=" + julkaisuVuosi + ", levyMaara=" + levyMaara + ", levyKunto=" + levyKunto
				+ ", kansiKunto=" + kansiKunto + ", muutaTietoa=" + muutaTietoa + ", levyArtistiNimi=" + levyArtistiNimi
				+ ", levyGenre=" + levyGenre + ", levyTyyppi=" + levyTyyppi + "]";
	}*/
	


}
