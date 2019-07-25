package perm.Model;

public class Agent {
    private String firmName;
    private String city;
    private String state;

    public Agent(String firmName, String city, String state) {
        this.firmName = firmName;
        this.city = city;
        this.state = state;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
