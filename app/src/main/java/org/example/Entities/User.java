package org.example.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.util.List;



@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;
    private String hashPassword;
    private List<Ticket> ticketBooked;
    private String userId;

    public User(String name, String hashPassword, List<Ticket> ticketBooked, String userId) {
        this.name = name;
        this.hashPassword = hashPassword;
        this.ticketBooked = ticketBooked;
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public void setTicketBooked(List<Ticket> ticketBooked) {
        this.ticketBooked = ticketBooked;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public List<Ticket> getTicketBooked() {
        return ticketBooked;
    }

    public String getUserId() {
        return userId;
    }

    public void printTicket(){
        for(int i=0;i<ticketBooked.size();i++){
            System.out.println(ticketBooked.get(i).getTicketInfo());
        }
    }
}
