public class SessionList {

    private static class Node {
        Session session;
        Node next;

        Node(Session session) {
            this.session = session;
            this.next = null;
        }
    }

    private Node head;

    public SessionList() {
        this.head = null;
    }

    public boolean containsId(int id) {
        Node current = head;
        while (current != null) {
            if (current.session.getId() == id) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean addSession(Session newSession) {
        if (containsId(newSession.getId())) {
            return false;
        }

        Node newNode = new Node(newSession);

        if (head == null || newSession.getDate().compareTo(head.session.getDate()) < 0) {
            newNode.next = head;
            head = newNode;
            return true;
        }

        Node current = head;
        while (current.next != null && current.next.session.getDate().compareTo(newSession.getDate()) <= 0) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        return true;
    }

    public boolean isSession() {
        return head != null;
    }
}