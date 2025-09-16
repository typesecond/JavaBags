package project1;

import bag.Bag;
import student.TestableRandom;


public class DisplayCollection {
    
    /**
     * array of possible items for the bag
     */
    public static final String[] STRINGS = {
        "red circle", "blue circle", "red square", "blue square"
    };

    /**
     * the bag that holds  randomly selected items
     */
    private Bag<String> itemBag;

    /**
     * constructs a DisplayCollection by initializing the bag 
     * and filling it with a random number of strings chosen from
     * the STRINGS array
     * the number of items is a random integer between 5 and 15 
     */
    public DisplayCollection() {
        itemBag = new Bag<>();
        TestableRandom random = new TestableRandom();
        int count = random.nextInt(11) + 5; // Random size between 5 and 15

        for (int i = 0; i < count; i++) {
            int index = random.nextInt(4); // random index for STRINGS array
            itemBag.add(STRINGS[index]);
        }
    }

    /**
     * Returns the bag containing the randomly selected strings.
     *
     * @return the bag of strings
     */
    public Bag<String> getItemBag() {
        return itemBag;
    }
}

// init comment 
