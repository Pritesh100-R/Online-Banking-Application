import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UpdateService {


  readonly rootUrl = 'http://localhost:8080/bank';

  constructor(private http: HttpClient) { }

  update(username:String,prevpassword:string,password:string) {
    var body = {
      username:username,
      password: prevpassword,
      newpassword:password
    }
    console.log(body);
    return this.http.post(this.rootUrl + '/profile/update', body);
  }
}
