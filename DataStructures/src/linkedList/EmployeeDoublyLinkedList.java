package linkedList;

public class EmployeeDoublyLinkedList {

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public EmployeeDoublyLinkedList() {
    }

    public void addtoTheFront(Employee employee) {
        EmployeeNode newNode = new EmployeeNode(employee);
        newNode.setNext(head);
        head.setPrevious(newNode);
        head = newNode;
        size++;
    }

    public void addToTheEnd(Employee employee){
        EmployeeNode newNode = new EmployeeNode(employee);
        newNode.setNext(tail);
        tail.setPrevious(newNode);
        tail = newNode;
        size++;
    }

    public void print() {
        EmployeeNode current = head;
        System.out.println("HEAD -->");
        while (current != null){
            System.out.println(current);

        }
    }

    }


