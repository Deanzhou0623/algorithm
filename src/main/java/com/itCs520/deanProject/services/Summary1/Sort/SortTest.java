package com.itCs520.deanProject.services.Summary1.Sort;

import com.itCs520.deanProject.services.Day03.sort.Merge.Merge;
import com.itCs520.deanProject.services.Summary1.Sort.Bubble.BubbleSort2;
import com.itCs520.deanProject.services.Summary1.Sort.Insertion.InsertionSort;
import com.itCs520.deanProject.services.Summary1.Sort.Merge.MergeSort;
import com.itCs520.deanProject.services.Summary1.Sort.Merge.MergeSort2;
import com.itCs520.deanProject.services.Summary1.Sort.Quick.QuickSort;
import com.itCs520.deanProject.services.Summary1.Sort.Quick.QuickSort2;
import com.itCs520.deanProject.services.Summary1.Sort.Selection.SelectionSort;
import com.itCs520.deanProject.services.Summary1.Sort.Selection.SelectionSort2;
import com.itCs520.deanProject.services.Summary1.Sort.Shell.ShellSort;
import com.itCs520.deanProject.services.Summary1.Sort.Shell.ShellSort2;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        Integer[] arr={4,5,6,3,2,1,23,754,2125,7745543,43,321,456,909};
        QuickSort2.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
