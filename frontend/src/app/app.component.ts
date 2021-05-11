import { Component, OnInit } from '@angular/core';
import { Persona } from './models/persona';
import { AppService } from './services/app.service';
import Swal from 'sweetalert2/dist/sweetalert2.js'
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  listPersons:Persona[] = [];
  persona:Persona = new Persona();
  constructor(private _srv:AppService){}

  ngOnInit(): void {
    this.loadPersons();
  }

  validPerson(form){
    if(this.persona.edad >= 18){
      this.createPerson(this.persona, form);
    }else{
      Swal.fire('Persona no creada', 'La persona es menor de edad', 'error');
    }
  }

  private loadPersons(){
    this._srv.getPersons()
    .subscribe( (data:Persona[]) =>{
      this.listPersons = data;
    },err=>{
      console.error(err);
      this.listPersons = [];
      Swal.fire('Persona no creada', JSON.stringify(err), 'error');
    });
  }

  private createPerson(p:Persona, form:NgForm){
    this._srv.postPerson(p)
    .subscribe(data=>{
      Swal.fire('Persona creada', 'Exitosamente!', 'success');
      this.listPersons.push(p);
      this.persona = new Persona();
      form.resetForm();
    },err=>{
      this.persona = new Persona();
      form.resetForm();
      console.error(err);
      Swal.fire('Persona no creada', JSON.stringify(err), 'error');
    });
  }

}
