package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Notification {
    private LocalDateTime localDateTime;
    private String subject;

    public Notification(LocalDateTime localDateTime, String subject) {
        this.localDateTime = localDateTime;
        this.subject = subject;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        return String.format("[%s] : %s", localDateTime.format(formatter),subject);

    }
}
