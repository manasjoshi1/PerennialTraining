import { Component, OnInit } from '@angular/core';
import { User } from './user';

@Component({
  selector: 'app-templatedrivenform',
  templateUrl: './templatedrivenform.component.html',
  styleUrls: ['./templatedrivenform.component.css']
})
export class TemplatedrivenformComponent implements OnInit {
  title="Template Driven Form";
  constructor() { }
  topics = ['Angular','React','Vue'];
  userModel=new User("as","asd","asds","asds","asds");
  ngOnInit(): void {
  }

}
