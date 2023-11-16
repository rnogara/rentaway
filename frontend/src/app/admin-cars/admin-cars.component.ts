import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarsService } from './cars.service';
import { Car } from './car';

@Component({
  selector: 'app-admin-cars',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './admin-cars.component.html',
  styleUrl: './admin-cars.component.css',
  providers: [CarsService]
})
export class AdminCarsComponent {
  constructor(private carsService:CarsService){};

  car: Car = new Car();

  cars: Car[] = [];

  ngOnInit(): void {
    this.carsService.getCars().subscribe(
      resposta => {
        this.cars = resposta;
      },
      error => {
        console.log("Error: ", error);
      }
    );
  }

  deleteCar(idCar: number): void {
    this.carsService.deleteCar(idCar).subscribe(
      resposta => {
        this.cars = resposta;
        window.location.reload();
      },
      error => {
        console.log("Error: ", error);
      }
    );
  }

}
