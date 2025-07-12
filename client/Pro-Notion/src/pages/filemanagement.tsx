import file_info from "../assets/file_info.json";
import "./styles.css/fileManagement.css";

export default function FileManagementPage() {
  const visibleFiles = file_info.files;

  return (
    <div className="file-management-container">
      <h2 className="file-management-header">View, Search, and Upload Files</h2>
      <div className="folders-list">
        {visibleFiles.map((folder: { id: string; name: string }) => (
          <div className="folder-item" key={folder.id}>
            <span role="img" aria-label="folder">
              📁
            </span>
            <span className="folder-name">{folder.name}</span>
          </div>
        ))}
      </div>
      <div className="upload-section">
        <button className="upload-btn" title="Upload">
          <span role="img" aria-label="plus">
            ➕
          </span>
        </button>
      </div>
    </div>
  );
}
