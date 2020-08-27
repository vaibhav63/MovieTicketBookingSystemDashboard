import { Component, OnInit } from '@angular/core';
import {  Validators, FormBuilder } from '@angular/forms';

import { AuthService } from '../auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  
  constructor(private authService: AuthService,public fb:FormBuilder) { }

  ngOnInit() {
  }

  fg= this.fb.group({
 
    email:['',Validators.required],
    password:['',Validators.required]


  })
  onSignUp() {
    if(this.fg.valid){
      const email = this.fg.get("email").value;
      const password = this.fg.get("password").value;
      this.authService.signupUser(email, password);
    }
    
  }
}
