package lock;

import fsm.State;

public enum LockState implements State {
	WAIT_FOR_FIRST_1,
	WAIT_FOR_3,
	WAIT_FOR_LAST_1,
	UNLOCKED
}
