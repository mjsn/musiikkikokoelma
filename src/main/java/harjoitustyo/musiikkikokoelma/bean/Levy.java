package harjoitustyo.musiikkikokoelma.bean;


public interface Levy {
	
	public abstract int getId();
	
	public abstract void setId(int id);
	
	public abstract String getTunnus();
	
	public abstract void setTunnus(String tunnus);
	
	public abstract String getOtsikko();
	
	public abstract void setOtsikko(String otsikko);
	
	public abstract LevyArtisti getLevyArtisti();
	
	public abstract void setLevyArtisti(LevyArtisti levyArtisti);
	
	/*public abstract String getLevyArtistiNimi();
	
	public abstract void setLevyArtistiNimi(String levyArtistiNimi);*/
	
	public abstract LevyGenre getLevyGenre();
	
	public abstract void setLevyGenre(LevyGenre levyGenre);
	
	public abstract int getArvosana();
	
	public abstract void setArvosana(int arvosana);
	
	public abstract String getJulkaisuVuosi();
	
	public abstract void setJulkaisuVuosi(String julkaisuVuosi);
	
	public abstract LevyTyyppi getLevyTyyppi();
	
	public abstract void setLevyTyyppi(LevyTyyppi levyTyyppi);
	
	public abstract int getLevyMaara();
	
	public abstract void setLevyMaara(int levyMaara);
	
	public abstract int getLevyKunto();
	
	public abstract void setLevyKunto(int levyKunto);
	
	public abstract int getKansiKunto();
	
	public abstract void setKansiKunto(int kansiKunto);
	
	public abstract String getMuutaTietoa();
	
	public abstract void setMuutaTietoa(String muutaTietoa);

}
