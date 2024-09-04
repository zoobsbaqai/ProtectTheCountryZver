import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;


//following code is from zohair
public class GameButtons extends JPanel {

    //initializing all the Jbuttons
    JButton watBtn;
    JButton rivBtn;
    JButton fireBtn;
    JButton earBtn;
    JButton airBtn;
    JButton extBtn;
    JLabel coinTxt;
    JButton passBtn;
    DecimalFormat formatter = new DecimalFormat("#,###");
    Clicklistener click= new Clicklistener();

    //setting up each button to a set size and text
    public void exitBut(){
        
        extBtn = new JButton("X");
        extBtn.setBounds(5,65,50,30);
        extBtn.addActionListener(click);
        this.setLayout(null);
        this.add(watBtn);
    }

    public void passBut(){
        passBtn = new JButton("PASS");
        passBtn.setBounds(400, 20, 120, 60);
        passBtn.addActionListener(click);
        this.setLayout(null);
        this.add(passBtn);
    }

    public void waterBut(){
        watBtn = new JButton("Tsunami Alarm $1M");
        watBtn.setBounds(1110, 20, 150, 60);
        watBtn.addActionListener(click);
        this.setLayout(null);
        this.add(watBtn);
    }

    public void riverBut(){
        rivBtn = new JButton("River Dam $3M");
        rivBtn.setBounds(985, 20, 120, 60);
        rivBtn.addActionListener(click);
        this.setLayout(null);
        this.add(rivBtn);
    }

    public void fireBut(){
        fireBtn = new JButton("Firefighters $2M");
        fireBtn.setBounds(850, 20, 130, 60);
        fireBtn.addActionListener(click);
        this.setLayout(null);
        this.add(fireBtn);
    }

    public void earthBut(){
        earBtn = new JButton("Earthquake Alarm $1M");
        earBtn.setBounds(680, 20, 165, 60);
        earBtn.addActionListener(click);        
        this.setLayout(null);
        this.add(earBtn);
    }

    public void airBut(){
        airBtn = new JButton("Tornado Siren $1M");
        airBtn.setBounds(525, 20, 150, 60);
        airBtn.addActionListener(click);        
        this.setLayout(null);
        this.add(airBtn);
    }

    public void coinText(){
        coinTxt = new JLabel("$" + formatter.format(Game.coins));
        coinTxt.setBounds(110, 50, 300, 20);
        coinTxt.setFont(new Font("Serif", Font.PLAIN, 20));
    }

    //this will add all the buttons to be able to be used
    public GameButtons() {

        this.setPreferredSize(new Dimension(1280, 100));

        passBut();
        this.add(passBtn);

        waterBut();
        this.add(watBtn);

        riverBut();
        this.add(rivBtn);

        earthBut();  
        this.add(earBtn);
        
        fireBut();
        this.add(fireBtn);

        airBut();
        this.add(airBtn);

        exitBut();
        this.add(extBtn);

        coinText();
        this.add(coinTxt);
    }

    //Usman
    //This class determines the function of each button
    private class Clicklistener implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //checks and performs function

            if (e.getSource() == fireBtn){
                System.out.println("Fire clicked");
                if (Game.coins > 2000000){
                    JOptionPane.showMessageDialog(null, "Fire Fighters purchased!");
                    Game.buyFireFighters();
                }else{
                    JOptionPane.showMessageDialog(null, "You can't afford that!");
                }
            }else if (e.getSource() == earBtn){
                if (Game.coins > 1000000){
                    JOptionPane.showMessageDialog(null, "Earthquake Siren Placed!");
                    System.out.println("Earth clicked");
                    Game.buyEarthquake();
                }else{
                    JOptionPane.showMessageDialog(null, "You can't afford that!");
                }
            }else if (e.getSource() == airBtn){
                if (Game.coins > 1000000){
                    JOptionPane.showMessageDialog(null, "Tornado Siren Placed!");
                    System.out.println("Air clicked");
                    Game.buyTornadoAlarm();
                }else{
                    JOptionPane.showMessageDialog(null, "You can't afford that!");
                }
            }else if (e.getSource() == rivBtn){
                if (Game.coins > 3000000){
                    JOptionPane.showMessageDialog(null, "River Dam Built!");
                    System.out.println("River clicked");
                    Game.buyDam();
                }else{
                    JOptionPane.showMessageDialog(null, "You can't afford that!");
                }
            }else if (e.getSource() == watBtn){
                if (Game.coins > 1000000){
                    JOptionPane.showMessageDialog(null, "Tsunami Alarms Built!");
                    System.out.println("Water clicked");
                    Game.buyTsunamiAlarm();
                }else{
                    JOptionPane.showMessageDialog(null, "You can't afford that!");
                }
            }else if (e.getSource() == extBtn){
                System.out.println("Exit clicked");
                JOptionPane.showMessageDialog(null, "Exiting the Program.");
                SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
            }else if (e.getSource() == passBtn){
                Game.coins += 1000000;
                Game.startRound();
                //Game.test();
            }
        }
    }
}