package harjoitustyo.musiikkikokoelma.dao;

import java.util.List;

import harjoitustyo.musiikkikokoelma.bean.Levy;

public interface LevyDAO {

	public abstract void talletaLevy(Levy levy);

	public abstract void muutaLevy(Levy levy);

	public abstract Levy levynTiedot(int id);
	
	public abstract void poistaLevy(int id);

	public abstract List<Levy> kaikkiLevyt();
	
	public abstract List<Levy> levytTop10();
	
}