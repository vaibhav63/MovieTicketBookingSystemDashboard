import { Component, OnInit } from '@angular/core';
import {  FormBuilder, Validators } from '@angular/forms';

import { AuthService } from '../auth.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  constructor(private authService: AuthService,public fb:FormBuilder) { }

  ngOnInit() {
  }

   fg= this.fb.group({
 
    email:['',Validators.required],
    password:['',Validators.required]


  })
  onSignIn() {
    if(this.fg.valid){
      const email = this.fg.get("email").value;
      const password = this.fg.get("password").value;
      this.authService.signinUser(email, password);
    }
    
  }

}
