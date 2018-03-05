import { Component } from '@angular/core';
import { AppService } from './app.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import 'rxjs/add/operator/finally';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private app: AppService, private http: HttpClient, private router: Router) {
  }

  authenticated() {
    return localStorage.getItem('token') != null;
  }

  logout() {
    this.http.post('logout', {}).finally(() => {
        localStorage.removeItem('token');
        this.router.navigateByUrl('/home');
    }).subscribe();
  }
}
