package exercice1;

import datamocklib.Person;
import datamocklib.TxtHelper;
import parser.PersonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainExercice1 {
    public static Map<String, Integer> countPersonPerCities(List<Person> persons) {
        HashMap<String, Integer> countPerCities = new HashMap<>();
        for (Person person : persons) {
            String cityOfBirth = person.getCityOfBirth();
            int count = countPerCities.getOrDefault(cityOfBirth, 0);
            countPerCities.put(cityOfBirth, count + 1);
        }

        return countPerCities;
    }

    public static void main(String[] args) {
        // EXO 1
        /*
         * - Récuperez la liste des personnes sous la forme -> firstName,lastName,birthDate,gender,cityOfResidence,cityOfBirth
         *   grâce à la fonction TxtHelper.getDataFromTxt("persons.txt")
         * - Parser la liste des Personnes grâce à la fonction parse())
         * - Calculer le nombre de personnes nées dans chaque ville avec les données obtenues.
         * Les données contiennent une trentaine de villes, Bonne chance !
        */

        String fileName = args[0];
        List<String> fileData = TxtHelper.getDataFromTxt(fileName);
        PersonParser parser = new PersonParser();
        List<Person> persons = parser.parse(fileData);
        Map<String, Integer> countPerCities = countPersonPerCities(persons);
        countPerCities.forEach((city, count) -> System.out.println(city + ":" + count));
    }
}
