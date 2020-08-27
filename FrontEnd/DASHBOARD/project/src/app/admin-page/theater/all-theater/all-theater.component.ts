import { Component, OnInit } from '@angular/core';
import { TheatreService } from 'src/app/services/theatre.service';
import { CommunicationService } from 'src/app/services/communication.service';
import { ScreenService } from 'src/app/services/screen.service';
import { DataStorageService } from 'src/app/services/data-storage.service';
import { Theatre } from 'src/app/model/theatre';

@Component({
  selector: 'app-all-theater',
  templateUrl: './all-theater.component.html',
  styleUrls: ['./all-theater.component.css']
})
export class AllTheaterComponent implements OnInit {

  
  constructor(public service:TheatreService,public communicationService:CommunicationService
    ,private screenService:ScreenService,private showService:DataStorageService) { }

  ngOnInit() {
    let response=this.service.getTheatres();
    response.subscribe(data=>this.service.theatres=data);
  }

  public removeTheatre(theatre:Theatre){

    this.showService.deleteByTheaterId(theatre.theatreID).subscribe(
       (response)=>{
        console.log(response);
      },
      (error)=>{
        console.log(error);
        
      }
    );
    this.screenService.deleteByTheaterId(theatre.theatreID).subscribe(
      (response)=>{
        console.log(response);
      },
      (error)=>{
        console.log(error);
      }
    );
    let response=this.service.deleteTheatre(theatre.theatreID);
    response.subscribe(data=>console.log(data));

  

    this.service.theatres.splice(this.service.theatres.indexOf(theatre),1);
  }
  

}
