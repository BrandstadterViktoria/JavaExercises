package linkedList;

public class EmployeeDoublyLinkedList {

    private EmployeeNodeDoublyLinkedList head;
    private EmployeeNodeDoublyLinkedList tail;
    private int size;

    public EmployeeDoublyLinkedList() {
    }

    public void addToTheFront(Employee employee) {
        EmployeeNodeDoublyLinkedList newNode = new EmployeeNodeDoublyLinkedList(employee);

        if (head == null) {
            tail = newNode;
        } else {
            head.setPrevious(newNode);
            newNode.setNext(head);
        }
        head = newNode;
        size++;

    }

    public void addToTheEnd(Employee employee) {
        EmployeeNodeDoublyLinkedList newNode = new EmployeeNodeDoublyLinkedList(employee);

        if (tail == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
        }
        tail = newNode;
        size++;
    }

    public void print() {
        EmployeeNodeDoublyLinkedList current = head;
        while (current != null) {
            System.out.print(current);
            System.out.print("<=>");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public boolean addBefore(Employee newEmployee, Employee existingEmployee) {
        if (head == null) {
            return false;
        }

        EmployeeNodeDoublyLinkedList current = head;
        while ((current.getEmployee().getName() != existingEmployee.getName())) {
            current = current.getNext();
        }
        EmployeeNodeDoublyLinkedList newNode = new EmployeeNodeDoublyLinkedList(newEmployee);
        newNode.setPrevious(current.getPrevious());
        newNode.setNext(current);
        current.setPrevious(newNode);

        if (head == current) {
            head = newNode;
        }
        else {
            newNode.getPrevious().setNext(newNode);
        }


        size++;


        return true;
    }

}


