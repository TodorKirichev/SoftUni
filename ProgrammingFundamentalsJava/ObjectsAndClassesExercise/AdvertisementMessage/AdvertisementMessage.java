package ObjectsAndClassesExercise.AdvertisementMessage;

import java.util.Random;

public class AdvertisementMessage {
    private String[] Phrases = {"Excellent product.",
            "Such a great product.",
            "I always use that product.",
            "Best product of its category.",
            "Exceptional product.",
            "I can’t live without this product."};
    private String[] Events = {"Now I feel good.",
            "I have succeeded with this product.",
            "Makes miracles. I am happy of the results!",
            "I cannot believe but now I feel awesome.",
            "Try it yourself, I am very satisfied.",
            "I feel great!"};
    private String[] Authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
    private String[] Cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

    private Random rnd = new Random();

    public void randomMessage () {
        System.out.printf("%s %s %s - %s%n"
                ,Phrases[rnd.nextInt(Phrases.length)],
                Events[rnd.nextInt(Events.length)],
                Authors[rnd.nextInt(Authors.length)],
                Cities[rnd.nextInt(Cities.length)]);
    }
}
