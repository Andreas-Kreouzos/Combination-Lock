package lock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fsm.StateMachine;
import fsm.Transition;

public class Lock {
	
	private StateMachine sm;

	
	public Lock() {
		sm = new StateMachine(transitions(), State.WAIT_FOR_FIRST_1);
	}
	
	public void accept(String key) {
		sm.transitioning(key);
	}
	
	public boolean isLocked() {
		return !sm.getState().equals(State.UNLOCKED);
	}
	
	
	private List<Transition> transitions() {
		return Arrays.asList(new Transition[] {
				new Transition(State.WAIT_FOR_FIRST_1, "1", State.WAIT_FOR_3),
				new Transition(State.WAIT_FOR_3, "3", State.WAIT_FOR_LAST_1),
				new Transition(State.WAIT_FOR_3, "1", State.WAIT_FOR_3),
				new Transition(State.WAIT_FOR_LAST_1, "1", State.UNLOCKED)
		});
	}
}
