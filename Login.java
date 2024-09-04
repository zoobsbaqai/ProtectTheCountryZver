import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

//zohair
class Login extends JFrame {
    public static void main(String[] args) {

        //initializing basic visuals for login screen
        JFrame frame = new JFrame("Protect The Country!; Login");

        final JTextField textField = new JTextField();
        textField.setBounds(125, 120, 150, 20);

        JButton login = new JButton("Login");
        login.setBounds(150, 150, 95, 30);

        JButton cont = new JButton("Continue?");
        cont.setBounds(150, 300, 95, 30);

        JLabel entUser;
        entUser = new JLabel("Please Enter Username!");
        entUser.setBounds(125, 100, 150, 20);

        JLabel userName;
        userName = new JLabel();
        userName.setBounds(130, 190, 300, 20);

        JLabel title;
        title = new JLabel("PROTECT THE COUNTRY!");
        title.setBounds(85, 50, 300, 20);
        title.setFont(new Font("Serif", Font.PLAIN, 20));

        frame.setLocationRelativeTo(null);

        //adding everything onto the frame
        frame.add(entUser);
        frame.add(userName);
        frame.add(title);
        frame.add(login);
        frame.add(textField);
        frame.add(cont);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //getting inputs
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = textField.getText();
                userName.setText("Your Username is " + data);
                frame.remove(login);
                cont.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            FileWriter writer = new FileWriter("logininfo.txt", true);
                            writer.write(data + "\n");
                            writer.close();
                            System.out.println("New login credentials appended to logininfo.txt");
                        } catch (IOException x) {
                            System.out.println("An error occurred while writing to the file.");
                            x.printStackTrace();
                        }
                        SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
                        MainMenu game = new MainMenu();
                        game.main(args);
                    }
                });
            }
        });


    }
}