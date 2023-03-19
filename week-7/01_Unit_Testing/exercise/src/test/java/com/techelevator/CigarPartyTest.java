package com.techelevator;

import org.junit.Test;

public class CigarPartyTest {
    /*
     When squirrels get together for a party, they like to have cigars. A squirrel party is successful
     when the number of cigars is between 40 and 60, inclusive. Unless it is the weekend, in which case
     there is no upper bound on the number of cigars. Return true if the party with the given values is
     successful, or false otherwise.
     haveParty(30, false) → false
     haveParty(50, false) → true
     haveParty(70, true) → true
     */
    @Test
    public void main() {

        CigarParty test = new CigarParty();

        System.out.println(test.haveParty(30, false));
        System.out.println(test.haveParty(50, false));
        System.out.println(test.haveParty(70, true));
    }
}
