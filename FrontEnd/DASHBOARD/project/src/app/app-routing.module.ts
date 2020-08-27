import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { OngoingShowComponent } from './admin-page/show/ongoing-show/ongoing-show.component';
import { ShowManagementComponent } from './admin-page/show/show-management/show-management.component';
import { ScreenListComponent } from './admin-page/screen/screen-list/screen-list.component';
import { CreateScreenComponent } from './admin-page/screen/create-screen/create-screen.component';
import { SearchTheaterComponent } from './admin-page/theater/search-theater/search-theater.component';
import { AllTheaterComponent } from './admin-page/theater/all-theater/all-theater.component';
import { CreateTheaterComponent } from './admin-page/theater/create-theater/create-theater.component';
import { CustomerPageComponent } from './customer-page/customer-page.component';
import { AuthGuard } from './auth/auth-guard.service';
import { SignupComponent } from './auth/signup/signup.component';
import { SigninComponent } from './auth/signin/signin.component';


const routes: Routes = [



  {path:'',redirectTo:'/customerPage',pathMatch:'full'},
  {path:'adminPage',component:AdminPageComponent,canActivate: [AuthGuard],children:[
       {path:'onGoingShow',component:OngoingShowComponent},
       {path:'showManagement',component:ShowManagementComponent},
       { path: 'screen', component: ScreenListComponent ,children:[
            { path: 'addScreen', component: CreateScreenComponent }
        ]},
        {path:"search", component:SearchTheaterComponent} ,
        {path:"all-theatres",component:AllTheaterComponent},
        {path:"create",component:CreateTheaterComponent}

   ]},
 
  {path:'customerPage',component:CustomerPageComponent},
  { path: 'signup', component: SignupComponent },
  { path: 'signin', component: SigninComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
