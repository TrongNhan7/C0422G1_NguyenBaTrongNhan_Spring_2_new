import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import {BookDetailComponent} from './book-detail/book-detail.component';
import {CartBookComponent} from './cart-book/cart-book.component';


const routes: Routes = [
  {path: 'header', component: HeaderComponent},
  {path: 'footer', component: FooterComponent},
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'detail', component: BookDetailComponent},
  {path: 'cart', component: CartBookComponent},
  {path: 'book-detail/:id', component: BookDetailComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
