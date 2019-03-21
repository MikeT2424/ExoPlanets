package service;
import java.util.Comparator;
import java.util.List;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.Planet;
import dao.PlanetDAO;

@Service("PlanetService")
public class PlanetService {

	PlanetDAO planetdao;
	
	@Autowired
	public void setPlanetdao(PlanetDAO planetdao) {
		this.planetdao = planetdao;
	}

	// Select a single planet
	public Planet selectPlanet(int id) {
		return planetdao.getPlanet(id);
	}

	public List<Planet> selectPlanetList(@Min(5) double from, @Min(5) double to, String searchType) {
		return planetdao.getPlanetList(from, to, searchType);
	}
	
	public List<Planet> sortPlanets(List<Planet> planetList, String sort) {

		System.out.println("called PlanetService.sortPlanets sort= " + sort);

		return planetdao.sortPlanets(planetList, sort);
	}
}
