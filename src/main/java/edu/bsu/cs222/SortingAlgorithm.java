package edu.bsu.cs222;

import java.util.List;

public class SortingAlgorithm {


    private void swap(List<Float> rateList, int i, int j) {
        Float temp = rateList.get(i);
        rateList.set(i, rateList.get(j));
        rateList.set(j, temp);
    }

    public List<Float> insertionSort(List<Float> rateList){
        for (int i=0; i < rateList.size(); ++i){
            for (int j = i; j > 0; --j){
                if (rateList.get(j) > rateList.get(j-1)){
                    break;
                }
                swap(rateList, j,j-1);
            }//Close inner loop
        }
        System.out.println(rateList);//Close outside loop
        return rateList;
    }//Close insertion_Sort method

}
