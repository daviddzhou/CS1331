import java.util.Scanner;
import java.util.LinkedList;




public class PlanetarySystem {
	

    private String name;
    private Star star = null;
    private LinkedList<Planet> planets = new LinkedList<>();

    public void printSystem() {
        System.out.println();

        System.out.println(this.name + "'s current status: ");
        System.out.println(" ⦾ " + star.toString());
        for (Planet p : planets) {
            System.out.println(" ⦿ " + p.toString());
        }

        System.out.println();
    }

    public void setName(String name) {
    	this.name = name;
    }

    
    public void addPlanet(Planet planet) {
        this.planets.add(planet);
    }

    public void listPlanets() {
    	int i = 0;
    	for (Planet p : planets) {
            System.out.println(i + ". " + p.getName());
            i++;
        }
    }

    public Planet getPlanetAtIndex(int index) {
    	return planets.get(index);
    }

    public void changeStar(Star newStar, Scanner input) {
        if (newStar.getColor() == Color.RED) {
            System.out.println("Are you sure you want to lose your planets? 1. Yes 2. No");
            if (input.nextInt() == 2) {
                System.out.println("Ok. Keeping the previous star.");
                return;
            } else {
                this.planets.clear();
            }
        }
        this.star = newStar;
    }

}