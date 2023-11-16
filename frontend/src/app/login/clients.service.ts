import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";


@Injectable({
  providedIn: 'root'
})

export class ClientsService {
  constructor(private http:HttpClient) {}

  private url = 'http://localhost:8080/';

  // public getClients(): Observable<Client[]> {
  //   return this.http.get<any>(this.url);
  // }

  public login(email: string, password: string): Observable<any> {
    return this.http.post<any>(this.url + 'login', {email, password}, {responseType: 'json'});
  }

}