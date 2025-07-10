package Pronotion.web_server.model;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private long id;
    private String name;
    private List<Long> user_ids;

    public Team() {

    }

    public Team(long id, String name, List<Long> user_ids) {
        this.id = id;
        this.name = name;
        this.user_ids = user_ids;
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

    public List<Long> getUser_ids() {
        return user_ids;
    }

    public void setUser_ids(List<Long> user_ids) {
        this.user_ids = user_ids;
    }
}
