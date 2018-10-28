package harjoitustyo.musiikkikokoelma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import harjoitustyo.musiikkikokoelma.bean.LevyArtisti;

@Repository
public class LevyArtistiDAOSpringJdbcImpl implements LevyArtistiDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// levyartistin lisäys
	public void talletaLevyArtisti(LevyArtisti artisti) {
		final String sql = "INSERT INTO levyArtisti(nimi) VALUES(?);";

		final String nimi = artisti.getNimi();

		KeyHolder idHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
				Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
					ps.setString(1, nimi);
					return ps;
				}
		}, idHolder);

		artisti.setId(idHolder.getKey().intValue());

	}

	// kaikkien levyartistien haku
	public List<LevyArtisti> kaikkiLevyArtistit() {

		String sql = "SELECT a.id, a.nimi, COUNT(*) as levyMaara" 
				   +" FROM levyArtisti a"
				   +" JOIN levy l" 
				   +" ON l.artistiId = a.id"
				   +" GROUP BY a.id;";
		RowMapper<LevyArtisti> mapper = new LevyArtistiListaRowMapper();
		List<LevyArtisti> levyArtistit = jdbcTemplate.query(sql, mapper);

		return levyArtistit;
	}
	
	// levyartistin tietojen haku id:n mukaan
	public LevyArtisti levyArtistinTiedot(int id) {
		String sql = "SELECT id, nimi"
				   + "	FROM levyArtisti"
				   + " WHERE id = ?;";
		Object[] parametrit = new Object[] { id };
		RowMapper<LevyArtisti> mapper = new LevyArtistiRowMapper();

		LevyArtisti levyArtisti;
		try {
			levyArtisti = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new EiLoydyPoikkeus(e);
		}
		return levyArtisti;

	}
	
	// levyartistin tietojen haku nimen mukaan
	public LevyArtisti levyArtistinTiedotNimenMukaan(String nimi) {
		String sql = "SELECT id, nimi"
				   + "	FROM levyArtisti"
				   + " WHERE nimi = ?;";
		Object[] parametrit = new Object[] { nimi };
		RowMapper<LevyArtisti> mapper = new LevyArtistiRowMapper();

		LevyArtisti levyArtisti;
		try {
			levyArtisti = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new EiLoydyPoikkeus(e);
		}
		return levyArtisti;

	}
	
	// levyartistin olemassaolon tarkistus
	public boolean onkoLevyArtistia(String nimi) {

		String sql = "SELECT id, nimi"
				   + "	FROM levyArtisti"
				   + " WHERE nimi = ?;";
		Object[] parametrit = new Object[] { nimi };
		RowMapper<LevyArtisti> mapper = new LevyArtistiRowMapper();

		try {
			jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			return false;
		}
		return true;

	}
	

}
