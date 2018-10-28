package harjoitustyo.musiikkikokoelma.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import harjoitustyo.musiikkikokoelma.bean.LevyGenre;
import harjoitustyo.musiikkikokoelma.bean.LevyGenreImpl;


public class LevyGenreRowMapper implements RowMapper<LevyGenre> {

	public LevyGenre mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		LevyGenre levyGenre = new LevyGenreImpl();
		levyGenre.setNimi(rs.getString("nimi"));
		levyGenre.setId(rs.getInt("id"));

		return levyGenre;
		
	}

}
