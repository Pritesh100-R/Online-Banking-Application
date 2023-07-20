import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  readonly rootUrl = 'http://localhost:8080/bank';

  constructor(private http: HttpClient) { }

  insertUser(firstName: string, lastName: string,fathername: string, gender: string, userName: string, password: string, dob:Date, phone: number, address: string, identitytype: string,identityno:number, adharno:number, email: string) {
    var body = { 
      firstname : firstName,
      lastname : lastName,
      fathername: fathername,
      gender:gender,
      username: userName,
      password: password,
      dob:dob,
      phone : phone,
      address : address,
      identitytype:identitytype,
      identityno:identityno,
      adharno:adharno,
      email : email,
    }
    return this.http.post(this.rootUrl + '/newaccount', body);
  }
}
