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

    public page: any = {count: 0, size: 4, currentPage: 0}

    pageEvent: PageEvent;

    constructor(private router: Router, private modalService: NgbModal, private sensorService: SensorService) { }

    ngOnInit() {
        this.getSensors()
    }

    getSensors(page: number = 1) {
        this.sensorService.getSensorBySearch(page, this.search).subscribe((data) => {
            this.sensors = JSON.parse(data.toString())['results'];
            let tmp = JSON.parse(data.toString())['info'];
            this.buildPage(tmp)
        }, error=>{
            this.logout()
        }
        );
    }

    buildPage(info: PageInfo){
        this.page.count = info.count;
    }

    onCreate(content) {
        this.sensor = null
        this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then((res) => {
        }, (res) => {
        });
    }

    onSearchClicked(page = 1, value: string) {
        this.search = value
        this.sensorService.getSensorBySearch(page, this.search).subscribe(result => {
            this.sensors = JSON.parse(result.toString())['results'];
            let tmp = JSON.parse(result.toString())['info'];
            this.buildPage(tmp)
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

    public handlePage(event?: PageEvent) {
        this.page.currentPage = event.pageIndex
        this.getSensors(event.pageIndex+1)
        return event;
    }

    modalClosed(isUpdated) {
        this.getSensors(this.page.currentPage+1)
        this.modalService.dismissAll()
    }
}