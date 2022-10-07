package lock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lock {

	private List<String> keys;
	
	public Lock() {
		keys = new ArrayList<String>();
	}
	
	public void accept(String key) {
		keys.add(key);
	}
	
	public boolean isLocked() {
		return !keys.equals(Arrays.asList(new String[] {
			"1","3","1"	
		}));
	}
}
