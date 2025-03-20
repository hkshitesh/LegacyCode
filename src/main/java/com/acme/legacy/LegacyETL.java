package com.acme.legacy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Collectors;

public class LegacyETL {

    private static final Logger logger = LoggerFactory.getLogger(LegacyETL.class);

    /**
     * Example method to demonstrate modernization.
     * @param input Optional input data
     * @return Processed result
     */
    public Optional<String> process(Optional<String> input) {
        logger.info("Starting the ETL process");

        return input.map(data -> {
            // Process the data
            String result = data.trim().toUpperCase();
            logger.info("Processed data: {}", result);
            return result;
        }).or(() -> {
            logger.warn("No input data provided");
            return Optional.empty();
        });
    }

    /**
     * Example method to demonstrate try-with-resources for file handling.
     * @param filePath Path to the input file
     * @return Content of the file
     */
    public Optional<String> readFile(String filePath) {
        logger.info("Reading file: {}", filePath);

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String content = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            logger.info("File read successfully");
            return Optional.of(content);
        } catch (IOException e) {
            logger.error("Error reading file", e);
            return Optional.empty();
        }
    }

    // Additional modernized methods can be added here
}