import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EnableService {

  readonly rootUrl = 'http://localhost:8080/bank/customer/';
  constructor(private http: HttpClient) { 
  }

  enableLoginService(username){
    return this.http.get(this.rootUrl + username + '/enable');
  }
}
