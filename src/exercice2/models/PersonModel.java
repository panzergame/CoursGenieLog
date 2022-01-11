package exercice2.models;

import datamocklib.Person;
import datamocklib.TxtHelper;
import parser.PersonParser;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class PersonModel {
    public static final String SERVER_FILE = "server.txt";


    public List<Person> loadPersonsFromServer() {
        PersonParser parser = new PersonParser();
        return parser.parse(TxtHelper.getDataFromTxt(SERVER_FILE));
    }

    public List<Person> getPersonFromChambery() {
        return this.loadPersonsFromServer().stream().filter(person -> person.getCityOfBirth().equals("Chambery")).collect(Collectors.toList());
    }

    public List<Person> getBoomers() {
        return this.getBoomers(this.loadPersonsFromServer());
    }

    public List<Person> getBoomers(List<Person> persons) {
        return persons.stream().filter(person -> person.getAge() > 25).collect(Collectors.toList());
    }

    public List<Person> getFemales() {
        return this.loadPersonsFromServer().stream().filter(person -> person.getGender().equals("female")).collect(Collectors.toList());
    }

    public List<Person> getFemaleBoomers() {
        return this.getBoomers(this.getFemales());
    }
}
