import { Component, OnInit } from '@angular/core';
import { Show } from 'src/app/model/show.model';
import { DataStorageService } from 'src/app/services/data-storage.service';
import { OwlOptions } from 'ngx-owl-carousel-o';

@Component({
  selector: 'app-show-carousel',
  templateUrl: './show-carousel.component.html',
  styleUrls: ['./show-carousel.component.css']
})
export class ShowCarouselComponent implements OnInit {

  showList:Show[];

  customOptions: OwlOptions = {
   loop: true,
   mouseDrag: true,
   touchDrag: true,
   pullDrag: true,
   dots: false,
   navSpeed: 700,
   navText: ['', ''],
   responsive: {
     0: {
       items: 1
     },
     700: {
       items: 4
     }
   },
   nav: true
 }
   constructor(public service:DataStorageService) { }
 
   ngOnInit() {
     this.setShowList();
   }
   
     setShowList(){
      
      this.service.getShowsDB().subscribe(
      
       (shows)=>{
           this.showList=shows;
           console.log(this.showList);
       },
       (error:Response)=>{
           console.log("error in getting shows");
       });
 
     }
 
 
     searchByMovieName(movieName){
 
       this.service.getShowListByMovieName(movieName).subscribe(
 
         (shows)=>{
            this.showList=shows;
            console.log(this.showList);
         },
         (error:Response)=>{
           console.log("error in getting shows");
         })
 
     }
 
 
     searchByDate(showDate){
 
      var date=new Date(showDate);
      date.setDate(date.getDate()+1);
      
      var tempDate=date.toISOString();
     
 
      console.log(tempDate);

       this.service.getShowListByDate(tempDate.substr(0,10)).subscribe(
 
         (shows)=>{
            this.showList=shows;
            console.log(this.showList);
         },
         (error:Response)=>{
           console.log("error in getting shows");
         })
     }
 
     searchByTheaterName(theaterName){
 
       this.service.getShowListByTheaterName(theaterName).subscribe(
       (shows)=>{
         this.showList=shows;
         console.log(this.showList);
       },
       (error:Response)=>{
         console.log("error in getting shows");
       })
     }

}
