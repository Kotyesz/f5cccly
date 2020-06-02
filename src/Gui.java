import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Gui extends JFrame {
    Robot rob;
    JFrame mainframe;
    JTextField input;
    JButton setBtn;
    JLabel infLabel;
    Gui(Robot rob) {
        this.rob = rob;

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException e) {e.printStackTrace();
        } catch (InstantiationException e) {e.printStackTrace();
        } catch (IllegalAccessException e) {e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {e.printStackTrace();}

        mainframe = new JFrame("f5cccly");
        infLabel = new JLabel();
        setBtn = new JButton("SUBMIT");
        input = new JTextField();
        mainframe.setResizable(false);
        mainframe.setLayout(new GridLayout(1,3));
        infLabel.setText("Másodperc->");
        input.setText("5");
        setBtn.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e){rob.loop(Integer.parseInt(input.getText()));}
        });

        input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String value = input.getText();
                int l = value.length();
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9'
                        || e.getKeyChar() == KeyEvent.VK_BACK_SPACE || e.getKeyChar() == KeyEvent.VK_DELETE) {
                    input.setEditable(true);
                } else {
                    input.setEditable(false);
                }
            }
        });
        mainframe.add(infLabel);
        mainframe.add(input);
        mainframe.add(setBtn);
        mainframe.setLocationRelativeTo(null);
        mainframe.setSize(300,55);
        mainframe.setAlwaysOnTop(true);
        mainframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainframe.setVisible(true);
    }
}
