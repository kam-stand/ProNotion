package Pronotion.web_server.model;


public class Team {

    private long id;
    private String name;

    public Team() {

    }

    public Team(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
}
