package module3.lesson6_AlternativeLibraries.work3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InfoAboutUser {
    public static List<User> users;

    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\Java-Maven\\src\\main\\java\\module3\\lesson6_AlternativeLibraries\\work3\\users.json"));
        users = Arrays.asList(gson.fromJson(bufferedReader, User[].class));

        Scanner scanner = new Scanner(System.in);
        System.out.println("====Info====");
        while (true) {
            System.out.print("Email or userName: ");
            String enterText = scanner.nextLine();
            boolean notFound = true;
            for (User user : users) {
                if (user != null) {
                    if (user.getUsername().toLowerCase().equals(enterText.toLowerCase()) || user.getEmail().toLowerCase().equals(enterText.toLowerCase())) {
                        notFound = false;
                        System.out.println("Company: " + user.getCompany().getName() + " || CatchPhase: " + user.getCompany().getCatchPhase() + " || BS: " + user.getCompany().getBs());
                        System.out.println("Latitude: " + user.getAddress().getGeo().getLat() + "Longitude: " + user.getAddress().getGeo().getLng() + "\n");
                    }
                }
            }
            if (notFound) {
                System.out.println("Not found?!\n");
            }
        }
    }
}
