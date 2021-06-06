package json.titanic;


interface PassengerDAO {
    PassengerDAO readAll();
    Passenger get(int id);
    void delete(Passenger p);
    void update(Passenger p);
    void add(Passenger p);
    void graphPassengerAges();
    void graphPassengerClasses();
    void graphPassengerSurvived();
    void graphPassengerSurvivedGender();
}
