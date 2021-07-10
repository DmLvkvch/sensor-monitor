import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent }  from './app.component';
import { routing }        from './app.routing';

import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

import { MatTableModule } from '@angular/material/table'  
import { SensorService } from './home/sensor.service';;
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule } from '@angular/forms';;
import { SensorDetailsComponent } from './sensor-details/sensor-details.component'

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        MatTableModule,
        NgbModule,
        ReactiveFormsModule,
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