package exercice2.models;

import datamocklib.Person;
import datamocklib.TxtHelper;
import parser.PersonParser;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class PersonModel {public static final String SERVER_FILE = "server.txt";
    public static final String LOCAL_FILE = "local.txt";
    private List<Person> persons;

    public PersonModel() {
        loadPersonsFromServer();
        List<String> localData = TxtHelper.getDataFromTxt(LOCAL_FILE);
        PersonParser parser = new PersonParser();
        this.persons = parser.parse(localData);
    }

    public void loadPersonsFromServer() {
        List<String> serverData = TxtHelper.getDataFromTxt(SERVER_FILE);
        try {
            TxtHelper.clearDataLocal();
            for (String data : serverData) {
                TxtHelper.insertDataInTxt(data, LOCAL_FILE);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Person> getPersonFromChambery() {
        return this.persons.stream().filter(person -> person.getCityOfBirth().equals("Chambery")).collect(Collectors.toList());
    }

    public List<Person> getBoomers() {
        return this.getBoomers(this.persons);
    }

    public List<Person> getBoomers(List<Person> persons) {
        return persons.stream().filter(person -> person.getAge() > 25).collect(Collectors.toList());
    }

    public List<Person> getFemales() {
        return this.persons.stream().filter(person -> person.getGender().equals("female")).collect(Collectors.toList());
    }

    public List<Person> getFemaleBoomers() {
        return this.getBoomers(this.getFemales());
    }
}
