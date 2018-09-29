package datamaker.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import datamaker.DataMaker;
import datamaker.JsonConverter;
import datamaker.demo.types.CarCollector;

public class DataMakerJSONDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataMaker.class);

    public static void main(String[] args) {
        //// @formatter:off
        System.out.println(JsonConverter
                .toJson(new DataMaker()
                        .setLocaleName("es_ES")
                        .setDepthOfSelfCollections(1)
                        .setSizeOfCollections(3)
                        .makeObject(CarCollector.class))
                );
        // @formatter:on
    }
}
