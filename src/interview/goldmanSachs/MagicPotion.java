/*
 * Copyright (c) 2020.
 * File : MagicPotion.java
 * Author : Ankur
 * Last modified : 20/7/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package interview.goldmanSachs;

/* Problem Name is &&& Magic Potion &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
Instructions to candidate.
  1) Run this code in the REPL to observe its behaviour. The
   execution entry point is main.
  2) Consider adding some additional tests in doTestsPass().
  3) Implement minimalSteps() correctly.
  4) If time permits, some possible follow-ups.

Question:
Hermione is preparing a cheat-sheet for her final exam in Potions class.
To create a potion, one must combine ingredients in a specific order, any of which may be repeated.

As an example, consider the following potion which uses 4 distinct ingredients
(A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, D

Hermione realizes she can save tremendous space on her cheat-sheet by introducing a
special instruction, '*', which means "repeat from the beginning".

Using these optimizations, Hermione is able to encode the potion above using only 6 characters: A,B,*,C,*,D

Your job is to write a function that takes as input an un-encoded potion and returns the
minimum number of characters required to encode the potion on Hermione's Cheat Sheet.
*/

public class MagicPotion
{
    private int minimalSteps( String ingredients )
    {
        int len = ingredients.length();
        if(len == 0)
            return 0;

        if(ingredients.substring(0, len/2).equals(ingredients.substring(len/2, len))) {
            return len/2+1;
        }

        int min_steps = 1;
        for(int i = 1; i<len; min_steps++) {
            String prev = ingredients.substring(0,i);

            if(2*i < len) {
                String next = ingredients.substring(i, 2*i);

                if (prev.equals(next))
                    i = i+i;
                else
                    i++;

            } else
                i++;
        }

        return min_steps;
    }

    /**
     * Returns true if the tests pass. Otherwise, false.
     */
    private boolean doTestsPass()
    {
        return minimalSteps("ABCDABCE") == 8
                && minimalSteps("ABCABCE") == 5
                && minimalSteps("ABABCABABCD") == 6
                && minimalSteps("AAAAAA") == 4;
    }


    /**
     * Execution entry point.
     */
    public static void main( String[] args )
    {
        MagicPotion solution = new MagicPotion( );
        if ( solution.doTestsPass( ) )
        {
            System.out.println( "All tests passed" );
        }
        else
        {
            System.out.println( "Tests failed" );
        }
    }
}

