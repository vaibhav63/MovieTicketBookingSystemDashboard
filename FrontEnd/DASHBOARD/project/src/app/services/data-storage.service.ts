import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Show } from '../model/show.model';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DataStorageService {

  private baseUrl ='http://localhost:8000/show'

  constructor( private httpClient:HttpClient) { }

  getShowsDB():Observable<Show[]>{
    
     return this.httpClient.get<Show[]>(this.baseUrl).pipe(catchError(this.handleError));
  }
     

     handleError(error:HttpErrorResponse){

      return throwError(error.message || "Server Error");
      
     }

     getShowListByScreenId(screenId){
       return this.httpClient.get<Show[]>(`${this.baseUrl}/screenId/${screenId}`);
     }
   saveShowsDB(show:any){

    // let showHeader = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient.put(this.baseUrl,show);

   }

   deleteShowDB(showId){

    return this.httpClient.delete(`${this.baseUrl}/delete/`+showId);
   }


   getShowListByMovieName(movieName){

    return this.httpClient.get<Show[]>(`${this.baseUrl}/movieName/`+movieName);
   }

   getShowListByDate(showDate){

    return this.httpClient.get<Show[]>(`${this.baseUrl}/showDate/`+showDate);
   }

   getShowListByTheaterName(theaterName){

    return this.httpClient.get<Show[]>(`${this.baseUrl}/theaterName/`+theaterName);
   }

   getData(){

    return this.httpClient.get<Show[]>(`${this.baseUrl}/onGoingShows`);
   }


deleteByTheaterId(theaterId){

    return this.httpClient.delete(`${this.baseUrl}/delete/theaterId/${theaterId}`);
   }

   deleteByScreenId(screenId){

    return this.httpClient.delete(`${this.baseUrl}/delete/screenId/${screenId}`);
   }
}
