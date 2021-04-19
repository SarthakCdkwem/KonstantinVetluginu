package ru.niias.fsm;

/**
 * Перечисление Signal хранит в себе взможные сигналы, поступающие на вход конечного автомата
 */
public enum Signal {
    REQUEST, UPDATE, LOAD, LOAD_ERROR, LOAD_AND_CONFIRM, CONFIRM, CONFIRM_ERROR, FINISH, TIMER
}
