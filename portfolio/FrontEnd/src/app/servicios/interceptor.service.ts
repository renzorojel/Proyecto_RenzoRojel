import { Injectable } from '@angular/core';
import { AutenticacionService } from './autenticacion.service';
import { HttpEvent, HttpHandler, HttpHeaders, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InterceptorService {

  constructor(
    private servicioAutenticacion: AutenticacionService
  ) { }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

    const token = this.servicioAutenticacion.getToken();     

    const headers = new HttpHeaders({
        'Authorization': `Bearer ${token}`,
        'Content-Type':'application/json'
      })    

    if (token) {
      if (request.url =="") {
        const cloned = request.clone ({
          headers: request.headers.set('Authorization', `Bearer ${token}`)        
        });
        return next.handle(cloned);
      } else {
        const cloned = request.clone ({
          headers
        });
        
        return next.handle(cloned);       
      }   
    }
    
    return next.handle(request);
  }
}