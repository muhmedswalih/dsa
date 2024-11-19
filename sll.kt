// Define the Node class
data class Node(var name: String, var capacity: Int) {
    var next: Node? = null
}

// Define the SinglyLinkedList class
class SinglyLinkedList {
    private var head: Node? = null

    // Insert at the beginning
    fun insertAtBeginning(name: String, capacity: Int) {
        val newNode = Node(name, capacity)
        newNode.next = head
        head = newNode
    }

    // Insert at the end
    fun insertAtEnd(name: String, capacity: Int) {
        val newNode = Node(name, capacity)
        if (head == null) {
            head = newNode
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
    }

    // Create a selected node
    fun createSelectedNode(name: String, capacity: Int): Node {
        return Node(name, capacity)
    }

    // Delete from the beginning
    fun deleteFromBeginning() {
        if (head != null) {
            head = head?.next
        }
    }

    // Delete from the end
    fun deleteFromEnd() {
        if (head == null) return
        if (head?.next == null) {
            head = null
        } else {
            var current = head
            var prev: Node? = null
            while (current?.next != null) {
                prev = current
                current = current.next
            }
            prev?.next = null
        }
    }

    // Delete by "name"
    fun deleteByName(name: String) {
        if (head == null) return
        if (head?.name == name) {
            head = head?.next
            return
        }
        var current = head
        var prev: Node? = null
        while (current != null && current.name != name) {
            prev = current
            current = current.next
        }
        if (current != null) {
            prev?.next = current.next
        }
    }

    // Print the total capacity
    fun printTotalCapacity(): Int {
        var totalCapacity = 0
        var current = head
        while (current != null) {
            totalCapacity += current.capacity
            current = current.next
        }
        return totalCapacity
    }

    // Display the list
    fun display() {
        var current = head
        while (current != null) {
            print("(${current.name}, ${current.capacity}) -> ")
            current = current.next
        }
        println("null")
    }
}

// Usage Example
fun main() {
    val sll = SinglyLinkedList()

    // Insert at the beginning
    sll.insertAtBeginning("Node1", 10)
    sll.insertAtBeginning("Node2", 15)

    // Insert at the end
    sll.insertAtEnd("Node3", 20)
    sll.insertAtEnd("Node4", 25)

    // Create a selected node (not added to the list)
    val selectedNode = sll.createSelectedNode("SelectedNode", 30)
    println("Selected Node: (${selectedNode.name}, ${selectedNode.capacity})")

    // Display the list
    println("Initial List:")
    sll.display()

    // Delete from beginning
    sll.deleteFromBeginning()
    println("\nAfter deleting from beginning:")
    sll.display()

    // Delete from end
    sll.deleteFromEnd()
    println("\nAfter deleting from end:")
    sll.display()

    // Delete by name
    sll.deleteByName("Node3")
    println("\nAfter deleting Node3:")
    sll.display()

    // Print the total capacity
    val totalCapacity = sll.printTotalCapacity()
    println("\nTotal Capacity: $totalCapacity")
}