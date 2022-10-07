package lock

import spock.lang.Specification

class LockSpec extends Specification {
	
	def "lock accepts key"(){
		given:
		Lock lock = new Lock()
		
		expect:
		lock.accept("1")
	}
}
