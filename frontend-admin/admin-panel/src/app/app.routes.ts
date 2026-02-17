import { Routes } from '@angular/router';
import { ProjectComponent } from './components/project/project.component';

export const routes: Routes = [
  { path: 'projects', component: ProjectComponent },
  { path: '', redirectTo: 'projects', pathMatch: 'full' }
];
