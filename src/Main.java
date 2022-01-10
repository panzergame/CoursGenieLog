import datamocklib.Server;

import java.util.*;

import datamocklib.exo1.Person;
import datamocklib.exo1.PersonParser;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        List<String> resultStringBefore = server.getDataFromServer();
        int result = server.sendDataToServer("Kristan Kelapierre");
        List<String> resultString = server.getDataFromServer();



        // EXO 1

        /*
         * Parser la liste des Personnes (fonction parse() dans PersonParser)
         * Calculer la population totale par ville avec les données obtenues.
         * (Les données contiennent une trentaine de villes)
        */ 

    }
}
