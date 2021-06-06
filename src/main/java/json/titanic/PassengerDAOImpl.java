package json.titanic;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class PassengerDAOImpl implements PassengerDAO {
    private List<Passenger> passengers;
    private String file;

    public PassengerDAOImpl(String f) {
        passengers = new ArrayList<Passenger>();
        file = f;
    }

    public PassengerDAO readAll() {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            InputStream ifile = new FileInputStream(file);
            passengers = om.readValue(ifile, new TypeReference<List<Passenger>>() {
            });
        } catch (Exception e) {
            System.out.println(e);
        }

        return this;
    }

    public Passenger get(int id) {
        return passengers.stream().filter(p -> p.getId() == id).toList().get(0);
    }

    public void delete(Passenger p) {

    }

    public void update(Passenger p) {

    }

    public void add(Passenger p) {

    }

    public void graphPassengerAges() {
        Map<Integer,Long> ages_histo = new TreeMap<>(passengers.stream().collect(Collectors.groupingBy(p->(int)Math.ceil(p.getAge()/5)*5,Collectors.counting())));
        ages_histo.remove(0);
        List<Integer> age_range = new ArrayList<Integer>();
        List<Long> histo = new ArrayList<Long>();
        ages_histo.forEach((k,v)->{
            age_range.add(k);
            histo.add(v);
        });
        CategoryChart chart = new CategoryChartBuilder()
        .width(800).height(600)
        .title("Age Histogram")
        .xAxisTitle("PassengerID")
        .yAxisTitle("Age")
        .build();
        chart.getStyler().setHasAnnotations(true);
        chart.addSeries("Histogram", age_range,histo);
        chart.getStyler().setStacked(true);
        new SwingWrapper<>(chart).displayChart();
    }
    public void graphPassengerClasses() {
        Map<Byte,Long> classes = passengers.stream().collect(Collectors.groupingBy(Passenger::getPclass,Collectors.counting()));
        PieChart chart = new PieChartBuilder()
        .width(800).height(600)
        .title("Age Histogram")
        .build();
        classes.forEach((k,v)->chart.addSeries("Class "+k.toString(),v));
        new SwingWrapper<>(chart).displayChart();
    }
    public void graphPassengerSurvived() {
        Map<Boolean,Long> classes = passengers.stream().collect(Collectors.groupingBy(Passenger::getSurvived,Collectors.counting()));
        PieChart chart = new PieChartBuilder()
        .width(800).height(600)
        .title("Survival")
        .build();
        classes.forEach((k,v)->chart.addSeries(k?"Survived":"Died",v));
        new SwingWrapper<>(chart).displayChart();
    }
    public void graphPassengerSurvivedGender() {
        Map<Passenger.SEX,Long> classes = passengers.stream().filter(Passenger::getSurvived).collect(Collectors.groupingBy(Passenger::getSex,Collectors.counting()));
        PieChart chart = new PieChartBuilder()
        .width(800).height(600)
        .title("Genders Survived")
        .build();
        classes.forEach((k,v)->chart.addSeries(k.toString(),v));
        new SwingWrapper<>(chart).displayChart();
    }
}
