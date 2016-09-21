function Node(value, next) {
    this.value = value;
    this.next = next;
}
Node.prototype = {
    constructor: Node,
    getValue: function() {
        return this.value;
    },
    setValue: function(value) {
        this.value = value;
    },
    getNext: function() {
        return this.next;
    },
    setNext: function(next) {
        this.next = next;
    }
};

module.exports = Node;