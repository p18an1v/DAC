
function add(num1, num2) {
    return num1 + num2;
}

function sub(num1, num2) {
    // some code logic ...
}

function multiply(num1, num2) {
    // some code logic ...
}

const someConstantValue = 8;

const calculateObject = {
    a: 5,
    b: 6
};

class CalculationClass{
    calcSquareRoot(){
        // some code logic ...
    }
}



module.exports = {
    add,
    sub,
    multiply,
    someConstantValue,
    calculateObject,
    CalculationClass
}

function add(num1, num2) {
    return num1 + num2;
}

// replacing
// module.exports = add;

// with
exports = add;


const add = require("./calculate"); // 2.
const result = add(2, 2);
console.log(result);

// result:
// TypeError: add is not a function