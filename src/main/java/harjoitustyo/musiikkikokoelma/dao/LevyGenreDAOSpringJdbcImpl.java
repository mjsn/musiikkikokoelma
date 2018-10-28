package harjoitustyo.musiikkikokoelma.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import harjoitustyo.musiikkikokoelma.bean.LevyGenre;

@Repository
public class LevyGenreDAOSpringJdbcImpl implements LevyGenreDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// kaikki levygenret
	public List<LevyGenre> kaikkiGenret() {

		String sql = "SELECT id, nimi"
				   + " FROM levyGenre;";
		RowMapper<LevyGenre> mapper = new LevyGenreRowMapper();
		List<LevyGenre> genret = jdbcTemplate.query(sql, mapper);

		return genret;
	}
	
	// levygenren tiedot id:n mukaan
	public LevyGenre levyGenrenTiedot(int id) {
		String sql = "SELECT id, nimi"
				   + "	FROM levyGenre"
				   + " WHERE id = ?;";
		Object[] parametrit = new Object[] { id };
		RowMapper<LevyGenre> mapper = new LevyGenreRowMapper();

		LevyGenre levyGenre;
		try {
			levyGenre = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new EiLoydyPoikkeus(e);
		}
		return levyGenre;

	}
	

}
