import { Component, OnInit ,ViewChild} from '@angular/core';
import { ScreenService } from '../../../services/screen.service';
import { MatSort, MatTableDataSource, MatPaginator } from '@angular/material';
import { MatDialog, MatDialogConfig } from '@angular/material';
import { CreateScreenComponent } from '../create-screen/create-screen.component';
import { ScreenProductionService } from 'src/app/services/screen-production.service';
import { CommunicationService } from 'src/app/services/communication.service';
import { Screen } from 'src/app/model/screen';
import { DataStorageService } from 'src/app/services/data-storage.service';



@Component({
  selector: 'screen-list',
  templateUrl: './screen-list.component.html',
  styleUrls: ['./screen-list.component.scss']
})
export class ScreenListComponent implements OnInit {

  
  visible:boolean=true;
  row:any;
  displayedColumns: string[] = ['screenId', 'screenName', 'movieEndDate', 'rows','columns','action'];
  dataSource: MatTableDataSource<Screen>;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private dialog:MatDialog,private service: ScreenProductionService, private screenService: ScreenService,
              public communicationService:CommunicationService,private showService:DataStorageService) { }

  ngOnInit() {
    this.reloadData();
  }

   onCreateScreen(row){
    this.service.setTempRow(row);
    const dialogConfig=new MatDialogConfig();
    dialogConfig.disableClose=true;
    dialogConfig.autoFocus=true;
    dialogConfig.width="60%";
    this.dialog.open(CreateScreenComponent,dialogConfig);

  }

  deleteScreens() {
    this.screenService.deleteAll()
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }

  applySearchFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  reloadData() {
  if(this.communicationService.sharedId!=null){

    this.service.setScreenListByTheaterId(this.communicationService.sharedId);
    this.communicationService.clean();
    this.service.subject.subscribe(res => {
      this.service.data = res;
      this.dataSource = new MatTableDataSource(this.service.data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });

  
  }else{
    
    this.visible=false;
    this.service.setScreenList();
    this.service.subject.subscribe(res => {
       this.service.data = res;
      this.screenService.screens = res;
      this.dataSource = new MatTableDataSource(this.service.data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
    
  }
 
  }

  deleteScreen(screen:Screen) {



    this.showService.deleteByScreenId(screen.screenId).subscribe(

      response=>{
        console.log(response);
      });

    this.screenService.deleteScreen(screen.screenId)
      .subscribe(
        data => {
          console.log(data);
          
        },
        error => console.log(error));
  }

}
