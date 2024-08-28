import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(Statistics.getTeams());
        System.out.println(Statistics.getTeamsWithMembers());
        System.out.println(Statistics.getTeamMembers("BAHRAIN VICTORIOUS"));
    }
}
