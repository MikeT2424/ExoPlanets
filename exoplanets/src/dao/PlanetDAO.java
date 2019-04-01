package dao;

import java.util.Comparator;
import java.util.List;
import javax.sql.DataSource;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("PlanetDAO")
public class PlanetDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
		System.out.println("system is ready for connections via JDBC source.");
	}

	public Planet getPlanet(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from allplanets where ID=:id", params, new PlanetRowMapper());
	}

	public List<Planet> getPlanetList(@Min(5) double from, @Min(5) double to, String searchType) {

		System.out.println(
				"passed values to PlanetDAO.getPlanetList: to: " + to + " from " + from + " searchType: " + searchType);

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("from", from);
		paramSource.addValue("to", to);

		System.out.println(searchType.toString());

		if (searchType.equals("mass")) {
			return jdbc.query("SELECT * FROM allplanets where mass >=:from and mass <=:to", paramSource,
					new PlanetRowMapper());
		} else if (searchType.equals("radius")) {
			return jdbc.query("SELECT * FROM allplanets where radius >=:from and radius <=:to", paramSource,
					new PlanetRowMapper());
		}
		if (searchType.equals("period")) {
			return jdbc.query("SELECT * FROM allplanets where period >=:from and period <=:to", paramSource,
					new PlanetRowMapper());
		}
		if (searchType.equals("year")) {
			return jdbc.query("SELECT * FROM allplanets where year >=:from and year <=:to", paramSource,
					new PlanetRowMapper());
		}
		if (searchType.equals("star_distance")) {
			return jdbc.query("SELECT * FROM allplanets where star_distance >=:from and star_distance <=:to",
					paramSource, new PlanetRowMapper());
		} else if (searchType.equals("default")) {
			return jdbc.query("SELECT * FROM allplanets where ID >=:from and ID <=:to", paramSource,
					new PlanetRowMapper());
		}

		else
			return jdbc.query("Select * from allplanets", paramSource, new PlanetRowMapper());
	}

	public List<Planet> sortPlanets(List<Planet> planetList, String sort) {

		System.out.println("called PlanetDAO.sortPlanets sort= " + sort);

		switch (sort) {
		case "sortIDa":
			planetList.sort(Comparator.comparing(Planet::getID));
			break;
		case "sortIDr":
			planetList.sort(Comparator.comparing(Planet::getID).reversed());
			break;
		case "sortNameAsc":
			planetList.sort(Comparator.comparing(Planet::getName));
			break;
		case "sortNameDesc":
			planetList.sort(Comparator.comparing(Planet::getName).reversed());
			break;
		case "sortMassAsc":
			planetList.sort(Comparator.comparing(Planet::getMass));
			break;
		case "sortMassDesc":
			planetList.sort(Comparator.comparing(Planet::getMass).reversed());
			break;
		case "sortRadiusAsc":
			planetList.sort(Comparator.comparing(Planet::getRadius));
			break;
		case "sortRadiusDesc":
			planetList.sort(Comparator.comparing(Planet::getRadius).reversed());
			break;
		case "sortPeriodAsc":
			planetList.sort(Comparator.comparing(Planet::getPeriod));
			break;
		case "sortPeriodDesc":
			planetList.sort(Comparator.comparing(Planet::getPeriod).reversed());
			break;
		case "sortYearAsc":
			planetList.sort(Comparator.comparing(Planet::getYear));
			break;
		case "sortYearDesc":
			planetList.sort(Comparator.comparing(Planet::getYear).reversed());
			break;
		case "sortDistanceAsc":
			planetList.sort(Comparator.comparing(Planet::getStarDistance));
			break;
		case "sortDistanceDesc":
			planetList.sort(Comparator.comparing(Planet::getStarDistance).reversed());
			break;
		}
		return planetList;
	}
}
