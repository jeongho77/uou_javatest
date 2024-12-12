package kiosk.view;

import javax.swing.*;
import java.awt.*;

public class Header extends JFrame {
    //헤더 메소드
    public JPanel header() {
        JPanel header = new JPanel(new BorderLayout());
        header.setPreferredSize(new Dimension(1000, 70)); // 헤더 크기 설정

        Color color = new Color(14, 159, 104); // RGB 사용
        header.setBackground(color); // 배경색 설정

        JLabel title = new JLabel("Kiosk");
        JLabel uni = new JLabel("울산대학교");
        title.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        uni.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        title.setForeground(Color.WHITE); // 글자색 설정
        uni.setForeground(Color.WHITE); // 글자색 설정

        // 각각의 JLabel을 패널로 감싸기
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(color);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0)); // 왼쪽 여백 20px
        leftPanel.add(uni, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(color);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20)); // 오른쪽 여백 20px
        rightPanel.add(title, BorderLayout.CENTER);

        header.add(leftPanel, BorderLayout.WEST);
        header.add(rightPanel, BorderLayout.EAST);

        return header;
    }
}
