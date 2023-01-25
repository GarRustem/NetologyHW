import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientLog {
    List<String[]> logFromBasket = new ArrayList<>();

    public void log(int productNum, int amount) {
        logFromBasket.add((productNum + "," + amount).split(","));
    }

    public void exportAsCSV(File file) {
        try (CSVWriter csvFileToWrite = new CSVWriter(new FileWriter(file, true))) {
            csvFileToWrite.writeAll(logFromBasket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
