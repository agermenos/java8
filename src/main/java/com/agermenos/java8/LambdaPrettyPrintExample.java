package com.agermenos.java8;

import com.agermenos.java8.interfaces.PrettyPrintPredicate;

import java.util.Arrays;

/**
 * Created by alejandrogermenos on 6/19/17.
 */
public class LambdaPrettyPrintExample {
    String brands[]=new String[] {"Gala", "Jazz", "Honey", "Sweet"};
    String colors[]= new String[] {"red", "yellow", "dark red", "brown", "green"};

    private Apple createRandomApple(){
        int colorChosen = (int) (Math.random()*colors.length);
        int brandChosen = (int) (Math.random()*brands.length);
        int chosenWeight = 100 + (int) (Math.random()*200);
        String color = colors[colorChosen];
        String brand = brands [brandChosen];
        return new Apple(brand, chosenWeight, color);
    }

    public Apple[] generateApples(int amount){
        Apple[] returnSet = new Apple[amount];
        for (int k=0; k<amount; k++) {
            returnSet[k] = createRandomApple();
        }
        return returnSet;
    }

    /**
     * Why not just add a toString in the Apple Object, and add a prettyTemplate, which defines how each apple presents itself?
     * @param args
     */
    public static void main(String args[]) {
        System.out.println("\n\tApple List\n\t=============\n");
        PrettyPrintPredicate ppp = apple -> System.out.printf("\tThe %s - %doz (%s)\n", apple.getBrand(), apple.getWeight(), apple.getColor());

        LambdaPrettyPrintExample lppe = new LambdaPrettyPrintExample();
        Apple[] apples = lppe.generateApples(10);
        Arrays.stream(apples).forEach(apple -> ppp.print(apple));
    }
}
