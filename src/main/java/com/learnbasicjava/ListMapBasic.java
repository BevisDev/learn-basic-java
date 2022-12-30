package com.learnbasicjava;

import com.learnbasicjava.entity.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMapBasic {

    public static void main(String[] args) {
        // demo1();
        demo2();
        // demo3();
    }

    private static void demo3() {
        Map<String, Double> map = new HashMap<>();
        map.put("BINH", 9.5);
        map.put("Thinh", 9.5);
        map.put("Van a", 6.5);

        // CACH 1
//		map.forEach((key,value) -> {
//			System.out.printf("%s = %.1f\r\n", key,value);
//		});

        // CACH 2
        map.keySet().forEach(x -> {
            System.out.printf("%s = %.1f\r\n", x, map.get(x));
        });

        System.out.println(map.keySet().toString());
        System.out.println(map.values().toString());
    }

    private static void demo2() {
        List<Account> list = new ArrayList<>();
        list.add(new Account("VAN A", "123", "Nga", "vana@gmail.com", "user.png", false, List.of()));
        list.add(new Account("BINH", "456", "binhne", "binhhtt@gmail.com", "user1.png", true, List.of()));
        list.add(new Account("THINH", "768", "xuanthinh", "thinhga@gmail.com", "user2.png", false, List.of()));

//		for(Account o : list) {
//			if (o.getActivated() == true) {
//				 System.out.println(o);
//			}
//		}

        list.stream()
                .filter(o -> !o.getActivated())
                .forEach(o -> System.out.println(o));

//		list.forEach(a -> {
//			if(o.getActivated() == false)
//			 System.out.println(o);
//		});
//
    }

    private static void demo1() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        list.forEach(n -> System.out.println(n));
    }
}
