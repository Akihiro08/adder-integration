import { Injectable } from '@angular/core';
import {environment} from "../environments/environment";
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {filter} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AdderService {
  private readonly backendURL: any;

  constructor(private http: HttpClient) {
    this.backendURL = {};

    let baseUrl = `${environment.backend.protocol}://${environment.backend.host}`;
    if (environment.backend.port) {
      baseUrl += `:${environment.backend.port}`;
    }

    Object.keys(environment.backend.endpoints).forEach(i => this.backendURL[ i ] = `${baseUrl}${environment.backend.endpoints[ i ]}`);
  }

  add(num: number): Observable<number> {
    return this.http.post<number>(this.backendURL.add.replace(':num', num),  this._options())
      .pipe(
        filter(_ => !!_)
      );
  }

  accumulate(num: number): Observable<number> {
    return this.http.post<number>(this.backendURL.accumulate.replace(':num', num),  this._options())
      .pipe(
        filter(_ => !!_)
      );
  }

  current(): Observable<number> {
    return this.http.get<number>(this.backendURL.getCurrent)
      .pipe(
        filter(_ => !!_)
      );
  }

  setBase(num: number): Observable<any> {
    return this.http.post<number>(this.backendURL.setBase.replace(':num', num),  this._options())
      .pipe(
        filter(_ => !!_)
      );
  }

  random(): Observable<number> {
    return this.http.get<number>(this.backendURL.getRandom)
      .pipe(
        filter(_ => !!_)
      );
  }

  private _options(headerList: object = {}): any {
    return { headers: new HttpHeaders(Object.assign({ 'Content-Type': 'text/html' }, headerList)) };
  }
}
