package dao;
import javax.validation.constraints.Min;

public class Planet {

	@Min(value = 0, message="Must be value of 0 or above.")
	private Integer ID;
	private String Name;
	@Min(value = 0, message="Must be value of 0 or above.")
	private Double Mass;
	@Min(value = 0, message="Must be value of 0 or above.")
	private Double Radius;
	@Min(value = 0, message="Must be value of 0 or above.")
	private Double Period;
	@Min(value = 0, message="Must be value of 0 or above.")
	private Integer Year;
	@Min(value = 0, message="Must be value of 0 or above.")
	private Double StarDistance;
	
	public Planet() {
		//default constructor
	}


	public Planet(Integer iD, String name, Double mass, Double radius, Double period, Integer year,
			Double starDistance) {
		ID = iD;
		Name = name;
		Mass = mass;
		Radius = radius;
		Period = period;
		Year = year;
		StarDistance = starDistance;
	}




	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Double getMass() {
		return Mass;
	}

	public void setMass(Double mass) {
		Mass = mass;
	}

	public Double getRadius() {
		return Radius;
	}

	public void setRadius(Double radius) {
		Radius = radius;
	}

	public Double getPeriod() {
		return Period;
	}

	public void setPeriod(Double period) {
		Period = period;
	}

	public Integer getYear() {
		return Year;
	}

	public void setYear(Integer year) {
		Year = year;
	}

	public Double getStarDistance() {
		return StarDistance;
	}

	public void setStarDistance(Double starDistance) {
		StarDistance = starDistance;
	}

	@Override
	public String toString() {
		return "Planet [ID=" + ID + ", Name=" + Name + ", Mass=" + Mass + ", Radius=" + Radius + ", Period=" + Period
				+ ", Year=" + Year + ", StarDistance=" + StarDistance + "]";
	}

	

	

}
