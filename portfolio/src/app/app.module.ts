import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BarraNavComponent } from './component/barra-nav/barra-nav.component';
import { BannerComponent } from './component/banner/banner.component';
import { HeaderComponent } from './component/header/header.component';
import { AboutComponent } from './component/about/about.component';
import { ExpComponent } from './component/exp/exp.component';
import { EducacionComponent } from './component/educacion/educacion.component';

@NgModule({
  declarations: [
    AppComponent,
    BarraNavComponent,
    BannerComponent,
    HeaderComponent,
    AboutComponent,
    ExpComponent,
    EducacionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
