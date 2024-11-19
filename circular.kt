// Define the Node class
data class Node(var capacity: Int) {
    var next: Node? = null
}

// Define the CircularLinkedList class
class CircularLinkedList {
    private var head: Node? = null

    // Insert at the beginning
    fun insertAtBeginning(capacity: Int) {
        val newNode = Node(capacity)
        if (head == null) {
            head = newNode
            newNode.next = head
        } else {
            var current = head
            while (current?.next != head) {
                current = current?.next
            }
            newNode.next = head
            head = newNode
            current?.next = head
        }
    }

    // Insert at the end
    fun insertAtEnd(capacity: Int) {
        val newNode = Node(capacity)
        if (head == null) {
            head = newNode
            newNode.next = head
        } else {
            var current = head
            while (current?.next != head) {
                current = current?.next
            }
            current?.next = newNode
            newNode.next = head
        }
    }

    // Create a selected node (not added to the list)
    fun createSelectedNode(capacity: Int): Node {
        return Node(capacity)
    }

    // Delete from the beginning
    fun deleteFromBeginning() {
        if (head == null) return
        if (head?.next == head) {  // Only one node in the list
            head = null
        } else {
            var current = head
            while (current?.next != head) {
                current = current?.next
            }
            head = head?.next
            current?.next = head
        }
    }

    // Delete from the end
    fun deleteFromEnd() {
        if (head == null) return
        if (head?.next == head) {  // Only one node in the list
            head = null
        } else {
            var current = head
            var prev: Node? = null
            while (current?.next != head) {
                prev = current
                current = current?.next
            }
            prev?.next = head
        }
    }

    // Print the total capacity
    fun printTotalCapacity(): Int {
        var totalCapacity = 0
        var current = head
        if (head != null) {
            do {
                totalCapacity += current?.capacity ?: 0
                current = current?.next
            } while (current != head)
        }
        return totalCapacity
    }

    // Display the list for verification
    fun display() {
        if (head == null) {
            println("List is empty")
            return
        }
        var current = head
        do {
            print("${current?.capacity} -> ")
            current = current?.next
        } while (current != head)
        println("... (circular)")
    }
}

// Usage Example
fun main() {
    val cll = CircularLinkedList()

    // Insert nodes at the beginning and end
    cll.insertAtBeginning(10)
    cll.insertAtBeginning(20)
    cll.insertAtEnd(30)

    // Create a selected node (not added to list)
    val selectedNode = cll.createSelectedNode(40)
    println("Created selected node with capacity: ${selectedNode.capacity}")

    // Display the list
    println("Initial List:")
    cll.display()

    // Delete from beginning
    cll.deleteFromBeginning()
    println("\nAfter deleting from beginning:")
    cll.display()

    // Delete from end
    cll.deleteFromEnd()
    println("\nAfter deleting from end:")
    cll.display()

    // Print total capacity
    val totalCapacity = cll.printTotalCapacity()
    println("\nTotal Capacity: $totalCapacity")
}
