import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-template-admin',
  templateUrl: './template-admin.component.html',
  styleUrls: ['./template-admin.component.css']
})
export class TemplateAdminComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  status = false;
addToggle()
{
  this.status = !this.status;       
}

}