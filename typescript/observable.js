"use strict";
exports.__esModule = true;
var rxjs_1 = require("rxjs");
var operators_1 = require("rxjs/operators");
var nums = rxjs_1.of(1, 2, 3);
var squareValues = operators_1.map((function (val) { return val * val; }));
var squaredNums = squareValues(nums);
squaredNums.subscribe();
(function (x) { return console.log(x); });
console.log("HEY");
var observable = new rxjs_1.Observable(function (observer) {
    for (var i = 0; i < 3; i++) {
        observer.next(i);
    }
});
