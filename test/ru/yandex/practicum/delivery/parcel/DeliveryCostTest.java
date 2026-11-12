package ru.yandex.practicum.delivery.parcel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DeliveryCostTest {

    @Test
    public void calculateDeliveryCost_standardParcel_returnsWeightTimesTwo() {
        int weight = 4;
        int standardCost = 2;
        StandardParcel standardParcel = new StandardParcel("Standart", weight, "address", 2);

        assertEquals(weight * standardCost, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void calculateDeliveryCost_fragileParcel_returnsWeightTimesFour() {
        int weight = 4;
        int fragileCost = 4;
        FragileParcel fragileParcel = new FragileParcel("Fragile", weight, "address", 2);

        assertEquals(weight * fragileCost, fragileParcel.calculateDeliveryCost());
    }

    @Test
    public void calculateDeliveryCost_perishableParcel_returnsWeightTimesThree() {
        int weight = 4;
        int perishableCost = 3;
        PerishableParcel perishableParcel = new PerishableParcel("Perishable", weight, "address", 2, 10);

        assertEquals(weight * perishableCost, perishableParcel.calculateDeliveryCost());
    }

    @Test
    public void calculateDeliveryCost_standardParcelWithZeroWeight_returnsZero() {
        StandardParcel parcel = new StandardParcel("standart2", 0, "address2", 2);

        assertEquals(0, parcel.calculateDeliveryCost());
    }

    @Test
    public void calculateDeliveryCost_fragileParcelWithZeroWeight_returnsZero() {
        FragileParcel parcel = new FragileParcel("fragile2", 0, "address2", 2);

        assertEquals(0, parcel.calculateDeliveryCost());
    }

    @Test
    public void calculateDeliveryCost_perishableParcelWithZeroWeight_returnsZero() {
        PerishableParcel parcel = new PerishableParcel("perishable2", 0, "address2", 2, 5);

        assertEquals(0, parcel.calculateDeliveryCost());
    }
}
