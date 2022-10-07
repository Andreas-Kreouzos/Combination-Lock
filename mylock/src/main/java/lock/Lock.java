package lock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fsm.Transition;

public class Lock {
	
	private State state;
	
	public Lock() {
		state = State.WAIT_FOR_FIRST_1;
	}
	
	public void accept(String key) {
		transitioning(transitionMatches(key));
	}

	private void transitioning(Transition t) {
		if (t != null) {
			state = t.newState;
		} else {
			state = State.WAIT_FOR_FIRST_1;
		}
	}
	
	public boolean isLocked() {
		return !state.equals(State.UNLOCKED);
	}
	
	private Transition transitionMatches(String key) {
		for (Transition t : transitions()) {
			if (state.equals(t.initialState) && key.equals(t.event)) {
				return t;
			}
		}
		return null;
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
