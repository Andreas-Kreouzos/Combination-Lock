package lock;

public class Transition {
	
	public State initialState;
	public State newState;
	public String event;
	
	public Transition(State initialState,
			String event,
			State newState) {
		this.initialState = initialState;
		this.event = event;
		this.newState = newState;
	}
}
