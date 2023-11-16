import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ClientsService } from './clients.service';
import { Client } from './client';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [ClientsService]
})
export class LoginComponent {
  constructor(private clientsService:ClientsService){};

  client: Client = new Client();

  clientId: string | null = null;

  email: string = '';
  password: string = '';

  login(email: string, password: string): void {
    this.clientsService.login(email, password).subscribe(
      resposta => {
        this.client = resposta;
        if (this.client.id == null) {
          alert("Incorrect email or password.");
          return;
        }
        window.localStorage.setItem('clientId', this.client.id);
        window.location.href = '/profile/' + this.client.id;
      },
      error => {
        console.log("Error: ", error);
        return;
      }
    )
  }
}
