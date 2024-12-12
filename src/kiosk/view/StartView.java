package kiosk.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class StartView extends JFrame {
    public StartView() {
        setTitle("울산대학교 키오스크");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // 이미지 경로 확인
        URL imageUrl = getClass().getResource("/resources/startImage.jpg");
        if (imageUrl == null) {
            System.err.println("이미지 파일을 찾을 수 없습니다.");
        } else {
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            Image scaledImage = imageIcon.getImage().getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage), SwingConstants.CENTER);
            panel.add(imageLabel, BorderLayout.CENTER);
        }

        // 패널에 마우스 클릭 리스너 추가
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose(); // 현재 창 닫기
                new JFrameView(); // 새로운 화면 열기
            }
        });

        add(panel);

        setVisible(true);
    }

}

