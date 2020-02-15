import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { GreentechSharedModule } from 'app/shared/shared.module';
import { GreentechCoreModule } from 'app/core/core.module';
import { GreentechAppRoutingModule } from './app-routing.module';
import { GreentechHomeModule } from './home/home.module';
import { GreentechEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    GreentechSharedModule,
    GreentechCoreModule,
    GreentechHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    GreentechEntityModule,
    GreentechAppRoutingModule
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent]
})
export class GreentechAppModule {}
