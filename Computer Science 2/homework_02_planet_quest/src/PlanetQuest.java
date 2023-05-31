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

    // TODO: only add a new destination if distance from current planet to the given one is <= MAX_DISTANCE
    public void addPlanet(Planet planet) {

    }

    // TODO: return the closest planet from current
    public Planet closest() {
        return null;
    }

    // TODO: return the farthest planet from current
    public Planet farthest() {
        return null;
    }

    @Override
    public String toString() {
        String str = planets.toString();
        str += "\nClosest: " + closest();
        str += "\nFarthest: " + farthest();
        return str;
    }
}
