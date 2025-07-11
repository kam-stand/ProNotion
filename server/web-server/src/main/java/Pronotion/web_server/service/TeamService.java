package Pronotion.web_server.service;

import Pronotion.web_server.dao.TeamDaoImpl;

public class TeamService {

    private final TeamDaoImpl teamDao;

    public TeamService(TeamDaoImpl teamDao) {
        this.teamDao = teamDao;
    }


}
