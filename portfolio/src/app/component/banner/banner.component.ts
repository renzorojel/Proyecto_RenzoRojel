import { Component } from '@angular/core';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.scss']
})
export class BannerComponent {
name: string = 'Mi banner';
urlImg: string = 'https://www.argentina.gob.ar/sites/default/files/cordoba-la-canada-landing.jpg';
photo: string = `url('${this.urlImg}')`;




}
