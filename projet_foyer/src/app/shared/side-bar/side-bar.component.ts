import { Component, OnInit } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent implements OnInit {
  public uiBasicCollapsed = false;
  public uiAdvancedCollapsed = false;
  public formsCollapsed = false;
  public editorsCollapsed = false;
  public chartsCollapsed = false;
  public tablesCollapsed = false;
  public iconsCollapsed = false;
  public mapsCollapsed = false;
  public userPagesCollapsed = false;
  public errorCollapsed = false;
  public generalPagesCollapsed = false;
  public eCommerceCollapsed = false;
  
  constructor() { }

  ngOnInit() {
    const body: HTMLBodyElement | null = document.querySelector('body');

if (body !== null) {
  document.querySelectorAll('.sidebar .nav-item').forEach(function (el) {
    el.addEventListener('mouseover', function() {
      if(body.classList.contains('sidebar-icon-only')) {
        el.classList.add('hover-open');
      }
    });
    el.addEventListener('mouseout', function() {
      if(body.classList.contains('sidebar-icon-only')) {
        el.classList.remove('hover-open');
      }
    });
  });
}}}
