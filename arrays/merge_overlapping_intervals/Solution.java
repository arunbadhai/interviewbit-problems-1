package arrays.merge_overlapping_intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;

/**
 Merge Overlapping Intervals
 https://www.interviewbit.com/problems/merge-overlapping-intervals/

 Given a collection of intervals, merge all overlapping intervals.

 For example:
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].

 Make sure the returned intervals are sorted.
 */

public class Solution {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args) {
        System.out.println(
                merge(new ArrayList<>(asList(new Interval(1, 3), new Interval(2, 6), new Interval(8, 10))))
        );
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort((i1, i2) -> i1.start - i2.start);

        HashSet<Interval> intervalsToRemove = new HashSet<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval first = intervals.get(i);
            int end = first.end;

            if (!intervalsToRemove.contains(first)) {
                for (int j = i+1; j < intervals.size(); j++) {
                    Interval second = intervals.get(j);
                    if (end >= second.start && !intervalsToRemove.contains(second)) {
                        if (end < second.end) {
                            first.end = end = second.end;
                        }
                        intervalsToRemove.add(second);
                    }


                }
            }
        }

        intervals.removeAll(intervalsToRemove);

        return intervals;
    }

}

// Can be optimized by storing current elemnt instead of iterating all subset:
//
//    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
//
//        Collections.sort(intervals,new Comparator<Interval>(){
//            @Override
//            public int compare(Interval a, Interval b)
//            {
//                return a.start-b.start;
//            }
//        });
//        ArrayList<Interval>res=new ArrayList<Interval>();
//        int start=intervals.get(0).start;
//        int end=intervals.get(0).end;
//        for(int i=1;i<intervals.size();i++)
//        {
//            if(intervals.get(i).start<=end)
//            {
//                end=Math.max(intervals.get(i).end,end);
//            }
//            else
//            {
//                res.add(new Interval(start,end));
//                start=intervals.get(i).start;
//                end=intervals.get(i).end;
//            }
//        }
//        res.add(new Interval(start,end));
//
//        return res;
//    }

