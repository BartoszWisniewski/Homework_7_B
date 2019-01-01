package com.isa.service;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class fibonacciService {

    public Integer findNumber(Integer n) {

        int result;
        if (n > 1) {
            return findNumber(n - 1) + findNumber(n - 2);
        } else if (n == 1) {
            result = 1;
            return result;
        } else {
            result = 0;
            return result;
        }
    }

    public List<Integer> listNumber(Integer n) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                list.add(i);
            } else {
                list.add(list.get(i - 1) + (list.get(i - 2)));
            }
        }
        return list;
    }
}


