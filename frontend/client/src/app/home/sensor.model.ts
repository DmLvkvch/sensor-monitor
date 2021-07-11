export class Sensor {
  constructor(
    public id: number = 0,
    public name: string = "",
    public model: string = "",
    public type: SensorType = null,
    public unit: SensorUnit = null,
    public location: string = "",
    public description: string = "",
    public range: SensorRange = new SensorRange(0, 1)
  ) {
  }
}

export class PageInfo {
  constructor(public next: string, public prev: string, public pages: number, public count: string) { }
}

export class SensorRange {
  constructor(public from: number, public to: number) { }
}

export class SensorType {
  constructor(public id: number, public name: string) { }
}

export class SensorUnit {
  constructor(public id: number, public name: string) { }
}