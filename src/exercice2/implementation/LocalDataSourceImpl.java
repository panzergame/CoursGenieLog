package exercice2.implementation;

import datamocklib.Constants;
import datamocklib.TxtHelper;
import datamocklib.Person;
import exercice2.models.LocalDataSource;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class LocalDataSourceImpl implements LocalDataSource {

    @Override
    public List<Person> getDataFromLocal() {
        List<String> data = TxtHelper.getDataFromTxt(Constants.SERVERFILE);
        return data.stream().map(this::getPersonFromString).collect(Collectors.toList());
    }

    @Override
    public void pushDataToLocal(List<Person> data) {
        try {
            TxtHelper.clearDataLocal();
            data.forEach(this::insertPersonInDatabase);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void insertPersonInDatabase(Person person) {
        TxtHelper.insertDataInTxt(getStringFromPerson(person), Constants.LOCALFILE);
    }

    public String getStringFromPerson(Person person) {
        return person.getFirstName() + "," + person.getLastName() + "," + person.getBirthDate() + "," + person.getGender() + "," + person.getCityOfResidence() + "," + person.getCityOfBirth();
    }

    private Person getPersonFromString(String data) {
        var array = data.split(",");
        return new Person(
                array[Constants.FIRST_NAME],
                array[Constants.NAME],
                array[Constants.BIRTH_DATE],
                array[Constants.GENDER],
                array[Constants.CITY_OF_RESIDENCE],
                array[Constants.CITY_OF_BIRTH]
        );
    }
}
