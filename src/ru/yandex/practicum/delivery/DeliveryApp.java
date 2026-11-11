package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    System.out.println("Посылка добавлена");
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        boolean running;
        do {
            running = false;
            showType();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    allParcels.add(createParcel(1));
                    break;
                case 2:
                    allParcels.add(createParcel(2));
                    break;
                case 3:
                    allParcels.add(createParcel(3));
                    break;
                default:
                    running = true;
                    System.out.println("Неверный выбор.");
            }
        } while (running);
    }

    private static Parcel createParcel(int type) {
        String description;
        int weight;
        String deliveryAddress;
        int sendDay;
        int ttl = 0;

        System.out.print("Укажите название посылки: ");
        description = scanner.nextLine();
        System.out.print("Укажите вес посылки: ");
        weight = Integer.parseInt(scanner.nextLine());
        System.out.print("Укажите адрес посылки: ");
        deliveryAddress = scanner.nextLine();
        System.out.print("Укажите день отправки посылки: ");
        sendDay = Integer.parseInt(scanner.nextLine());

        if (type == 3) {
            System.out.print("Укажите срок годности посылки: ");
            ttl = Integer.parseInt(scanner.nextLine());
        }
        return switch (type) {
            case 1 -> new StandardParcel(description, weight, deliveryAddress, sendDay);
            case 2 -> new FragileParcel(description, weight, deliveryAddress, sendDay);
            case 3 -> new PerishableParcel(description, weight, deliveryAddress, sendDay, ttl);
            default -> null;
        };
    }

    private static void showType() {
        System.out.println("Выберите тип посылки:");
        System.out.println("1 — Стандартная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящаяся");
    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        int total = 0;
        for (Parcel parcel : allParcels) {
            total += parcel.calculateDeliveryCost();
        }
        System.out.println(total);
    }
}