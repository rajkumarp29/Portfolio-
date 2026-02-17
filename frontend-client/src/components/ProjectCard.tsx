type Props = {
  project: any;
};

const ProjectCard = ({ project }: Props) => {
  return (
    <div style={{ border: "1px solid #ccc", padding: "10px", margin: "10px" }}>
      <h3>{project.title}</h3>
      <p>{project.description}</p>

      {project.clientName && (
        <small>Client: {project.clientName}</small>
      )}
    </div>
  );
};

export default ProjectCard;
