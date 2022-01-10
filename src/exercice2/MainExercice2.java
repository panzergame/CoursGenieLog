package exercice2;

import datamocklib.Constants;
import exercice2.implementation.BusinessImpl;
import exercice2.implementation.LocalDataSourceImpl;
import exercice2.implementation.RepositoryImpl;
import exercice2.implementation.ServerDataSourceImpl;
import exercice2.models.*;

public class MainExercice2 implements Exo2 {

    public static LocalDataSource localDataSource = new LocalDataSourceImpl();
    public static ServerDatasource serverDatasource = new ServerDataSourceImpl();
    public static Repository repository = new RepositoryImpl(localDataSource, serverDatasource);
    public static Business business = new BusinessImpl(repository);

    // EXO 2
    /*
     * Recupérez depuis le serveur la liste des gens qui sont nés à Chambéry,
     * La récupération de Data se fait dans l'ordre :
     *  - Récupération de data sur le server grace à TxtHelper.getDataFromTxt("server.txt");
     *  - Vider la base de données locale 
     */
    @Override
    public void displayPersonFromChambery() {
        System.out.println(business.getPersonsFromCity(Constants.CHAMBERY));
    }

    @Override
    public void displayBoomers() {
        System.out.print(business.getBoomers());
    }

    @Override
    public void displayFemales() {
        System.out.println(business.getFemales());
    }

    @Override
    public void displayFemaleBoomers() {
        System.out.println(business.getFemaleBoomers());
    }

    public static void main(String[] args) {
        MainExercice2 mainExercice2 = new MainExercice2();
        mainExercice2.displayFemaleBoomers();
    }
}
