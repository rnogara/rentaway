import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Car } from "./car";

@Injectable({
  providedIn: 'root'
})

export class CarsService {
  constructor(private http:HttpClient) {}

  private url = 'http://localhost:8080/';

  public getCars(): Observable<Car[]> {
    return this.http.get<any>(this.url);
  }
}