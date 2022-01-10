package exercice2.models;

import datamocklib.Person;

import java.util.List;

public interface ServerDatasource {
    List<Person> getDataFromServer();
}
