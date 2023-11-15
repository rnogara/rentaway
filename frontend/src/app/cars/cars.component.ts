import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarsService } from './cars.service';
import { Car } from './car';


@Component({
  selector: 'app-cars',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cars.component.html',
  styleUrl: './cars.component.css'
})
export class CarsComponent {
  constructor(private carsService:CarsService){};

  car: Car = new Car();

  cars: Car[] = [];

  ngOnInit(): void {
    this.carsService.recuperarCarros().subscribe(
      resposta => {
        this.cars = resposta;
      },
      error => {
        console.log("Error: ", error);
      }
    );
  }
}
