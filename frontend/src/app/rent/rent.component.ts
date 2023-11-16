import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CarsService } from './cars.service';
import { Car } from './car';
import { BookingsService } from './bookings.service';
import { Book } from './book';

@Component({
  selector: 'app-rent',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './rent.component.html',
  styleUrl: './rent.component.css',
  providers: [CarsService, BookingsService]
})
export class RentComponent {
  constructor(private carsService:CarsService, private bookingsService:BookingsService){
    if (typeof window !== 'undefined') {
      this.idClient = JSON.parse(window.localStorage.getItem('clientId') || 'null');
    }
  };
  
  idClient: string | null = null;
  
  car: Car = new Car();
  
  cars: Car[] = [];

  carPricePerDay: number = 0;
  
  rentForm: FormGroup = new FormGroup({});

  idCar: number | null = null;
  startDate: Date | null = null;
  endDate: Date | null = null;
  totalPrice: number | null = null;

  ngOnInit(): void {
    this.rentForm = new FormGroup({
      'idCar': new FormControl(null),
      'idClient': new FormControl(null),
      'startDate': new FormControl(Date.now()),
      'endDate': new FormControl(Date.now() + 1),
    });
    this.carPricePerDay = this.cars.find(car => car.idCar == this.idCar)?.pricePerDay || 0;
    if (this.startDate && this.endDate) {
      this.totalPrice = (this.endDate.getTime() - this.startDate.getTime()) / (1000 * 60 * 60 * 24) * this.carPricePerDay;
    } else {
      this.totalPrice = null;
    }
    if (this.idClient != null) {
      console.log("idClient: ", this.idClient);
      this.carsService.avaiableCars(String(this.idClient)).subscribe(
        resposta => {
          console.log("Resposta: ", resposta);
          this.cars = resposta;
        },
        error => {
          console.log("Error: ", error);
        }
      );
    }
  }

  book = {
    idBooking: null,
    idCar: this.idCar?.toString() || null,
    idClient: this.idClient,
    startDate: this.startDate,
    endDate: this.endDate,
    totalPrice: this.totalPrice
  }

  submit() {
    console.log('passou aqui');
    
    if (this.idClient != null && this.book != null) {
      this.bookingsService.book(this.idClient, this.book as Book).subscribe();
    }
  }
}
