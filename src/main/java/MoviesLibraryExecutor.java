import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MoviesLibraryExecutor {

    private static Films films = null;


    public static void main(String[] args) throws IOException{

        films = new JsonReader().readFromJson();
        printMainMenu();
        System.out.println(films);
    }

    private static void printMainMenu() {
        System.out.println("1. Search film by actor");
        System.out.println("2. Search films by year.");
        System.out.println("3. Add new film to the library.");
        System.out.println("Select option...");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                actorsListMenu();
                break;
            default:
                System.exit(0);
        }
    }

    private static void actorsListMenu() {
        List<Actor> actors = films.getAllActors();
        for (int i = 0; i < actors.size(); i++) {
            System.out.println(" " + (i + 1) + "." + actors.get(i).getDisplayName());
        }
        System.out.println("Return to main menu hit 0");
        System.out.println("Choose actor to get the film");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        if (choose == 0) {
            printMainMenu();
        }
        Actor actor = actors.get(choose - 1);
        films.getFilms().stream().filter(f -> f.getActors().contains(actor))
                .forEach(f -> System.out.println(f.getTitle()));
        System.out.println("Press any key to continue");
        scanner.nextLine();
        actorsListMenu();
    }
}
