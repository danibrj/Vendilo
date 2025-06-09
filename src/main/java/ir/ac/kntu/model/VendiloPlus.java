package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VendiloPlus {
    private RegularUser user;
    private LocalDateTime membershipDate;
    private LocalDateTime expirationDate;

    public VendiloPlus(RegularUser user, LocalDateTime membershipDate, LocalDateTime expirationDate) {
        this.user = user;
        this.membershipDate = membershipDate;
        this.expirationDate = expirationDate;
    }

    public RegularUser getUser() {
        return user;
    }

    public void setUser(RegularUser user) {
        this.user = user;
    }

    public LocalDateTime getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(LocalDateTime membershipDate) {
        this.membershipDate = membershipDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        return String.format("user : %s %s | membershipDate : [%s] | expirationDate : [%s]", user.getFirstName(), user.getLastName(), membershipDate.format(formatter), expirationDate.format(formatter));
    }
}
