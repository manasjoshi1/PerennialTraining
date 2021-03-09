import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";

@Component({
    template: `<h2> You have selected the Product := {{prod_nam}}</h2>
                <button routerLink="/prod">Go Back<button> `
}) 
export class ProductDetails implements OnInit{

    prod_nam="";

    constructor(private ar : ActivatedRoute){
        let name=this.ar.snapshot.params['nam'];
        this.prod_nam = name;
    }

    ngOnInit(){
       
    }
}