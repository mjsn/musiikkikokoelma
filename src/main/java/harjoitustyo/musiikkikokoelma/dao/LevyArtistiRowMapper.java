package harjoitustyo.musiikkikokoelma.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import harjoitustyo.musiikkikokoelma.bean.LevyArtisti;
import harjoitustyo.musiikkikokoelma.bean.LevyArtistiImpl;


public class LevyArtistiRowMapper implements RowMapper<LevyArtisti> {

	public LevyArtisti mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		LevyArtisti levyArtisti = new LevyArtistiImpl();
		levyArtisti.setNimi(rs.getString("nimi"));
		levyArtisti.setId(rs.getInt("id"));
		

		return levyArtisti;
		
	}

}
