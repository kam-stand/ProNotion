package Pronotion.web_server.dao;

import Pronotion.web_server.model.Team;
import Pronotion.web_server.model.User;

import java.util.List;

public interface TeamDao {

    public List<Team> getTeams();
    public Team getTeamById(int id);
    public boolean addTeam(Team team);
    public boolean updateTeam(Team team);
    public boolean deleteTeam(int id);
    public List<User> getUsersByTeamId(int teamId);
}
