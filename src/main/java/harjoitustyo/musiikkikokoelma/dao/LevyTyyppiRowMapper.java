package harjoitustyo.musiikkikokoelma.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import harjoitustyo.musiikkikokoelma.bean.LevyTyyppi;
import harjoitustyo.musiikkikokoelma.bean.LevyTyyppiImpl;


public class LevyTyyppiRowMapper implements RowMapper<LevyTyyppi> {

	public LevyTyyppi mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		LevyTyyppi levyTyyppi = new LevyTyyppiImpl();
		levyTyyppi.setNimi(rs.getString("nimi"));
		levyTyyppi.setId(rs.getInt("id"));

		return levyTyyppi;
		
	}

}
