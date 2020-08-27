import { Injectable } from '@angular/core';
import { Theatre } from '../model/theatre';
import { Screen } from '../model/screen';


@Injectable({
  providedIn: 'root'
})
export class CommunicationService {

  constructor() { };
  
  menuOpen:boolean=true;
  marginValue=240;
  public sharedId:any;
  public sharedName:any;
  public sharedScreen:Screen;
  public sharedTheater:Theatre;


  sendScreenId(screen:Screen){

    console.log(screen);
    this.sharedScreen=screen;
    console.log(this.sharedScreen);
    this.sharedId=screen.screenId;
    console.log(this.sharedId);
  }

  sendTheaterId(theater:Theatre){

   this.sharedTheater=theater;
   console.log(this.sharedTheater);
   this.sharedId=theater.theatreID;
   this.sharedName=theater.theatreName;
   console.log(this.sharedId);

  }


  clean(){
    this.sharedId=null;
  }


  toggleMenu(){
    this.menuOpen=!this.menuOpen;

    if(this.menuOpen){
      this.marginValue=50;
    }else{
      this.marginValue=240;
    }
  }

}
