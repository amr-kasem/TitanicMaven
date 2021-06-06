package json.titanic;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PassengerDAO pDao = new PassengerDAOImpl("titanic_csv.json").readAll();
        pDao.graphPassengerAges();
        pDao.graphPassengerClasses();
        pDao.graphPassengerSurvived();
        pDao.graphPassengerSurvivedGender();
    }
}
