package fsm;

public class Event<T> {
	
	private T value;

	public Event(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
	
	
}
