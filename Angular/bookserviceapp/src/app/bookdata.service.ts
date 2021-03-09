import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Localbook } from './localbook';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { RemoteBook } from './remotebook';

@Injectable({
  providedIn: 'root'
})
export class BookdataService {

  constructor(private httpservice: HttpClient) { }

  localurl:string = './assets/bookset.json  ';
  remoteurl:string='https://jsonplaceholder.typicode.com/posts';
  myData() {
    return 'This is the data from my DataService !';
  }
  GetLocalBooks(): Observable<Localbook> { 
    return this.httpservice.get<Localbook>(this.localurl).pipe(
       retry(1), catchError(this.myerrorhandler));
  }
  GetRemoteBooks():Observable<RemoteBook>{
    return this.httpservice.get<RemoteBook>(this.remoteurl).pipe(
      retry(1), catchError(this.myerrorhandler));
  }
  // Error handling
myerrorhandler(error) {
  let errorMessage = '';
  if(error.error instanceof ErrorEvent) {
    // Get client-side error
    errorMessage = error.error.message;
  } else {
    // Get server-side error
    errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
  }
  console.log(errorMessage);
  return throwError(errorMessage);
}
}
