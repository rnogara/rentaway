import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileBookingComponent } from '../profile-booking/profile-booking.component';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [CommonModule, ProfileBookingComponent],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {
  clientId: string | null = null;
  // clientName: string | null = null;

  constructor() {
    if (typeof window !== 'undefined') {
      this.clientId = JSON.parse(window.localStorage.getItem('clientId') || 'null');
      // this.clientName = JSON.parse(window.localStorage.getItem('clientName') || 'null');
    }
  }

  rentBtn(): void {
    window.location.href = '/rent/' + this.clientId;
  } 

  bookingBtn(): void {
    window.location.href = '/profile/' + this.clientId + '/bookings';
  } 
}
