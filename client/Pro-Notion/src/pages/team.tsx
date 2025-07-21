import React, { useEffect, useState } from "react";
import axios from "axios";
import "./styles.css/teamManagement.css";

interface User {
  id: number;
  name: string;
}

interface Team {
  id: number;
  name: string;
  members: User[];
}

const TeamManagement: React.FC = () => {
  const [teams, setTeams] = useState<Team[]>([]);
  const [newTeamName, setNewTeamName] = useState("");
  const [selectedTeamIndex, setSelectedTeamIndex] = useState<number | null>(null);

  const [newMemberName, setNewMemberName] = useState("");

  // Fetch all teams on mount
  useEffect(() => {
    fetchTeams();
  }, []);

  // Fetch all teams
  const fetchTeams = async () => {
    try {
      const res = await axios.get<Team[]>("http://localhost:8080/api/teams");
      setTeams(res.data);
      if (res.data.length > 0 && selectedTeamIndex === null) {
        setSelectedTeamIndex(0);
      }
    } catch (err) {
      console.error("Failed to fetch teams", err);
    }
  };

  // Fetch users for selected team
  const fetchUsersForTeam = async (teamId: number) => {
    try {
      const res = await axios.get<User[]>(`http://localhost:8080/api/teams/${teamId}/users`);
      setTeams((prev) =>
        prev.map((team) =>
          team.id === teamId ? { ...team, members: res.data } : team
        )
      );
    } catch (err) {
      console.error("Failed to fetch users for team", err);
    }
  };

  // When team selection changes, fetch its users
  useEffect(() => {
    if (selectedTeamIndex === null) return;
    const team = teams[selectedTeamIndex];
    if (team && !team.members) {
      fetchUsersForTeam(team.id);
    }
  }, [selectedTeamIndex, teams]);

  // Create a new team
  const handleCreateTeam = async () => {
    const name = newTeamName.trim();
    if (!name) return;
    try {
      await axios.post("http://localhost:8080/api/teams", { name });
      setNewTeamName("");
      await fetchTeams();
      // Auto select last added team
      setSelectedTeamIndex(teams.length);
    } catch (err) {
      console.error("Failed to create team", err);
      alert("Could not create team.");
    }
  };

  // Add user by name to selected team
  const handleAddMember = async () => {
    if (selectedTeamIndex === null) return;
    const name = newMemberName.trim();
    if (!name) return;

    try {
      // First get user ID by name (assumed API)
      const userRes = await axios.get<User[]>(`http://localhost:8080/api/users/by-name`, {
        params: { name }
      });
      const user = userRes.data[0]; // Assuming the first match

      if (!user) {
        alert("User not found");
        return;
      }

      const teamId = teams[selectedTeamIndex].id;
      await axios.post(`http://localhost:8080/api/teams/${teamId}/users/${user.id}`);

      setNewMemberName("");
      await fetchUsersForTeam(teamId); // refresh members list
    } catch (err) {
      console.error("Failed to add user to team", err);
      alert("Could not add user to team.");
    }
  };

  return (
    <div className="team-management">
      <h2>👥 Team Management Panel</h2>

      {/* Create a team */}
      <div className="create-team-form">
        <input
          type="text"
          value={newTeamName}
          onChange={(e) => setNewTeamName(e.target.value)}
          placeholder="Enter new team name"
        />
        <button onClick={handleCreateTeam}>➕ Create Team</button>
      </div>

      {/* Team Selector */}
      {teams.length > 0 && (
        <div className="team-selector">
          <label>Select a Team:</label>
          <select
            value={selectedTeamIndex ?? ""}
            onChange={(e) => setSelectedTeamIndex(Number(e.target.value))}
          >
            <option value="" disabled>
              Select...
            </option>
            {teams.map((team, idx) => (
              <option key={team.id} value={idx}>
                {team.name}
              </option>
            ))}
          </select>
        </div>
      )}

      {/* Selected Team Info */}
      {selectedTeamIndex !== null && (
        <>
          <h3>
            🚀 Team: <span className="team-name">{teams[selectedTeamIndex].name}</span>
          </h3>

          {/* Add member */}
          <div className="add-member-form">
            <input
              type="text"
              value={newMemberName}
              onChange={(e) => setNewMemberName(e.target.value)}
              placeholder="Enter member name"
            />
            <button onClick={handleAddMember}>➕ Add Member</button>
          </div>

          {/* Member list */}
          <div className="team-list">
            {teams[selectedTeamIndex].members?.length === 0 ? (
              <p className="no-members">No members yet. Add some!</p>
            ) : (
              teams[selectedTeamIndex].members?.map((member) => (
                <div key={member.id} className="member-card">
                  <div className="member-header">
                    <span>👤 {member.name}</span>
                  </div>
                </div>
              ))
            )}
          </div>
        </>
      )}
    </div>
  );
};

export default TeamManagement;
