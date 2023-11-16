import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Book } from "./book";

@Injectable({
  providedIn: 'root'
})

export class BookingsService {
  constructor(private http:HttpClient) {}

  private url = 'http://localhost:8080/';

  public book(idClient: string, book: Book): Observable<any> {
    return this.http.post<any>(this.url + 'rent/' + idClient, book);
  }
}