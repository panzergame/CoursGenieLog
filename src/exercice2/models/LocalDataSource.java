package exercice2.models;

import datamocklib.Person;

import java.util.List;

public interface LocalDataSource {
    List<Person> getDataFromLocal();
    void pushDataToLocal(List<Person> data);
}
