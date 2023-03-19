package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		// ### EXAMPLE:
		int birdsOnABranch = 4;
		int birdsThatFlyAway = 1;
		int birdsRemaining = birdsOnABranch - birdsThatFlyAway;
		System.out.println("#1: "+birdsRemaining);

        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;
		System.out.println("#2: "+numberOfExtraBirds);

        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int numberOfRaccoons = 3;
		int numberOfRaccoonsEatingDinner = 2;
		int numberOfRaccoonsLeftInWoods = numberOfRaccoons - numberOfRaccoonsEatingDinner;
		System.out.println("#3: "+numberOfRaccoonsLeftInWoods);

        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int numberOfFlowers = 5;
		int numberOfBees = 3;
		int numberLessBees = numberOfFlowers - numberOfBees;
		System.out.println("#4: "+numberLessBees);

        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int numberPigeonsEatingBreadcrumbs = 1;
		int numberPigeonsAdditionalEatingBreadcrumbs = 1;
		int numberTotalPigeonsEatingBreadcrumbs = numberPigeonsEatingBreadcrumbs + numberPigeonsAdditionalEatingBreadcrumbs;
		System.out.println("#5: "+numberTotalPigeonsEatingBreadcrumbs);

        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int numberOwlsSittingOnFence = 3;
		int numberOwlsJoiningThem = 2;
		int numberOwlsSittingOnFenceTotal = numberOwlsSittingOnFence + numberOwlsJoiningThem;
		System.out.println("#6: "+numberOwlsSittingOnFenceTotal);

        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int numberBeaversWorkingOnTheirHome = 2;
		int numberBeaversWentForSwim = 1;
		int numberBeaversLeftWorkingOnTheirHome = numberBeaversWorkingOnTheirHome - numberBeaversWentForSwim;
		System.out.println("#7: "+numberBeaversLeftWorkingOnTheirHome);

        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int numberOfToucansSittingOnTreeLimb = 2;
		int numberOfToucansJoiningThem = 1;
		int numberTotalToucans = numberOfToucansSittingOnTreeLimb + numberOfToucansJoiningThem;
		System.out.println("#8: "+numberTotalToucans);

        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int numberSquirrels = 4;
		int numberNuts = 2;
		int numberAdditionalSquirrels = numberSquirrels - numberNuts;
		System.out.println("#9: "+numberAdditionalSquirrels);

        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double numberQuarters = .25;
		double numberDime = .10;
		double numberNickels = .10;
		double numberTotalMoney = numberQuarters + numberDime + numberNickels;
		System.out.println("#10: "+numberTotalMoney);

        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int numberMuffinsBrier = 18;
		int numberMuffinsMacAdams = 20;
		int numberMuffinsFlannery = 17;
		int numberMuffinsHilt = numberMuffinsBrier + numberMuffinsMacAdams + numberMuffinsFlannery;
		System.out.println("#11: "+numberMuffinsHilt);

        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double costYoyo = .24;
		double costWhistle = .14;
		double costTotal = costYoyo + costWhistle;
		System.out.println("#12: "+costTotal);

        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispies Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int numberLargeMarshmallows = 8;
		int numberMiniMarshmallows = 10;
		int numberTotalMarshmallows = numberLargeMarshmallows + numberMiniMarshmallows;
		System.out.println("#13: "+numberTotalMarshmallows);

        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int numberSnowHilt = 29;
		int numberSnowBrecknock = 17;
		int numberMoreShowHilt = numberSnowHilt - numberSnowBrecknock;
		System.out.println("#14: "+numberMoreShowHilt);

        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		double numberHilt = 10.00;
		double costToyTruck = 3.00;
		double costPencil = 2.00;
		double numberTotalHilt = numberHilt - ( costToyTruck + costPencil ) ;
		System.out.println("#15: "+numberTotalHilt);

        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int numberJoshMarbles = 16;
		int numberLostMarbles = 7;
		int numberTotalJoshMarbles = numberJoshMarbles - numberLostMarbles ;
		System.out.println("#16: "+numberTotalJoshMarbles);

        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int numberMeganSeashells = 19;
		int numberTotalSeashells = 25;
		int numberMissingSeashells = numberTotalSeashells - numberMeganSeashells;
		System.out.println("#17: "+numberMissingSeashells);

        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int numberTotalBalloos = 17;
		int numberRedBalloons = 8;
		int numberGreenBalloons = numberTotalBalloos - numberRedBalloons;
		System.out.println("#18: "+numberGreenBalloons);

        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int numberBooks = 38;
		int numberBooksAdditional = 10;
		int numberTotalBooks = numberBooks + numberBooksAdditional;
		System.out.println("#19: "+numberTotalBooks);

        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int numberBeeLegs = 6;
		int numberBees = 8;
		int numberTotalBeeLegs = numberBeeLegs * numberBees;
		System.out.println("#20: "+numberTotalBeeLegs);

        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double costIceCreamCone = .99;
		double numberIceCreamCones = 2;
		double costTwoIceCreamCones = costIceCreamCone * numberIceCreamCones;
		System.out.println("#21: "+costTwoIceCreamCones);

        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int numberTotalRocksNeeded = 125;
		int numberRocks = 64;
		int numberRocksAdditional = numberTotalRocksNeeded - numberRocks;
		System.out.println("#22: "+numberRocksAdditional);

        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int numberTotalMarbles = 38;
		int numberMarblesLost = 15;
		int numberMarblesRemaining = numberTotalMarbles - numberMarblesLost;
		System.out.println("#23: "+numberMarblesRemaining);

        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int numberTotalMiles = 78;
		int numberMilesDriven = 32;
		int numberMilesRemaining = numberTotalMiles - numberMilesDriven;
		System.out.println("#24: "+numberMilesRemaining);

        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */
		int numberMinsShovelingSnowSatMorn = 90;
		int numberMinsShovelingSnowSatAft = 45;
		int numberTotalMinsShovelingSnow = numberMinsShovelingSnowSatMorn + numberMinsShovelingSnowSatAft;
		System.out.println("#25: "+numberTotalMinsShovelingSnow);

        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		int numberTotalHotDogs = 6;
		double costOneHotDog = .50;
		double costTotalHotDogs = numberTotalHotDogs * costOneHotDog;
		System.out.println("#26: "+costTotalHotDogs);

        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int numberTotalMoneyForPencils = 50;
		int numberOnePencilCost = 7;
		int numberPencilsCanBuy =  numberTotalMoneyForPencils / numberOnePencilCost ;
		System.out.println("#27: "+numberPencilsCanBuy);

        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int numberButterflies = 33;
		int numberButterfliesOracle = 20;
		int numberButterfliesRed = numberButterflies - numberButterfliesOracle;
		System.out.println("#28: "+numberButterfliesRed);

        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double numberMoney = 1.00;
		double numberCandyCost = .54;
		double numberChange = numberMoney - numberCandyCost ;
		System.out.println("#29: "+numberChange);

        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int numberTrees = 13;
		int numberTreesPlanted = 12;
		int numberTotalTrees = numberTrees + numberTreesPlanted;
		System.out.println("#30: "+numberTotalTrees);

        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int numberDaysToSeeGrandma = 2;
		int numberHoursInOneDay = 24;
		int numberHoursToSeeGrandma = numberDaysToSeeGrandma * numberHoursInOneDay;
		System.out.println("#31: "+numberHoursToSeeGrandma);

        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int numberTotalCousins = 4;
		int numberPiecesGum = 5;
		int numberTotalPiecesGumNeeded = numberTotalCousins * numberPiecesGum;
		System.out.println("#32: "+numberTotalPiecesGumNeeded);

        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double numberDanTotalMoney = 3.00;
		double numberDanCandyBar = 1.00;
		double numberDanMoneyLeft = numberDanTotalMoney - numberDanCandyBar;
		System.out.println("#33: "+numberDanMoneyLeft);

        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int numberBoats = 5;
		int numberPeopleInBoats = 3;
		int numberTotalPeopleInBoats = numberBoats * numberPeopleInBoats;
		System.out.println("#34: "+numberTotalPeopleInBoats);

        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int numberTotalLegos = 380;
		int numberLostLegos = 57;
		int numberLegosRemaining = numberTotalLegos - numberLostLegos;
		System.out.println("#35: "+numberLegosRemaining);

        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int numberBakedMuffins = 35;
		int numberTotalBakedMuffins = 83;
		int numberMuffinsRemaining = numberTotalBakedMuffins - numberBakedMuffins;
		System.out.println("#36: "+numberMuffinsRemaining);

        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int numberWillyTotalCrayons = 1400;
		int numberLucyTotalCrayons = 290;
		int numberWillyMoreCrayons = numberWillyTotalCrayons - numberLucyTotalCrayons;
		System.out.println("#37: "+numberWillyMoreCrayons);

        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int numberStickersOnPage = 10;
		int numberTotalPages = 22;
		int numberTotalStickers = numberStickersOnPage * numberTotalPages;
		System.out.println("#38: "+numberTotalStickers);

        /* Exercise 39
        39. There are 100 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		double numberTotalCupcakes = 100;
		double numberTotalChildren = 8;
		double numberEachPersonCupcakes = numberTotalCupcakes / numberTotalChildren;
		System.out.println("#39: "+numberEachPersonCupcakes);

        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If Each jar is to contain six cookies, how many
        cookies will not be placed in a jar?
        */
		int numberTotalGingerbreadCookies = 47;
		int numberGingerbreadCookiesInEachJar = 6;
		int numberCookiesNotInJar = numberTotalGingerbreadCookies % numberGingerbreadCookiesInEachJar;
		System.out.println("#40: "+numberCookiesNotInJar);

        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received an equal number of croissants,
        how many will be left with Marian?
        */
		int numberCroissantsPrepared = 59;
		int numberNeighbors = 8;
		int numberCroissantsLeft = numberCroissantsPrepared % numberNeighbors;
		System.out.println("#41: "+numberCroissantsLeft);

        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int numberOatmealCookies = 276;
		int numberCookiesOnTray = 12;
		int numberTotalTrays = numberOatmealCookies / numberCookiesOnTray;
		System.out.println("#42: "+numberTotalTrays);

        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int numberTotalPretzels = 480;
		int numberPretzelsInOneServing = 12;
		int numberTotalPretzelsPrepared = numberTotalPretzels / numberPretzelsInOneServing;
		System.out.println("#43: "+numberTotalPretzelsPrepared);

        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int numberLemonCupcakesBaked = 53;
		int numberLemonCakesLeftHome = 2;
		int numberLemonCupcakesFitInBox = 3;
		int numberLemonCupcakeBoxesGivenAway = ( numberLemonCupcakesBaked - numberLemonCakesLeftHome ) / numberLemonCupcakesFitInBox;
		System.out.println("#44: "+numberLemonCupcakeBoxesGivenAway);

        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int numberCarrotSticksPrepared = 74;
		int numberPeople = 12;
		int numberCarrotSticksLeft = numberCarrotSticksPrepared % numberPeople;
		System.out.println("#45: "+numberCarrotSticksLeft);

        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int numberTeddyBears = 98;
		int numberTeddyBearsOnShelf = 7;
		int numberShelvesFilled = numberTeddyBears / numberTeddyBearsOnShelf;
		System.out.println("#46: "+numberShelvesFilled);

        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int numberPicturesInAlbum = 20;
		int numberTotalPictures = 480;
		int numberAlbumsNeeded = numberTotalPictures / numberPicturesInAlbum;
		System.out.println("#47: "+numberAlbumsNeeded);

        /* Exercise 48
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int numberTradingCards = 94;
		int numberFullBoxTradingCards = 8;
		int numberBoxesFilled = numberTradingCards / numberFullBoxTradingCards;
		int numberCardsRemaining = numberTradingCards % numberFullBoxTradingCards;
		System.out.println("#48: Boxes Filled = "+numberBoxesFilled+", Cards Remaining = "+numberCardsRemaining);

        /* Exercise 49
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int numberTotalBooksDistributed = 210;
		int numberShelves = 10;
		int numberBooksOnEachShelf = numberTotalBooksDistributed / numberShelves;
		System.out.println("#49: "+numberBooksOnEachShelf);

        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		double numberCroissants = 17;
		double numberGuests = 7;
		double numberCroissantsPerGuest = numberCroissants / numberGuests;
		System.out.println("#50: "+numberCroissantsPerGuest);

	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a standard room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 standard rooms?
	    Hint: Calculate the rate at which each painter can complete a room (rooms / hour), combine those rates, 
        and then divide by the total number of rooms to be painted.
	    */
		double numberBillStandardRoom = 2.15;
		double numberJillStandardRoom = 1.90;
		double numberOneRoom = 1;
		double numberRooms = 5;
		// double numberLengthToPaintFiveStandardRooms = ( ( ( numberBillStandardRoom + numberJillStandardRoom ) / 2 ) * numberRooms)  ;
		double numberLengthToPaintFiveStandardRooms = numberRooms / ( ( numberOneRoom / numberBillStandardRoom ) + (  numberOneRoom / numberJillStandardRoom ) );
		System.out.println("#51: "+numberLengthToPaintFiveStandardRooms);

	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */
		String stringFirstName = " Grace ";
		String stringLastName = "Hopper,";
		String stringMiddleInitial = "B.";
		String stringFullName = stringLastName+stringFirstName+stringMiddleInitial;
		System.out.println("#52: "+stringFullName);

	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */
		int numberMilesBetweenNewYorkAndChicago = 800;
		int numberMilesTraveled = 537;
		double numberPercentComplete = (double)numberMilesTraveled / (double)numberMilesBetweenNewYorkAndChicago ;
		int numberPercentCompleteFinal = (int) (numberPercentComplete * 100 );

	}

}
