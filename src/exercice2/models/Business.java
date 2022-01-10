package exercice2.models;

import datamocklib.Person;

import java.util.List;

public interface Business {

    List<Person> getPersonsFromCity(String chambery);

    List<Person> getFemales();

    List<Person> getBoomers();

    List<Person> getFemaleBoomers();
}
