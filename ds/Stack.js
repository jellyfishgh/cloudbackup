const Node = require('./Node.js');

function Stack(){
    this.head = this.tail = new Node(0, null);
}
Stack.prototype = {
    constructor: Stack,
    size: function() {
        return this.head.getValue();
    },
    push: function(item) {
        this.head.setValue(this.size() + 1);
        this.tail = new Node(item, this.tail);
    },
    pop: function() {
        if(this.size() < 1) {
            return null;
        }else {
            this.head.setValue(this.size() - 1);
            const temp = this.tail.getValue();
            this.tail = this.tail.getNext();
            return temp;

        }
    },
    peek: function() {
        if(this.size() < 1) {
            return null;
        } else {
            return this.tail.getValue();
        }
    }
};

module.exports = Stack;