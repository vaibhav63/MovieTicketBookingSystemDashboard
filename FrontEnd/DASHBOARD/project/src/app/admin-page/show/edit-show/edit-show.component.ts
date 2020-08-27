import { Component, OnInit } from '@angular/core';
import { ProductionService } from 'src/app/services/production.service';
import { NotificationService } from 'src/app/services/notification.service';
import { MatDialogRef } from '@angular/material';

@Component({
  selector: 'app-edit-show',
  templateUrl: './edit-show.component.html',
  styleUrls: ['./edit-show.component.css']
})
export class EditShowComponent implements OnInit {

  url:any="/assets/images/add-image.png";
  header:string;
 
  
  constructor(public service:ProductionService,private notificationService:NotificationService,private dialogRef:MatDialogRef<EditShowComponent>) {}
  
ngOnInit(){
  this.service.initializeFormGroup();
  if(this.service.tempRow!=null){
    this.header="Update ShOw Details";
  }else{
    this.header="Save ShOw Details";
  }
}
  onClear() {
    this.service.formGroupName.reset();
    this.notificationService.success(':: Cleared successfully');
  }

  onSubmit() {
    console.log("inside on submit")
    if (this.service.formGroupName.valid) {
      console.log("after validation")
      this.service.saveShow(this.service.formGroupName.value);
      this.service.formGroupName.reset();
      this.onClose();
      
      this.notificationService.success(':: Submitted successfully');

    }
  }

  onClose(){
    this.dialogRef.close();
  }

}
