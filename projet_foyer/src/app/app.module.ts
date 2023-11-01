import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';


import { AppComponent } from './app.component';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { HomeComponent } from './shared/home/home.component';
import { NotFoundPageComponent } from './shared/not-found-page/not-found-page.component';
import { TemplateAdminComponent } from './shared/template-admin/template-admin.component';
import { NavComponent } from './shared/nav/nav.component';
import { SideBarComponent } from './shared/side-bar/side-bar.component';
import { NavAdminComponent } from './shared/nav-admin/nav-admin.component';
import { FooterAdminComponent } from './shared/footer-admin/footer-admin.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    NavComponent,
    NotFoundPageComponent,
    SideBarComponent,
    NavAdminComponent,
    FooterAdminComponent,
    TemplateAdminComponent
  ],
  imports: [
    BrowserModule,
    
    AppRoutingModule,
    NgbModule
   
 
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
