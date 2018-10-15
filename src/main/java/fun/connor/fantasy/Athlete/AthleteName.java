package fun.connor.fantasy.Athlete;

public class AthleteName {
    private final String firstName;
    private final String lastName;

    AthleteName(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getAthleteName()
    {
        return this.firstName + " " + this.lastName;
    }
}
