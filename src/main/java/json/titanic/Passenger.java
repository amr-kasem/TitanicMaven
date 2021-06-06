package json.titanic;

public class Passenger {
    public enum SEX {
        MALE, FEMALE
    };

    private int id;
    private boolean survived;
    private byte pclass;
    private String name;
    private SEX sex;
    private double age;
    private double sibsp;
    private int parch;
    private String ticket;
    private double fare;
    private String cabin;
    private char embarcked;

    public int getId() {
        return id;
    };

    public boolean getSurvived() {
        return survived;
    };

    public byte getPclass() {
        return pclass;
    };

    public String getName() {
        return name;
    };

    public SEX getSex() {
        return sex;
    };

    public double getAge() {
        return age;
    };

    public double getSibsp() {
        return sibsp;
    };

    public int getParch() {
        return parch;
    };

    public String getTicket() {
        return ticket;
    };

    public double getFare() {
        return fare;
    };

    public String getCabin() {
        return cabin;
    };

    public char getEmbarcked() {
        return embarcked;
    };

    public void setId(int id) {
        this.id = id;
    }

    public void setSurvived(int survived) {
        this.survived = survived == 1;
    }

    public void setPclass(byte pclass) {
        this.pclass = pclass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex.equals("female") ? SEX.FEMALE : SEX.MALE;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setSibsp(double sibsp) {
        this.sibsp = sibsp;
    }

    public void setParch(int parch) {
        this.parch = parch;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public void setEmbarcked(String embarcked) {
        if (embarcked.length() > 0)
            this.embarcked = embarcked.charAt(0);
    }

    public String toString() {
        return name + ", " + age + " years old has" + (survived ? "" : "n't") + " survived.\n";
    }
}
