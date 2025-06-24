import "./styles/home_page.css";

export default function HomePage() {
  return (
    <div className="HomePage">
      <header className="home-header">
        <h1>Pro Notion Dashboard</h1>
        <p>Welcome back! Manage your tasks and notes efficiently.</p>
      </header>
      <main className="home-main">
        <section className="quick-actions">
          <h2>Quick Actions</h2>
          <button>Add Task</button>
          <button>View Notes</button>
          <button>Set Reminder</button>
        </section>
        <section className="recent-activity">
          <h2>Recent Activity</h2>
          <ul>
            <li>Task "Finish project" marked as complete</li>
            <li>Note "Meeting summary" updated</li>
            <li>Reminder set for tomorrow</li>
          </ul>
        </section>
      </main>
    </div>
  );
}
