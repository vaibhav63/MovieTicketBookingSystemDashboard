import { Component, OnInit } from '@angular/core';
import * as firebase from 'firebase';
import { CommunicationService } from './services/communication.service';
import { Router } from '@angular/router';
import { AuthService } from './auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(public communeService:CommunicationService,private router: Router,
               public authService:AuthService){}
  hidden:boolean=true;
  ngOnInit() {

    
    firebase.initializeApp({
   apiKey: "AIzaSyBMPLZuZnxVSv8GHr5nUhGtqOmMVaKHxuU",
  authDomain: "authentication-backup.firebaseapp.com"
    });
  }

  toggleMenu(){
    this.communeService.toggleMenu();
   } 
   
   goToHome(){
     this.hidden=true;
    this.router.navigate(['/']);
   }

   goToDashboard(){
     this.hidden=false;
    this.router.navigate(['/adminPage']);
   }
}
