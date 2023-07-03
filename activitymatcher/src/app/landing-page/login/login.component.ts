import {Component, EventEmitter, Output} from '@angular/core';
import {AuthenticationRequest} from "../../interfaces/AuthenticationRequest";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth.service";
import {ActivatedRoute, Router} from "@angular/router";
import {RefreshService} from "../../services/refresh.service";
import {LocalStorageService} from "../../services/local-storage.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginForm: FormGroup | any;

  loginRequest: AuthenticationRequest;
  passwordVisible: boolean = false;

  isError: boolean | any;
  @Output() closeLogin = new EventEmitter<void>();
  @Output() loginSuccess = new EventEmitter<void>();
  @Output() showRegister = new EventEmitter<void>();


  constructor(
    private authService: AuthService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private formBuilder: FormBuilder,// added form builder dependency
    private refreshService: RefreshService,
    private localStorageService: LocalStorageService
  ) {

    this.loginRequest = {
      username: '',
      password: ''
    }
  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', Validators.required]
    });
    this.refreshService.usernameSource.subscribe(username => {
      this.loginForm.get('username').setValue(username);
    });

    this.refreshService.passwordSource.subscribe(password => {
      this.loginForm.get('password').setValue(password);
    });
  }

  login() {
    //username and password check
    this.loginRequest.username = this.loginForm.get('username').value;
    this.loginRequest.password = this.loginForm.get('password').value;

    //loginrequest send to authentication
    this.authService.authenticate(this.loginRequest).subscribe(data => {
      this.isError = false;
      //this.router.navigateByUrl('/home');
      console.log("login successful!");

      const jsonString = JSON.stringify(data, null, 2);
      console.log(jsonString)

      const Json =this.authService.authenticate(this.loginRequest);
      console.log(data.valueOf());
      //this.toastr.success('Login Successful','Success', {
      //positionClass: 'toast-top-center'
      });
      // if success emit is executed
      this.loginSuccess.emit();

      //this.resetInput();
      this.refreshService.triggerNavImageRefresh();
    };//, error => {
      //this.isError = true;
      //throwError(error);
      //this.toastr.error('Username or Password are not right!','Error!', {
       // positionClass: 'toast-top-center'
      //});

  //todo reset input is not used yet
  resetInput(){
    this.loginForm.get('username').setValue('');
    this.loginForm.get('password').setValue('');
  }

  // toggles password visibility
  togglePasswordVisibility(input: HTMLInputElement): void {
    input.type = input.type === 'password' ? 'text' : 'password';
    this.passwordVisible = !this.passwordVisible;
  }


}
