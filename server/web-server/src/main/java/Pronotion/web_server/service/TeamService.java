package Pronotion.web_server.service;

import Pronotion.web_server.dao.TeamDaoImpl;
import Pronotion.web_server.dao.UserDaoImpl;
import Pronotion.web_server.model.Team;
import Pronotion.web_server.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamDaoImpl teamDao;
    private final UserDaoImpl userDao;

    public TeamService(TeamDaoImpl teamDao, UserDaoImpl userDao) {
        this.teamDao = teamDao;
        this.userDao = userDao;
    }

    public boolean addTeam(Team team) {
        return teamDao.addTeam(team);
    }

    public Team getTeam(int id) {
        return teamDao.getTeamById(id);
    }

    public List<Team> getAllTeams() {
        return teamDao.getTeams();
    }

    public boolean deleteTeam(int id) {
        return teamDao.deleteTeam(id);
    }

    public boolean updateTeam(Team team) {
        return teamDao.updateTeam(team);
    }

    public List<User> getUsersByTeamId(int teamId) {
        return teamDao.getUsersByTeamId(teamId);
    }

    public boolean addUserToTeam(int teamId, int userId) {
        if (userDao.findUser(userId).isEmpty()) {
            return false;
        }
        return teamDao.addUserToTeam(teamId, userId);
    }

    public boolean removeUserFromTeam(int teamId, int userId) {
        return teamDao.removeUserFromTeam(teamId, userId);
    }

    public List<Team> getTeamsByUserId(int userId) {
        return teamDao.getTeamsByUserId(userId);
    }
}
