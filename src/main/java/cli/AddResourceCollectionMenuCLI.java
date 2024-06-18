package cli;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.DigitalResource;
import domain.Libro;
import domain.ResourcesCollection;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class AddResourceCollectionMenuCLI implements CommandLineInterface {

    private final Consumer<ResourcesCollection> addResourceCollectionUseCaseMixin;
    private final Scanner sc;

    public AddResourceCollectionMenuCLI(Consumer<ResourcesCollection> addResourceCollectionUseCaseMixin) {
        sc = new Scanner(System.in);
        this.addResourceCollectionUseCaseMixin = addResourceCollectionUseCaseMixin;
    }

    @Override
    public void scanInput() {

        System.out.println("Choose a name for your new collection:");
        String name = sc.nextLine();

        System.out.println("Choose an access level:\n1 - PUBLIC\n2 - RESTRICTED\n3 - PRIVATE (Default)");
        int accessLevel = sc.nextInt();

        switch (accessLevel) {

            case 1: {



            }

        }

    }

}
