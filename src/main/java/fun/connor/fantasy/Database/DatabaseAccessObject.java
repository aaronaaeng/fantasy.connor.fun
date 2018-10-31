package fun.connor.fantasy.Database;

import com.google.gson.Gson;
//import com.mongodb.MongoClient;
import fun.connor.fantasy.Athlete.Athlete;
import fun.connor.fantasy.Statistics.BowlerStatistics;
//import org.mongodb.morphia.Datastore;
//import org.mongodb.morphia.Morphia;

import java.util.UUID;

public class DatabaseAccessObject {
//    private final Morphia morphia = new Morphia();
    private final Gson gson = new Gson();
//    private final Datastore dataStore = morphia.createDatastore(new MongoClient(), "fantasy_database");

    public DatabaseAccessObject()
    {
//        morphia.mapPackage("fun.connor.fantasy");
//        dataStore.ensureIndexes();
    }

    public Athlete loadAthlete(UUID athleteID)
    {
//        Athlete athlete = gson.fromJson("test", Athlete.class);
        return null;
    }

    public void saveAthlete(Athlete athlete) {
//    };dataStore.save(athlete);
    }
}
