/*
 * Copyright 2005-2006 William Von Vian <cozly@hotmail.com> Licensed under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance with the License. You
 * may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See
 * the License for the specific language governing permissions and limitations under the License.
 */
package com.cozly.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CozUtils{
	public static Collection<Method> getDeclaredMethods(Class clazz,final Class upto){
		// collect methods to register (include methods for all classes up to
		// and including this one)
		final Collection<Method> methods=new ArrayList<Method>();
		while(!clazz.equals(upto.getSuperclass())){
			methods.addAll(Arrays.asList(clazz.getDeclaredMethods()));
			clazz=clazz.getSuperclass();
		}
		return methods;
	}
}
