import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { Product } from '../common/product';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private baseUrl = 'http://localhost:8080/api/productsgit';

  constructor(private httpClient: HttpClient) {}

  getProductList(): Observable<Product[]> {
    // maps the json data from spring data rest to product array
    return this.httpClient
      .get<GetResponse>(this.baseUrl)
      .pipe(map((response) => response._embedded.products));
  }
}

interface GetResponse {
  // unwraps the json from spring data rest _embedded entry
  _embedded: {
    products: Product[];
  };
}
