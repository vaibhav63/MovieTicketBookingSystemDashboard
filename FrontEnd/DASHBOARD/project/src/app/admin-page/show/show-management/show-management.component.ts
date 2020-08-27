import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSort, MatDialog, MatDialogConfig } from '@angular/material';
import { Show } from 'src/app/model/show.model';
import { EditShowComponent } from '../edit-show/edit-show.component';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { ProductionService } from 'src/app/services/production.service';
import { NotificationService } from 'src/app/services/notification.service';
import { CommunicationService } from 'src/app/services/communication.service';


@Component({
  selector: 'app-show-management',
  templateUrl: './show-management.component.html',
  styleUrls: ['./show-management.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class ShowManagementComponent implements OnInit {


  visible:boolean=true;
  row:any;
  displayedColumns: string[] = ['showId', 'movieName', 'showDate', 'startTime','endTime','actions'];
  dataSource: MatTableDataSource<Show>;
  expandedElement: Show | null;
  public spinner:boolean=true;
  error:any="";


  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private dialog:MatDialog,public service:ProductionService,private notificationService:NotificationService,public communicationService:CommunicationService) {}

  ngOnInit() {
    
    this.loadData();
   

  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }


  onCreate(row:Show){

    this.service.setTempRow(row);
    const dialogConfig=new MatDialogConfig();
    dialogConfig.disableClose=true;
    dialogConfig.autoFocus=true;
    dialogConfig.width="60%";
    this.dialog.open(EditShowComponent,dialogConfig);

  }


  deleteShowEvent(show:Show){

    this.service.deleteShow(show);
    this.notificationService.success(':: Deleted successfully');
    
  }


  loadData(){

    if(this.communicationService.sharedId!=null){

     
      this.service.setShowListByScreenId(this.communicationService.sharedId);
      this.communicationService.clean();
      this.service.subject1.subscribe(
        (shows)=>{
          this.service.data=shows;
          console.log(this.service);
          this.dataSource = new MatTableDataSource(this.service.data);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
          this.spinner=false;
        });
    }else{

      
      this.visible=false;

      this.service.setShowList();
      this.service.subject1.subscribe(
        (shows)=>{
          this.service.data=shows;
          console.log(this.service);
          this.dataSource = new MatTableDataSource(this.service.data);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
          this.spinner=false;
        });

    }
   

      this.service.subject2.subscribe(

        (error)=>{
          this.spinner=false;
          this.error=error; 
        }
      );
  }
}
