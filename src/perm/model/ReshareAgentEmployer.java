package perm.model;

public class ReshareAgentEmployer {
    private int id;
    private String employerName;
    private String agentName;

    public ReshareAgentEmployer(int id, String employerName, String agentName) {
        this.id = id;
        this.employerName = employerName;
        this.agentName = agentName;
    }

    public ReshareAgentEmployer(String agentName,String employerName) {
        this.agentName = agentName;
        this.employerName = employerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }
}
