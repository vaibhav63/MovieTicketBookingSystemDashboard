import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { CustomerPageComponent } from './customer-page/customer-page.component';
import { FrontPageComponent } from './customer-page/front-page/front-page.component';
import { ShowCarouselComponent } from './customer-page/show-carousel/show-carousel.component';
import { ShowManagementComponent } from './admin-page/show/show-management/show-management.component';
import { EditShowComponent } from './admin-page/show/edit-show/edit-show.component';
import { OngoingShowComponent } from './admin-page/show/ongoing-show/ongoing-show.component';
import { CreateScreenComponent } from './admin-page/screen/create-screen/create-screen.component';
import { ScreenListComponent } from './admin-page/screen/screen-list/screen-list.component';
import { CreateTheaterComponent } from './admin-page/theater/create-theater/create-theater.component';
import { SearchTheaterComponent } from './admin-page/theater/search-theater/search-theater.component';
import { AllTheaterComponent } from './admin-page/theater/all-theater/all-theater.component';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { MaterialModule } from './material/material.module';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NotificationService } from './services/notification.service';
import { ProductionService } from './services/production.service';
import { DataStorageService } from './services/data-storage.service';
import { MatDatepickerModule } from '@angular/material';
import { TheatreService } from './services/theatre.service';
import { CommunicationService } from './services/communication.service';
import { ScreenService } from './services/screen.service';
import { SigninComponent } from './auth/signin/signin.component';
import { SignupComponent } from './auth/signup/signup.component';
import { AuthService } from './auth/auth.service';
import { AuthGuard } from './auth/auth-guard.service';
import { ScreenProductionService } from './services/screen-production.service';

@NgModule({
  declarations: [
    AppComponent,
    AdminPageComponent,
    CustomerPageComponent,
    FrontPageComponent,
    ShowCarouselComponent,
    ShowManagementComponent,
    EditShowComponent,
    OngoingShowComponent,
    CreateScreenComponent,
    ScreenListComponent,
    CreateTheaterComponent,
    SearchTheaterComponent,
    AllTheaterComponent,
    SigninComponent,
    SignupComponent
  ],
  imports: [
    
    CarouselModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    FormsModule, 
    HttpClientModule
  ],
  providers: [NotificationService,ProductionService, DataStorageService,
    ScreenService,CommunicationService,TheatreService,  MatDatepickerModule
    , AuthService, AuthGuard,ScreenProductionService],
  bootstrap: [AppComponent],
  entryComponents:[EditShowComponent,CreateScreenComponent]
})
export class AppModule { }
