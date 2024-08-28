import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TDFFileReader {
    File file;
    Scanner scanner;

    public TDFFileReader(String fileName) throws FileNotFoundException {
//        String fileName = "tdffinishers2024.csv";
        this.file = new File(fileName);
        scanner = new Scanner(file);
    }
    public List<Cyclist> readFile(){
        List<Cyclist> cyclistList = new ArrayList<>();
        while (scanner.hasNext()){
            Cyclist c = new Cyclist();
            String cyclistLine = scanner.nextLine();
            String[] cyclistArray = cyclistLine.split(";");
            c.name = cyclistArray[1];
            c.team = cyclistArray[2];
            cyclistList.add(c);
        }

        return cyclistList;
    }
}
