package harjoitustyo.musiikkikokoelma.dao;

import java.util.List;

import harjoitustyo.musiikkikokoelma.bean.LevyTyyppi;

public interface LevyTyyppiDAO {

	public abstract List<LevyTyyppi> kaikkiTyypit();
	
	public abstract LevyTyyppi levyTyypinTiedot(int id);

}