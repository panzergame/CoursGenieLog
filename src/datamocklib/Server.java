package datamocklib;
import java.util.List;

import static datamocklib.TxtHelper.getDataFromTxt;
import static datamocklib.TxtHelper.insertDataInTxt;

public class Server {
    private final String SERVER = "server.txt";

    public int sendDataToServer(String data) {
        return insertDataInTxt(data, SERVER);
    }

    public List<String> getDataFromServer() {
        return getDataFromTxt(SERVER);
    }


}
