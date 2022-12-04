import {Component, OnInit} from '@angular/core';
import {TokenService} from '../Service/token.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  check = false;
  avatar: string;

  constructor(
    private tokenService: TokenService, private router: Router) {

  }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.check = true;
      this.avatar = this.tokenService.getAvatar();
    }
  }

  getLogout() {
    this.tokenService.getLogout();
  }
}
