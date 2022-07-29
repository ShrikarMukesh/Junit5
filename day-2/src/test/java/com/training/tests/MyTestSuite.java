package com.training.tests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
//@SelectClasses( { MyStackTest.class, UserAccountServiceTest.class } )
//@SelectPackages({ "com.training.tests.pack1", "com.training.tests.pack3" })
//@ExcludePackages({ "com.training.tests.pack3.p4"})
//@IncludePackages({ "com.training.tests.pack3.p1", "com.training.tests.pack3.p2" })
@SelectPackages({ "com.training.tests.pack3", "com.training.tests.pack2", "com.training.tests.pack1" })
//@IncludeTags( { "feature-3" } )
public class MyTestSuite {
	
}
