import { Injectable, OnInit, OnChanges, Input, DoCheck } from '@angular/core';
import { FormBuilder, Validators, FormArray, ValidatorFn, FormGroup } from '@angular/forms';
import { Subject } from 'rxjs';
import { CommunicationService } from './communication.service';
import { ScreenService } from '../services/screen.service';
import { NotificationService } from './notification.service';
import { Screen } from '../model/screen';
import { Theatre } from '../model/theatre';


@Injectable({
  providedIn: 'root'
})


export class ScreenProductionService implements OnInit {

  public data:Screen[];
  tempRow=null;
  subject=new Subject<any>();
  

  
  constructor(private fb:FormBuilder, private service:ScreenService,public communicationService:CommunicationService, 
    public notifcation: NotificationService) { 
  
  }

  ngOnInit(){
    this.subject.next(this.data);
  }

  screenFormGroup=this.fb.group({
    screenId:[''],
    screenName:['',Validators.required],
    movieEndDate:['',Validators.required],
    rows:['',Validators.required],
    columns:['',Validators.required],
    theatreId:[''],
  
 });

  initializeFormGroup(){

    if(this.tempRow==null){
      this.screenFormGroup.setValue({
        screenId:0,
        screenName:'',
        movieEndDate:'',
        rows:'',
        columns:'',
        theatreId:this.communicationService.sharedTheater.theatreID,
    
    })
    }else{
      this.screenFormGroup.setValue({
        screenId:this.tempRow.screenId,
        screenName:this.tempRow.screenName,
        movieEndDate:this.tempRow.movieEndDate,
        rows:this.tempRow.rows,
        columns:this.tempRow.columns,
        theatreId:this.tempRow.theatreId,
       
    });
console

    this.data.splice(this.data.indexOf(this.tempRow),1);
   
  }
}

  setTempRow(row){
    this.tempRow=row;
  }

  saveScreen(screen:any){
        
        console.log(screen);
        const objStr=JSON.stringify(screen);
        var tempScreen:Screen=JSON.parse(objStr);
        // if(tempScreen.theatreId == null || tempScreen.theatreId == -1){
        //   if(this.communicationService != null && this.communicationService.sharedTheater != null){
        //     tempScreen.theatreId=this.communicationService.sharedTheater.theatreID;
        //     // tempScreen.theatreName=this.communicationService.sharedTheater.theatreName;
        //   }else{
        //       this.screenFormGroup.controls['theatreId'].setErrors({'error': "theatre not found."});
        //   }

        // }
      

        
        this.service.createScreen(tempScreen).subscribe(
           
          (response)=>{
            console.log(response),
             this.notifcation.success(':: Submitted successfully');
             this.screenFormGroup.reset();
            (error)=>{
              console.log(error)
                this.notifcation.error(':: There is some issue in submission '+error);
            }
          }
        );
      this.data.push(tempScreen);
      this.ngOnInit();
  }




  deleteScreen(screen: Screen){

   this.service.deleteScreen(screen.screenId).subscribe(

      (response)=>{
        console.log(response);
      },
      (error)=>{
        console.log(error);
      });
     
      this.data.splice(this.data.indexOf(screen),1);
      this.ngOnInit();
  }


  setScreenList(){

    this.service.getScreensList()
    .subscribe(
      (screens)=>{
           this.subject.next(screens);
          });
  }


  setScreenListByTheaterId(screenId){

    this.service.getScreenListByTheaterId(this.communicationService.sharedId)
    .subscribe(
      (screens)=>{
           this.subject.next(screens);
          });
  }
}
