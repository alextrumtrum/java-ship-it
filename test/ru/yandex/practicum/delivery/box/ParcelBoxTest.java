package ru.yandex.practicum.delivery.box;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.parcel.StandardParcel;

public class ParcelBoxTest {

    private ParcelBox<StandardParcel> parcelBox;
    private static final int MAX_WEIGHT = 4;

    @BeforeEach
    public void beforeEach() {
        parcelBox = new ParcelBox<>(MAX_WEIGHT);
    }

    @Test
    public void addParcel_belowWeightLimit_addsParcel() {
        parcelBox.addParcel(new StandardParcel("Standart", 2, "address", 2));
        parcelBox.addParcel(new StandardParcel("Standart", 1, "address", 2));

        assertEquals(2, parcelBox.getAllParcels().size());
    }

    @Test
    public void addParcel_aboveWeightLimit_doesNotAddParcel() {
        parcelBox.addParcel(new StandardParcel("Standart", 2, "address", 2));
        parcelBox.addParcel(new StandardParcel("Standart", 4, "address", 2));

        assertEquals(1, parcelBox.getAllParcels().size());
    }

    @Test
    public void addParcel_exactlyAtWeightLimit_addsParcel() {
        parcelBox.addParcel(new StandardParcel("Standart", 2, "address", 2));
        parcelBox.addParcel(new StandardParcel("Standart", 2, "address", 2));

        assertEquals(2, parcelBox.getAllParcels().size());
    }
}
