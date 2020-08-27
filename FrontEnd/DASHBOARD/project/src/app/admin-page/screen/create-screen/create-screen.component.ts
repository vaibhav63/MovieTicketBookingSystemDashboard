import { Component, OnInit } from '@angular/core';



import { FormBuilder, FormGroup, Validators } from '@angular/forms';


import { MatDialogRef } from '@angular/material';

import { TheatreService } from 'src/app/services/theatre.service';
import { ScreenProductionService } from 'src/app/services/screen-production.service';
import { NotificationService } from 'src/app/services/notification.service';
import { CommunicationService } from 'src/app/services/communication.service';
import { Screen } from 'src/app/model/screen';
import { Theatre } from 'src/app/model/theatre';

@Component({
  selector: 'create-screen',
  templateUrl: './create-screen.component.html',
  styleUrls: ['./create-screen.component.scss']
})
export class CreateScreenComponent implements OnInit {
  //  angForm: FormGroup;
   public screen = {} as Screen;
  submitted = false;
  header:string;
 public theatres:Theatre[];
  constructor(private theatreService:TheatreService, public service:ScreenProductionService,
    private notificationService:NotificationService,
    public communicationService: CommunicationService,
    private dialogRef:MatDialogRef<CreateScreenComponent>) {}


  // createScreen(){
  //     this.angForm= this.formBuilder.group({
  //       screenName:['',Validators.required],
  //     });
  //   }

  ngOnInit() {
    this.service.initializeFormGroup();
    if(this.service.tempRow!=null){
      this.header="Update Screen " + this.service.tempRow.screenName;
    }else{
      this.header="Add Screen";
      
    }
    
    let response=this.theatreService.getTheatres();
    response.subscribe(data=>this.theatres=data);
  }
   onClear() {
    this.service.screenFormGroup.reset();
    this.notificationService.success(':: Cleared successfully');
  }


  onSubmit() {
   if (this.service.screenFormGroup.valid) {
      this.service.saveScreen(this.service.screenFormGroup.value);
      if(this.service.screenFormGroup.valid){
        this.service.screenFormGroup.reset();
        this.onClose();
      }
    }
  }
  goBack(): void {
    window.location.href = window.location.href + '/..';
  }

  onClose(){
    this.service.screenFormGroup.reset();
    this.dialogRef.close([]);
  }
}
