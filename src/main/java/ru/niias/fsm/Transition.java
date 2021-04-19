package ru.niias.fsm;
/**
 * Объект Transition писывает переход из текущего состояния в сдедующее
 */
public class Transition {
    private State stateBefore;
    private Signal inputSignal;
    private State stateAfter;

    public State getStateBefore() {
        return stateBefore;
    }

    public Signal getInputSignal() {
        return inputSignal;
    }

    public State getStateAfter() {
        return stateAfter;
    }

    public Transition(State stateBefore, Signal inputSignal, State stateAfter){
        this.stateBefore = stateBefore;
        this.inputSignal = inputSignal;
        this.stateAfter = stateAfter;
    }
}
