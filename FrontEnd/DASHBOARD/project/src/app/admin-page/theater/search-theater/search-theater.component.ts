import { Component, OnInit } from '@angular/core';
import { TheatreService } from 'src/app/services/theatre.service';

@Component({
  selector: 'app-search-theater',
  templateUrl: './search-theater.component.html',
  styleUrls: ['./search-theater.component.css']
})
export class SearchTheaterComponent implements OnInit {

  
  Id:number;
  theatre:any;
  constructor(private service:TheatreService) { }

  ngOnInit() {
  }

  public findById(){
    let response=this.service.getTheatreById(this.Id);
    response.subscribe(data=>this.theatre=data);
  }


}
