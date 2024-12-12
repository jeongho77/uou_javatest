package kiosk.view;

import kiosk.model.Food;
import kiosk.model.FoodOrderKiosk;
import kiosk.model.Kiosk;
import kiosk.model.Order;
import kiosk.model.enums.Status;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class JFrameView extends JFrame {
    Color color = new Color(233, 250, 244); // RGB 사용
    FoodOrderKiosk foodOrderKiosk = new FoodOrderKiosk();
    private JPanel orderPanel; // 주문 패널
    JPanel containerPanel = new JPanel(new BorderLayout()); // 상위 패널에 BorderLayout 사용

    public JFrameView() {
        setTitle("울산대학교 키오스크");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800); // 프레임 크기 설정
        setLayout(new BorderLayout()); // 레이아웃 설정 (헤더, 센터, 푸터 배치 가능)

        setBackground(color);

        // 헤더, 센터, 푸터 추가
        add(new Header().header(), BorderLayout.NORTH); // 헤더를 상단에 추가
        add(createProductPanel(), BorderLayout.CENTER);
//        add(createOrderPanel(), BorderLayout.EAST);
        Kiosk kisok = new Kiosk(Status.ACTIVE); //키오스크 시작
        setVisible(true); // 프레임 출력
    }


    private JPanel createProductPanel() {
        containerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 10)); // 마진 추가
        containerPanel.setBackground(color);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30)); // 마진 추가
        contentPanel.setBackground(Color.WHITE);

        // 제품 라벨 상단에 추가
        JLabel productTitle = new JLabel("Products");
        productTitle.setFont(new Font("맑은고딕", Font.BOLD, 20));
        Color green = new Color(14, 159, 104); // RGB 사용
        productTitle.setForeground(green); // 배경색 설정
        productTitle.setHorizontalAlignment(SwingConstants.LEFT);
        productTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // 마진 추가
        contentPanel.add(productTitle, BorderLayout.NORTH);

        // 제품 패널 (3행 4열)
        JPanel productPanel = new JPanel(new GridLayout(3, 5, 10, 10));
        productPanel.setBackground(Color.white);

        FoodOrderKiosk kiosk = new FoodOrderKiosk();
        List<Food> products = kiosk.menu;

        for (int i = 0; i < products.size(); i++) {
            JPanel product = new JPanel(new BorderLayout());
            // 이미지 설정
            String imagePath = products.get(i).getImageUrl();
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/" + imagePath));
            Image scaledImage = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // 이미지 크기 조정
            JLabel image = new JLabel(new ImageIcon(scaledImage), SwingConstants.CENTER); // JLabel에 이미지 설정
            image.setBackground(Color.BLUE);

            // 텍스트 설정
            JLabel name = new JLabel(products.get(i).getName(), SwingConstants.CENTER);
            JLabel price = new JLabel(products.get(i).getPrice() + "원", SwingConstants.CENTER);

            // 텍스트를 담는 패널
            JPanel textPanel = new JPanel(new GridLayout(2, 1));
            textPanel.setBackground(Color.WHITE);
            textPanel.add(name);
            textPanel.add(price);

            // 구성 추가
            product.add(image, BorderLayout.CENTER); // 이미지 상단
            product.add(textPanel, BorderLayout.SOUTH); // 텍스트 하단

            int productIndex = products.get(i).getNumber(); // 클릭한 제품을 식별하기 위한 인덱스 저장
            product.addMouseListener(new java.awt.event.MouseAdapter() {
                // 클릭 시 실행할 동작
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    foodOrderKiosk.addOrder(productIndex); // 주문 데이터 추가
                    System.out.println("클릭된 제품: " + foodOrderKiosk.getMenu().get(productIndex).getName());

                    // 기존 주문 패널을 새로 생성된 패널로 교체
                    JPanel updatedOrderPanel = createOrderPanel(); // 새로운 주문 패널 생성
                    containerPanel.remove(orderPanel); // 기존 주문 패널 제거
                    containerPanel.add(updatedOrderPanel, BorderLayout.EAST); // 새 패널 추가

                    // 레이아웃 갱신
                    containerPanel.revalidate();
                    containerPanel.repaint();

                    // 주문 패널 참조 업데이트
                    orderPanel = updatedOrderPanel;
                }

                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    product.setBackground(Color.LIGHT_GRAY); // 마우스가 들어오면 배경색 변경
                    textPanel.setBackground(Color.LIGHT_GRAY); // 마우스가 들어오면 텍스트 패널 배경색 변경
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    product.setBackground(Color.WHITE); // 마우스가 나가면 배경색 복구
                    textPanel.setBackground(Color.WHITE); // 마우스가 나가면 텍스트 패널 배경색 복구
                }
            });
            product.setBackground(Color.WHITE); //오버라이드 메소드 때문에 색이 회색으로 바껴 추가함
            product.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // 테두리 추가
            productPanel.add(product); // 최종적으로 제품 패널에 추가
        }

        contentPanel.add(productPanel);
