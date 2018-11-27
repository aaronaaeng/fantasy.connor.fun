package fun.connor.fantasy.Athlete;

/**
 * The AthleteName class encapsulates the first and last name of the athlete.
 * @author Aaron Aaeng
 * @version 1.0
 */
public class AthleteName {
    private final String firstName;
    private final String lastName;

    /**
     * The constructor takes in the first and last name of the athlete.
     * @param firstName The first name of the athlete
     * @param lastName The last name of the athlete
     */
    public AthleteName(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the athlete's name as a single string
     * @return The athlete's name as a single string
     */
    public String getAthleteName()
    {
        return this.firstName + " " + this.lastName;
    }
}
