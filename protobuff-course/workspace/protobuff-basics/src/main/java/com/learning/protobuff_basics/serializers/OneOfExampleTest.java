package com.learning.protobuff_basics.serializers;

import com.learning.protobuff_basics.beans.OneOfExampleOuterClass.OneOfExample;

public class OneOfExampleTest {

	
	public static void main(String[] args) {
		OneOfExample obj1 = OneOfExample.newBuilder().setId(1).setFullName("kanishk bhatt")
		   .setName("kanishk") // ampont name and fullname only one ca be set
		   //here name will be aknishk and full anme will auto set to empty string/default value
		   .setFullName("jai shree ram") // this will set fullname but set name as empty
		   .setMiddleName("ram")//now other two names will be empty as among these 3 names only one can be set
		   
		   .build();
		   
		
		System.out.println(obj1);
		System.out.println("name "+obj1.getName());
		System.out.println("full name "+obj1.getFullName()); // if la;st setter called is name then this wil be empty/default
		System.out.println("middle name "+obj1.getMiddleName()); // if la;st setter called is name then this wil be empty/default
	}
	
}
