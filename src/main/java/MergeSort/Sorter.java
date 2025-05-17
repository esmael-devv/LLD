package MergeSort;

import lombok.AllArgsConstructor;

import java.util.*;
import java.util.concurrent.*;


@AllArgsConstructor
public class Sorter implements Callable<List<Integer>> {

    private List<Integer> values = new ArrayList<>();
    private ExecutorService executorService;
    @Override
    public List<Integer> call() throws Exception {

        System.out.println("Got " + values.size() + " on" + Thread.currentThread().getName());
        //base case
        if(values.size() <= 1){
            return values;
        }
        //split the array
        int mid = values.size() / 2;
        List<Integer> leftArray = values.subList(0, mid);
        List<Integer> rightArray = values.subList(mid, values.size());

        Sorter leftSorter = new Sorter(leftArray, executorService);
        Sorter rightSorter = new Sorter(rightArray, executorService);

        System.out.println("Dividing  " + values + " on Thread " + Thread.currentThread().getName());

        Future<List<Integer>> leftFuture = executorService.submit(leftSorter);
        Future<List<Integer>> rightFuture = executorService.submit(rightSorter);

        return merge(leftFuture, rightFuture);
    }

    private List<Integer> merge(Future<List<Integer>> sortedLeftFuture, Future<List<Integer>> sortedRightFuture)
            throws InterruptedException, ExecutionException {
        List<Integer> sortedArray = new ArrayList<>();
        int first = 0;
        int second = 0;

        List<Integer> sortedLeft = sortedLeftFuture.get();
        List<Integer> sortedRight = sortedRightFuture.get();

        // Compare values from both the arrays
        while (first < sortedLeft.size() && second < sortedRight.size()) {
            // If left is smaller, add to sorted array
            // increment first
            if (sortedLeft.get(first) < sortedRight.get(second)) {
                sortedArray.add(sortedLeft.get(first));
                ++first;
            } else {
                // Add the right one to the sorted array
                // increment second
                sortedArray.add(sortedRight.get(second));
                ++second;
            }
        }

        while (first < sortedLeft.size()) {
            sortedArray.add(sortedLeft.get(first));
            ++first;
        }

        while (second < sortedRight.size()) {
            sortedArray.add(sortedRight.get(second));
            ++second;
        }

        return sortedArray;
    }
}
