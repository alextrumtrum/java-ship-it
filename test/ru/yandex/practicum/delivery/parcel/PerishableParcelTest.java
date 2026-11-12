package ru.yandex.practicum.delivery.parcel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PerishableParcelTest {

    private PerishableParcel perishableParcel;
    private static final int SEND_DAY = 2;

    @BeforeEach
    public void beforeEach() {
        int timeToLive = 5;
        perishableParcel = new PerishableParcel("Standart", 10, "address", SEND_DAY, timeToLive);
    }

    @Test
    public void isExpired_beforeExpiration_returnsFalse() {
        assertFalse(perishableParcel.isExpired(3));
    }

    @Test
    public void isExpired_afterExpiration_returnsTrue() {
        assertTrue(perishableParcel.isExpired(8));
    }

    @Test
    public void isExpired_onExpirationDay_returnsFalse() {
        assertFalse(perishableParcel.isExpired(7));
    }
}
