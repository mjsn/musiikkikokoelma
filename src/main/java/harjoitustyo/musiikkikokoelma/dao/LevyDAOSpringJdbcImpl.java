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

import harjoitustyo.musiikkikokoelma.bean.Levy;

@Repository
public class LevyDAOSpringJdbcImpl implements LevyDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// levyn lisäys
	public void talletaLevy(Levy levy) {
		final String sql = "INSERT INTO levy(tunnus, otsikko, artistiId, genreId, arvosana, julkaisuVuosi, tyyppiId, levyMaara, levyKunto, kansiKunto, muutaTietoa) VALUES(?,?,?,?,?,?,?,?,?,?,?);";

		final String tunnus = levy.getTunnus();
		final String otsikko = levy.getOtsikko();
		final int artistiId = levy.getLevyArtisti().getId();
		final int genreId = levy.getLevyGenre().getId();
		final int arvosana = levy.getArvosana();
		final String julkaisuVuosi = levy.getJulkaisuVuosi();
		final int tyyppiId = levy.getLevyTyyppi().getId();
		final int levyMaara = levy.getLevyMaara();
		final int levyKunto = levy.getLevyKunto();
		final int kansiKunto = levy.getKansiKunto();
		final String muutaTietoa = levy.getMuutaTietoa();

		KeyHolder idHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
				Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
					ps.setString(1, tunnus);
					ps.setString(2, otsikko);
					ps.setInt(3, artistiId);
					ps.setInt(4, genreId);
					ps.setInt(5, arvosana);
					ps.setString(6, julkaisuVuosi);
					ps.setInt(7, tyyppiId);
					ps.setInt(8, levyMaara);
					ps.setInt(9, levyKunto);
					ps.setInt(10, kansiKunto);
					ps.setString(11, muutaTietoa);
					return ps;
				}
		}, idHolder);

		levy.setId(idHolder.getKey().intValue());

	}
	
	// levyn tietojen muuttaminen
	public void muutaLevy(Levy levy) {
		final String sql = "UPDATE levy SET tunnus=?, otsikko=?, artistiId=?, genreId=?, arvosana=?, julkaisuVuosi=?, tyyppiId=?, levyMaara=?, levyKunto=?, kansiKunto=?, muutaTietoa=?"
				+ " WHERE id = ?";

		final String tunnus = levy.getTunnus();
		final String otsikko = levy.getOtsikko();
		final int artistiId = levy.getLevyArtisti().getId();
		final int genreId = levy.getLevyGenre().getId();
		final int arvosana = levy.getArvosana();
		final String julkaisuVuosi = levy.getJulkaisuVuosi();
		final int tyyppiId = levy.getLevyTyyppi().getId();
		final int levyMaara = levy.getLevyMaara();
		final int levyKunto = levy.getLevyKunto();
		final int kansiKunto = levy.getKansiKunto();
		final String muutaTietoa = levy.getMuutaTietoa();
		final int id = levy.getId();

		KeyHolder idHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
				Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
					ps.setString(1, tunnus);
					ps.setString(2, otsikko);
					ps.setInt(3, artistiId);
					ps.setInt(4, genreId);
					ps.setInt(5, arvosana);
					ps.setString(6, julkaisuVuosi);
					ps.setInt(7, tyyppiId);
					ps.setInt(8, levyMaara);
					ps.setInt(9, levyKunto);
					ps.setInt(10, kansiKunto);
					ps.setString(11, muutaTietoa);
					ps.setInt(12, id);
					return ps;
				}
		}, idHolder);

	}

	// levyn tietojen haku id:n mukaan
	public Levy levynTiedot(int id) {
		String sql = "SELECT l.id, l.tunnus, l.otsikko, a.nimi AS levyArtisti, g.nimi AS levyGenre, l.arvosana, l.julkaisuVuosi, t.nimi AS levyTyyppi, l.levyMaara, l.levyKunto, l.kansiKunto, l.muutaTietoa"
				   + "	FROM levy l"
				   + "		JOIN levyArtisti a"
				   + "			ON a.id = l.artistiId"
				   + "		JOIN levyGenre g"
				   + "			ON g.id = l.genreId"
				   + "		JOIN levyTyyppi t"
				   + "			ON t.id = l.tyyppiId"
				   + " WHERE l.id = ?;";
		Object[] parametrit = new Object[] { id };
		RowMapper<Levy> mapper = new LevyRowMapper();

		Levy levy;
		try {
			levy = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new EiLoydyPoikkeus(e);
		}
		return levy;

	}
	
	// levyn poisto
	public void poistaLevy(int id) {
		String sql = "DELETE FROM levy WHERE id = ?";
		Object[] parametrit = new Object[] { id };

		try {
			jdbcTemplate.update(sql, parametrit);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new EiLoydyPoikkeus(e);
		}

	}
	
	// kaikkien levyjen haku
	public List<Levy> kaikkiLevyt() {

		String sql = "SELECT l.id, l.otsikko, a.nimi AS levyArtisti, l.arvosana, l.julkaisuVuosi, t.nimi AS levyTyyppi"
				   + "	FROM levy l"
				   + "		JOIN levyArtisti a"
				   + "			ON a.id = l.artistiId"
				   + "		JOIN levyTyyppi t"
				   + "			ON t.id = tyyppiId;";
		RowMapper<Levy> mapper = new LevyListaRowMapper();
		List<Levy> levyt = jdbcTemplate.query(sql, mapper);

		return levyt;
	}
	
	// levyjen top 10
	public List<Levy> levytTop10() {

		String sql = "SELECT l.id, l.otsikko, a.nimi AS levyArtisti, l.arvosana"
				   + "	FROM levy l"
				   + "		JOIN levyArtisti a"
				   + "			ON a.id = l.artistiId"
				   + "		ORDER BY l.arvosana DESC"
				   + "		LIMIT 10;";
		RowMapper<Levy> mapper = new LevyTop10RowMapper();
		List<Levy> levyt = jdbcTemplate.query(sql, mapper);

		return levyt;
	}
	

}
