package harjoitustyo.musiikkikokoelma.bean;

import javax.validation.constraints.Size;

public class LevyArtistiImpl implements LevyArtisti {

	private int id, levyMaara;
	
	@Size(min = 1, max = 255)
	private String nimi;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public int getLevyMaara() {
		return levyMaara;
	}
	public void setLevyMaara(int levyMaara) {
		this.levyMaara = levyMaara;
	}
	
	@Override
	public String toString() {
		return "LevyArtistiImpl [id=" + id + ", nimi=" + nimi + "]";
	}
	
}
