import React, { useState } from "react";
import "./styles.css/teamManagement.css";

interface Member {
  name: string;
  tasks: string[];
}

interface Team {
  name: string;
  members: Member[];
}

const TeamManagement: React.FC = () => {
  const [teams, setTeams] = useState<Team[]>([]);
  const [newTeamName, setNewTeamName] = useState("");
  const [selectedTeamIndex, setSelectedTeamIndex] = useState<number | null>(null);

  const [newMemberName, setNewMemberName] = useState("");

  const handleCreateTeam = () => {
    const name = newTeamName.trim();
    if (!name) return;

    setTeams((prev) => [...prev, { name, members: [] }]);
    setNewTeamName("");
    setSelectedTeamIndex(teams.length); // auto-select new team
  };

  const handleAddMember = () => {
  if (selectedTeamIndex === null) return;
  const name = newMemberName.trim();
  if (!name) return;

  setTeams((prev) => {
    return prev.map((team, idx) => {
      if (idx === selectedTeamIndex) {
        return {
          ...team,
          members: [...team.members, { name, tasks: [] }]
        };
      }
      return team;
    });
  });

  setNewMemberName("");
};


const assignTask = (memberIndex: number) => {
  if (selectedTeamIndex === null) return;

  const task = prompt(`Assign a task to ${teams[selectedTeamIndex].members[memberIndex].name}:`);
  if (!task) return;

  setTeams((prev) => {
    return prev.map((team, idx) => {
      if (idx !== selectedTeamIndex) return team;

      // Create new members array with updated member's tasks
      const updatedMembers = team.members.map((member, mIdx) => {
        if (mIdx !== memberIndex) return member;

        // Return a new member object with updated tasks array
        return {
          ...member,
          tasks: [...member.tasks, task],
        };
      });

      // Return new team object with updated members array
      return {
        ...team,
        members: updatedMembers,
      };
    });
  });
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
            <option value="" disabled>Select...</option>
            {teams.map((team, idx) => (
              <option key={idx} value={idx}>
                {team.name}
              </option>
            ))}
          </select>
        </div>
      )}

      {/* Selected Team Info */}
      {selectedTeamIndex !== null && (
        <>
          <h3>🚀 Team: <span className="team-name">{teams[selectedTeamIndex].name}</span></h3>

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
            {teams[selectedTeamIndex].members.length === 0 ? (
              <p className="no-members">No members yet. Add some!</p>
            ) : (
              teams[selectedTeamIndex].members.map((member, index) => (
                <div key={index} className="member-card">
                  <div className="member-header">
                    <span>👤 {member.name}</span>
                    <button onClick={() => assignTask(index)}>📝 Assign Task</button>
                  </div>

                  <ul className="task-list">
                    {member.tasks.length === 0 ? (
                      <li className="no-tasks">No tasks assigned.</li>
                    ) : (
                      member.tasks.map((task, i) => <li key={i}>📌 {task}</li>)
                    )}
                  </ul>
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
