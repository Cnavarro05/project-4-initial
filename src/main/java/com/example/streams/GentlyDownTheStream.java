package com.example.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * These coding kata on the Stream API can all be completed with a single return line.
 */
public class GentlyDownTheStream {

    protected List<String> fruits;
    protected List<String> veggies;
    protected List<Integer> integerValues;

    public GentlyDownTheStream() {
        fruits = Arrays.asList("Apple", "Orange", "Banana", "Pear", "Peach", "Tomato");
        veggies = Arrays.asList("Corn", "Potato", "Carrot", "Pea", "Tomato");
        integerValues = new Random().ints(0, 1001)
                                    .boxed()
                                    .limit(1000)
                                    .collect(Collectors.toList());
    }

    // TODO - return a list of sorted fruits based on the fruits list
    public List<String> sortedFruits() {
        return fruits.stream()
                     .sorted()
                     .collect(Collectors.toList());
    }
    // TODO - return a list of sorted fruits with all fruits filtered out that start with "A"
    public List<String> sortedFruitsException() {
        return fruits.stream()
                .filter(fruit -> !fruit.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());
    }
    // TODO - return a list with the first 2 elements of a sorted list of fruits
    public List<String> sortedFruitsFirstTwo() {
        List<String> sortedFruits = new ArrayList<>(fruits);
        Collections.sort(sortedFruits);
        return sortedFruits.subList(0, Math.min(sortedFruits.size(), 2));
    }
    // TODO - return a comma separated String of sorted fruits
    public String commaSeparatedListOfFruits() {
        return fruits.stream()
                .sorted()
                .collect(Collectors.joining(", "));
    }
    // TODO - return a list of veggies that are sorted in reverse (descending) order
    public List<String> reverseSortedVeggies() {
        List<String> sortedVeggies = new ArrayList<>(veggies);
        Collections.sort(sortedVeggies, Collections.reverseOrder());
        return sortedVeggies;
    }

    // TODO - return a list of veggies that are sorted in reverse order, and all in upper case
    public List<String> reverseSortedVeggiesInUpperCase() {
        List<String> sortedVeggiesUpperCase = veggies.stream()
                .sorted(Collections.reverseOrder())
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        return sortedVeggiesUpperCase;
    }

    // TODO - return a list of the top 10 values in the list of random integers
    public List<Integer> topTen() {
        Random random = new Random();
        List<Integer> randomIntegers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            randomIntegers.add(random.nextInt(1000));
        }
        Collections.sort(randomIntegers, Collections.reverseOrder());
        return randomIntegers.subList(0, Math.min(randomIntegers.size(), 10));
    }

    // TODO - return a list of the top 10 unique values in the list of random integers
    public List<Integer> topTenUnique() {
        Random random = new Random();
        List<Integer> randomIntegers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            randomIntegers.add(random.nextInt(1000));
        }
        List<Integer> uniqueNumbers = randomIntegers.stream().distinct().collect(Collectors.toList());
        Collections.sort(uniqueNumbers, Collections.reverseOrder());
        return uniqueNumbers.subList(0, Math.min(uniqueNumbers.size(), 10));
    }

    // TODO - return a list of the top 10 unique values in the list of random integers that are odd
    public List<Integer> topTenUniqueOdd() {
        Random random = new Random();
        List<Integer> randomIntegers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            randomIntegers.add(random.nextInt(1000));
        }
        List<Integer> uniqueOddNumbers = randomIntegers.stream()
                .distinct()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());
        Collections.sort(uniqueOddNumbers, Collections.reverseOrder());
        return uniqueOddNumbers.subList(0, Math.min(uniqueOddNumbers.size(), 10));
    }

    // TODO - return a single value that represents the average of all of your random numbers
    public Double average() {
        Random random = new Random();
        List<Integer> randomIntegers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            randomIntegers.add(random.nextInt(1000));
        }
        return randomIntegers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }
}
