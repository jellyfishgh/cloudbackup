
/**校验对称性是否完整:{[()]}*/

const Stack = require('./Stack.js');

const arg = process.argv.slice(2)[0];

var brackets = '(){}[]';

function isPair(left, right) {
    switch (left) {
        case '(':
            return right === ')';
        case '[':
            return right === ']';
        case '{':
            return right === '}';
    }
    return false;
}

var stack = new Stack();

for(var i = 0; i < arg.length; i++) {
    if(brackets.indexOf(arg[i]) > -1) {
        if(isPair(stack.peek(), arg[i])){
            stack.pop();
        }else {
            stack.push(arg[i]);
        }
    }
}

console.log(stack.size() === 0);