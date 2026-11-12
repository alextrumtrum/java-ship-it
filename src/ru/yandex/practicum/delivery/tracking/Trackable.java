package ru.yandex.practicum.delivery.tracking;

/**
 * Отправление, поддерживающее отслеживание местоположения.
 */
public interface Trackable {

    /**
     * Сообщает о новом местоположении отправления.
     *
     * @param newLocation новое местоположение отправления
     */
    void reportStatus(String newLocation);
}
