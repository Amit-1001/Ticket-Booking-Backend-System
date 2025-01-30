package org.example.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Entities.Train;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TrainService {

    private List<Train> trainList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String trainDB = "../LocalDb/train.json";

    public TrainService() throws IOException {
        File trains = new File(trainDB);
        trainList = objectMapper.readValue(trains, new TypeReference<List<Train>>() {
        });
    }

    public List<Train> searchTrain(String source, String destination) {
        return trainList.stream().filter(train -> validTrain(train, source, destination)).collect(Collectors.toList());
    }

    public boolean validTrain(Train train, String source, String destination) {
        List<String> stations = train.getStation(); // we will get all stations train will visit
        int sourceIndex = stations.indexOf(source);
        int destinationIndex = stations.indexOf(destination);

        // if source is index is smaller than destination then it is valid
        return sourceIndex != -1 && destinationIndex != -1 && sourceIndex < destinationIndex;
    }


    public void addTrain(Train newTrain) throws IOException{
        Optional<Train> existingTrain = trainList.stream().filter(train -> train.getTrainId().equalsIgnoreCase(newTrain.getTrainId())).findFirst();

        if (existingTrain.isPresent()) {
            updateTrain(newTrain);
        } else {
            trainList.add(newTrain);
            saveTrainListToFile();
        }
    }

    public void saveTrainListToFile() throws IOException{
        objectMapper.writeValue(new File(trainDB),trainList);
    }

    public void updateTrain(Train updateTrain) throws IOException{
        OptionalInt index = IntStream.range(0,trainList.size())
                .filter(i ->trainList.get(i).getTrainId().equalsIgnoreCase(updateTrain.getTrainId())).findFirst();

        if(index.isPresent()){
            trainList.set(index.getAsInt(),updateTrain);
            saveTrainListToFile();
        }else{
            addTrain(updateTrain);
        }

    }


}
