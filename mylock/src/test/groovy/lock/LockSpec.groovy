package lock

import spock.lang.Specification
import spock.lang.Unroll

class LockSpec extends Specification {
	
	Lock lock
	
	def setup() {
		lock = new Lock()
	}
	
	@Unroll
	def "wrong combination"() {
		when:
		accept(keys)
		
		then:
		lock.isLocked()
		
		where:
		keys << [
			["1","1","3"],
			["2","5","3"],
			["3","1","3","4"],
			["1","2","3","4","1"]
		]	
	}
	
	@Unroll
	def "correct combination"() {
		when:
		accept(keys)
		
		then:
		!lock.isLocked()
		
		where:
		keys << [
			["1","3","1"],
			["8","1","7","1","3","1"],
			["3","1","3","1"],
			["1","1","3","1"]
		]
	}
	
	private void accept(def keys) {
		keys.each { key -> lock.accept(key) }
	}
}
