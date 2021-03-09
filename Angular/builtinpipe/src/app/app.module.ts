import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SquarePipe } from './square.pipe';
import { AadharnoPipe } from './aadharno.pipe';

@NgModule({
  declarations: [
    AppComponent,
    SquarePipe,
    AadharnoPipe
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
