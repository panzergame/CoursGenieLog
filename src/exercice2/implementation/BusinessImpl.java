package exercice2.implementation;

import datamocklib.Constants;
import datamocklib.Person;
import exercice2.models.Business;
import exercice2.models.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class BusinessImpl implements Business {

    private Repository repo;

    public BusinessImpl(Repository repo) {
        this.repo = repo;
    }

    @Override

    public List<Person> getPersonsFromCity(String city) {
        List<Person> persons = repo.getPersons();
        return persons.stream().filter(i -> i.getCityOfBirth().equals(city)).collect(Collectors.toList());
    }

    @Override
    public List<Person> getFemales() {
        List<Person> persons = repo.getPersons();
        return persons.stream().filter(i -> i.getGender().equals(Constants.GENDER_FEMALE)).collect(Collectors.toList());
    }

    @Override
    public List<Person> getBoomers() {
        List<Person> persons = repo.getPersons();
        return persons.stream().filter(i -> i.getAge() > 25).collect(Collectors.toList());
    }

    @Override
    public List<Person> getFemaleBoomers() {
        List<Person> persons = repo.getPersons();
        return persons.stream().filter(i -> i.getAge() > 25 && i.getGender().equals(Constants.GENDER_FEMALE)).collect(Collectors.toList());
    }

}
