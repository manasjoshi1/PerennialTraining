import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-reactiveform',
  templateUrl: './reactiveform.component.html',
  styleUrls: ['./reactiveform.component.css']
})
export class ReactiveformComponent implements OnInit {
title="Reactive Model Form";
  constructor() { }

  ngOnInit(): void {
  }
  registrationform = new FormGroup({
    //username : new FormControl('Amit'), //default value
    username : new FormControl('Amit',
              [Validators.required, Validators.minLength(4)]),
    password : new FormControl(''),
    confirmPassword : new FormControl(''),
    address : new FormGroup({
      city : new FormControl('Pune'), //city, state and postalcode combined in address
      state : new FormControl(''),
      postalcode : new FormControl('')
    })
    
  
});
onSubmit(){
console.log(this.registrationform.value);
alert(JSON.stringify(this.registrationform.value));
}
}
