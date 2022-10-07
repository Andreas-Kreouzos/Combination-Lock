package fsm;

import lock.LockState;

public class Transition {
	
	public LockState initialState;
	public LockState newState;
	public String event;
	
	public Transition(LockState initialState,
			String event,
			LockState newState) {
		this.initialState = initialState;
		this.event = event;
		this.newState = newState;
	}
}
