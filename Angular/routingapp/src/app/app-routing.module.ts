import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { EquityNewsComponent } from './news/equityNews';
import { FinanceNewsComponent } from './news/financenews';
import { NewsComponent } from './news/news.component';
import { SportsNewsComponent } from './news/sportsnews';
import { Product } from './product';
import { ProductDetails } from './productdetails';

const routes: Routes = [];
const routes1=
[
    {path:'about',component:AboutComponent},
    {path:'news',component:NewsComponent}
]

const routes2=
[
  {path:'about',component:AboutComponent},
  {path:'news',component:NewsComponent,
   children: [
    {path: 'news/sports',component:SportsNewsComponent},
    {path: 'news/finance',component:FinanceNewsComponent},
    {path: 'news/finance/equity',component:EquityNewsComponent} 
   ]
  }
]

const routes3=
[
  {path:'about',component:AboutComponent},
  {path:'news',component:NewsComponent,
   children: [
    {path: 'news/sports',component:SportsNewsComponent},
    {path: 'news/finance',component:FinanceNewsComponent},
    {path: 'news/finance/equity',component:EquityNewsComponent} 
   ]
  },
  { path:'prod',component:Product},
  { path:'selectedprod/:nam',component:ProductDetails}
]

@NgModule({
  
  imports: [RouterModule.forRoot(routes3)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
