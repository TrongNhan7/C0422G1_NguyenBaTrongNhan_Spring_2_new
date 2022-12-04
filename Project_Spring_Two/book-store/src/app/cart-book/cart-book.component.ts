import {Component, OnInit} from '@angular/core';
import {ShopService} from '../Service/shop.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cart-book',
  templateUrl: './cart-book.component.html',
  styleUrls: ['./cart-book.component.css']
})
export class CartBookComponent implements OnInit {

  carts: any = [];
  totalMoney: number = this.shopService.getTotalMoney();

  constructor(private shopService: ShopService) {

  }

  ngOnInit(): void {
    this.carts = this.shopService.getCart();
  }

  subTotal(cart: any) {
    return cart.quantity * cart.price;
  }

  updateQuantity(i: number, event: any) {
    let newQuantity = event.target.value;
    newQuantity = newQuantity > 0 ? newQuantity : 1;
    newQuantity = newQuantity <= 100 ? newQuantity : 100;
    event.target.value = newQuantity;
    this.carts[i].quantity = event.target.value;
    this.shopService.saveCart(this.carts);
    this.totalMoney = this.shopService.getTotalMoney();
  }

  increase(i: number, quantity: any) {
    let newQuantity = parseInt(quantity) + 1;
    newQuantity = newQuantity > 0 ? newQuantity : 1;
    this.carts[i].quantity = newQuantity;
    this.shopService.saveCart(this.carts);
    this.totalMoney = this.shopService.getTotalMoney();
  }

  reduce(i: number, quantity: any) {
    let newQuantity = parseInt(quantity) - 1;
    newQuantity = newQuantity > 0 ? newQuantity : 1;
    newQuantity = newQuantity <= 100 ? newQuantity : 100;
    this.carts[i].quantity = newQuantity;
    this.shopService.saveCart(this.carts);
    this.totalMoney = this.shopService.getTotalMoney();
  }

  removeCart(i: number) {
    let this2 = this;
    Swal.fire({
      title: 'Bạn chắc chưa?',
      text: 'Hành động này không thể hoàn tác!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Đồng ý!',
      cancelButtonText: 'Hủy!',
    }).then(function (isConfirm: any) {
      if (isConfirm.isConfirmed) {
        Swal.fire(
          'Xóa!',
          'Đã xóa sách khỏi giỏ hàng',
          'success'
        );
        this2.carts.splice(i, 1);
        this2.shopService.saveCart(this2.carts);
        this2.totalMoney = this2.shopService.getTotalMoney();
      }
    })

  }
}
