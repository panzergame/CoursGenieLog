package parser;

import datamocklib.Person;

import java.util.List;
import java.util.stream.Collectors;

public class PersonParser {
    public static Person parse(String line) {
        String[] tokens = line.split(",");
        return new Person(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
    }

    // Format du fichier : firstName,lastName,birthDate,gender,cityOfResidence,cityOfBirth
    // Pas de header
    public static List<Person> parse(List<String> data) {
        // A COMPLETER
        return data.stream().map(line -> parse(line)).collect(Collectors.toList());
    }
}
