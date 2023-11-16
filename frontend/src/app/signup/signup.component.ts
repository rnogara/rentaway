import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Client } from './client';
import { ClientsService } from './clients.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css',
  providers: [ClientsService]
})
export class SignupComponent {
  constructor(private clientsService:ClientsService){};

  client: Client = new Client();

  clientId: string | null = null;

  name: string = '';
  email: string = '';
  password: string = '';

  signup(name: string, email: string, password: string): void {
    this.clientsService.signup(name, email, password).subscribe(
      resposta => {
        this.client = resposta;
        if (this.client.id == null || this.client.name == null) {
          alert("Incorrect email or password.");
          return;
        }
        window.localStorage.setItem('clientId', this.client.id);
        window.localStorage.setItem('clientName', this.client.name);
        window.location.href = '/profile/' + this.client.id;
      },
      error => {
        console.log("Error: ", error);
        return;
      }
    )
  }
}
