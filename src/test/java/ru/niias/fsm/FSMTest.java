package ru.niias.fsm;

import junit.framework.TestCase;
import junit.framework.Assert;
import org.junit.Test;


import java.util.HashSet;


public class FSMTest
    extends TestCase
{
    //Создание схемы переходов переходов состояний конечного автомата
    public static HashSet<Transition> transitionsInit(){
        HashSet<Transition> transitions = new HashSet<Transition>();
        transitions.add(new Transition(State.INIT, Signal.REQUEST, State.REQUEST));
        transitions.add(new Transition(State.INIT, Signal.UPDATE, State.FORM_UPDATED));

        transitions.add(new Transition(State.REQUEST, Signal.UPDATE, State.FORM_UPDATED));
        transitions.add(new Transition(State.REQUEST, Signal.TIMER, State.REQUEST));
        transitions.add(new Transition(State.REQUEST, Signal.FINISH, State.INIT));

        transitions.add(new Transition(State.FORM_UPDATED, Signal.TIMER, State.FORM_UPDATED));
        transitions.add(new Transition(State.FORM_UPDATED, Signal.REQUEST, State.REQUEST));
        transitions.add(new Transition(State.FORM_UPDATED, Signal.LOAD_AND_CONFIRM, State.CONFIRMED));
        transitions.add(new Transition(State.FORM_UPDATED, Signal.LOAD, State.LOADED));
        transitions.add(new Transition(State.FORM_UPDATED, Signal.LOAD_ERROR, State.LOAD_ERROR));
        transitions.add(new Transition(State.FORM_UPDATED, Signal.FINISH, State.INIT));

        transitions.add(new Transition(State.LOADED, Signal.TIMER, State.LOADED));
        transitions.add(new Transition(State.LOADED, Signal.REQUEST, State.REQUEST));
        transitions.add(new Transition(State.LOADED, Signal.CONFIRM, State.CONFIRMED));
        transitions.add(new Transition(State.LOADED, Signal.CONFIRM_ERROR, State.CONFIRM_ERROR));
        transitions.add(new Transition(State.LOADED, Signal.UPDATE, State.FORM_UPDATED));
        transitions.add(new Transition(State.LOADED, Signal.FINISH, State.FINISHED));

        transitions.add(new Transition(State.LOAD_ERROR, Signal.LOAD, State.LOADED));
        transitions.add(new Transition(State.LOAD_ERROR, Signal.REQUEST, State.REQUEST));
        transitions.add(new Transition(State.LOAD_ERROR, Signal.FINISH, State.INIT));
        transitions.add(new Transition(State.LOAD_ERROR, Signal.UPDATE, State.FORM_UPDATED));

        transitions.add(new Transition(State.CONFIRMED, Signal.TIMER, State.CONFIRMED));
        transitions.add(new Transition(State.CONFIRMED, Signal.REQUEST, State.REQUEST));
        transitions.add(new Transition(State.CONFIRMED, Signal.FINISH, State.FINISHED));
        transitions.add(new Transition(State.CONFIRMED, Signal.UPDATE, State.FORM_UPDATED));

        transitions.add(new Transition(State.CONFIRM_ERROR, Signal.REQUEST, State.REQUEST));
        transitions.add(new Transition(State.CONFIRM_ERROR, Signal.FINISH, State.FINISHED));
        transitions.add(new Transition(State.CONFIRM_ERROR, Signal.UPDATE, State.FORM_UPDATED));

        transitions.add(new Transition(State.FINISHED, Signal.TIMER, State.FINISHED));
        transitions.add(new Transition(State.FINISHED, Signal.REQUEST, State.REQUEST));
        transitions.add(new Transition(State.FINISHED, Signal.UPDATE, State.FORM_UPDATED));

        return transitions;
    }
    @Test
    public void testFSMConstructor(){
        HashSet<Transition> transitions = transitionsInit();
        FSM fsm = new FSM(State.REQUEST, transitions);
        Assert.assertEquals(State.REQUEST, fsm.getCurrentState());
    }

    @Test
    public void testNextState(){
        HashSet<Transition> transitions = transitionsInit();
        FSM fsm = new FSM(transitions);

        fsm.nextState(Signal.REQUEST);
        Assert.assertEquals(State.REQUEST, fsm.getCurrentState());

        fsm.nextState(Signal.FINISH);
        Assert.assertEquals(State.INIT, fsm.getCurrentState());

        fsm.nextState(Signal.UPDATE);
        Assert.assertEquals(State.FORM_UPDATED, fsm.getCurrentState());

        fsm.nextState(Signal.TIMER);
        Assert.assertEquals(State.FORM_UPDATED, fsm.getCurrentState());

        fsm.nextState(Signal.LOAD_ERROR);
        Assert.assertEquals(State.LOAD_ERROR, fsm.getCurrentState());

        fsm.nextState(Signal.LOAD);
        Assert.assertEquals(State.LOADED, fsm.getCurrentState());

        fsm.nextState(Signal.CONFIRM_ERROR);
        Assert.assertEquals(State.CONFIRM_ERROR, fsm.getCurrentState());

        fsm.nextState(Signal.REQUEST);
        Assert.assertEquals(State.REQUEST, fsm.getCurrentState());

        fsm.nextState(Signal.UPDATE);
        Assert.assertEquals(State.FORM_UPDATED, fsm.getCurrentState());

        fsm.nextState(Signal.LOAD_AND_CONFIRM);
        Assert.assertEquals(State.CONFIRMED, fsm.getCurrentState());

        fsm.nextState(Signal.FINISH);
        Assert.assertEquals(State.FINISHED, fsm.getCurrentState());

        fsm.nextState(Signal.UPDATE);
        Assert.assertEquals(State.FORM_UPDATED, fsm.getCurrentState());

        fsm.nextState(Signal.LOAD);
        Assert.assertEquals(State.LOADED, fsm.getCurrentState());

        fsm.nextState(Signal.CONFIRM_ERROR);
        Assert.assertEquals(State.CONFIRM_ERROR, fsm.getCurrentState());

        fsm.nextState(Signal.FINISH);
        Assert.assertEquals(State.FINISHED, fsm.getCurrentState());

        System.out.println("Currrent state is State." + fsm.getCurrentState());

    }
}
