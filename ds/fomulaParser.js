/**
 * 
 * 解析算式
 * eg:5+3*2-(2+3*8)*10/2
 * 
 * http://blog.csdn.net/zhangxiangdavaid/article/details/27176751
 * 
 * http://blog.csdn.net/chenpeggy/article/details/7478145
 */

const Stack = require('./Stack.js');

const numStack = new Stack();
const opeStack = new Stack();

const arg = process.argv.slice(2)[0];

function isOpe(char) {
    return /[\+\-\*/\(\)]/g.test(char);
}

function isNum(char) {
    return /\d/.test(char);
}

// eg: 1/2
function opeNum(num1, num2, ope) {
    switch (ope) {
        case '+':
            return num2 + num1;
        case '-':
            return num2 - num1;
        case '*':
            return num2 * num1;
        case '/':
            return num2 / num1;
    }
}

const order = {
    '+': 0,
    '-': 1,
    '*': 2,
    '/': 3
};
const priority = [
    [0, 0, 1, 1],
    [0, 0, 1, 1],
    [0, 0, 0, 0],
    [0, 0, 0, 0]
];

function isHigher(ope1, ope2) {
    return priority[order[ope1]][order[ope2]] > 0;
}

let numArr = [];
for (let i = 0; i < arg.length; i++) {
    let char = arg[i];
    if (isNum(char)) numArr.push(char);
    else if (isOpe(char)) {
        if(numArr.length > 0)numStack.push(parseInt(numArr.join('')));
        numArr = [];
        let ope = opeStack.peek();
        if(ope && !isHigher(ope, char)){
            numStack.push(opeNum(numStack.pop(), numStack.pop(), opeStack.pop()));
        }
        opeStack.push(char);
        // if (ope) {
        //     if (isHigher(char, ope)) {
        //         opeStack.push(char);
        //     } else {
        //         let num1 = numStack.pop(),
        //             num2 = numStack.pop();
        //         numStack.push(opeNum(num1, num2, opeStack.pop()));
        //         opeStack.push(char);
        //     }
        // } else {
        //     opeStack.push(char);
        // }
    }
}
if(numArr.length > 0)numStack.push(parseInt(numArr.join('')));
console.log(opeNum(numStack.pop(), numStack.pop(), opeStack.pop()));