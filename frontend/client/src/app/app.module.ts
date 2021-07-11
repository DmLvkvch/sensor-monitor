import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppComponent } from './app.component';
import { routing } from './app.routing';
import { HomeComponent } from './home/home.component';
import { SensorService } from './home/sensor.service';
import { LoginComponent } from './login/login.component';
import { SensorDetailsComponent } from './sensor-details/sensor-details.component';
import { MatTooltipModule } from '@angular/material/tooltip';

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        MatTableModule,
        NgbModule,
        ReactiveFormsModule,
        MatPaginatorModule,
        MatTooltipModule,
        routing
    ],
    declarations: [
        AppComponent,
        HomeComponent,
        LoginComponent,
        SensorDetailsComponent
    ],
    providers: [SensorService],
    bootstrap: [AppComponent]
})

export class AppModule { }