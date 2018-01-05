package linkedList;

public class EmployeeNodeSinglyLinkedList {
    
    private Employee employee;
    private EmployeeNodeSinglyLinkedList head;

    public EmployeeNodeSinglyLinkedList(Employee employee) {
        this.employee = employee;
    }

    public void addToTheList(Employee newEmployee) {
        EmployeeNodeSinglyLinkedList newNode = new EmployeeNodeSinglyLinkedList(newEmployee);
        if (head == null) {
            head = newNode;
        }
    }
    public EmployeeNodeSinglyLinkedList getHead() {
        return head;
    }

    public void setHead(EmployeeNodeSinglyLinkedList head) {
        this.head = head;
    }




}
