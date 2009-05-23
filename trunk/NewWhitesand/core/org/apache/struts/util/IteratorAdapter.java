/*
 * $Id: IteratorAdapter.java 56698 2004-11-05 21:11:41Z niallp $ 
 *
 * Copyright 2002-2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.struts.util;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Utility method for converting Enumeration to an Iterator
 * class.  If you attempt to remove() an Object from the iterator, it will
 * throw an UnsupportedOperationException. Added for use by TagLib so
 * Enumeration can be supported
 *
 * @version $Rev: 56698 $ $Date: 2004-11-05 13:11:41 -0800 (Fri, 05 Nov 2004) $ 
 */

public class IteratorAdapter implements Iterator {
    private java.util.Enumeration Enum;

    public IteratorAdapter(java.util.Enumeration Enum) {
        this.Enum = Enum;
    }

    public boolean hasNext() {
        return Enum.hasMoreElements();
   }

    public Object next() {
        if (!Enum.hasMoreElements()) {
            throw new NoSuchElementException("IteratorAdaptor.next() has no more elements");
        }
        return Enum.nextElement();
    }
    public void remove() {
        throw new java.lang.UnsupportedOperationException("Method IteratorAdaptor.remove() not implemented");
    }
}
