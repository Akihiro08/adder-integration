import {Component, Input, OnInit} from '@angular/core';
import {AdderService} from "./adder.service";
import {filter, map} from "rxjs/operators";
import {stringify} from "querystring";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'adder-front';

  @Input()
  current = 0;
  random = 0;
  num = 0;

  constructor(private service: AdderService) {
  }

  ngOnInit(): void {
    this.getCurrent();
  }

  getCurrent() : void{
    this.service.current()
      .subscribe(
        (num: number) => this.current = num
      );
  }

  setBase(base: number) : void {
    this.service.setBase(base)
      .subscribe(
        (server) => {
          if(!!server['server']['response'] && server['server']['response'] === 'Ok') {
            this.current = base;
          }
        }
      );
  }

  getRandom() : void {
    this.service.random()
      .subscribe(
        (rand: number) => this.random = rand
      );
  }

  accumulate(num: number) : void {
    this.service.accumulate(num)
      .subscribe(
        (num: number) => {
          this.current = num;
          this.num = num;
        }
      );
  }

  add(num: number) : void {
    this.service.add(num)
      .subscribe(
        (num: number) => this.num = num
      )
  };
}
