import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NotFoundPageComponent } from './shared/not-found-page/not-found-page.component';
import { HomeComponent } from './shared/home/home.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent }, // Route vers la page d'accueil

  { path: '', redirectTo: '/home', pathMatch: 'full' }, // Redirection vers la page d'accueil lorsque la route est vide

  { path: '**', component: NotFoundPageComponent } // Route wildcard pour gérer les routes inexistantes
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
