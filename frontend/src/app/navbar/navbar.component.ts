import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent {
  clientId: string | null = null;
  constructor() {
    if (typeof window !== 'undefined') {
      this.clientId = JSON.parse(window.localStorage.getItem('clientId') || 'null');
    }
  }
}
