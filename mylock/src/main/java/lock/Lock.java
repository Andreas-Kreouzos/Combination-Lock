package lock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lock {
	
	private State state;
	
	public Lock() {
		state = State.WAIT_FOR_FIRST_1;
	}
	
	public void accept(String key) {
		for (Transition t : transitions()) {
			if (state.equals(t.initialState) && key.equals(t.event)) {
				state = t.newState;
			}
		}
	}
	
	public boolean isLocked() {
		return !state.equals(State.UNLOCKED);
	}
	
	private List<Transition> transitions() {
		List<Transition> transitions = new ArrayList<Transition>();
		Transition t1 = new Transition(State.WAIT_FOR_FIRST_1, "1", State.WAIT_FOR_3);
		Transition t2 = new Transition(State.WAIT_FOR_3, "3", State.WAIT_FOR_LAST_1);
		Transition t3 = new Transition(State.WAIT_FOR_LAST_1, "1", State.UNLOCKED);
		transitions.add(t1);
		transitions.add(t2);
		transitions.add(t3);
		
		return transitions;
	}
}
