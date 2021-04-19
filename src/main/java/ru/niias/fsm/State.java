package ru.niias.fsm;

/**
 * Перечисление State хранит в себе взможные состояния конечного автомата
 */
public enum State {
    INIT, REQUEST,
    FORM_UPDATED,
    LOADED, LOAD_ERROR,
    CONFIRMED, CONFIRM_ERROR,
    FINISHED
}
