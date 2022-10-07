package fsm;

import java.util.List;

public class StateMachine<E> {
	
	private State state;
	private State defaultState;
	private List<Transition<E>> transitions;
	
	
	public StateMachine(List<Transition<E>> transitions, State defaultState) {
		state = defaultState;
		this.defaultState = defaultState;
		this.transitions = transitions;
	}
	
	public void transitioning(E eventValue) {
		Transition<E> t = transitionMatches(eventValue);
		if (t != null) {
			state = t.newState;
		} else {
			state = defaultState;
		}
	}
	
	public State getState() {
		return state;
	}
	
	private Transition<E> transitionMatches(E eventValue) {
		for (Transition<E> t : transitions) {
			if (state.equals(t.initialState) && eventValue.equals(t.event.getValue())) {
				return t;
			}
		}
		return null;
	}
}
