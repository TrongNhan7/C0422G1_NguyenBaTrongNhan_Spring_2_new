import {Component, OnInit} from '@angular/core';
import {LoginService} from '../Service/login.service';
import {LoginRequest} from '../model/LoginRequest';
import {Router} from '@angular/router';
import {TokenService} from '../Service/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  token: string = '';

  account: LoginRequest = new class implements LoginRequest {
    email: string;
    password: string;
  };

  constructor(private loginService: LoginService, private router: Router, private tokenStorageService: TokenService) {

  }

  ngOnInit(): void {
  }

  userLogin() {

    this.loginService.getLogin(this.account).subscribe(n => {
      if (n.token != undefined) {
        this.tokenStorageService.setToken(n.token);
        this.tokenStorageService.setName(n.username);
        this.tokenStorageService.setRole(n.roles);
        this.tokenStorageService.setAvatar(n.avatar);
      }
    }, error => {
      alert('sai tên tài khoản hoặc mk');
    }, () => {
      this.router.navigateByUrl('/');
    });
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username');
    console.log(!(user === null));
    return !(user === null);
  }
}
