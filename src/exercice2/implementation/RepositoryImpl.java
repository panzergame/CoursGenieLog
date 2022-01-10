package exercice2.implementation;

import datamocklib.Person;
import exercice2.models.LocalDataSource;
import exercice2.models.Repository;
import exercice2.models.ServerDatasource;

import java.util.List;

public class RepositoryImpl implements Repository {

    private LocalDataSource localDataSource;
    private ServerDatasource serverDatasource;

    public RepositoryImpl(LocalDataSource localDataSource, ServerDatasource serverDatasource) {
        this.localDataSource = localDataSource;
        this.serverDatasource = serverDatasource;
    }

    @Override
    public List<Person> getPersons() {
        localDataSource.pushDataToLocal(serverDatasource.getDataFromServer());
        return localDataSource.getDataFromLocal();
    }
}
