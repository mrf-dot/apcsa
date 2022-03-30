import java.util.ArrayList;

public class RoadTrip {
	private ArrayList<CityData> stops;

	public RoadTrip(CityData city) {
		stops = new ArrayList<CityData>();
		stops.add(city);
	}

	public void addStop(CityData city) {
		stops.add(city);
	}

	public void removeStop(int i) {
		stops.remove(i);
	}

	public int getNumStops() {
		return stops.size();
	}

	public void switchStops(int i1, int i2) {
		CityData tmp = stops.get(i1);
		stops.set(i1, stops.get(i2));
		stops.set(i2, tmp);
	}

	public double getTripLength() {
		double length = 0;
		CityData city;
		CityData nextCity;
		for (int i = 0; i < stops.size() - 1; i++) {
			city = stops.get(i);
			nextCity = stops.get(i + 1);
			length += city.distanceFrom(nextCity);
		}
		return length;
	}

	public String toString() {
		CityData city = stops.get(0);
		String print = String.format("ITINERARY%n1: %s, (%.4f, %.4f)%n",
				city.getName(), city.latitude, city.longitude);
		CityData prevCity;
		for (int i = 1; i < stops.size(); i++) {
			prevCity = stops.get(i - 1);
			city = stops.get(i);
			print += String.format("%d: %s (%.4f, %.4f), Distance from %s: %f%n",
					i + 1, city.getName(), city.latitude, city.longitude, prevCity.getName(),
					city.distanceFrom(prevCity));
		}
		return print;
	}
}
