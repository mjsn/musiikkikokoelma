package harjoitustyo.musiikkikokoelma.bean;

public class LevyTyyppiImpl implements LevyTyyppi {

	private int id;
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
		return "LevyTyyppi [id=" + id + ", nimi=" + nimi + "]";
	}
	
}
