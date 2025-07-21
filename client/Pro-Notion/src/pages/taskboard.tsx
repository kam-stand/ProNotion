import React, { useEffect, useState } from "react";
import axios from "axios";
import {
  BarChart,
  Bar,
  XAxis,
  YAxis,
  Tooltip,
  ResponsiveContainer,
} from "recharts"; // ✅ Correct
import "./styles.css/taskDashboard.css";

interface Task {
  id: number;
  name: string;
  description: string;
  status: Status;
  user_id: number;
  due_date: string;
}

type Status = "Completed" | "In Progress" | "Incomplete";
/**
 * incomplete
Complete
inprogress
complete

 */
const statusEmojis: Record<Status, string> = {
  Completed: "✅",
  "In Progress": "🔵",
  Incomplete: "❌",
};

export default function TaskDashboard() {
  const [tasks, setTasks] = useState<Task[]>([]);
  const [filteredStatus, setFilteredStatus] = useState<Status | "All">("All");
  const [newTask, setNewTask] = useState({
    name: "",
    description: "",
    status: "Incomplete" as Status,
    due_date: "",
  });

  const userId = "1"

  useEffect(() => {
    if (!userId) return;
    axios
      .get("http://localhost:8080/api/task", { params: { userId } })
      .then((res) => setTasks(res.data))
      .catch((err) => console.error("Failed to fetch tasks", err));
  }, [userId]);

  const handleAddTask = () => {
    if (!userId) return;
    const taskDto = { ...newTask, userId: parseInt(userId) };

    axios
      .post("http://localhost:8080/api/task", taskDto)
      .then(() => {
        setTasks((prev) => [...prev, { id: Date.now(), ...taskDto } as unknown as Task]);
        setNewTask({ name: "", description: "", status: "Incomplete", due_date: "" });
      })
      .catch((err) => console.error("Add failed", err));
  };

  const filteredTasks =
    filteredStatus === "All" ? tasks : tasks.filter((t) => t.status === filteredStatus);

  const chartData = ["Completed", "In Progress", "Incomplete"].map((status) => ({
    status,
    count: tasks.filter((t) => t.status === status).length,
  }));

  return (
    <div className="task-dashboard-container">
      <h2>📋 Task Dashboard</h2>

      <div className="task-chart">
      <ResponsiveContainer width="100%" height={200}>
  <BarChart
    data={chartData}
    layout="vertical"
    margin={{ top: 10, right: 10, left: 2, bottom: 10 }} // ← increase left margin
  >
    <XAxis type="number" allowDecimals={false} />
    <YAxis
      dataKey="status"
      type="category"
      width={120} // ← increase width to fit longer labels
    />
    <Tooltip />
    <Bar dataKey="count" fill="#8884d8" />
  </BarChart>
</ResponsiveContainer>

      </div>

      <div className="filter-buttons">
        {["All", "Completed", "In Progress", "Incomplete"].map((status) => (
          <button
            key={status}
            onClick={() => setFilteredStatus(status as Status | "All")}
            className={filteredStatus === status ? "active" : ""}
          >
            {status !== "All" ? statusEmojis[status as Status] : "📂"} {status}
          </button>
        ))}
      </div>

      <div className="task-list">
        {filteredTasks.map((task) => (
          <div key={task.id} className="task-item">
            {statusEmojis[task.status]} <strong>{task.name}</strong>: {task.description}
          </div>
        ))}
      </div>

      <div className="task-form">
        <small>Add a new task</small>
        <input
          type="text"
          placeholder="Task Name"
          value={newTask.name}
          onChange={(e) => setNewTask({ ...newTask, name: e.target.value })}
        />
        <input
          type="text"
          placeholder="Description"
          value={newTask.description}
          onChange={(e) => setNewTask({ ...newTask, description: e.target.value })}
        />
        <input
          type="date"
          value={newTask.due_date}
          onChange={(e) => setNewTask({ ...newTask, due_date: e.target.value })}
        />
        <select
          value={newTask.status}
          onChange={(e) => setNewTask({ ...newTask, status: e.target.value as Status })}
        >
          <option value="Completed">Completed</option>
          <option value="In Progress">In Progress</option>
          <option value="Incomplete">Incomplete</option>
        </select>
        <button onClick={handleAddTask}>➕ Add Task</button>
      </div>
    </div>
  );
}