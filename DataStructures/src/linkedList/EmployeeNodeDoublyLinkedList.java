package linkedList;

public class EmployeeNodeDoublyLinkedList {

    private Employee employee;
    private EmployeeNodeDoublyLinkedList next;
    private EmployeeNodeDoublyLinkedList previous;

    public EmployeeNodeDoublyLinkedList(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeNodeDoublyLinkedList getNext() {
        return next;
    }


    public void setNext(EmployeeNodeDoublyLinkedList next) {
        this.next = next;
    }

    public EmployeeNodeDoublyLinkedList getPrevious() {
        return previous;
    }

    public void setPrevious(EmployeeNodeDoublyLinkedList previous) {
        this.previous = previous;
    }

    public String toString() {
        return employee.toString();
    }


}
