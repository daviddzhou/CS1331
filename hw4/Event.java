//I worked on this project with Daniel Lee, Frankie Kim, and Peter Han
import java.util.Random;

public class Event {
    private Athlete[] competitors;
    private Athlete goldMedalist;
    private Athlete silverMedalist;
    private Athlete bronzeMedalist;
    private boolean eventPlayed;
    private Random injuredProb = new Random();
    private Random comparison = new Random();

    public Event(Athlete[] competitors) {
        this.competitors = competitors;
        eventPlayed = false;
    }

    public boolean injure(double probability) {
        boolean condition = false;
        double match = injuredProb.nextDouble();
        match = Math.round(match * 10.0) / 10.0;
        if (match < probability) {
            condition = true;
        } else {
            condition = false;
        }
        return condition;

    }

    public void play() {
        Random rand = new Random();
        double probability = rand.nextDouble();

        for (Athlete person : competitors) {
            person.setInjured(injure(probability));
        }

        int goldMax = -1;
        int silverMax = -1;
        int bronzeMax = -1;
        for (int i = 0; i < competitors.length; i++) {
            if (!competitors[i].isInjured()) {
                if (competitors[i].getGoldMedals() > goldMax) {
                    goldMax = competitors[i].getGoldMedals();
                    goldMedalist = competitors[i];
                } else if (competitors[i].getGoldMedals() == goldMax) {
                    int randCompare = comparison.nextInt(2);
                    if (randCompare == 0) {
                        continue;
                    } else {
                        goldMax = competitors[i].getGoldMedals();
                        goldMedalist = competitors[i];
                    }
                }
            }
        }

        for (int j = 0; j < competitors.length; j++) {
            if (!competitors[j].isInjured()) {
                if ((competitors[j].getSilverMedals() > silverMax)
                    && (competitors[j] != goldMedalist)) {
                    silverMax = competitors[j].getSilverMedals();
                    silverMedalist = competitors[j];
                } else if (competitors[j].getSilverMedals() == silverMax) {
                    int randCompare = comparison.nextInt(2);
                    if (randCompare == 0) {
                        continue;
                    } else if ((randCompare == 1)
                        && (competitors[j] != goldMedalist)) {
                        silverMax = competitors[j].getSilverMedals();
                        silverMedalist = competitors[j];
                    }
                }
            }
        }

        for (int k = 0; k < competitors.length; k++) {
            if (!competitors[k].isInjured()) {
                if ((competitors[k].getBronzeMedals() > bronzeMax)
                    && (competitors[k] != goldMedalist)
                    && (competitors[k] != silverMedalist)) {
                    bronzeMax = competitors[k].getBronzeMedals();
                    bronzeMedalist = competitors[k];
                } else if (competitors[k].getBronzeMedals() == bronzeMax) {
                    int randCompare = comparison.nextInt(2);
                    if (randCompare == 0) {
                        continue;
                    } else if ((randCompare == 1)
                        && (competitors[k] != goldMedalist)
                        && (competitors[k] != silverMedalist)) {
                        silverMax = competitors[k].getBronzeMedals();
                        silverMedalist = competitors[k];
                    }
                }
            }
        }
        if (goldMedalist != null) {
            goldMedalist.winGoldMedal();
        }
        if (silverMedalist != null) {
            silverMedalist.winSilverMedal();
        }
        if (bronzeMedalist != null) {
            bronzeMedalist.winBronzeMedal();
        }

        eventPlayed = true;
    }

    public String getGoldMedalist() {
        if (goldMedalist != null) {
            return goldMedalist.getName() + " - " + goldMedalist.getCountry();
        } else {
            return "NONE - N/A";
        }
    }

    public String getSilverMedalist() {
        if (silverMedalist != null) {
            return silverMedalist.getName() + " - "
                + silverMedalist.getCountry();
        } else {
            return "NONE - N/A";
        }
    }

    public String getBronzeMedalist() {
        if (bronzeMedalist != null) {
            return bronzeMedalist.getName() + " - "
                + bronzeMedalist.getCountry();
        } else {
            return "NONE - N/A";
        }
    }

/*    public static void main(String[] args) {
        Sport l = Sport.LUGE;
        Athlete chris = new Athlete("Chris Mazdzer", "USA", l, 2, 6, 0);
        Athlete david = new Athlete("David Gleirscher", "AUT", l, 6, 9, 3);
        Athlete felix = new Athlete("Felix Loch", "GER", l, 5, 4, 2);
        Athlete dominik = new Athlete("Dominik Fischnaller", "ITA", l);
        Athlete johannes = new Athlete("Johannes Ludwig", "GER", l, 3, 3, 3);
        Athlete[] lugers = {chris, david, felix, dominik, johannes};
        Event mensSingles2018 = new Event(lugers);
        mensSingles2018.play();
        for (Athlete dude : lugers) {
            if (dude.isInjured()) {
                System.out.println(dude.getName() + " was injured.");
            }

        }
        System.out.println("Gold Medal: "
            + mensSingles2018.getGoldMedalist());
        System.out.println("Silver Medal: "
            + mensSingles2018.getSilverMedalist());
        System.out.println("Bronze Medal: "
            + mensSingles2018.getBronzeMedalist());
    }
*/
}
