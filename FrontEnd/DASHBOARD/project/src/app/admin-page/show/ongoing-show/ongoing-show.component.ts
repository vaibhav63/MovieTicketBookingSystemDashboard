import { Component, OnInit, ViewChild } from '@angular/core';
import { trigger, state,style, transition, animate } from '@angular/animations';
import { Show } from 'src/app/model/show.model';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { ProductionService } from 'src/app/services/production.service';

@Component({
  selector: 'app-ongoing-show',
  templateUrl: './ongoing-show.component.html',
  styleUrls: ['./ongoing-show.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class OngoingShowComponent implements OnInit {

  public data:Show[];
  displayedColumns: string[] = ['showId', 'movieName', 'showDate', 'startTime','endTime'];
  dataSource: MatTableDataSource<Show>;
  expandedElement: Show | null;
  public now=new Date();
  public spinner:boolean=true;
  error:any="";

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;
  
  constructor(public service:ProductionService) { }

  ngOnInit(): void {

  
    this.service.getData();
     this.service.subject1.subscribe(
      (shows)=>{
        this.service.data=shows;
        this.dataSource = new MatTableDataSource(this.service.data);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
        this.spinner=false;
      });

      this.service.subject2.subscribe(

        (error)=>{
          this.spinner=false;
          this.error=error; 
        }
      );
  }

}
