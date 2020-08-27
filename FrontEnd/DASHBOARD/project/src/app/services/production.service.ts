import { Injectable, OnInit, OnChanges, Input, DoCheck } from '@angular/core';
import { FormBuilder, Validators, FormArray, ValidatorFn, FormGroup, FormControl } from '@angular/forms';
import { Show } from '../model/show.model';
import { DataStorageService } from './data-storage.service';
import { Subject } from 'rxjs';
import { CommunicationService } from './communication.service';
import { Screen } from 'src/app/model/screen';
import { Theatre } from 'src/app/model/theatre';
import { DatePipe } from '@angular/common';


@Injectable({
  providedIn: 'root'
})


export class ProductionService implements OnInit {

  public data:Show[];

  

  // For Successful Response
subject1=new Subject<any>();
//For error
subject2=new Subject<any>();
tempRow=null;

  
  constructor(private fb:FormBuilder, private service:DataStorageService,public communicationService:CommunicationService) { 
  
  }

  ngOnInit(){

    this.subject1.next(this.data);
  }

  formGroupName=this.fb.group({
    showId:[''],
    movieName:['',Validators.required],
    showDate:['',Validators.required],
    startTime:['',Validators.required],
    endTime:['',Validators.required],
    showPoster:['',Validators.required],
    theaterId:[''],
    screenId:[''],
    theaterName:['']
    
 
 });
 

  initializeFormGroup(){

    if(this.tempRow==null){
      this.formGroupName.setValue({
        showId:'',
        movieName:'',
        showDate:'',
        startTime:'',
        endTime:'',
        showPoster:'',
        theaterId:this.communicationService.sharedScreen.theatreId,
        screenId:this.communicationService.sharedScreen.screenId,
        theaterName:this.communicationService.sharedTheater.theatreName
        
  
      })
    }else{
      this.formGroupName.setValue({
        showId:this.tempRow.showId,
        movieName:this.tempRow.movieName,
        showDate:this.tempRow.showDate,
        startTime:this.tempRow.startTime,
        endTime:this.tempRow.endTime,
        showPoster:this.tempRow.showPoster,
        theaterId:this.tempRow.theaterId,
        screenId:this.tempRow.screenId,
        theaterName:this.tempRow.theaterName
       

    });

    this.data.splice(this.data.indexOf(this.tempRow),1);
   
  }
}

  setTempRow(row:Show){
    this.tempRow=row;
  }


  setShowList(){

    this.service.getShowsDB()
    .subscribe(
      (shows)=>{
           this.subject1.next(shows);
          },
      (error:Response)=>{
        this.subject2.next(error);
      });
  }


  setShowListByScreenId(screenId){

    this.service.getShowListByScreenId(screenId)
    .subscribe(
      (shows)=>{
           this.subject1.next(shows);
          },
      (error:Response)=>{
        this.subject2.next(error);
      });
  }

  saveShow(show:any){
        
        console.log(show);
        const objStr=JSON.stringify(show);
        var tempShow:Show=JSON.parse(objStr);
       
      //  var datePipe=new DatePipe("en-US");
       var date=new Date(this.formGroupName.get("showDate").value);
       date.setDate(date.getDate()+1);
       tempShow.showDate=date.toISOString();
    
        this.service.saveShowsDB(tempShow).subscribe(
           
          (response)=>{
            console.log(response),
            (error)=>{
              console.log(error)
            }
          }

        );
        tempShow.showDate=tempShow.showDate.substr(0,10);
        this.data.push(tempShow);
        

      this.ngOnInit();

  }


  // updateShowList(show:Show){

  //   // very efficient way ,first we map Object into id's than in single blow we find index of that id
  //   const index=this.showList.map(item=>item.showId).indexOf(show.showId);
  //   this.showList[index]=show;
  // }


  deleteShow(show:Show){

   this.service.deleteShowDB(show.showId).subscribe(

      (response)=>{
        console.log(response);
      },
      (error)=>{
        console.log(error);
      });
     
      this.data.splice(this.data.indexOf(show),1);
      this.ngOnInit();
  }

  getData(){

    this.service.getData()
    .subscribe(
      (shows)=>{
           this.subject1.next(shows);
          },
      (error:Response)=>{
          console.log(error);
      });
  }
  
}
