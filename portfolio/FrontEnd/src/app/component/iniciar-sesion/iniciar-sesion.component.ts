import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-iniciar-sesion',
  templateUrl: './iniciar-sesion.component.html',
  styleUrls: ['./iniciar-sesion.component.scss']
})
export class IniciarSesionComponent implements OnInit {
form:FormGroup
constructor(private formBuilder:FormBuilder, private ruta:Router){
this.form=this.formBuilder.group(

{
  email:['',[Validators.required,Validators.email]],
  password:['',[Validators.required,Validators.minLength(8)]],
  deviceinfo:this.formBuilder.group ({
  deviceId: ["17867868768"],
  deviceType: ["DEVICE_TYPE_ANDROID"],
  notificationToken: ["67657575eececc34"]
})
}
)
 
}


ngOnInit(): void {

}

get Email(){
  return this.form.get('email');
} 

get Password(){
  return this.form.get('password');
}


    }


