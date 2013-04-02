package org.haim.springframwork.stackoverflow;

import org.haim.springframwork.stackoverflow.Bar;
import org.haim.springframwork.stackoverflow.BarService;
import org.haim.springframwork.stackoverflow.Foo;
import org.haim.springframwork.stackoverflow.FooService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class FooServiceTest {
	
	@Autowired
	FooService fooService;
	
	@Autowired
	BarService barService;
	
	@Test
	public void test() {
		Bar bar = new Bar();
		barService.create(bar);
		
		Foo foo = new Foo();
		fooService.create(foo);
	}

}
