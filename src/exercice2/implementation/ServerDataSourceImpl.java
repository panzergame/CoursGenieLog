package exercice2.implementation;

import datamocklib.Constants;
import datamocklib.TxtHelper;
import datamocklib.Person;
import exercice2.models.ServerDatasource;
import java.util.List;
import java.util.stream.Collectors;

public class ServerDataSourceImpl implements ServerDatasource {
    @Override
    public List<Person> getDataFromServer() {
        List<String> data = TxtHelper.getDataFromTxt(Constants.SERVERFILE);
        return data.stream().map(this::getPersonFromString).collect(Collectors.toList());
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
