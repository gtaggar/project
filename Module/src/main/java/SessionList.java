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

    public String getAllSessionsAsString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.session.toString()).append("\n--------------------\n");
            current = current.next;
        }
        return sb.toString();
    }

    public Session searchByID(int id) {
        Node current = head;
        while (current != null) {
            if (current.session.getId() == id) {
                return current.session;
            }
            current = current.next;
        }
        return null;
    }

    public String searchByMentorAsString(String mentor) {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            if (current.session.getMentor().equalsIgnoreCase(mentor)) {
                sb.append(current.session.toString()).append("\n--------------------\n");
            }
            current = current.next;
        }
        return sb.toString();
    }

    public boolean removeSession (int id) {
        if (head == null) {
            return false;
        }

        if (head.session.getId()== id) {
            head = head.next;
            return true;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.session.getId() == id) {
                current.next = current.next.next;
                return true;
            }

            current = current.next;
        }
        return false;
    }
    public String registerParticipant (int id) {
        Session session= searchByID(id);

        if (session ==null) {
            return ("Error: There is no session found with ID " + id);
        }

        if (session.registerParticipant()) {
            return ("Participant registered succesfully!");
        }
        return ("Error: This session is already full!");
    }
}