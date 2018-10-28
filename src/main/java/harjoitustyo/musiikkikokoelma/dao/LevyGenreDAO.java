package harjoitustyo.musiikkikokoelma.dao;

import java.util.List;

import harjoitustyo.musiikkikokoelma.bean.LevyGenre;

public interface LevyGenreDAO {

	public abstract List<LevyGenre> kaikkiGenret();
	
	public abstract LevyGenre levyGenrenTiedot(int id);

	
}