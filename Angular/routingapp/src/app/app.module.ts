import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AboutComponent } from './about/about.component';
import { NewsComponent } from './news/news.component';
import { ProductDetails } from './productdetails';
import { Product } from './product';
import { SportsNewsComponent } from './news/sportsnews';
import { FinanceNewsComponent } from './news/financenews';
import { EquityNewsComponent } from './news/equityNews';

@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    NewsComponent,
    SportsNewsComponent,
    FinanceNewsComponent,
    EquityNewsComponent,
    Product,
    ProductDetails
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
