/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 02 - PlanetQuest Class
 */

public class PlanetQuest {

    private ArrayList planets;
    private Planet current;
    private double MAX_DISTANCE = 1000;

    public PlanetQuest(Planet current) {
        planets = new ArrayList();
        this.current = current;
    }

    public PlanetQuest() {
        this(new Planet());
    }

    // TODOd: only add a new destination if distance from current planet to the given one is <= MAX_DISTANCE
    //pq.addPlanet(planet);

    public void addPlanet(Planet planet) {
        if (planet.distance(current) <= MAX_DISTANCE){
            planets.add(planet);
        }
    }

    // TODOd: return the closest planet from current
    public Planet closest() {
        double distance = planets.get(0).distance(current);
        int index = 0;
        for (int i = 0 ; i < planets.size() ; i++){
            if (planets.get(i).distance(current) <= distance){
            distance = planets.get(i).distance(current);
            index = i;
        }  
            
        }return planets.get(index);
    }

    // TODOd: return the farthest planet from current
    public Planet farthest() {
        double distance = planets.get(0).distance(current);
        int index = 0;
        for (int i = 0 ; i < planets.size() ; i++){
            if (planets.get(i).distance(current) >= distance){
            distance = planets.get(i).distance(current);
            index = i;
        }  
            
        }return planets.get(index);
    }

    @Override
    public String toString() {
        String str = planets.toString();
        str += "\nClosest: " + closest();
        str += "\nFarthest: " + farthest();
        return str;
    }
}
