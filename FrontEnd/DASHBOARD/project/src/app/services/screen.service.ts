import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Screen } from '../model/screen';


@Injectable({
  providedIn: 'root'
})
export class ScreenService {

  public screens: Screen[];
  private baseUrl ='http://localhost:8001/screen'

  constructor(private http: HttpClient) { }

  getScreensList(): Observable<Screen[]> {
    return this.http.get<Screen[]>(`${this.baseUrl}`);
  }
  // addScreen(): Observable<Screen>  {
  //   return this.http.get<Screen>(`${this.baseUrl}/add`);
  // }
  createScreen(screen: Object): Observable<Object> {
    console.log(screen);
    return this.http.post(`${this.baseUrl}`, screen);
  }

  updateScreen(screen: Object): Observable<Object> {
    console.log(screen);
    return this.http.put(`${this.baseUrl}`, screen);
  }
  deleteScreen(screenId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${screenId}`);
  }
  
  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }

  getScreenListByTheaterId(theaterId){

    return this.http.get<Screen[]>(`${this.baseUrl}/theaterId/${theaterId}`);
  }

    deleteByTheaterId(theaterId){

    return this.http.delete(`${this.baseUrl}/delete/theaterId/${theaterId}`);
   }
}


  

  