import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  templateUrl: './home.component.html'
})
export class HomeComponent {

  constructor(private app: AppService, private http: HttpClient, private router: Router) {
  }

  authenticated() {
    return localStorage.getItem('token') != null;
  }
}
