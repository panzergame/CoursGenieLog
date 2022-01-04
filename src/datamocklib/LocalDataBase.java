package datamocklib;

import java.util.List;

import static datamocklib.TxtHelper.getDataFromTxt;
import static datamocklib.TxtHelper.insertDataInTxt;

public class LocalDataBase {
    private final String LOCAL = "local.txt";

    public int resetData() {
        return 200;
    }

    public int sendDataToLocal(String data) {
        return insertDataInTxt(data, LOCAL);
    }

    public List<String> getDataFromLocal() {
        return getDataFromTxt(LOCAL);
    }

}
