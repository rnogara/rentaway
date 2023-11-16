import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})

export class CarsService {
  constructor(private http:HttpClient) {}

  private url = 'http://localhost:8080/';

  public avaiableCars(clientId: String): Observable<any> {
    return this.http.get<any>(this.url + 'rent/' + clientId);
  }
}