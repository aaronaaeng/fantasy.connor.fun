package fun.connor.fantasy.Database;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.MongoClient;
import fun.connor.fantasy.Athlete.Athlete;
import fun.connor.fantasy.Statistics.BowlerStatistics;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.UUID;

public class DatabaseAccessObject {
    private final Morphia morphia = new Morphia();
    private final Gson gson = new Gson();
    private final Datastore dataStore = morphia.createDatastore(new MongoClient(), "fantasy_database");

    public DatabaseAccessObject()
    {
        morphia.mapPackage("fun.connor.fantasy");
        dataStore.ensureIndexes();
    }

    public <T> T loadAthlete(UUID athleteID)
    {
        T athlete = gson.fromJson("test", new TypeToken<Athlete<BowlerStatistics>>(){}.getType());
        return athlete;
    }

    public void saveAthlete(Athlete<BowlerStatistics> athlete)
    {
        dataStore.save(athlete);
    }
}
