package com.wmyeah.wmlauncher.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 作者：ZhouYou
 * 日期：2016/8/29.
 */
public class ListUtils {
    private ListUtils(){}

    public static List<?> EMPTY_ARRAYLIST = new ArrayList<>();
    public static List<?> EMPTY_LINKEDLIST = new LinkedList<>();

    public static <E> boolean isEmpty(List<E> list) {
        return list == null || list.size() == 0;
    }

    public static <E> List<E> addElement(List<E> list, E element) {
        return addElement(list, element, -1);
    }

    public static <E> List<E> addElement(List<E> list, E element, int index) {
        if (list == null) return list;
        if (index < 0 || index > list.size()) {
            list.add(element);
        } else {
            list.add(index, element);
        }
        return list;
    }

    public static <E> List<E> removeElement(List<E> list, int index) {
        if (isEmpty(list) || index < 0 || index >= list.size()) return list;
        list.remove(index);
        return list;
    }

    public static <E> List<E> removeElement(List<E> list, E element) {
        if (isEmpty(list)) return list;
        list.remove(element);
        return list;
    }

    public static <E> E getElement(List<E> list, int index) {
        if (isEmpty(list) || index < 0 || index >= list.size()) return null;
        return list.get(index);
    }

    public static <E> int getCount(List<E> list) {
        if (isEmpty(list)) return 0;
        return list.size();
    }

    public static <E> boolean isEmpty(E[] list) {
        return list == null || list.length == 0;
    }

    public static <E> E[] addElement(E[] list, E element, int index) {
        if (list == null) return null;
        if (index >= 0 && index < list.length) {
            list[index] = element;
        }
        return list;
    }

    public static <E> E getElement(E[] list, int index) {
        if (isEmpty(list) || index < 0 || index >= list.length) return null;
        return list[index];
    }

    public static <E> int getCount(E[] list) {
        if (isEmpty(list)) return 0;
        return list.length;
    }

    public static <E> void sort(List<E> list, Comparator<? super E> comparator) {
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        Collections.sort(list, comparator);
    }

}
