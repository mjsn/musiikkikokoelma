package harjoitustyo.musiikkikokoelma.bean;

import javax.validation.constraints.Size;

public class LevyGenreImpl implements LevyGenre {

	private int id;
	
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
	
	@Override
	public String toString() {
		return "LevyGenreImpl [id=" + id + ", nimi=" + nimi + "]";
	}
	
}
