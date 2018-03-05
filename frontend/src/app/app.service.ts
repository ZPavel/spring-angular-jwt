import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class AppService {

  constructor(private http: HttpClient) {
  }

  login(credentials, callback) {
    this.http.post('login', credentials).subscribe(response => {
        if(response){
          localStorage.setItem('token', response['token']);
        }
        return callback && callback();
    });
  }

  register(user, callback) {
    this.http.post('register', user).subscribe(response => {
        return callback && callback();
    });
  }
}
