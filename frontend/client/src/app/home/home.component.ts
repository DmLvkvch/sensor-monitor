import { Component, OnInit, ViewChild } from '@angular/core';
import { SensorService } from './sensor.service';
import { PageInfo, Sensor } from './sensor.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { PageEvent } from '@angular/material/paginator';
import { Router } from '@angular/router';

@Component({
    selector: 'home',
    templateUrl: './home.component.html'
})

export class HomeComponent implements OnInit {

    public sensors: Sensor[];

    public sensor: Sensor;

    public id: number;

    public search: string;

    public page: PageInfo;

    pageEvent: PageEvent;

    constructor(private router: Router, private modalService: NgbModal, private sensorService: SensorService) { }

    ngOnInit() {
        this.getSensors()
    }

    getSensors(page: number = 1) {
        this.sensorService.findAll().subscribe((data) => {
            this.sensors = JSON.parse(data.toString())['results'];
            let tmp = JSON.parse(data.toString())['info'];
            let curPage = 1;
        }, error=>{
            this.logout()
        }
        );
    }

    onCreate(content) {
        this.sensor = null
        this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then((res) => {
        }, (res) => {
        });
    }

    onSearchClicked(value: string) {
        this.sensorService.getSensorBySearch(value).subscribe(result => {
            this.sensors = JSON.parse(result.toString())['results'];
        });
    }

    onDelete(id) {
        this.sensorService.deleteSensor(id).subscribe((result) => {
            this.getSensors()
        });
    }

    onEdit(id: number, content) {
        this.id = id;
        this.modalService.open(content).result.then((res) => { },
            (res) => {
            });
    }

    logout() {
        sessionStorage.setItem('token', '');
        this.router.navigate(['login']);
    }

    public getServerData(event?: PageEvent) {
        this.getSensors(event.pageIndex)
        return event;
    }

    modalClosed(isUpdated) {
        this.getSensors()
        this.modalService.dismissAll()
    }
}