package ru.niias.fsm;

import java.util.HashSet;

/**
 * Simple example of finite-state machine
 *
 */
public class FSM
{
    private State state;
    private HashSet<Transition> transitions;

    public FSM(HashSet<Transition> transitions){
        this.state = State.INIT;
        this.transitions = transitions;
    }

    public FSM(State st, HashSet<Transition> transitions){
        this.state = st;
        this.transitions = transitions;
    }

    private synchronized void setState(State newState){
        this.state = newState;
    }

    public synchronized State getCurrentState(){
        return this.state;
    }

    public synchronized void nextState(Signal sg){
        State сurState;
        сurState = this.getCurrentState();
        for (Transition t: this.transitions) {
            if(t.getStateBefore().equals(сurState) && t.getInputSignal().equals(sg)){
                  this.setState(t.getStateAfter());
                  break;
            }
        }
    }
}
