import { Component, OnInit } from '@angular/core';
import { AppService } from './app.service';
import { HttpClient } from '@angular/common/http';

@Component({
  templateUrl: './home.component.html'
})
export class HomeComponent {

  title = 'Viree';
  greeting = {};

  constructor(private app: AppService, private http: HttpClient) {
  }

  authenticated() {
    return localStorage.getItem('token') != null;
  }
}
