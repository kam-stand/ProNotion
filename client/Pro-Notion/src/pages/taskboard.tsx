import React, { useState } from "react";
import "./styles.css/taskDashboard.css";

type Status = "Completed" | "In Progress" | "Incomplete";

interface TaskMeta {
  icon: string;
  color: string;
}

const statusMeta: Record<Status, TaskMeta> = {
  Completed: { icon: "✅", color: "green" },
  "In Progress": { icon: "🔵", color: "blue" },
  Incomplete: { icon: "❌", color: "red" },
};

const TaskDashboard: React.FC = () => {
  const [tasks, setTasks] = useState<Record<Status, string[]>>({
    Completed: [],
    "In Progress": [],
    Incomplete: [],
  });

  const [inputs, setInputs] = useState<Record<Status, string>>({
    Completed: "",
    "In Progress": "",
    Incomplete: "",
  });

  const handleAddTask = (status: Status) => {
    const input = inputs[status].trim();
    if (!input) return;

    setTasks((prev) => ({
      ...prev,
      [status]: [...prev[status], input],
    }));

    setInputs((prev) => ({
      ...prev,
      [status]: "",
    }));
  };

  const statuses: Status[] = ["Completed", "In Progress", "Incomplete"];

  return (
    <div className="task-dashboard">
      {statuses.map((status) => (
        <div key={status} className="task-column">
          <div className="task-header" style={{ color: statusMeta[status].color }}>
            <span>{statusMeta[status].icon} {status}</span>
          </div>

          <div className="task-list">
            {tasks[status].map((task, i) => (
              <div key={i} className="task-item">📌 {task}</div>
            ))}
          </div>

          <div className="task-form">
            <input
              type="text"
              value={inputs[status]}
              onChange={(e) => setInputs({ ...inputs, [status]: e.target.value })}
              placeholder={`Add ${status.toLowerCase()} task...`}
            />
            <button onClick={() => handleAddTask(status)}>➕</button>
          </div>
        </div>
      ))}
    </div>
  );
};

export default TaskDashboard;
