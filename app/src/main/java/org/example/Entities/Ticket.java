package org.example.Entities;

import java.util.Date;

public class Ticket {

    private String ticketId;
    private String ticketNo;
    private String userId;
    private String source;
    private String destination;
    private Date dateOfTravel;
    private Train train;

    public Ticket(String ticketId, String ticketNo, String userId, String source, String destination, Date dateOfTravel, Train train) {
        this.ticketId = ticketId;
        this.ticketNo = ticketNo;
        this.userId = userId;
        this.source = source;
        this.destination = destination;
        this.dateOfTravel = dateOfTravel;
        this.train = train;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(Date dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getTicketInfo(){
        return String.format("Ticket id: %s Ticket No:%s",ticketId,ticketNo);
    }
}
