import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {
    static TDFFileReader TDF;

    static {
        try {
            TDF = new TDFFileReader("tdffinishers2024.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Statistics() throws FileNotFoundException {
    }

    public static Set<String> getTeams(){
        // som returnerer en samling af hold
        Set<String> teams = new HashSet<String>();
        List<Cyclist> dat = TDF.readFile();
        for (Cyclist rider : dat) {
            teams.add(rider.team);
        }
        return teams;
    }

    public static Map<String, List<String>> getTeamsWithMembers() throws FileNotFoundException {
        // som returnerer en samling af alle hold sammen parrede med deres medlemmer.
        TDFFileReader TDF2 = new TDFFileReader("tdffinishers2024.csv");
        Map<String, List<String>> teamsWithRiders = new HashMap<>();
        List<Cyclist> dat = TDF2.readFile();

        for (Cyclist rider : dat) {
            if (!teamsWithRiders.containsKey(rider.team)) {
                teamsWithRiders.put(rider.team, new ArrayList<>());
            }
            teamsWithRiders.get(rider.team).add(rider.name);
        }
        return teamsWithRiders;
    }

    public static Set<String> getTeamMembers(String team) throws FileNotFoundException {
        // som returnerer en samling af navnene på cyklisterne på holdet.

        Set<String> teamMembers = new HashSet<>();
        TDFFileReader TDF3 = new TDFFileReader("tdffinishers2024.csv");
        List<Cyclist> dat = TDF3.readFile();
        for (Cyclist rider : dat) {
            if (rider.team.equals(team)) {
                teamMembers.add(rider.name);
            }
        }
        return teamMembers;
    }
}
