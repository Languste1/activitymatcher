import {EventEmitter, Injectable, Output} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map, Observable, throwError} from 'rxjs';
import {BehaviorSubject} from 'rxjs';
import {User} from "../interfaces/user";
import {RefreshService} from "./refresh.service";
import {RegisterRequest} from "../interfaces/register-request";
import {AuthenticationRequest} from "../interfaces/AuthenticationRequest";
import {AuthenticationResponse} from "../interfaces/AuthenticationResponse";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  @Output() loggedIn: EventEmitter<boolean> = new EventEmitter();
  @Output() username: EventEmitter<string> = new EventEmitter();
  @Output() role: EventEmitter<string> = new EventEmitter();

  //refreshTokenPayload = {
  //refreshToken: this.getJwtToken(),
  //username: this.getUsername(),
  //role: this.getRole()
  //}
  private apiUrl = 'http://localhost:8080';
  private authStatus = new BehaviorSubject<boolean>(false);


  constructor(private http: HttpClient, private refreshService: RefreshService) {
  }


  register(request: RegisterRequest): Observable<AuthenticationResponse> {
    return this.http.post<AuthenticationResponse>(`${this.apiUrl}/register`, request);
  }

  getUserByUsername(username: string): Observable<User> {
    return this.http.get<User>("http://localhost:8080/api/users/" + username);
  }


  // authentication checks if user and password are correct or even available
  authenticate(request: AuthenticationRequest): Observable<boolean> {
    return this.http.post<AuthenticationResponse>(`${this.apiUrl}/authenticate`,
      request).pipe(map(data => {
      //this.localStorage.store('username', data.username);
      //this.localStorage.store('token', data.token);
      //this.localStorage.store('role', data.role);

      this.loggedIn.emit(true);
      this.username.emit(data.username);
      //this.role.emit(data.role);
      return true;
    }));
  }

  /*
  logout() {
    this.http.post(`${this.apiUrl}/logout`, this.refreshTokenPayload,
      {responseType: 'text'})
      .subscribe(data => {
        console.log(data);
      }, error => {
        throwError(error);
      })
    this.localStorage.clear('token');
    this.localStorage.clear('username');
    this.localStorage.clear('role');
    this.localStorage.clear('refreshToken');
  }

  getJwtToken() {
    return this.localStorage.retrieve('token');
  }

  setAuthStatus(status: boolean) {
    this.authStatus.next(status);
  }

  getAuthStatus(): Observable<boolean> {
    return this.authStatus.asObservable();
  }

  getUsername() {
    return this.localStorage.retrieve('username');
  }

  getRefreshToken() {
    return this.localStorage.retrieve('refreshToken');
  }

  isLoggedIn(): boolean {
    return this.getJwtToken() != null;
  }


   */

  /*
  getRole() {
    return this.localStorage.retrieve('role');
  }

   */
}
