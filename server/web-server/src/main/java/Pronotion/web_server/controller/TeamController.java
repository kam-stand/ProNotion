package Pronotion.web_server.controller;

import Pronotion.web_server.dto.TeamDto;
import Pronotion.web_server.model.Team;
import Pronotion.web_server.model.User;
import Pronotion.web_server.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    // Create a team
    @PostMapping
    public ResponseEntity<?> createTeam(@RequestBody TeamDto teamDto) {
        Team team = new Team();
        team.setName(teamDto.getName());
        boolean created = teamService.addTeam(team);
        return created ? ResponseEntity.ok("Team created.") : ResponseEntity.badRequest().body("Could not create team.");
    }

    // Get all teams
    @GetMapping
    public List<TeamDto> getAllTeams() {
        return teamService.getAllTeams().stream()
                .map(team -> new TeamDto(team.getId(), team.getName())) // or use a helper method
                .collect(Collectors.toList());
    }

    // Get team by ID
    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> getTeamById(@PathVariable int id) {
        Team team = teamService.getTeam(id);
        if (team == null) return ResponseEntity.notFound().build();
        TeamDto dto = new TeamDto();
        dto.setId(team.getId());
        dto.setName(team.getName());
        return ResponseEntity.ok(dto);
    }

    // Update a team
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeam(@PathVariable int id, @RequestBody TeamDto teamDto) {
        Team team = new Team();
        team.setId(id);
        team.setName(teamDto.getName());
        boolean updated = teamService.updateTeam(team);
        return updated ? ResponseEntity.ok("Team updated.") : ResponseEntity.notFound().build();
    }

    // Delete a team
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable int id) {
        boolean deleted = teamService.deleteTeam(id);
        return deleted ? ResponseEntity.ok("Team deleted.") : ResponseEntity.notFound().build();
    }

    // Get users by team ID
    @GetMapping("/{id}/users")
    public List<User> getUsersByTeamId(@PathVariable int id) {
        return teamService.getUsersByTeamId(id);
    }

    // Add user to team
    @PostMapping("/{teamId}/users/{userId}")
    public ResponseEntity<?> addUserToTeam(@PathVariable int teamId, @PathVariable int userId) {
        boolean added = teamService.addUserToTeam(teamId, userId);
        return added ? ResponseEntity.ok("User added to team.") : ResponseEntity.badRequest().body("Could not add user to team.");
    }

    // Remove user from team
    @DeleteMapping("/{teamId}/users/{userId}")
    public ResponseEntity<?> removeUserFromTeam(@PathVariable int teamId, @PathVariable int userId) {
        boolean removed = teamService.removeUserFromTeam(teamId, userId);
        return removed ? ResponseEntity.ok("User removed from team.") : ResponseEntity.badRequest().body("Could not remove user from team.");
    }
}
