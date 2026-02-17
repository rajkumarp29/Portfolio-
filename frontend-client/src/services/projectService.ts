import axios from "axios";

const API_URL = "http://localhost:8080/api/projects";

export const getProjects = () => {
  return axios.get(API_URL);
};
