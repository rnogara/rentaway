import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { AdminComponent } from './admin/admin.component';
import { RentComponent } from './rent/rent.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { ProfileBookingComponent } from './profile-booking/profile-booking.component';
import { AdminBookingsComponent } from './admin-bookings/admin-bookings.component';
import { AdminClientsComponent } from './admin-clients/admin-clients.component';
import { AdminCarsComponent } from './admin-cars/admin-cars.component';

export const routes: Routes = [
  {path: '', component: HomeComponent, pathMatch: 'full'},

  {path: 'profile/:id', component: ProfileComponent, children: [
    {path: 'bookings', component: ProfileBookingComponent},
  ]},

  {path: 'admin', component: AdminComponent, children: [
    {path: 'bookings', component: AdminBookingsComponent},
    {path: 'clients', component: AdminClientsComponent},
    {path: 'cars', component: AdminCarsComponent}
  ]},
  
  {path: 'rent/:id', component: RentComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  {path: '**', redirectTo: ''}
];
