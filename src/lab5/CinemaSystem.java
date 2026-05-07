package lab5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinemaSystem implements InformationSearcher {
    private List<Cinema> cinemas;

    public CinemaSystem() {
        this.cinemas = new ArrayList<>();
        System.out.println("Об'єкт CinemaSystem створено");
    }

    public void addCinema(Cinema cinema) {
        cinemas.add(cinema);
        System.out.println("Кінотеатр додано до системи");
    }

    @Override
    public List<String> searchFilmSessions(String filmName) {
        System.out.println("Пошук розпочато...");
        List<String> results = new ArrayList<>();
        
        for (Cinema cinema : cinemas) {
            if (cinema.hasFilm(filmName)) {
                List<String> sessions = cinema.getFilmSessions(filmName);
                for (String session : sessions) {
                    results.add(cinema.getName() + ": " + session);
                }
            }
        }
        
        System.out.println("Пошук завершено");
        return results;
    }

    public void displayAllCinemas() {
        System.out.println("=== Список кінотеатрів ===");
        for (int i = 0; i < cinemas.size(); i++) {
            System.out.println((i + 1) + ". " + cinemas.get(i).getName());
        }
    }

    public Cinema getCinema(int index) {
        if (index >= 0 && index < cinemas.size()) {
            return cinemas.get(index);
        }
        return null;
    }

    public static class Cinema {
        private String name;
        private List<String> films;
        private Map<String, List<String>> schedule;

        public Cinema(String name) {
            this.name = name;
            this.films = new ArrayList<>();
            this.schedule = new HashMap<>();
            System.out.println("Об'єкт Кінотеатр створено: " + name);
        }

        public String getName() {
            return name;
        }

        public void addFilm(String filmName) {
            if (!films.contains(filmName)) {
                films.add(filmName);
                schedule.put(filmName, new ArrayList<>());
                System.out.println("Фільм додано: " + filmName);
            }
        }

        public void addSession(String filmName, String sessionTime) {
            if (films.contains(filmName)) {
                schedule.get(filmName).add(sessionTime);
                System.out.println("Сеанс додано: " + filmName + " о " + sessionTime);
            }
        }

        public boolean hasFilm(String filmName) {
            return films.contains(filmName);
        }

        public List<String> getFilmSessions(String filmName) {
            return schedule.getOrDefault(filmName, new ArrayList<>());
        }

        public void displayInfo() {
            System.out.println("=== Кінотеатр: " + name + " ===");
            System.out.println("Фільми:");
            for (String film : films) {
                System.out.println("  - " + film);
                List<String> sessions = schedule.get(film);
                if (!sessions.isEmpty()) {
                    System.out.println("    Сеанси: " + String.join(", ", sessions));
                }
            }
        }
    }
}
