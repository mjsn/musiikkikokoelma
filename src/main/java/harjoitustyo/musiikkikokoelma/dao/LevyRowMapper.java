package harjoitustyo.musiikkikokoelma.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import harjoitustyo.musiikkikokoelma.bean.Levy;
import harjoitustyo.musiikkikokoelma.bean.LevyImpl;
import harjoitustyo.musiikkikokoelma.bean.LevyArtisti;
import harjoitustyo.musiikkikokoelma.bean.LevyArtistiImpl;
import harjoitustyo.musiikkikokoelma.bean.LevyGenre;
import harjoitustyo.musiikkikokoelma.bean.LevyGenreImpl;
import harjoitustyo.musiikkikokoelma.bean.LevyTyyppi;
import harjoitustyo.musiikkikokoelma.bean.LevyTyyppiImpl;


public class LevyRowMapper implements RowMapper<Levy> {

	public Levy mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Levy levy = new LevyImpl();
		LevyArtisti levyArtisti = new LevyArtistiImpl();
		LevyGenre levyGenre = new LevyGenreImpl();
		LevyTyyppi levyTyyppi = new LevyTyyppiImpl();
		
		//levyArtisti.setId(rs.getInt("artistiId"));
		//levyGenre.setId(rs.getInt("genreId"));
		//levyTyyppi.setId(rs.getInt("tyyppiId"));
		
		levyArtisti.setNimi(rs.getString("levyArtisti"));
		levyTyyppi.setNimi(rs.getString("levyTyyppi"));
		levyGenre.setNimi(rs.getString("levyGenre"));

		levy.setId(rs.getInt("id"));
		levy.setTunnus(rs.getString("tunnus"));
		levy.setOtsikko(rs.getString("otsikko"));
		levy.setLevyArtisti(levyArtisti);
		levy.setLevyGenre(levyGenre);
		levy.setArvosana(rs.getInt("arvosana"));
		levy.setJulkaisuVuosi(rs.getString("julkaisuVuosi"));
		levy.setLevyTyyppi(levyTyyppi);
		levy.setLevyMaara(rs.getInt("levyMaara"));
		levy.setLevyKunto(rs.getInt("levyKunto"));
		levy.setKansiKunto(rs.getInt("kansiKunto"));
		levy.setMuutaTietoa(rs.getString("muutaTietoa"));

		return levy;
		
	}

}
