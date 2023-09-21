import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { HttpClientModule } from '@angular/common/http';
import { ProductService } from './services/product.service';
import { NgOptimizedImage } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'category/:id',
    component: ProductListComponent,
  },
  {
    path: 'category',
    component: ProductListComponent,
  },
  {
    path: 'products',
    component: ProductListComponent,
  },
  {
    path: '',
    component: ProductListComponent,
  },
  {
    path: '',
    redirectTo: '/products',
    pathMatch: 'full',
  },
  // generic wildcard, it will match on anything that doesnt match above routes
  {
    path: '**',
    redirectTo: '/products',
    pathMatch: 'full',
  },
];

@NgModule({
  declarations: [AppComponent, ProductListComponent],
  imports: [BrowserModule, HttpClientModule, RouterModule.forRoot(routes)],
  providers: [ProductService],
  bootstrap: [AppComponent],
})
export class AppModule {}
