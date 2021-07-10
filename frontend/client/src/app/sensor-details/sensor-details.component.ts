import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Sensor, SensorRange, SensorType, SensorUnit } from '../home/sensor.model';
import { SensorService } from '../home/sensor.service';

@Component({
  selector: 'app-sensor-details',
  templateUrl: './sensor-details.component.html'
})
export class SensorDetailsComponent implements OnInit {

  @Input()
  public id: number = 0;

  public sensor: Sensor;

  public units: SensorUnit[];

  public types: SensorType[];

  @Output()
  onClose: EventEmitter<boolean> = new EventEmitter();

  @Output()
  onUpdate: EventEmitter<boolean> = new EventEmitter();

  constructor(private sensorService: SensorService) {
    this.sensor = new Sensor()
   }

  profileForm = new FormGroup({
    name: new FormControl(''),
    type: new FormControl(new SensorType(0, "")),
    location: new FormControl(''),
    description: new FormControl(''),
    model: new FormControl(''),
    unit: new FormControl(new SensorUnit(0, "")),
    range: new FormGroup({
      from: new FormControl(0),
      to: new FormControl(1)
    })
  });

  ngOnInit(): void {
    this.sensorService.getUnits().subscribe(result=>{
      this.units = JSON.parse(result.toString())
      this.profileForm.patchValue({
        unit: this.sensor.unit
      })
    })

    this.sensorService.getTypes().subscribe(result=>{
      this.types = JSON.parse(result.toString())
      this.profileForm.patchValue({
        type: this.sensor.type
      })
    })
    if(this.id===0){
        this.sensor = new Sensor()
    }else{
        this.sensorService.getSensor(this.id).subscribe(result => { 
            this.sensor = JSON.parse(result.toString());
            this.profileForm.patchValue({
              type: this.sensor.type
            })
            this.profileForm.patchValue({
              unit: this.sensor.unit
            })
        })
    }
  } 
  onSubmit(){
    let updatedSensor = this.profileForm.value
    updatedSensor.id = this.id
    console.log(updatedSensor)
    this.sensorService.updateSensor(updatedSensor).subscribe(result => { 
      this.onClose.emit(true)
    })
  }

  onCancel(){
    this.closeModal()
  }

  closeModal() {
    this.onClose.emit(true);
  }
}
