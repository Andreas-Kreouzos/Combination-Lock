package lock;

public class Transition {
	
	private State initialState;
	private State newState;
	private String event;
	
	public Transition(State initialState,
			String event,
			State newState) {
		this.initialState = initialState;
		this.event = event;
		this.newState = newState;
	}
}
