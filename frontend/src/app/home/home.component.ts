import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarsComponent } from '../cars/cars.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, CarsComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {
  
}
