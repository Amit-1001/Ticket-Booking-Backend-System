package org.example.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Entities.Ticket;
import org.example.Entities.User;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserBookingService {
    private User user;

    private List<User> userList; // to get deserialized data from json

    private ObjectMapper objectMapper = new ObjectMapper(); // to map json key with Entities

    private static final String USER_PATH = "../LocalDb/users.json";

    public UserBookingService(User user) throws IOException { // initializing user
        this.user = user;
        File users = new File(USER_PATH);

        /** we are mapping all users from json to List<User>
        here we are using TypeReference so in runtime compiler will know we are using List<User> to map data
        as List is generic we don't know exact data we are passing at run time **/
        userList = objectMapper.readValue(users, new TypeReference<List<User>>(){});
    }

    public UserBookingService() throws IOException{
        File users = new File(USER_PATH);
        userList = objectMapper.readValue(users, new TypeReference<List<User>>(){});
    }

    public Boolean loginUser(User user){
        /** stream allow us to filter list in runtime **/
        Optional<User> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equalsIgnoreCase(user.getName()) && UserServiceUtil.checkPassword(user.getHashPassword(),user1.getHashPassword());
        }).findFirst();

        return foundUser.isPresent(); // optional class method

    }

    public Boolean signUp(User user){
        try {
            userList.add(user);
            saveUserToUserList();
            return true;
        }catch (IOException e){
            return Boolean.FALSE;
        }

    }

    public void saveUserToUserList() throws IOException {
        File userFile = new File(USER_PATH);
        objectMapper.writeValue(userFile,userList);
    }

    public void fetchBooking(){
        user.printTicket();
    }

    public Boolean cancelBooking(String ticketId){
        Optional<Ticket> ticketFound = user.getTicketBooked().stream().findFirst();
        if(ticketFound.isPresent()){
            List<Ticket> tickets = user.getTicketBooked();

            tickets.remove(ticketId);
            return true;
        }


        return false;
    }





}
