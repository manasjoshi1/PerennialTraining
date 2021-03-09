import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'aadharno'
})
export class AadharnoPipe implements PipeTransform {

  transform(value: string, ...args: string[]): any{
    let delim:string = args[0];
    let first:string=value.toString().substr(0,4);
    let second:string=value.toString().substr(4,4);
    let third:string=value.toString().substr(8,4);

     return first+ delim +second+delim+third;
  }

}
