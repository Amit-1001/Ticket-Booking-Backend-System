package org.example.Entities;

import java.sql.Time;
import java.util.List;
import java.util.Map;

public class Train {

    private String trainId;
    private String trainNo;

    private List<List<Integer>> seats; // available seats in train
    private Map<String, String> stationsTime; // source and time
    private List<String> station;

    public Train(String trainId, String trainNo, List<List<Integer>> seats, Map<String, String> stationsTime, List<String> station) {
        this.trainId = trainId;
        this.trainNo = trainNo;
        this.seats = seats;
        this.stationsTime = stationsTime;
        this.station = station;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public List<List<Integer>> getSeats() {
        return seats;
    }

    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }

    public Map<String, String> getStationsTime() {
        return stationsTime;
    }

    public void setStationsTime(Map<String, String> stationsTime) {
        this.stationsTime = stationsTime;
    }

    public List<String> getStation() {
        return station;
    }

    public void setStation(List<String> station) {
        this.station = station;
    }

    public String getTrainInfo(){
        return String.format("Train id : %s Train No : %s",trainId,trainNo);
    }
}
