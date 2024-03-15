import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();
        
        // Добавление контактов в телефонную книгу
        addContact(phoneBook, "John Smith", "1234567890");
        addContact(phoneBook, "John Smith", "0987654321");
        addContact(phoneBook, "Jane Doe", "9876543210");
        addContact(phoneBook, "Jane Doe", "0123456789");
        addContact(phoneBook, "Bob Johnson", "5555555555");
        
        // Вывод телефонной книги в отсортированном порядке по убыванию числа телефонов
        printPhoneBook(phoneBook);
    }
    
    // Метод для добавления контакта в телефонную книгу
    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        List<String> phoneNumbers = phoneBook.getOrDefault(name, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        phoneBook.put(name, phoneNumbers);
    }
    
    // Метод для вывода телефонной книги
    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {
        // Создание списка записей телефонной книги
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        
        // Сортировка записей по убыванию числа телефонов
        entries.sort((a, b) -> b.getValue().size() - a.getValue().size());
        
        // Вывод отсортированной телефонной книги
        for (Map.Entry<String, List<String>> entry : entries) {
            System.out.println(entry.getKey() + ":");
            for (String phoneNumber : entry.getValue()) {
                System.out.println(phoneNumber);
            }
            System.out.println();
        }
    }
}
