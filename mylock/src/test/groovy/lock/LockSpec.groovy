package lock

import spock.lang.Specification

class LockSpec extends Specification {
	
	def "lock accepts key"() {
		given:
		Lock lock = new Lock()
		
		expect:
		lock.accept("1")
	}
	
	def "wrong combination"() {
		given:
		Lock lock = new Lock()
		
		when:
		lock.accept("1")
		
		then:
		lock.isLocked()
	}
	
	def "correct combination"() {
		given:
		Lock lock = new Lock()
		
		when:
		lock.accept("1")
		lock.accept("3")
		lock.accept("1")
		
		then:
		!lock.isLocked()
	}
}
