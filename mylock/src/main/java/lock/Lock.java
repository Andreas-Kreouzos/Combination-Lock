package lock;

import java.util.Arrays;
import java.util.List;

import fsm.Event;
import fsm.StateMachine;
import fsm.Transition;

public class Lock {
	
	private StateMachine<String> sm;

	
	public Lock() {
		sm = new StateMachine(transitions(), LockState.WAIT_FOR_FIRST_1);
	}
	
	public void accept(String key) {
		sm.transitioning(key);
	}
	
	public boolean isLocked() {
		return !sm.getState().equals(LockState.UNLOCKED);
	}
	
	
	@SuppressWarnings("unchecked")
	private List<Transition<String>> transitions() {
		return Arrays.asList(new Transition[] {
				new Transition<String>(LockState.WAIT_FOR_FIRST_1, new Event<String>("1"), LockState.WAIT_FOR_3),
				new Transition<String>(LockState.WAIT_FOR_3, new Event<String>("3"), LockState.WAIT_FOR_LAST_1),
				new Transition<String>(LockState.WAIT_FOR_3, new Event<String>("1"), LockState.WAIT_FOR_3),
				new Transition<String>(LockState.WAIT_FOR_LAST_1, new Event<String>("1"), LockState.UNLOCKED)
		});
	}
}
