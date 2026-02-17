import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

 private API_URL = 'http://localhost:8081/api/projects';


  constructor(private http: HttpClient) {}

  getAllProjects(): Observable<any[]> {
    return this.http.get<any[]>(this.API_URL);
  }

  createProject(project: any): Observable<any> {
    return this.http.post(this.API_URL, project);
  }

  updateProject(id: number, project: any): Observable<any> {
    return this.http.put(`${this.API_URL}/${id}`, project);
  }

  deleteProject(id: number): Observable<any> {
    return this.http.delete(`${this.API_URL}/${id}`);
  }
}
