import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})

export class BookingsService {
  constructor(private http:HttpClient) {}

  private url = 'http://localhost:8080/';

  public getBookings(): Observable<any> {
    return this.http.get<any>(this.url + 'admin/bookings');
  }
}