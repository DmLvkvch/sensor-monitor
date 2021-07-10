import { Component, OnInit, ViewChild } from '@angular/core';
import { SensorService } from './sensor.service';
import { PageInfo, Sensor } from './sensor.model';
import { NgbModalRef, NgbModal, NgbModalOptions } from '@ng-bootstrap/ng-bootstrap';

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

    modalReference: NgbModalRef;

    modalOption: NgbModalOptions = {};

    constructor(private modalService: NgbModal,  private sensorService: SensorService) { }

    ngOnInit() {
        this.getSensors()
    }

    getSensors(){
        this.sensorService.findAll().subscribe((data)=>{
            this.sensors = JSON.parse(data.toString())['results'];
        }
    );
    }

    onCreate(content){
        this.sensor = null
        this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((res) => {
        }, (res) => {
            console.log(res+"res")
        });
    }

    onSearchClicked(value: string){
        this.sensorService.getSensorBySearch(value).subscribe(result => {
            this.sensors = JSON.parse(result.toString())['results'];
            
        });
    }

    onDelete(id){
        this.sensorService.deleteSensor(id).subscribe((result)=>{
            this.getSensors()
        });
        
    }

    onEdit(id: number, content){
        this.id = id;
        this.modalService.open(content).result.then((res) => {}, 
        (res) => {
        });
    }

    logout() {
        sessionStorage.setItem('token', '');
    }

    modalClosed(isUpdated) {
        this.getSensors()
        this.modalService.dismissAll()
    }
}