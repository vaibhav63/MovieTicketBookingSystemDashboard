import { Component, OnInit } from '@angular/core';
import { TheatreService } from 'src/app/services/theatre.service';
import { Theatre } from 'src/app/model/theatre';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-create-theater',
  templateUrl: './create-theater.component.html',
  styleUrls: ['./create-theater.component.css']
})
export class CreateTheaterComponent implements OnInit {

  theatre:Theatre=new Theatre(0,"","","",0);
  message:any;
  
  constructor(public service:TheatreService) { }

  ngOnInit(): void {

  }

  public createNow(){
  let response=  this.service.addTheatre(this.theatre);
  response.subscribe(data=>{
    this.message=data
  });

  this.service.theatres.push(this.theatre);
  this.ngOnInit();
  }


}
