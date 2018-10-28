package harjoitustyo.musiikkikokoelma.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import harjoitustyo.musiikkikokoelma.bean.Levy;
import harjoitustyo.musiikkikokoelma.bean.LevyImpl;
import harjoitustyo.musiikkikokoelma.bean.LevyArtisti;
import harjoitustyo.musiikkikokoelma.bean.LevyArtistiImpl;


public class LevyTop10RowMapper implements RowMapper<Levy> {

	public Levy mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Levy levy = new LevyImpl();
		LevyArtisti levyArtisti = new LevyArtistiImpl();
		
		levyArtisti.setNimi(rs.getString("levyArtisti"));

		levy.setId(rs.getInt("id"));
		levy.setOtsikko(rs.getString("otsikko"));
		levy.setLevyArtisti(levyArtisti);
		levy.setArvosana(rs.getInt("arvosana"));

		return levy;
		
	}

}
