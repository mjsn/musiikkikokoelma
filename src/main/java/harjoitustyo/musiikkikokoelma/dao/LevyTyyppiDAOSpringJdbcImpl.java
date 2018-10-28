package harjoitustyo.musiikkikokoelma.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import harjoitustyo.musiikkikokoelma.bean.LevyTyyppi;

@Repository
public class LevyTyyppiDAOSpringJdbcImpl implements LevyTyyppiDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// kaikkien levytyyppien haku
	public List<LevyTyyppi> kaikkiTyypit() {

		String sql = "SELECT id, nimi"
				   + " FROM levyTyyppi;";
		RowMapper<LevyTyyppi> mapper = new LevyTyyppiRowMapper();
		List<LevyTyyppi> tyypit = jdbcTemplate.query(sql, mapper);

		return tyypit;
	}
	
	// levytyypin tietojen haku id:n mukaan
	public LevyTyyppi levyTyypinTiedot(int id) {
		String sql = "SELECT id, nimi"
				   + "	FROM levyTyyppi"
				   + " WHERE id = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<LevyTyyppi> mapper = new LevyTyyppiRowMapper();

		LevyTyyppi levyTyyppi;
		try {
			levyTyyppi = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new EiLoydyPoikkeus(e);
		}
		return levyTyyppi;

	}
	

}
