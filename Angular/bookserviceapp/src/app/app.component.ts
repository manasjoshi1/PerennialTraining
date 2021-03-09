import { Component } from '@angular/core';
import { BookdataService } from './bookdata.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'bookserviceapp';
  somedata : string = "";
  localbookList: any[];
  remotebooklist:any[];
  constructor(private bookservice:BookdataService){}
  /*
  ngOnInit() is a lifecycle hook, which runs when the component loads
  */
 ngOnInit() {
   this.somedata=this.bookservice.myData();
   this.loadlocalbooks();
   this.loadRemotebooks();
  }
  // Load localbooks
 loadlocalbooks(){ 
  return this.bookservice.GetLocalBooks().subscribe( (data:any)=>{
      this.localbookList=data;
  }  )
 }
 loadRemotebooks(){
  return this.bookservice.GetRemoteBooks().subscribe( (data:any)=>{
    this.remotebooklist=data;
}  )

 }
}
