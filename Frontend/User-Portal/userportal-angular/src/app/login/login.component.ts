import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Login } from '../_models';
import { LoginService } from '../login.service';
import { HttpErrorResponse } from '@angular/common/http';
import { AuthService } from '../auth.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']

})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  isLoginError : boolean = false;
  
  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private loginService : LoginService,
    private authService : AuthService
  ) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });

  }


    // for accessing the form fields
    get fval() { return this.loginForm.controls; }

  onFormSubmit() {
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }
    
    this.loading = true;
    //this.loading = false;
    const result:Login= Object.assign({}, this.loginForm.value);
    //console.log(result);
    //const result: Login = JSON.parse(JSON.stringify(this.loginForm.value));
    this.loginService.loginUser(result.username,result.password).subscribe(
      (data : any) =>{
        //console.log(data);
         localStorage.setItem('login',data.temp);
         localStorage.setItem('username',data.username);
        //localStorage.setItem('login',data);
        console.log(data.temp);
        if(data.temp==true){
          Swal.fire({
            icon: 'success',
            title: 'Login successful',
            showConfirmButton: false,
            timer: 2000
          })
          this.router.navigate(['/home']);
        }
        else{
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: data.message,
          })
         this.router.navigate(['/login']);   
         this.loading = false;
        }
      },
    (err : HttpErrorResponse)=>{
      this.isLoginError = true;
    });

    const logindata = new Login();
    this.authService.authenticate(this.isLoginError);
        
  }
  // onFormSubmit() {
  //   this.submitted = true;
  
  //   if (this.loginForm.invalid) {
  //     return;
  //   }
  
  //   this.loading = true;
  //   const { username, password } = this.loginForm.value;
  
  //   this.loginService.loginUser(username, password).subscribe(
  //     (data: any) => {
  //       if (data.temp) {
  //         localStorage.setItem('login', data.temp);
  //         localStorage.setItem('username', data.username);
  
  //         Swal.fire({
  //           icon: 'success',
  //           title: 'Login successful',
  //           showConfirmButton: false,
  //           timer: 2000
  //         });
  //         this.router.navigate(['/home']);
  //       } else {
  //         Swal.fire({
  //           icon: 'error',
  //           title: 'Oops...',
  //           text: data.responseMessage
  //         });
  //         this.router.navigate(['/login']);
  //       }
  //     },
  //     (err: HttpErrorResponse) => {
  //       this.isLoginError = true;
  //     }
  //   );
  // }
  // onFormSubmit() {
  //   this.submitted = true;
  
  //   if (this.loginForm.invalid) {
  //     return;
  //   }
  
  //   this.loading = true;
  //   const result: Login = Object.assign({}, this.loginForm.value);
  
  //   this.loginService.loginUser(result.username, result.password).subscribe(
  //     (data: any) => {
  //       // localStorage.setItem('login', data.temp);
  //       // localStorage.setItem('username', data.username);
  //       localStorage.setItem('login',JSON.stringify(data));
  
  //       if (data.temp) {
  //         Swal.fire({
  //           icon: 'success',
  //           title: 'Login successful',
  //           showConfirmButton: false,
  //           timer: 2000
  //         });
  //         this.router.navigate(['/home']);
  //         this.authService.authenticate(this.isLoginError);
  //       } else {
  //         Swal.fire({
  //           icon: 'error',
  //           title: 'Oops...',
  //           text: data.message,
  //         });
  //         this.router.navigate(['/login']);
  //         this.loading = false;
  //       }
  //     },
  //     (err: HttpErrorResponse) => {
  //       this.isLoginError = true;
  //     }
  //   );
  // }
}
