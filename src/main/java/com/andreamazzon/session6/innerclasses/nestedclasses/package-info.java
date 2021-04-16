/**
 * This package is dedicated to nested classes: these are static, inner classes. To understand the meaning
 * of static when applied to inner classes, remember that the object of an ordinary inner class implicitly
 * keeps a reference to the object of the enclosing class that created it. This is not true when you define
 * an inner class to be static. For nested classes, you don’t need an outer-class object in order to
 * create an object of a nested class, and you can’t access a non-static outer-class field from an object
 * of a nested class. Moreover, ordinary inner classes cannot have static methods and static fields,
 * unless static fields are also final, since they depend on the object of the outer class, but nested
 * classes can have all of these.
 */
package com.andreamazzon.session6.innerclasses.nestedclasses;
