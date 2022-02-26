package JavaExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class GameFunction {
    SoundEffect se = DisplayGame.se;
        
    ArrayList<Character> clickColor = DisplayGame.clickColor;
    ArrayList<Character> trueColor = DisplayGame.trueColor;
    int score = DisplayGame.score, tmp = DisplayGame.tmp, bonusPoint = DisplayGame.bonusPoint, order = DisplayGame.order, timer = DisplayGame.timer, 
                BGtimer = DisplayGame.BGtimer, count = DisplayGame.count, rNumber = DisplayGame.rNumber, displayScore = DisplayGame.displayScore;
    boolean gameRun = DisplayGame.gameRun, restart = DisplayGame.restart;
    char modeChecker = DisplayGame.modeChecker;
    String modeSound = DisplayGame.modeSound;
    String greenSound = DisplayGame.greenSound;
    String redSound = DisplayGame.redSound;
    String pinkSound = DisplayGame.pinkSound;
    String blueSound = DisplayGame.blueSound;
    String gameoverSound = DisplayGame.gameoverSound;
    String wowSound = DisplayGame.wowSound;
    String awwSound = DisplayGame.awwSound;
    ImageIcon img = DisplayGame.img;
    JButton[] btn = DisplayGame.btn;
    JButton[] mode = DisplayGame.mode;
    JButton pnScore = DisplayGame.pnScore, playGame = DisplayGame.playGame, displayScoreBTN = DisplayGame.displayScoreBTN, restartGame = DisplayGame.restartGame;
    JPanel welcomeGame = DisplayGame.welcomeGame, windowsConponent = DisplayGame.windowsConponent, MenuBar = DisplayGame.MenuBar, 
                        westPn = DisplayGame.westPn, eastPn = DisplayGame.eastPn, southPn = DisplayGame.southPn, tBtn1 = DisplayGame.tBtn1;
    JLabel Text = DisplayGame.Text, ScoreText1 = DisplayGame.ScoreText1, ScoreText2 = DisplayGame.ScoreText2, ScoreText3 = DisplayGame.ScoreText3, 
                LogoGame = DisplayGame.LogoGame, pnCenter = DisplayGame.pnCenter, lostWindows = DisplayGame.lostWindows, displayScoreLB = DisplayGame.displayScoreLB, 
                ownerRef = DisplayGame.ownerRef;
    JLabel displayQuote = DisplayGame.displayQuote;
    JFrame lostFrame = DisplayGame.lostFrame;
    static Random rand = DisplayGame.rand;

    public void scoreboard() {
        if (score < 1000) {
            se.setFile(awwSound);
            displayQuote.setIcon(new ImageIcon(((new ImageIcon(".//res//Gameover-lv1.png")).getImage()).getScaledInstance(640, 650, java.awt.Image.SCALE_SMOOTH)));
        }
        else if (score >= 1000 && score < 3000) {
            se.setFile(wowSound);
            displayQuote.setIcon(new ImageIcon(((new ImageIcon(".//res//Gameover-lv2.png")).getImage()).getScaledInstance(640, 650, java.awt.Image.SCALE_SMOOTH)));
        }
        else if (score >= 3000 && score < 6000) {
            se.setFile(wowSound);
            displayQuote.setIcon(new ImageIcon(((new ImageIcon(".//res//Gameover-lv3.png")).getImage()).getScaledInstance(640, 650, java.awt.Image.SCALE_SMOOTH)));
        }
        else if (score >= 6000 && score < 10000) {
            se.setFile(wowSound);
            displayQuote.setIcon(new ImageIcon(((new ImageIcon(".//res//Gameover-lv4.png")).getImage()).getScaledInstance(640, 650, java.awt.Image.SCALE_SMOOTH)));
        }
        else if(score >= 10000 && score < 100000) {
            se.setFile(wowSound);
            displayQuote.setIcon(new ImageIcon(((new ImageIcon(".//res//Gameover-lv5.png")).getImage()).getScaledInstance(640, 650, java.awt.Image.SCALE_SMOOTH)));
        }
        else {
            se.setFile(wowSound);
            displayQuote.setIcon(new ImageIcon(((new ImageIcon(".//res//Gameover-lv5.png")).getImage()).getScaledInstance(640, 650, java.awt.Image.SCALE_SMOOTH)));
        }
        se.play();
        displayScore = score;
        score = 0 ;
        ScoreText2.setText(String.valueOf(0));
    }
    public void blinker() throws InterruptedException {
        if (score == 100000) ScoreText2.setText(String.valueOf(100000));
        else ScoreText2.setText(String.valueOf(score));
        for (int i = 0; i < 6; i++) {
            btn[0].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnGreen3.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
            btn[1].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnRed3.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
            btn[2].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnPink3.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
            btn[3].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnBlue3.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
            TimeUnit.MILLISECONDS.sleep(100);
            btn[0].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnGreen2.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
            btn[1].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnRed2.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
            btn[2].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnPink2.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
            btn[3].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnBlue2.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
            TimeUnit.MILLISECONDS.sleep(100);
        }
        btn[0].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnGreen3.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
        btn[1].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnRed3.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
        btn[2].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnPink3.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
        btn[3].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnBlue3.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
    }
    public void lostPanel() {
        Dimension lostSize = new Dimension(650, 690);
        
        displayScoreLB = new JLabel();
        displayScoreLB.setText(String.valueOf(displayScore));
        displayScoreLB.setFont(new Font("Serif", Font.BOLD, 100));
        displayScoreLB.setForeground(Color.WHITE);
        displayScoreLB.setBounds(300, 275, 205, 90);

        displayScoreBTN = new JButton();
        displayScoreBTN.setBounds(90, 225, 463, 150);
        displayScoreBTN.setLayout(new FlowLayout());
        displayScoreBTN.add(displayScoreLB);
        displayScoreBTN.setOpaque(false);
        displayScoreBTN.setContentAreaFilled(false);
        displayScoreBTN.setBorderPainted(false);

        restartGame = new JButton();
        restartGame.setBounds(215, 485, 205, 90);
        restartGame.setIcon(new ImageIcon(((new ImageIcon(".//res//Replay1.png")).getImage()).getScaledInstance(205, 90, java.awt.Image.SCALE_SMOOTH)));
        restartGame.setRolloverEnabled(true);
        restartGame.setRolloverIcon(new ImageIcon(((new ImageIcon(".//res//Replay2.png")).getImage()).getScaledInstance(205, 90, java.awt.Image.SCALE_SMOOTH)));;
        restartGame.setBorderPainted(false);
        restartGame.setContentAreaFilled(false);
        restartGame.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        tBtn1.setBounds(218, 445, 205, 170);
        tBtn1.setVisible(false);

        lostWindows = new JLabel();
        lostWindows.setSize(lostSize);
        lostWindows.setLayout(null);
        lostWindows.setIcon(displayQuote.getIcon());
        lostWindows.add(displayScoreBTN);
        lostWindows.add(restartGame);
        lostWindows.add(tBtn1);     

        restartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                se.setFile(modeSound);
                se.play();
                tBtn1.setVisible(true);
                restartGame.setVisible(false);
            }
        });

        lostFrame.setTitle("Simon Games Joystick Edition");
        lostFrame.setContentPane(lostWindows);
        lostFrame.setBackground(new Color(0, 22, 56));
        lostFrame.setResizable(false);
        lostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lostFrame.setSize(lostSize);
        lostFrame.setIconImage(new ImageIcon(".//res//LogoJoy.png").getImage());
        lostFrame.setLocationRelativeTo(null);
        lostFrame.setVisible(true);
    }
    public void startPanel() throws InterruptedException {
        btn[0].setEnabled(false);   btn[1].setEnabled(false);   btn[2].setEnabled(false);   btn[3].setEnabled(false);
        
        btn[0].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnGreen3.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
        btn[1].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnRed3.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
        btn[2].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnPink3.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
        btn[3].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnBlue3.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
    }
    public boolean clearGame(){
        btn[0].setEnabled(false);   btn[1].setEnabled(false);   btn[2].setEnabled(false);   btn[3].setEnabled(false);

        clickColor.clear();
        trueColor.clear();
        tmp = 1; bonusPoint = 0; order = 0; timer = 480; BGtimer = 360;
        return true;
    }
    public void setTrueColor () {
        for (int i = tmp - 1; i < tmp + 10; i++) {
            rNumber = rand.nextInt(4);
            if (rNumber == 0) trueColor.add('G');
            if (rNumber == 1) trueColor.add('R');
            if (rNumber == 2) trueColor.add('P');
            if (rNumber == 3) trueColor.add('B');
        }
    }
    public void Random() throws InterruptedException {
        timer = 480;
        BGtimer = 360;
        while(gameRun) {
            if(tmp % 10 == 1) setTrueColor();

            btn[0].setEnabled(false);   btn[1].setEnabled(false);   btn[2].setEnabled(false);   btn[3].setEnabled(false);

            TimeUnit.MILLISECONDS.sleep(480);
            for (int i = 0; i < tmp; i++) {
                if (!gameRun) break;
                bonusPoint = tmp * 8;
                if (modeChecker == 'S') bonusPoint = tmp * 10;
                if (trueColor.get(i) == 'G') {
                    se.setFile(greenSound);
                    se.play();
                    btn[0].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnGreen2.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
                    TimeUnit.MILLISECONDS.sleep(timer);
                    btn[0].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnGreen3.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
                    TimeUnit.MILLISECONDS.sleep(BGtimer);
                }
                if (trueColor.get(i) == 'R') {
                    se.setFile(redSound);
                    se.play();
                    btn[1].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnRed2.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
                    TimeUnit.MILLISECONDS.sleep(timer);
                    btn[1].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnRed3.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
                    TimeUnit.MILLISECONDS.sleep(BGtimer);
                }
                if (trueColor.get(i) == 'P') {
                    se.setFile(pinkSound);
                    se.play();
                    btn[2].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnPink2.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
                    TimeUnit.MILLISECONDS.sleep(timer);
                    btn[2].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnPink3.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
                    TimeUnit.MILLISECONDS.sleep(BGtimer);
                }
                if (trueColor.get(i) == 'B') {
                    se.setFile(blueSound);
                    se.play();
                    btn[3].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnBlue2.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
                    TimeUnit.MILLISECONDS.sleep(timer);
                    btn[3].setDisabledIcon(new ImageIcon(((new ImageIcon(".//res//btnBlue3.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
                    TimeUnit.MILLISECONDS.sleep(BGtimer);
                }
            }
            if (!gameRun) break;
            btn[0].setIcon(new ImageIcon(((new ImageIcon(".//res//btnGreen1.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
            btn[1].setIcon(new ImageIcon(((new ImageIcon(".//res//btnRed1.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
            btn[2].setIcon(new ImageIcon(((new ImageIcon(".//res//btnPink1.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
            btn[3].setIcon(new ImageIcon(((new ImageIcon(".//res//btnBlue1.png")).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
            btn[0].setEnabled(true);    btn[1].setEnabled(true);    btn[2].setEnabled(true);    btn[3].setEnabled(true);
            checkStop();
            if (!gameRun) break;
            order = 0;
            tmp++;
            if(modeChecker == 'S') {
                if (timer > 180) timer -= 60;
                if (BGtimer > 120) BGtimer -= 60;
            }
        }
    }
    public void checkTrueFalse() {
        if (clickColor.get(order) == (trueColor.get(order))) {
            if (clickColor.get(order) == 'G') se.setFile(greenSound);
            if (clickColor.get(order) == 'R') se.setFile(redSound);
            if (clickColor.get(order) == 'P') se.setFile(pinkSound);
            if (clickColor.get(order) == 'B') se.setFile(blueSound);
            se.play();
            score += bonusPoint;
            if (score >= 100000) {
                score = 100000;
                gameRun = false;
                modeChecker = 'D';
                se.setFile(gameoverSound);
                se.play();
                clearGame();
                return;
            }
            ScoreText2.setText(String.valueOf(score));
            order++;
        }
        else {
            gameRun = false;
            modeChecker = 'D';
            se.setFile(gameoverSound);
            se.play();
            clearGame();
        }
    }
    public void checkStop() throws InterruptedException {
        while (clickColor.size() < tmp && gameRun) {
            TimeUnit.MILLISECONDS.sleep(130);
        }
        clickColor.clear();
    }
    public void checkGAMEMODE() throws InterruptedException {
        while (modeChecker != 'N'&& modeChecker != 'S') {
            TimeUnit.MILLISECONDS.sleep(480);
        }
    }
}
