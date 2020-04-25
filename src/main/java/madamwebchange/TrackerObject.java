package madamwebchange;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TrackerObject {
    List<String> properties = new ArrayList<>();
    public String link = "";
    public String frequency = "";
    public String email = "";

    public TrackerObject() throws IOException {
        properties = Files.readAllLines(Paths.get("properties.txt"));
        this.link = properties.get(0);
        this.frequency = properties.get(1);
        this.email = properties.get(2);
    }

}
