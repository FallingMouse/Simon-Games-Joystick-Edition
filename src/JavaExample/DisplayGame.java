package JavaExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class DisplayGame {
    static ArrayList<Character> clickColor = new ArrayList<>();
    static ArrayList<Character> trueColor = new ArrayList<>();
    static int score = 0, tmp = 1, bonusPoint, order, timer, BGtimer, count = 0, rNumber, displayScore = 0;
    static boolean gameRun = true, restart;
    static char modeChecker = 'D';
    static String modeSound = ".//res//gamestart.wav";
    static String greenSound = ".//res//red.wav";
    static String redSound = ".//res//blue.wav";
    static String pinkSound = ".//res//yellow.wav";
    static String blueSound = ".//res//green.wav";
    static String gameoverSound = ".//res//gameover.wav";
    static String wowSound = ".//res//anime-wow-sound-effect.wav";
    static String awwSound = ".//res//studio-audience-awwww-sound-fx.wav";
    static ImageIcon img = new ImageIcon(".//res//LogoJoy.png");
    static JButton[] btn = new JButton[4];
    static JButton[] mode = new JButton[2];
    static JButton pnScore, playGame, displayScoreBTN, restartGame;
    static JPanel welcomeGame, windowsConponent, MenuBar, westPn, eastPn, southPn, tBtn1;
    static JLabel Text, ScoreText1, ScoreText2, ScoreText3, LogoGame, pnCenter, lostWindows, displayScoreLB, ownerRef;
    static JLabel displayQuote = new JLabel();
    static JFrame lostFrame = new JFrame();
    static Random rand = new Random();
    
    static SoundEffect se = new SoundEffect();
    GameFunction gameFunc = new GameFunction();

    public DisplayGame() throws InterruptedException {
        LogoGame = new JLabel();
        LogoGame.setBounds(100, 25, 240, 240);
        LogoGame.setIcon(new ImageIcon(((new ImageIcon(".//res//LogoJoy.png")).getImage()).getScaledInstance(240, 240, java.awt.Image.SCALE_SMOOTH)));

        playGame = new JButton();
        playGame.setBounds(115, 265, 205, 90);
        playGame.setIcon(new ImageIcon(((new ImageIcon(".//res//Play1.png")).getImage()).getScaledInstance(205, 90, java.awt.Image.SCALE_SMOOTH)));
        playGame.setRolloverEnabled(true);
        playGame.setRolloverIcon(new ImageIcon(((new ImageIcon(".//res//Play2.png")).getImage()).getScaledInstance(205, 90, java.awt.Image.SCALE_SMOOTH)));;
        playGame.setFont(new Font("Serif", Font.BOLD, 30));
        playGame.setBorderPainted(false);
        playGame.setContentAreaFilled(false);
        playGame.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ownerRef = new JLabel();
        ownerRef.setText("Simon Games Joystick Edition © 2020");
        ownerRef.setForeground(Color.WHITE);
        ownerRef.setFont(new Font("Serif", Font.BOLD, 14));
        ownerRef.setBounds(195, 420, 450, 20);

        tBtn1 = new JPanel();           
        tBtn1.setBackground(new Color(0, 22, 56));
        tBtn1.setLayout(null);
        
        mode[0] = new JButton();
        mode[0].setBounds(0, 0, 205, 80);
        mode[0].setIcon(new ImageIcon(((new ImageIcon(".//res//Normal1.png")).getImage()).getScaledInstance(205, 80, java.awt.Image.SCALE_SMOOTH)));
        mode[0].setCursor(new Cursor(Cursor.HAND_CURSOR));
        mode[0].setRolloverEnabled(true);
        mode[0].setRolloverIcon(new ImageIcon(((new ImageIcon(".//res//Normal2.png")).getImage()).getScaledInstance(205, 80, java.awt.Image.SCALE_SMOOTH)));
        mode[1] = new JButton();
        mode[1].setBounds(0, 85, 205, 80);
        mode[1].setIcon(new ImageIcon(((new ImageIcon(".//res//Expert1.png")).getImage()).getScaledInstance(205, 80, java.awt.Image.SCALE_SMOOTH)));
        mode[1].setCursor(new Cursor(Cursor.HAND_CURSOR));
        mode[1].setRolloverIcon(new ImageIcon(((new ImageIcon(".//res//Expert2.png")).getImage()).getScaledInstance(205, 80, java.awt.Image.SCALE_SMOOTH)));
        
        tBtn1.setBounds(115, 240, 205, 170);
        tBtn1.add(mode[0]);
        tBtn1.add(mode[1]);
        tBtn1.setVisible(false);
        gameFunc.tBtn1 = tBtn1;

        welcomeGame = new JPanel();
        welcomeGame.setLayout(null);
        welcomeGame.setBackground(new Color(0, 22, 56));
        welcomeGame.add(ownerRef);
        welcomeGame.add(LogoGame);
        welcomeGame.add(playGame);
        welcomeGame.add(tBtn1);     

        windowsConponent = new JPanel();
        windowsConponent.setLayout(new BorderLayout());
        MenuBar = new JPanel();
        MenuBar.setPreferredSize(new Dimension(640, 100));
        Text = new JLabel();
        Text.setIcon(new ImageIcon(((new ImageIcon(".//res//Name5.png")).getImage()).getScaledInstance(800, 100, java.awt.Image.SCALE_SMOOTH)));
        Text.setFont(new Font("Serif", Font.BOLD, 30));
        Text.setHorizontalAlignment(SwingConstants.CENTER);
        Text.setPreferredSize(new Dimension(2000, 100));
        Text.setBackground(new Color(0, 22, 56));
        Text.setOpaque(true);  
        MenuBar.add(Text);

        westPn = new JPanel();  eastPn = new JPanel();  southPn = new JPanel();
        westPn.setPreferredSize(new Dimension(30, 480));
        westPn.setBackground(new Color(0, 22, 56));
        eastPn.setPreferredSize(new Dimension(30, 480));
        eastPn.setBackground(new Color(0, 22, 56));
        southPn.setPreferredSize(new Dimension(640, 30));
        southPn.setBackground(new Color(0, 22, 56));

        ScoreText1 = new JLabel("Score");
        ScoreText1.setFont(new Font("Serif", Font.BOLD, 30));
        ScoreText1.setForeground(Color.BLACK);

        ScoreText2 = new JLabel();
        ScoreText2.setText(String.valueOf(score));
        ScoreText2.setBounds(190, 80, 60, 60);
        ScoreText2.setFont(new Font("Serif", Font.BOLD, 60));
        ScoreText2.setForeground(Color.WHITE);
        gameFunc.ScoreText2 = ScoreText2;
        ScoreText3 = new JLabel(" ");
        ScoreText3.setPreferredSize(new Dimension(40, 80));

        pnScore = new JButton();
        pnScore.setLayout(new FlowLayout());
        pnScore.setIcon(new ImageIcon(((new ImageIcon(".//res//Score.png")).getImage()).getScaledInstance(233, 90, java.awt.Image.SCALE_SMOOTH)));
        pnScore.add(ScoreText2);
        pnScore.setBounds(210, 10, 233, 90);
        pnScore.setBorderPainted(false);
        pnScore.setContentAreaFilled(false);

        //GREEN BUTTON
        btn[0] = new JButton();
        btn[0].setBounds(230, 150, 200, 200);
        btn[0].setIcon(new ImageIcon(((new ImageIcon(".//res//btnGreen1.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
        btn[0].setRolloverEnabled(true);
        btn[0].setRolloverIcon(new ImageIcon(".//res//btnGreen4.png"));
        btn[0].setPressedIcon(new ImageIcon(".//res//btnGreen2.png"));
        btn[0].setBorderPainted(false);
        btn[0].setContentAreaFilled(false);
        btn[0].setCursor(new Cursor(Cursor.HAND_CURSOR));
        //RED BUTTON
        btn[1] = new JButton();     btn[1].setBackground(Color.YELLOW);
        btn[1].setBounds(430, 280, 200, 200);
        btn[1].setIcon(new ImageIcon(((new ImageIcon(".//res//btnRed1.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
        btn[1].setRolloverEnabled(true);
        btn[1].setRolloverIcon(new ImageIcon(".//res//btnRed4.png"));
        btn[1].setPressedIcon(new ImageIcon(".//res//btnRed2.png"));
        btn[1].setBorderPainted(false);
        btn[1].setContentAreaFilled(false);
        btn[1].setCursor(new Cursor(Cursor.HAND_CURSOR));
        //PINK BUTTON
        btn[2] = new JButton();       btn[2].setBackground(Color.BLUE);
        btn[2].setBounds(30, 280, 200, 200);
        btn[2].setIcon(new ImageIcon(((new ImageIcon(".//res//btnPink1.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
        btn[2].setRolloverEnabled(true);
        btn[2].setRolloverIcon(new ImageIcon(".//res//btnPink4.png"));
        btn[2].setPressedIcon(new ImageIcon(".//res//btnPink2.png"));
        btn[2].setBorderPainted(false);
        btn[2].setContentAreaFilled(false);
        btn[2].setCursor(new Cursor(Cursor.HAND_CURSOR));
        //BLUE BUTTON
        btn[3] = new JButton();      btn[3].setBackground(Color.GREEN);
        btn[3].setBounds(230, 415, 200, 200);
        btn[3].setIcon(new ImageIcon(((new ImageIcon(".//res//btnBlue1.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
        btn[3].setRolloverEnabled(true);
        btn[3].setRolloverIcon(new ImageIcon(".//res//btnBlue4.png"));
        btn[3].setPressedIcon(new ImageIcon(".//res//btnBlue2.png"));
        btn[3].setBorderPainted(false);
        btn[3].setContentAreaFilled(false);
        btn[3].setCursor(new Cursor(Cursor.HAND_CURSOR));

        pnCenter = new JLabel();
        pnCenter.setLayout(null);
        pnCenter.setIcon(new ImageIcon(((new ImageIcon(".//res//pnCenterBG.png")).getImage()).getScaledInstance(665, 750, java.awt.Image.SCALE_SMOOTH)));
        pnCenter.add(btn[0]);   pnCenter.add(btn[1]);   pnCenter.add(btn[2]);   pnCenter.add(btn[3]);
        pnCenter.add(pnScore);  

        windowsConponent.setBackground(new Color(0, 22, 56));
        windowsConponent.add(MenuBar, BorderLayout.NORTH);
        windowsConponent.add(pnCenter, BorderLayout.CENTER);
        windowsConponent.add(westPn, BorderLayout.WEST);
        windowsConponent.add(eastPn, BorderLayout.EAST);
        windowsConponent.add(southPn, BorderLayout.SOUTH);

        Dimension sz = new Dimension(450, 490);
        JFrame frame = new JFrame();
        frame.setTitle("Simon Games Joystick Edition");
        frame.setContentPane(welcomeGame);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(sz);
        frame.setIconImage(new ImageIcon(".//res//LogoJoy.png").getImage());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Dimension size = new Dimension(750, 790);
        JFrame inGameFrame = new JFrame();
        inGameFrame.setTitle("Simon Games Joystick Edition");
        inGameFrame.setContentPane(windowsConponent);
        inGameFrame.setResizable(false);
        inGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inGameFrame.setSize(size);
        inGameFrame.setIconImage(new ImageIcon(".//res//LogoJoy.png").getImage());
        inGameFrame.setLocationRelativeTo(null);
        inGameFrame.setVisible(false);

        //When Startgame set color button(4 Playstation Button)
        //enable to false
        gameFunc.startPanel();

        playGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                se.setFile(modeSound);
                se.play();
                tBtn1.setVisible(true);
                playGame.setVisible(false);
            }
        });
        mode[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFunc.modeChecker = 'N';
                se.setFile(modeSound);
                se.play();
                frame.setVisible(false);
                inGameFrame.setVisible(true);
                lostFrame.setVisible(false);
                gameFunc.gameRun = true;
                gameFunc.count++;
            }
        });
        mode[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFunc.modeChecker = 'S';
                se.setFile(modeSound);
                se.play();
                frame.setVisible(false);
                inGameFrame.setVisible(true);
                lostFrame.setVisible(false);
                gameFunc.gameRun = true;
                gameFunc.count++;
            }
        });
        btn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFunc.clickColor.add('G');
                gameFunc.checkTrueFalse();
            }
        });
        btn[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFunc.clickColor.add('R');
                gameFunc.checkTrueFalse();
            }
        });
        btn[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFunc.clickColor.add('P');
                gameFunc.checkTrueFalse();
            }
        });
        btn[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFunc.clickColor.add('B');
                gameFunc.checkTrueFalse();
            }
        });
        do {
            inGameFrame.setVisible(false);
            gameFunc.checkGAMEMODE();
            gameFunc.Random();
            restart = gameFunc.clearGame(); //true
            gameFunc.blinker();
            gameFunc.scoreboard();
            gameFunc.lostPanel();
        }
        while (restart) ;
    }
}