package lock

import spock.lang.Specification

class LockSpec extends Specification {
	
	Lock lock
	
	def setup() {
		lock = new Lock()
	}
	
	def "wrong combination"() {
		when:
		lock.accept("1")
		
		then:
		lock.isLocked()
	}
	
	def "correct combination"() {
		when:
		lock.accept("1")
		lock.accept("3")
		lock.accept("1")
		
		then:
		!lock.isLocked()
	}
}
