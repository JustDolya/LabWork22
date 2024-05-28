import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class Group implements Observable {
    private List<Observer> observers;
    private String name;

    public Group(String name) {
        this.name = name;
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(name + ": " + message);
        }
    }

    public void postMessage(String message) {
        System.out.println(name + " отправляет сообщение: " + message);
        notifyObservers(message);
    }
}

class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " получил уведомление: " + message);
    }
}

interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

public class Main {
    public static void main(String[] args) {
        // Создание пользователей
        User user1 = new User("User1");
        User user2 = new User("User2");

        // Создание групп
        Group group1 = new Group("Group1");
        Group group2 = new Group("Group2");
        Group group3 = new Group("Group3");
        Group group4 = new Group("Group4");
        Group group5 = new Group("Group5");
        Group group6 = new Group("Group6");
        Group group7 = new Group("Group7");

        // Подписка пользователей на группы
        group1.addObserver(user1);
        group2.addObserver(user1);
        group3.addObserver(user1);

        group4.addObserver(user2);
        group5.addObserver(user2);
        group6.addObserver(user2);
        group7.addObserver(user2);

        // Отправка сообщений в группы
        group1.postMessage("Hello from Group1!");
        group2.postMessage("Hello from Group2!");
        group3.postMessage("Hello from Group3!");
        group4.postMessage("Hello from Group4!");
        group5.postMessage("Hello from Group5!");
        group6.postMessage("Hello from Group6!");
        group7.postMessage("Hello from Group7!");
    }
}