//        contentPanel.add(createCategoryPanel(), BorderLayout.SOUTH);
//
//        // 카테고리 패널 하단에 추가
//        JPanel categoryPanel = createCategoryPanel();

        // 구성 추가
        containerPanel.add(contentPanel, BorderLayout.CENTER);
        containerPanel.add(orderPanel = createOrderPanel(), BorderLayout.EAST);
        return containerPanel;
    }

//    private JPanel createCategoryPanel() {
//        JPanel categoryPanel = new JPanel(new GridLayout(1, 4, 10, 10)); // 1행 5열
//        categoryPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // 마진 추가
//        categoryPanel.setPreferredSize(new Dimension(100, 80));
//        categoryPanel.setBackground(color);
//
//        // 더미 카테고리 버튼 추가
//        String[] categories = {"전체", "한식", "중식", "양식", "커피"};
//        for (String category : categories) {
//            JButton button = new JButton(category);
//            button.setBackground(Color.WHITE);
//            categoryPanel.add(button);
//        }
//
//        return categoryPanel;
//    }

    private JPanel createOrderPanel() {
        JPanel orderPanel = new JPanel(new BorderLayout());
        orderPanel.setPreferredSize(new Dimension(300, 0)); // 오른쪽 전체 높이
        orderPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 1)); // 마진 추가
        orderPanel.setBackground(color);

        JLabel orderTitle = new JLabel("주문 목록");
        orderTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        orderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        orderTitle.setBackground(Color.WHITE);

        // 주문 항목 리스트 패널
        JPanel itemList = new JPanel();
        itemList.setLayout(new BoxLayout(itemList, BoxLayout.Y_AXIS));
        itemList.setBackground(Color.WHITE);

        // 주문 항목 추가
        for (Map.Entry<Integer, Order> entry : foodOrderKiosk.getOrders().entrySet()) {
            Order order = entry.getValue();
            Food food = order.getFood();

            JPanel itemPanel = new JPanel(new BorderLayout());
            itemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            itemPanel.setBackground(Color.WHITE);

            JLabel itemName = new JLabel(food.getName() + " x " + order.getQuantity() + "  ", SwingConstants.LEFT);
            JLabel itemPrice = new JLabel("  " + (food.getPrice() * order.getQuantity()) + "원", SwingConstants.RIGHT);

            JPanel quantityPanel = new JPanel(new GridLayout(1, 2, 5, 0));
            JButton plusButton = new JButton("+");
            JButton minusButton = new JButton("-");
            JButton allRemoveButton = new JButton("X");

            plusButton.setBackground(Color.WHITE);
            minusButton.setBackground(Color.WHITE);
            allRemoveButton.setBackground(Color.WHITE);

            // 버튼 크기 고정
            Dimension buttonSize = new Dimension(20, 20);
            plusButton.setPreferredSize(buttonSize);
            minusButton.setPreferredSize(buttonSize);
            allRemoveButton.setPreferredSize(buttonSize);

            plusButton.addActionListener(e -> {
                foodOrderKiosk.addOrder(food.getNumber());
                updateOrderPanel();
            });

            minusButton.addActionListener(e -> {
                if (order.getQuantity() > 1) {
                    order.setQuantity(order.getQuantity() - 1);
                } else {
                    foodOrderKiosk.getOrders().remove(food.getNumber());
                }
                updateOrderPanel();
            });

            allRemoveButton.addActionListener(e -> {
                foodOrderKiosk.getOrders().remove(food.getNumber());
                updateOrderPanel();
            });

            quantityPanel.add(plusButton);
            quantityPanel.add(minusButton);
            quantityPanel.add(allRemoveButton);

            itemPanel.add(itemName, BorderLayout.WEST);
            itemPanel.add(quantityPanel, BorderLayout.CENTER);
            itemPanel.add(itemPrice, BorderLayout.EAST);

            itemPanel.setMaximumSize(new Dimension(400, 60));
            itemList.add(itemPanel);
            itemList.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        // 하단 총합
        int total = calculateTotal();
        JLabel totalLabel = new JLabel("Total: " + total + "원");
        totalLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        totalLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton removeButton = new JButton("전체 지우기");
        if(foodOrderKiosk.getOrders().isEmpty()){
            removeButton.setEnabled(false);
            removeButton.setBackground(Color.GRAY);
        }else{
            removeButton.setEnabled(true);
            removeButton.setBackground(Color.RED);
        }
        removeButton.addActionListener(e -> {
            if(foodOrderKiosk.getOrders().isEmpty()){
                JOptionPane.showMessageDialog(null, "주문할 음식이 없습니다.");
            }else{
                foodOrderKiosk.getOrders().clear();
                updateOrderPanel();
            }
        });

        JButton orderButton = new JButton("결제하기");
        if(foodOrderKiosk.getOrders().isEmpty()){
            orderButton.setEnabled(false);
            orderButton.setBackground(Color.GRAY);
        }else{
            orderButton.setEnabled(true);
            orderButton.setBackground(Color.green);
        }

        orderButton.addActionListener(e -> {
            if(foodOrderKiosk.getOrders().isEmpty()){
                JOptionPane.showMessageDialog(null, "주문할 음식이 없습니다.");
            } else {
                // 결제 확인 창
                int option = JOptionPane.showOptionDialog(
                        null,
                        "결제할 비용은 총 " + total + "원 입니다.\n결제하시겠습니까?",
                        "결제 확인",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"결제하기", "돌아가기"}, // 버튼 이름
                        "결제하기" // 기본 선택 버튼
                );

                // 결제 처리
                if (option == JOptionPane.YES_OPTION) {
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Message");
                    dialog.setModal(true); // 모달로 설정하지 않으면 자동으로 닫힘
                    dialog.setSize(300, 150);
                    dialog.setLocationRelativeTo(null); // 화면 중앙에 표시

                    JLabel messageLabel = new JLabel(
                            "<html><div style='text-align: center;'>결제가 완료되었습니다.<br>3초 후 초기 화면으로 이동합니다.</div></html>",
                            SwingConstants.CENTER
                    );
                    dialog.add(messageLabel, BorderLayout.CENTER);

                    // 타이머를 사용해 3초 후에 실행
                    Timer timer = new Timer(3000, event -> {
                        System.out.println("동작 완료");
                        dialog.dispose(); // 메시지 창 닫기
                        foodOrderKiosk.getOrders().clear(); // 주문 초기화
                        updateOrderPanel(); // UI 갱신
                        dispose(); // 현재 창 닫기
                        new StartView(); // 새로운 화면 열기
                    });

                    timer.setRepeats(false); // 타이머를 한 번만 실행
                    timer.start();
                    dialog.setVisible(true);

                } else if (option == JOptionPane.NO_OPTION) {
                    // 돌아가기: 아무 동작도 하지 않음
                }
            }
        });

        // 패널에 구성 추가
        orderPanel.add(orderTitle, BorderLayout.NORTH);
        orderPanel.add(new JScrollPane(itemList), BorderLayout.CENTER); // 스크롤 가능
        // 하단 패널 생성
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // 간격 설정
        footerPanel.setBackground(Color.WHITE);

        // Total Label 추가
        footerPanel.add(totalLabel, BorderLayout.NORTH);

        JPanel footer2Panel = new JPanel(new GridLayout(1, 2));
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // 간격 설정
        footerPanel.setBackground(Color.WHITE);
        footer2Panel.add(removeButton);
        footer2Panel.add(orderButton);
        footerPanel.add(footer2Panel, BorderLayout.SOUTH);

        // 패널에 구성 추가
        orderPanel.add(orderTitle, BorderLayout.NORTH);
        orderPanel.add(new JScrollPane(itemList), BorderLayout.CENTER); // 스크롤 가능
        orderPanel.add(footerPanel, BorderLayout.SOUTH); // Footer 패널 추가

        return orderPanel;
    }

    public int calculateTotal() {
        int total = 0;
        for (Order order : foodOrderKiosk.getOrders().values()) {
            total += order.getFood().getPrice() * order.getQuantity();
        }
        return total;
    }

    public void updateOrderPanel() {
        JPanel updatedOrderPanel = createOrderPanel(); // 새로운 주문 패널 생성
        containerPanel.remove(orderPanel); // 기존 주문 패널 제거
        containerPanel.add(updatedOrderPanel, BorderLayout.EAST); // 새 패널 추가

        // 레이아웃 갱신
        containerPanel.revalidate();
        containerPanel.repaint();

        // 주문 패널 참조 업데이트
        orderPanel = updatedOrderPanel;
    }
}
