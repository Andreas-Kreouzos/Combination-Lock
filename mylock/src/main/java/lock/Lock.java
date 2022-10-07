package lock;

import java.util.Arrays;
import java.util.List;

import fsm.StateMachine;
import fsm.Transition;

public class Lock {
	
	private StateMachine sm;

	
	public Lock() {
		sm = new StateMachine(transitions(), LockState.WAIT_FOR_FIRST_1);
	}
	
	public void accept(String key) {
		sm.transitioning(key);
	}
	
	public boolean isLocked() {
		return !sm.getState().equals(LockState.UNLOCKED);
	}
	
	
	private List<Transition> transitions() {
		return Arrays.asList(new Transition[] {
				new Transition(LockState.WAIT_FOR_FIRST_1, "1", LockState.WAIT_FOR_3),
				new Transition(LockState.WAIT_FOR_3, "3", LockState.WAIT_FOR_LAST_1),
				new Transition(LockState.WAIT_FOR_3, "1", LockState.WAIT_FOR_3),
				new Transition(LockState.WAIT_FOR_LAST_1, "1", LockState.UNLOCKED)
		});
	}
}
