import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http'
import { from, Subject } from 'rxjs';
import { Theatre } from '../model/theatre';

@Injectable({
  providedIn: 'root'
})
export class TheatreService {

   theatres:any;
  
  constructor(private http:HttpClient) { }

  public baseUrl="http://localhost:7074/theatres";

  public addTheatre(theatre){
    return this.http.post(this.baseUrl,theatre,{responseType:"text" as "json"});
  }

  public getTheatres(){
    return this.http.get<Theatre[]>(this.baseUrl);
  }

  public getTheatreById(Id){
    return this.http.get<Theatre>(`${this.baseUrl}/`+Id);
  }

  public deleteTheatre(theatreID){
return this.http.delete(`${this.baseUrl}/`+theatreID);
  }
}
