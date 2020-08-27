export class Show{

    constructor(public showId:number,public movieName:string,public showDate:string,
        public startTime:string,public endTime:string,public showPoster:string,public theaterId:number,
        public screenId:number,public theaterName:string){

            this.showId=showId;
            this.movieName=movieName;
            this.showDate=showDate;
            this.startTime=startTime;
            this.endTime=endTime;
            this.showPoster=showPoster;
            this.theaterId=theaterId;
            this.screenId=screenId;
            this.theaterName=theaterName;
           
            
        }
}