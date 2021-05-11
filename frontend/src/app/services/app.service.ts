import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Persona } from '../models/persona';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private _http:HttpClient) { }


  getPersons(){
    return this._http.get(environment.getPersona);
  }

  postPerson(per:Persona){
    return this._http.post(environment.postPersona, per);
  }
}
