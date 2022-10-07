package fsm;

import java.util.List;

import lock.State;

public class StateMachine {
	
	private State state;
	private State defaultState;
	private List<Transition> transitions;
	
	
	public StateMachine(List<Transition> transitions, State defaultState) {
		state = defaultState;
		this.defaultState = defaultState;
		this.transitions = transitions;
	}
	
	public void transitioning(String key) {
		Transition t = transitionMatches(key);
		if (t != null) {
			state = t.newState;
		} else {
			state = defaultState;
		}
	}
	
	public State getState() {
		return state;
	}
	
	private Transition transitionMatches(String key) {
		for (Transition t : transitions) {
			if (state.equals(t.initialState) && key.equals(t.event)) {
				return t;
			}
		}
		return null;
	}
}
