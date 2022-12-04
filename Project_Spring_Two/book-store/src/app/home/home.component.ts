import {Component, OnInit} from '@angular/core';
import {ShopService} from '../Service/shop.service';
import {IBookDto} from '../model/book';
import {TokenService} from '../Service/token.service';
import Swal from 'sweetalert2';
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  books: IBookDto[];
  title: string = '';
  author: string = '';
  totalPage: number;
  page: number = 0;
  cart = this.shopService.getCart();
  check = false;

  constructor(private shopService: ShopService, private tokenService: TokenService,private router:Router) {

  }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.check = true;
    }
    this.getAllAndSearchBook();
    console.log(this.cart);
  }

  getAllAndSearchBook() {
    this.page = 0;
    this.shopService.getShop(this.title, this.author, this.page).subscribe(n => {
      this.books = n.content;
      this.totalPage = n.totalPages;
    });

  }

  next() {
    this.page = this.page + 1;

    return this.shopService.getShop(this.title, this.author, this.page).subscribe(n => {

      this.books = n.content;

      this.totalPage = n.totalPage;
    });
  }

  previous() {
    this.page = this.page - 1;

    return this.shopService.getShop(this.title, this.author, this.page).subscribe(n => {

      this.books = n.content;

      this.totalPage = n.totalPage;
    });
  }

  addToCart(book: IBookDto) {
    if (this.check==true) {
      let idx = this.cart.findIndex((item: any) => {
        return item.id == book.id;
      });
      if (idx >= 0) {
        this.cart[idx].quantity += 1;
      } else {
        let cartItem: any = {
          id: book.id,
          title: book.title,
          imageUrl: book.imageUrl,
          author: book.author,
          price: book.price,
          quantity: 1,
          subtotal: function () {
            return this.price * this.quantity;
          }
        };
        this.cart.push(cartItem);
      }
      this.shopService.saveCart(this.cart);
      Swal.fire({
        title: 'Thêm vào giỏ thành công',
        icon: 'success',
        timer: 800,
        confirmButtonColor: '#ff00ff'
      });
    } else {
      this.router.navigateByUrl('login')
    }
  }


}
