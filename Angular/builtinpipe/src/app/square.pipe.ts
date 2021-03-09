import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'square'
})
export class SquarePipe implements PipeTransform {

  transform(value: any, ...args: any): unknown {
    console.log("value which is of type any " + typeof value);
    console.log("args which is array of any[]" + args);
    return value*value;
  }

}
