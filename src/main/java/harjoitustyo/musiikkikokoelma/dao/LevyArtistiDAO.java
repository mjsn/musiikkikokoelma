package harjoitustyo.musiikkikokoelma.dao;

import java.util.List;

import harjoitustyo.musiikkikokoelma.bean.LevyArtisti;

public interface LevyArtistiDAO {
	
	public abstract void talletaLevyArtisti(LevyArtisti levyArtisti);

	public abstract List<LevyArtisti> kaikkiLevyArtistit();
	
	public abstract LevyArtisti levyArtistinTiedot(int id);
	
	public abstract LevyArtisti levyArtistinTiedotNimenMukaan(String nimi);
	
	public abstract boolean onkoLevyArtistia(String nimi);

	
}