//I worked on this project with Daniel Lee, Frankie Kim, and Peter Han
public class Athlete {
    private String name;
    private String country;
    private Sport sport;
    private int goldMedals;
    private int silverMedals;
    private int bronzeMedals;
    private int totalMedals;
    private boolean injured;

    public Athlete(String n, String c, Sport s,
        int gold, int silver, int bronze) {
        name = n;
        country = c;
        sport = s;
        goldMedals = gold;
        silverMedals = silver;
        bronzeMedals = bronze;
    }

    public Athlete(String n, String c, Sport s) {
        this(n, c, s, 0, 0, 0);
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Sport getSport() {
        return sport;
    }

    public int getGoldMedals() {
        return goldMedals;
    }

    public int getSilverMedals() {
        return silverMedals;
    }

    public int getBronzeMedals() {
        return bronzeMedals;
    }

    public boolean isInjured() {
        return injured;
    }

    public boolean setInjured(boolean inj) {
        injured = inj;
        return injured;
    }

    public void winGoldMedal() {
        goldMedals++;
    }

    public void winSilverMedal() {
        silverMedals++;
    }

    public void winBronzeMedal() {
        bronzeMedals++;
    }

    public int getTotalMedals() {
        totalMedals = goldMedals + silverMedals + bronzeMedals;
        return totalMedals;
    }
}
