import { Component, OnInit } from '@angular/core';
import { DataStorageService } from '../services/data-storage.service';
import { CommunicationService } from '../services/communication.service';


@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {

 

  constructor(private service:DataStorageService,public communeService:CommunicationService) { }

  ngOnInit() {
  }

 

}
