import React, { useEffect, useState } from "react";
import axios from "axios";
import "./styles.css/fileManagement.css";

interface FileItem {
  id: string;
  name: string;
  mimeType: string;
}

export default function FileManagementPage() {
  const [folders, setFolders] = useState<FileItem[]>([]);
  const [files, setFiles] = useState<FileItem[]>([]);
  const [view, setView] = useState<"folders" | "files">("folders");

  const email = localStorage.getItem("email");

  const connectToGoogle = () => {
    if (!email) return alert("Email not found in localStorage");
    const state = encodeURIComponent("/files");
    window.location.href = `http://localhost:8080/api/auth/google`;
  };

  const fetchFolders = async () => {
    try {
      const res = await axios.get("http://localhost:8080/google/folders", {
        params: { email },
      });
      setFolders(res.data.files || []);
    } catch (err) {
      console.error("Failed to fetch folders", err);
    }
  };

  const fetchFiles = async () => {
    try {
      const res = await axios.get("http://localhost:8080/google/files", {
        params: { email },
      });
      setFiles(res.data.files || []);
    } catch (err) {
      console.error("Failed to fetch files", err);
    }
  };

  useEffect(() => {
    if (!email) return;
    fetchFolders();
    fetchFiles();
  }, [email]);

  const handleUpload = async (event: React.ChangeEvent<HTMLInputElement>) => {
    if (event.target.files && event.target.files.length > 0) {
      const formData = new FormData();
      formData.append("file", event.target.files[0]);

      try {
        await axios.post("http://localhost:8080/api/files/upload", formData, {
          headers: { "Content-Type": "multipart/form-data" },
        });
        alert("File uploaded successfully");
      } catch (err) {
        console.error("Upload failed", err);
        alert("Upload failed");
      }
    }
  };

  const displayedItems = view === "folders" ? folders : files;

  return (
    <div className="file-management-container">
      <h2 className="file-management-header">Manage Files & Folders</h2>

      <div className="connect-box">
        <button className="connect-btn" onClick={connectToGoogle}>
          🔗 Connect to Google
        </button>
      </div>

      <div className="view-toggle">
        <button
          className={view === "folders" ? "active" : ""}
          onClick={() => setView("folders")}
        >
          📁 Show Folders
        </button>
        <button
          className={view === "files" ? "active" : ""}
          onClick={() => setView("files")}
        >
          📄 Show Files
        </button>
      </div>

      <div className="items-list">
        {displayedItems.map((item) => (
          <div className="item" key={item.id}>
            <span role="img" aria-label={view}>
              {view === "folders" ? "📁" : "📄"}
            </span>
            <span className="item-name">{item.name}</span>
          </div>
        ))}
      </div>

      <div className="upload-section">
        <label htmlFor="file-upload" className="upload-area">
          <span role="img" aria-label="plus">
            ➕
          </span>{" "}
          Click to Upload
        </label>
        <input
          id="file-upload"
          type="file"
          style={{ display: "none" }}
          onChange={handleUpload}
        />
      </div>
    </div>
  );
}
