import datamocklib.Server;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        List<String> resultStringBefore = server.getDataFromServer();
        int result = server.sendDataToServer("Kristan Kelapierre");
        List<String> resultString = server.getDataFromServer();

        System.out.println(resultStringBefore);
        System.out.println(result);
        System.out.println(resultString);
    }
}
