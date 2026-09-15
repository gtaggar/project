public class Session {
    private int id;
    private String title;
    private String mentor;
    private String date;
    private String location;
    private int currentParticipants;
    private int maxParticipants;

    public Session(int id, String title, String mentor, String date, String location, int maxParticipants) {
        this.id = id;
        this.title = title;
        this.mentor = mentor;
        this.date = date;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.currentParticipants = 0;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMentor() {
        return mentor;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public int getCurrentParticipants() {
        return currentParticipants;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public String toString() {
        return String.format("ID: %d | Title: %s | Mentor: %s | Date: %s | Location: %s | Spots: %d/%d",
                id, title, mentor, date, location, currentParticipants, maxParticipants);
    }
}