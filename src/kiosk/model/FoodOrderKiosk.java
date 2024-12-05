package kiosk.model;

import kiosk.model.enums.Categorys;
import kiosk.model.enums.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodOrderKiosk extends Kiosk {
    public List<Food> menu; //음식 목록
    public Map<Integer, Order> orders = new HashMap<>();

    public FoodOrderKiosk() {
        super(Status.INACTIVE);
        menu = new ArrayList<>();
        initializeMenu();
    }

    public List<Food> getMenu() {
        return menu;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    private void initializeMenu() {
        menu.add(new Food(0,"resources/1.jpg","김치찌개", 7000, Categorys.KOREAN));
        menu.add(new Food(1,"resources/국밥.jpg","국밥", 8000, Categorys.KOREAN));
        menu.add(new Food(2,"resources/제육.jpg","제육볶음", 9000, Categorys.KOREAN));
        menu.add(new Food(3,"resources/불고기.jpg","불고기", 8500, Categorys.KOREAN));
        menu.add(new Food(4,"resources/4.jpg","비빔밥", 10000, Categorys.KOREAN));
        menu.add(new Food(5,"resources/5.jpg","스테이크", 10000, Categorys.WESTERN));
        menu.add(new Food(6,"resources/13.jpg","토마호크", 12000, Categorys.WESTERN));
        menu.add(new Food(7,"resources/6.jpg","뉴욕치킨", 16000, Categorys.WESTERN));
        menu.add(new Food(8,"resources/7.jpg","파스타", 15000, Categorys.WESTERN));
        menu.add(new Food(9,"resources/14.jpg","울산피자", 19000, Categorys.WESTERN));
        menu.add(new Food(10,"resources/9.jpg","짜장면", 8000, Categorys.CHINESE));
        menu.add(new Food(11,"resources/10.jpg","꿔바로우", 18000, Categorys.CHINESE));
        menu.add(new Food(12,"resources/15.jpg","마파두부", 17000, Categorys.CHINESE));
        menu.add(new Food(13,"resources/16.jpg","깐풍기", 14000, Categorys.CHINESE));
        menu.add(new Food(14,"resources/12.jpg","양장피", 20000, Categorys.CHINESE));
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }

    public void addOrder(int number) {
        Food selectedFood = menu.get(number);
        System.out.println(selectedFood.getName() + "을(를) 주문하셨습니다.");
        if (!orders.containsKey(number)) {
            // 주문이 없으면 새로 추가
            orders.put(number, new Order(selectedFood, 1));
        } else {
            // 이미 존재하는 경우 수량 증가
            Order existingOrder = orders.get(number);
            existingOrder.setQuantity(existingOrder.getQuantity() + 1);
        }
    }

    public void removeOrder(int number) {
        Food selectedFood = menu.get(number);
        System.out.println(selectedFood.getName() + "을(를) 주문 취소하셨습니다.");
        if (orders.containsKey(number)) {
            Order existingOrder = orders.get(number);
            if (existingOrder.getQuantity() > 1) {
                existingOrder.setQuantity(existingOrder.getQuantity() - 1);
            } else {
                orders.remove(number);
            }
        }
    }

    public void show(){
        System.out.println("주문내역");
        for (Order order : orders.values()) {
            System.out.println(order.getFood().getName());
            System.out.println(order.getQuantity());
        }
    }

//    public void checkout() {
//        int total = orders.stream().mapToInt(Order::calculateTotalPrice).sum();
//        System.out.println("\nOrder Summary:");
//        for (Order order : orders) {
//            System.out.println(order);
//        }
//        System.out.println("Total: $" + total);
//    }
}

