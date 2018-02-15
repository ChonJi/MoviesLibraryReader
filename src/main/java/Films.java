import java.util.List;
import java.util.stream.Collectors;

public class Films {
    private List<Film> films;

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Films{" +
                "films=" + films +
                '}';
    }

    public List<Actor> getAllActors() {
        return films.stream().flatMap(f -> f.getActors().stream()).collect(Collectors.toList());
    }

    public List<Actor> removeDuplicates() {
        return films.stream().flatMap(f -> f.getActors().stream()).distinct().collect(Collectors.toList());
    }
}
