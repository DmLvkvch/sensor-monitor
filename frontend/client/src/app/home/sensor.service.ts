import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Sensor, SensorType, SensorUnit } from './sensor.model'
import { Observable } from 'rxjs';

@Injectable()
export class SensorService {

  private sensorsUrl: string;
  private headers: HttpHeaders;

  constructor(private http: HttpClient) {
    this.sensorsUrl = 'http://localhost:8080/api/sensors';
    this.headers = new HttpHeaders({
        'Authorization': 'Basic ' + sessionStorage.getItem('token')
    });
  }

  public findAll(): Observable<Object> {
    return this.http.get<Object>(this.sensorsUrl, {headers: this.headers , responseType: 'text' as 'json'});
  }

  public getSensor(id: number): Observable<Sensor> {
    return this.http.get<Sensor>(this.sensorsUrl+'/'+id, {headers: this.headers , responseType: 'text' as 'json'});
  }

  public getSensorBySearch(text: string): Observable<Object> {
    return this.http.get<Object>(this.sensorsUrl+'?'+'search='+text, {headers: this.headers , responseType: 'text' as 'json'});
  }

  public deleteSensor(id: number): Observable<Object> {
    return this.http.delete<Object>(this.sensorsUrl+'/'+id, {headers: this.headers , responseType: 'text' as 'json'});
  }

  public getUnits(): Observable<SensorUnit[]>{
    return this.http.get<SensorUnit[]>(this.sensorsUrl+'/units', {headers: this.headers , responseType: 'text' as 'json'}); 
  }

  public getTypes(): Observable<SensorType[]>{
    return this.http.get<SensorType[]>(this.sensorsUrl+'/types', {headers: this.headers , responseType: 'text' as 'json'}); 
  }

  public updateSensor(sensor: Sensor): Observable<Object>{
    return this.http.post<Object>(this.sensorsUrl, sensor, {headers: this.headers , responseType: 'text' as 'json'})
  }
}