package lab5;

import java.util.Scanner;

public class Main {
    static void main() {
        System.out.println("=== Лабораторна робота №5. Кінотеатр ===");
        System.out.println("Програма створена");
        
        Scanner scanner = new Scanner(System.in);
        CinemaSystem cinemaSystem = new CinemaSystem();
        
        while (true) {
            System.out.println("\n=== Головне меню ===");
            System.out.println("1. Додати кінотеатр");
            System.out.println("2. Додати фільм до кінотеатру");
            System.out.println("3. Додати сеанс фільму");
            System.out.println("4. Показати всі кінотеатри");
            System.out.println("5. Показати інформацію про кінотеатр");
            System.out.println("6. Пошук сеансів фільму");
            System.out.println("7. Вихід");
            System.out.print("Оберіть опцію: ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Помилка: введіть число від 1 до 7");
                continue;
            }
            
            switch (choice) {
                case 1:
                    addCinema(scanner, cinemaSystem);
                    break;
                case 2:
                    addFilmToCinema(scanner, cinemaSystem);
                    break;
                case 3:
                    addSessionToFilm(scanner, cinemaSystem);
                    break;
                case 4:
                    cinemaSystem.displayAllCinemas();
                    break;
                case 5:
                    displayCinemaInfo(scanner, cinemaSystem);
                    break;
                case 6:
                    searchFilmSessions(scanner, cinemaSystem);
                    break;
                case 7:
                    System.out.println("Програма завершена");
                    scanner.close();
                    return;
                default:
                    System.out.println("Помилка: невідома опція");
            }
        }
    }
    
    private static void addCinema(Scanner scanner, CinemaSystem cinemaSystem) {
        System.out.println("\n=== Додавання кінотеатру ===");
        System.out.print("Введіть назву кінотеатру: ");
        String name = scanner.nextLine();
        
        if (name.trim().isEmpty()) {
            System.out.println("Помилка: назва не може бути порожньою");
            return;
        }
        
        CinemaSystem.Cinema cinema = new CinemaSystem.Cinema(name);
        cinemaSystem.addCinema(cinema);
        System.out.println("Дані зчитано");
    }
    
    private static void addFilmToCinema(Scanner scanner, CinemaSystem cinemaSystem) {
        System.out.println("\n=== Додавання фільму ===");
        cinemaSystem.displayAllCinemas();
        System.out.print("Оберіть номер кінотеатру: ");
        
        int cinemaIndex;
        try {
            cinemaIndex = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Помилка: введіть число");
            return;
        }
        
        CinemaSystem.Cinema cinema = cinemaSystem.getCinema(cinemaIndex);
        if (cinema == null) {
            System.out.println("Помилка: кінотеатр не знайдено");
            return;
        }
        
        System.out.print("Введіть назву фільму: ");
        String filmName = scanner.nextLine();
        
        if (filmName.trim().isEmpty()) {
            System.out.println("Помилка: назва фільму не може бути порожньою");
            return;
        }
        
        cinema.addFilm(filmName);
        System.out.println("Дані зчитано");
    }
    
    private static void addSessionToFilm(Scanner scanner, CinemaSystem cinemaSystem) {
        System.out.println("\n=== Додавання сеансу ===");
        cinemaSystem.displayAllCinemas();
        System.out.print("Оберіть номер кінотеатру: ");
        
        int cinemaIndex;
        try {
            cinemaIndex = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Помилка: введіть число");
            return;
        }
        
        CinemaSystem.Cinema cinema = cinemaSystem.getCinema(cinemaIndex);
        if (cinema == null) {
            System.out.println("Помилка: кінотеатр не знайдено");
            return;
        }
        
        cinema.displayInfo();
        System.out.print("Введіть назву фільму: ");
        String filmName = scanner.nextLine();
        
        if (!cinema.hasFilm(filmName)) {
            System.out.println("Помилка: фільм не знайдено в цьому кінотеатрі");
            return;
        }
        
        System.out.print("Введіть час сеансу (напр. 14:30): ");
        String sessionTime = scanner.nextLine();
        
        if (sessionTime.trim().isEmpty()) {
            System.out.println("Помилка: час не може бути порожнім");
            return;
        }
        
        cinema.addSession(filmName, sessionTime);
        System.out.println("Дані зчитано");
    }
    
    private static void displayCinemaInfo(Scanner scanner, CinemaSystem cinemaSystem) {
        System.out.println("\n=== Інформація про кінотеатр ===");
        cinemaSystem.displayAllCinemas();
        System.out.print("Оберіть номер кінотеатру: ");
        
        int cinemaIndex;
        try {
            cinemaIndex = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Помилка: введіть число");
            return;
        }
        
        CinemaSystem.Cinema cinema = cinemaSystem.getCinema(cinemaIndex);
        if (cinema == null) {
            System.out.println("Помилка: кінотеатр не знайдено");
            return;
        }
        
        cinema.displayInfo();
        System.out.println("Дані зчитано");
    }
    
    private static void searchFilmSessions(Scanner scanner, CinemaSystem cinemaSystem) {
        System.out.println("\n=== Пошук сеансів фільму ===");
        System.out.print("Введіть назву фільму для пошуку: ");
        String filmName = scanner.nextLine();
        
        if (filmName.trim().isEmpty()) {
            System.out.println("Помилка: назва фільму не може бути порожньою");
            return;
        }
        
        System.out.println("Дані зчитано");
        var results = cinemaSystem.searchFilmSessions(filmName);
        
        if (results.isEmpty()) {
            System.out.println("Сеанси для фільму '" + filmName + "' не знайдено");
        } else {
            System.out.println("=== Знайдені сеанси ===");
            for (String result : results) {
                System.out.println(result);
            }
        }
    }
}
