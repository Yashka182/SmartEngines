package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Polygon {

    public int searchPoly(ArrayList<int[]> poly, int [] a){
        int index = 0;
        for(int[] element : poly){
            if(element[0] == a[0] && element[1] == a[1]){
                return index;
            }
            index++;
        }
        return -1;
    }

    public double areaOfTriangle(int[] a, int[] b, int[] c){
        return Math.abs(0.5*(((b[0] - a[0])*(c[1] - a[1])) - ((c[0] - a[0])*(b[1] - a[1]))));
    }

    public double areaOfSubpoly(ArrayList<int[]> subpoly){
        int area = 0;
        for(int i =  1; i < subpoly.size() - 1; i++){
            area += areaOfTriangle(subpoly.get(0), subpoly.get(i), subpoly.get(i+1));
        }
        return area;
    }
    public double[] areaOfPolys(ArrayList<int[]> poly, int[] a, int[] b){
        int aIndex = searchPoly(poly, a);
        int bIndex = searchPoly(poly, b);
        int firstIndex = 0;
        int secondIndex = 0;
        if(aIndex < bIndex) {
            firstIndex = aIndex;
            secondIndex = bIndex;
        }else{
            firstIndex = bIndex;
            secondIndex = aIndex;
        }
        ArrayList<int[]> subPoly1 = new ArrayList<int[]>(poly.subList(firstIndex, secondIndex + 1));
        ArrayList<int[]> subPoly2 = new ArrayList<int[]>(poly.subList(secondIndex, poly.size()));
        subPoly2.addAll(poly.subList(0, firstIndex + 1));
        return new double[] {areaOfSubpoly(subPoly1), areaOfSubpoly(subPoly2)};
    }

    public static void main(String[] args) {
        Polygon polygon = new Polygon();

        ArrayList<int[]> testPoly2= new ArrayList<>();
        testPoly2.add(new int[]{2, 2});
        testPoly2.add(new int[]{2, 10});
        testPoly2.add(new int[]{6, 14});
        testPoly2.add( new int[]{14, 6});
        testPoly2.add( new int[]{14, 2});

        double[] result = polygon.areaOfPolys(testPoly2, new int[] {2, 10}, new int[] {14, 2});
        System.out.println(Arrays.toString(result) + "\n" + (result[0] + result[1]));
        System.out.println(polygon.areaOfSubpoly(testPoly2));
    }

}
