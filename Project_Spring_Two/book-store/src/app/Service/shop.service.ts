import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {TokenService} from './token.service';

@Injectable({

  providedIn: 'root'
})
export class ShopService {

  tokenRequest: string;
  httpOption: any;

  constructor(private httpClient: HttpClient, private tokenService: TokenService) {
    this.tokenRequest = this.tokenService.getToken();
    this.httpOption = {
      headers: new HttpHeaders({
        'Content_Type': 'application/json',
        Authorization: 'Bearer ' + this.tokenRequest
      })
    };
  }

  getShop(title: string, author: string, page: number): Observable<any> {

    return this.httpClient.get('http://localhost:8080/public/shop?title=' + title + '&author=' + author + '&page=' + page);
  }

  getDetailBook(id: number): Observable<any> {

    return this.httpClient.get('http://localhost:8080/api/user/book/' + id, this.httpOption);

  }

  getCart() {
    let cartJson = sessionStorage.getItem('cart');
    if (cartJson) {
      return JSON.parse(cartJson);
    } else {
      return [];
    }
  }

  saveCart(cart: any) {
    let cartJson = JSON.stringify(cart);
    sessionStorage.setItem('cart', cartJson);
  }

  getTotalMoney() {
    let cart = this.getCart();
    let total = 0;
    cart.forEach((item: any) => {
      total += item.price * item.quantity;
    });
    return total;
  }
}
