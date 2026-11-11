package ru.yandex.practicum.delivery;

public abstract class Parcel {

    private final String description;
    private final int weight;
    private final String deliveryAddress;
    private final int sendDay;


    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.printf("Посылка <<%s>> упакована\n", description);
    }

    public void deliver() {
        System.out.printf("Посылка <<%s>> доставлена по адресу %s\n", description, deliveryAddress);
    }

    protected abstract int getBaseCost();

    public int calculateDeliveryCost() {
        return weight * getBaseCost();
    }

    public String getDescription() {
        return description;
    }

    public int getSendDay() {
        return sendDay;
    }
}
