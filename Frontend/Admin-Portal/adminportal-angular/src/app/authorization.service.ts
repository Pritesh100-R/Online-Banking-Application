import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthorizeUser } from './model/authorizeUser';

@Injectable({
  providedIn: 'root'
})
export class AuthorizationService {

  readonly rootUrl = 'http://localhost:8080/bank';

  constructor(private http: HttpClient) { }
  
  getRequestData(){
    return this.http.get<AuthorizeUser[]>(this.rootUrl + '/customer/deactiveaccouts/all');
  }
  
  authorizeAccount(username){
    return this.http.get(this.rootUrl+'/customer/' + username + '/activate');
  }
   
  rejectRequest(username){
    return this.http.get(this.rootUrl+'/customer/' + username + '/activate/cancel' );
  
  }


}