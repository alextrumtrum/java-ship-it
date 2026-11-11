package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {

    private final List<T> listParcel;
    private final int maxWeight;
    private int currentWeight;

    public ParcelBox(int maxWeight) {
        this.listParcel = new ArrayList<>();
        this.maxWeight = maxWeight;
        currentWeight = 0;
    }

    public void addParcel(T parcel) {
        int weight = parcel.getWeight();
        if (currentWeight + weight <= maxWeight) {
            listParcel.add(parcel);
            currentWeight += weight;
        } else {
            System.out.println("Коробка слишком тяжелая!");
        }
    }

    public List<T> getAllParcels() {
        return new ArrayList<>(listParcel);
    }
}
