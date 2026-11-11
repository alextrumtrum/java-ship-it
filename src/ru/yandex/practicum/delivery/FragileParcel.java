package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel {

    private static final int BASE_COST = 4;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.printf("Посылка <<%s>> обёрнута в защитную плёнку\n", getDescription());
        super.packageItem();
    }

    @Override
    protected int getBaseCost() {
        return BASE_COST;
    }
}
