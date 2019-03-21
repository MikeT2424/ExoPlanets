package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
//This class has the RowMapper interface which was made to organize database data to a Java class.
public class PlanetRowMapper implements RowMapper<Planet>{

	@Override
	public Planet mapRow(ResultSet rs, int rowNum) throws SQLException {
		Planet planet = new Planet();
		
		//The setter for every Planet field gets data from the ResultSet rs.
		planet.setID(rs.getInt("ID"));
		planet.setName(rs.getString("name"));
		planet.setMass(rs.getDouble("mass"));
		planet.setRadius(rs.getDouble("radius"));
		planet.setPeriod(rs.getDouble("period"));
		planet.setYear(rs.getInt("year"));
		planet.setStarDistance(rs.getDouble("star_distance"));
		
		return planet;
	}
}
