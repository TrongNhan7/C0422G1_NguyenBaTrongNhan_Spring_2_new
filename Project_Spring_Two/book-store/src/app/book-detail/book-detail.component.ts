import {Component, OnInit} from '@angular/core';
import {ShopService} from '../Service/shop.service';
import {IBookDto} from '../model/book';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {TokenService} from '../Service/token.service';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {

  book: IBookDto = null;
  id: number ;

  constructor(private shopService: ShopService, private router:Router,private route: ActivatedRoute, private tokenService:TokenService) {
    this.route.paramMap.subscribe((param: ParamMap)=> {
     this.id = +param.get("id")
   })
  }

  ngOnInit(): void {
    if (this.tokenService.getToken() != undefined){
      this.shopService.getDetailBook(this.id).subscribe(n => {
        console.log(n);
        this.book = n ;
      })
    }else {
      this.router.navigateByUrl('login')
    }
  }
}
