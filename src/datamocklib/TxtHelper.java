package datamocklib;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtHelper {
    /**
    public static List<String> getDataFromTxt(String file) {
        List<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * Insert a line of data at the end of a txt file
     * @param data the line of data you want to add in the file
     * @param file the file you want to store the data in
     * @return 200 if the operation succeed, 400 if it fails
     */
    public static int insertDataInTxt(String data, String file) {
        try {
            Writer output = new BufferedWriter(new FileWriter(file, true));
            output.append("\n").append(data);
            output.close();
            return 200;
        } catch (IOException e) {
            e.printStackTrace();
            return 400;
        }
    }
}
