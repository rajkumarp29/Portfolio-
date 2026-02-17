import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ProjectService } from '../../services/project.service';

@Component({
  selector: 'app-project',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './project.component.html'
})
export class ProjectComponent implements OnInit {

  projects: any[] = [];
  newProject: any = {};
  editMode = false;
  selectedId!: number;

  constructor(private projectService: ProjectService) {}

  ngOnInit(): void {
    this.loadProjects();
  }

  loadProjects() {
    this.projectService.getAllProjects()
      .subscribe(data => this.projects = data);
  }

 saveProject() {
  if (this.editMode) {
    this.projectService.updateProject(this.selectedId, this.newProject)
      .subscribe(() => this.reset());
  } else {
    this.projectService.createProject(this.newProject)
      .subscribe(() => this.reset());
  }
}

  editProject(project: any) {
    this.editMode = true;
    this.selectedId = project.id;
    this.newProject = { ...project };
  }

  deleteProject(id: number) {
    this.projectService.deleteProject(id)
      .subscribe(() => this.loadProjects());
  }

  reset() {
    this.newProject = {};
    this.editMode = false;
    this.loadProjects();
  }
}
