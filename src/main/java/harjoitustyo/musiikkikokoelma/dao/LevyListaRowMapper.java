package harjoitustyo.musiikkikokoelma.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import harjoitustyo.musiikkikokoelma.bean.Levy;
import harjoitustyo.musiikkikokoelma.bean.LevyImpl;
import harjoitustyo.musiikkikokoelma.bean.LevyArtisti;
import harjoitustyo.musiikkikokoelma.bean.LevyArtistiImpl;
import harjoitustyo.musiikkikokoelma.bean.LevyTyyppi;
import harjoitustyo.musiikkikokoelma.bean.LevyTyyppiImpl;


public class LevyListaRowMapper implements RowMapper<Levy> {

	public Levy mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Levy levy = new LevyImpl();
		LevyArtisti levyArtisti = new LevyArtistiImpl();
		LevyTyyppi levyTyyppi = new LevyTyyppiImpl();
		
		levyArtisti.setNimi(rs.getString("levyArtisti"));
		levyTyyppi.setNimi(rs.getString("levyTyyppi"));

		levy.setId(rs.getInt("id"));
		levy.setOtsikko(rs.getString("otsikko"));
		levy.setLevyArtisti(levyArtisti);
		levy.setArvosana(rs.getInt("arvosana"));
		levy.setJulkaisuVuosi(rs.getString("julkaisuVuosi"));
		levy.setLevyTyyppi(levyTyyppi);

		return levy;
		
	}

}
