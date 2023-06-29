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
import { HysComponent } from './component/hys/hys.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { FooterComponent } from './component/footer/footer.component';
import { PortfolioComponent } from './component/portfolio/portfolio.component';
import { IniciarSesionComponent } from './component/iniciar-sesion/iniciar-sesion.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    BarraNavComponent,
    BannerComponent,
    HeaderComponent,
    AboutComponent,
    ExpComponent,
    EducacionComponent,
    HysComponent,
    FooterComponent,
    PortfolioComponent,
    IniciarSesionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    NgCircleProgressModule.forRoot({})

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
