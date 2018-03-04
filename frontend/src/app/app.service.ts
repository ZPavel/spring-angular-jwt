import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class AppService {

  authenticated = false;

  constructor(private http: HttpClient) {
  }

  login(credentials, callback) {
    this.http.post('login', credentials).subscribe(response => {
        console.log(response);
        return callback && callback();
    });
  }

  register(user, callback) {
    this.http.post('register', user).subscribe(response => {
        console.log(response);
        return callback && callback();
    });
  }
}
