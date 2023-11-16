import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminCarsComponent } from '../admin-cars/admin-cars.component';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [CommonModule, AdminCarsComponent],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {

}
