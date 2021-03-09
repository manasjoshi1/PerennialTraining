import { Observable, of } from 'rxjs';
import {map} from 'rxjs/operators';
const nums=of(1,2,3);
const squareValues=map(((val: number) => val * val));
const squaredNums=squareValues(nums);
squaredNums.subscribe(  );
x =>console.log(x)
console.log("HEY");
let observable = new Observable((observer: { next: (arg0: number) => void; }) => {
    for (let i = 0; i < 3; i++) {
      observer.next(i);
    }
});