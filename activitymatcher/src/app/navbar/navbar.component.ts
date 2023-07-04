import {Component, EventEmitter, Output} from '@angular/core';
import {AuthService} from "../services/auth.service";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {LocalStorageService} from "../services/local-storage.service";
import {RefreshService} from "../services/refresh.service";
import {User} from "../interfaces/user";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  isLoggedIn: boolean = false;
  username: string | any;
  role?: string;
  selectedImage?: File;
  enduser?: User;
  fileInput: any;
  timerValue: number = 60;
  isPlaying: boolean = false;
  logo: string = "";

  @Output() showLogin = new EventEmitter<void>();
  @Output() showRegister = new EventEmitter<void>();


  constructor(
    private authService: AuthService,
    private router: Router,
    private http: HttpClient,
    private localStorage: LocalStorageService,
    private refreshService: RefreshService,

  ) {
  }


  ngOnInit() {
    this.authService.loggedIn.subscribe((data: boolean) => this.isLoggedIn = data);
    this.authService.username.subscribe((data: string) => this.username = data);
    this.authService.role.subscribe((data: string) => this.role = data);
    //this.isLoggedIn = this.authService.isLoggedIn();
    //this.username = this.authService.getUsername();
    //this.role = this.authService.getRole();
    this.authService.getUserByUsername(this.username).subscribe((user: User) => {
      this.enduser = user
    });
  }



  // logout() {
  //   this.authService.logout();
  //   this.isLoggedIn = false;
  //   this.router.navigateByUrl('');
  //   this.enduser = undefined;
  // }



  toggleDarkMode(): void {
    document.body.classList.toggle('dark-mode');

    this.refreshService.setDarkmode(!this.refreshService.getDarkmode());
  }

}
