#include <stdio.h>
#include <stdlib.h>

// Define the Node structure
struct Node {
    int capacity;
    struct Node* next;
};

// Insert at the beginning of the circular linked list
void insertAtBeginning(struct Node** head, int capacity) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->capacity = capacity;
    
    if (*head == NULL) {
        *head = newNode;
        newNode->next = *head;
    } else {
        struct Node* temp = *head;
        while (temp->next != *head) {
            temp = temp->next;
        }
        newNode->next = *head;
        temp->next = newNode;
        *head = newNode;
    }
}

// Insert at the end of the circular linked list
void insertAtEnd(struct Node** head, int capacity) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->capacity = capacity;

    if (*head == NULL) {
        *head = newNode;
        newNode->next = *head;
    } else {
        struct Node* temp = *head;
        while (temp->next != *head) {
            temp = temp->next;
        }
        temp->next = newNode;
        newNode->next = *head;
    }
}

// Create a selected node (not part of the list)
struct Node* createSelectedNode(int capacity) {
    struct Node* selectedNode = (struct Node*)malloc(sizeof(struct Node));
    selectedNode->capacity = capacity;
    selectedNode->next = NULL;
    return selectedNode;
}

// Delete from the beginning of the circular linked list
void deleteFromBeginning(struct Node** head) {
    if (*head == NULL) return;

    struct Node* temp = *head;
    struct Node* last = *head;

    while (last->next != *head) {
        last = last->next;
    }

    if (*head == last) { // Only one node in the list
        free(*head);
        *head = NULL;
    } else {
        *head = (*head)->next;
        last->next = *head;
        free(temp);
    }
}

// Delete from the end of the circular linked list
void deleteFromEnd(struct Node** head) {
    if (*head == NULL) return;

    struct Node* temp = *head;
    struct Node* prev = NULL;

    while (temp->next != *head) {
        prev = temp;
        temp = temp->next;
    }

    if (temp == *head) { // Only one node in the list
        free(*head);
        *head = NULL;
    } else {
        prev->next = *head;
        free(temp);
    }
}

// Print the total capacity of all nodes
int printTotalCapacity(struct Node* head) {
    int totalCapacity = 0;
    if (head == NULL) return totalCapacity;

    struct Node* temp = head;
    do {
        totalCapacity += temp->capacity;
        temp = temp->next;
    } while (temp != head);

    return totalCapacity;
}

// Display the circular linked list
void display(struct Node* head) {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    struct Node* temp = head;
    do {
        printf("%d -> ", temp->capacity);
        temp = temp->next;
    } while (temp != head);
    printf("(circular)\n");
}

// Main function to demonstrate functionality
int main() {
    struct Node* head = NULL;

    // Insert nodes
    insertAtBeginning(&head, 10);
    insertAtBeginning(&head, 20);
    insertAtEnd(&head, 30);

    // Create a selected node (not added to list)
    struct Node* selectedNode = createSelectedNode(40);
    printf("Selected Node Capacity: %d\n", selectedNode->capacity);

    // Display the list
    printf("Initial List:\n");
    display(head);

    // Delete from beginning
    deleteFromBeginning(&head);
    printf("\nAfter deleting from beginning:\n");
    display(head);

    // Delete from end
    deleteFromEnd(&head);
    printf("\nAfter deleting from end:\n");
    display(head);

    // Print total capacity
    int totalCapacity = printTotalCapacity(head);
    printf("\nTotal Capacity: %d\n", totalCapacity);

    // Free the selected node memory
    free(selectedNode);

    return 0;
}