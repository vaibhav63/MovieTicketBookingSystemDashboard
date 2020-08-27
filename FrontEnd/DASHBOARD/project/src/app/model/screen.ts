export class Screen {
    constructor(
        public screenId:number,
        public screenName:string,
        public movieEndDate:Date,
        public rows: number,
        public columns: number,
        public theatreId:number,
        
    ){

            this.screenId=screenId;
            this.screenName=screenName;
            this.movieEndDate=movieEndDate;
            this.rows=rows;
            this.columns=columns;
            this.theatreId=theatreId;
           
            
            
        }
}
