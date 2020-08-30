/*
 * Copyright (c) 2020.
 * File : AbstractClass.java
 * Author : Ankur
 * Last modified : 5/8/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package basics;

class Base{
    void doBaseStuff(){
        System.out.println("doBaseStuff");
    }
    Base doBaseStuff1() {
        return null;
    }
}

class Sub extends Base {
    Base doBaseStuff1() {
        return null;
    }

    void doBaseStuff(){
        System.out.println("doSubStuff");
    }

    void doOtherStuff(){
        System.out.println("doOtherStuff");
    }
}


