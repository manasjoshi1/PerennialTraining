import { Component } from "@angular/core";
import { Router } from "@angular/router";

@Component({
    selector: 'prod-comp',
    template: `<h2>Product Details</h2>
        <table border="3" *ngFor="let p of products" 
                       (click)="onSelectName(p)">
            <tr>
                <td>{{p.id}}</td>
                <td>{{p.name}}</td>
                <td>{{p.price}}</td>
            </tr>
        </table>
    `
    
})
export class Product{

    constructor(private router: Router){
  
    }
    products=[
        {"id":101,"name":"laptop","price":3200},
        {"id":102,"name":"phone","price":3200},
        {"id":103,"name":"TV","price":3200}
      ];

      onSelectName(p: any){
          this.router.navigate(['/selectedprod',p.name]);
      }
}