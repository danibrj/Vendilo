package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Notification {
    private String messageValue;
    private LocalDateTime localDateTime;
    private Subject subject;
    private RegularUser user;
    private List<DiscountCode> codes;
    private List<ManageUserSupport> reqq;
    private Products prod;

    public Notification(RegularUser user, LocalDateTime localDateTime, Subject subject, String messageValue) {
        this.user = user;
        this.localDateTime = localDateTime;
        this.subject = subject;
        this.messageValue = messageValue;
    }

    public Notification(RegularUser user, LocalDateTime localDateTime, Subject subject, List<DiscountCode> codes) {
        this.user = user;
        this.localDateTime = localDateTime;
        this.subject = subject;
        this.codes = codes;
    }

    public Notification(RegularUser user, LocalDateTime localDateTime, List<ManageUserSupport> reqq, Subject subject) {
        this.user = user;
        this.localDateTime = localDateTime;
        this.subject = subject;
        this.reqq = reqq;
    }

    public Notification(LocalDateTime localDateTime, RegularUser user, Subject subject, Products prod) {
        this.user = user;
        this.localDateTime = localDateTime;
        this.subject = subject;
        this.prod = prod;
    }

    public Products getProd() {
        return prod;
    }

    public void setProd(Products prod) {
        this.prod = prod;
    }

    public List<ManageUserSupport> getReqq() {
        return reqq;
    }

    public void setReqq(List<ManageUserSupport> reqq) {
        this.reqq = reqq;
    }

    public List<DiscountCode> getCodes() {
        return codes;
    }

    public void setCodes(List<DiscountCode> codes) {
        this.codes = codes;
    }

    public String getMessageValue() {
        return messageValue;
    }

    public void setMessageValue(String messageValue) {
        this.messageValue = messageValue;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public RegularUser getUser() {
        return user;
    }

    public void setUser(RegularUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "localDateTime = " + localDateTime + ", subject = " + subject;
    }
}
