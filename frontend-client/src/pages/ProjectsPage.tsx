import { useEffect, useState } from "react";
import { getProjects } from "../services/projectService";
import ProjectCard from "../components/ProjectCard";

const ProjectsPage = () => {
  const [projects, setProjects] = useState([]);

  useEffect(() => {
    getProjects().then(res => setProjects(res.data));
  }, []);

  return (
    <div>
      <h2>My Projects</h2>
      {projects.map((p: any) => (
        <ProjectCard key={p.id} project={p} />
      ))}
    </div>
  );
};

export default ProjectsPage;
