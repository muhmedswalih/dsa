data class Node(var data: Int, var next: Node? = null)

class SinglyLinkedList {
    var head: Node? = null
    var size: Int = 0

    // Insert at the beginning
    fun insertAtBeginning(data: Int) {
        val newNode = Node(data)
        newNode.next = head
        head = newNode
        size++
    }

    // Insert at the end
    fun insertAtEnd(data: Int) {
        val newNode = Node(data)
        if (head == null) {
            head = newNode
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
        size++
    }

    // Create a selected node (Insert after a given node)
    fun insertAfter(prevNodeData: Int, data: Int) {
        var current = head
        while (current != null && current.data != prevNodeData) {
            current = current.next
        }
        if (current != null) {
            val newNode = Node(data)
            newNode.next = current.next
            current.next = newNode
            size++
        }
    }

    // Delete from the beginning
    fun deleteAtBeginning() {
        if (head != null) {
            head = head?.next
            size--
        }
    }

    // Delete from the end
    fun deleteAtEnd() {
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
        size--
    }

    // Delete by "name" (Delete by value)
    fun deleteByValue(data: Int) {
        if (head == null) return
        if (head?.data == data) {
            head = head?.next
            size--
            return
        }
        var current = head
        var prev: Node? = null
        while (current != null && current.data != data) {
            prev = current
            current = current.next
        }
        if (current != null) {
            prev?.next = current.next
            size--
        }
    }

    // Print the total capacity (size)
    fun printTotalCapacity() {
        println("Total capacity: $size")
    }

    // Display the linked list
    fun display() {
        var current = head
        while (current != null) {
            print("${current.data} ")
            current = current.next
        }
        println()
    }
}

fun main() {
    val list = SinglyLinkedList()
    list.insertAtBeginning(1)
    list.insertAtEnd(3)
    list.insertAtEnd(2)
    list.insertAtEnd(4)
    list.insertAtEnd(6)
    list.display()

    list.insertAtBeginning(0)
    println("After inserting 0 at the beginning:")
    list.display()

    list.insertAtEnd(7)
    println("After inserting 7 at the end:")
    list.display()

    list.insertAfter(2, 5)
    println("After inserting 5 after 2:")
    list.display()

    list.deleteAtBeginning()
    println("After deleting at the beginning:")
    list.display()

    list.deleteAtEnd()
    println("After deleting at the end:")
    list.display()

    list.deleteByValue(3)
    println("After deleting value 3:")
    list.display()

    list.printTotalCapacity()
}
