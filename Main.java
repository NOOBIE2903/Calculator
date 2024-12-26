import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        new Calculator();
    }
}

class Calculator extends JFrame implements ActionListener, MouseListener {
    JLabel label1, label2;
    JTextField textField1, textField2, result;
    JButton add, sub, multiply, divide, clear;
    JToggleButton themeToggle;

//    Action addAction;
//    Action subAction;
//    Action multiplyAction;
//    Action divideAction;
//    Action clearAction;

    Calculator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(100, 100, 400, 400);

        themeToggle = new JToggleButton("Light Mode");
        themeToggle.setBounds(170, 280, 100, 30);
        themeToggle.setBackground(Color.white);
        themeToggle.setFocusable(false);
        themeToggle.addActionListener(this);
        themeToggle.addMouseListener(this);
        themeToggle.setFont(new Font("MV Boli", Font.BOLD, 15));
        add(themeToggle);

        label1 = new JLabel("Num1");
        label2 = new JLabel("Num2");
        textField1 = new JTextField();
        textField2 = new JTextField();
        result = new JTextField("Result");
        result.setEditable(false);

        add = new JButton("Add");
        sub = new JButton("Subtract");
        multiply = new JButton("Multiply");
        divide = new JButton("Divide");
        clear = new JButton("Clear");

//        add = new addAction();

        label1.setBounds(50, 30, 100, 30);
        textField1.setBounds(150, 30, 150, 30);
        label1.setForeground(Color.GREEN);

        label2.setBounds(50, 80, 100, 30);
        textField2.setBounds(150, 80, 150, 30);
        label2.setForeground(Color.GREEN);

        result.setBounds(50, 130, 250, 30);

        add.setBounds(50, 180, 80, 30);
        sub.setBounds(150, 180, 100, 30);
        multiply.setBounds(50, 230, 100, 30);
        divide.setBounds(170, 230, 80, 30);
        clear.setBounds(50, 280, 100, 30);

        add.addActionListener(this);
        sub.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
        clear.addActionListener(this);

        add.addMouseListener(this);
        sub.addMouseListener(this);
        multiply.addMouseListener(this);
        divide.addMouseListener(this);
        clear.addMouseListener(this);

        add.setFocusable(false);
        sub.setFocusable(false);
        multiply.setFocusable(false);
        divide.setFocusable(false);
        clear.setFocusable(false);
        add.setBackground(Color.white);
        sub.setBackground(Color.white);
        multiply.setBackground(Color.white);
        divide.setBackground(Color.white);
        clear.setBackground(Color.white);

        add.setBorder(BorderFactory.createLineBorder(Color.black));
        sub.setBorder(BorderFactory.createLineBorder(Color.black));
        multiply.setBorder(BorderFactory.createLineBorder(Color.black));
        divide.setBorder(BorderFactory.createLineBorder(Color.black));
        clear.setBorder(BorderFactory.createLineBorder(Color.black));

        label1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        add.setFont(new Font("MV Boli", Font.BOLD, 15));
        sub.setFont(new Font("MV Boli", Font.BOLD, 15));
        multiply.setFont(new Font("MV Boli", Font.BOLD, 15));
        divide.setFont(new Font("MV Boli", Font.BOLD, 15));
        clear.setFont(new Font("MV Boli", Font.BOLD, 15));

//        add.getInputMap().put(KeyStroke.getKeyStroke('a'), "ADD");
//        add.getActionMap().put("ADD", addAction);

        add(label1);
        add(textField1);
        add(label2);
        add(textField2);
        add(result);
        add(add);
        add(sub);
        add(multiply);
        add(divide);
        add(clear);

        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == themeToggle) {
            if (themeToggle.isSelected()) {
                getContentPane().setBackground(Color.WHITE);
                label1.setForeground(Color.BLACK);
                label2.setForeground(Color.BLACK);
                themeToggle.setText("Dark Mode");
                themeToggle.setFont(new Font("MV Boli", Font.BOLD, 15));
//                themeToggle.setBackground(Color.white);
            } else {
                getContentPane().setBackground(Color.BLACK);
                label1.setForeground(Color.GREEN);
                label2.setForeground(Color.GREEN);
                themeToggle.setText("Light Mode");
                themeToggle.setFont(new Font("MV Boli", Font.BOLD, 15));
//                themeToggle.setBackground(Color.white);
            }
        }
        else {
            try {
                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());
                int value = 0;

                if (e.getSource() == add) {
                    value = num1 + num2;
                } else if (e.getSource() == sub) {
                    value = num1 - num2;
                } else if (e.getSource() == multiply) {
                    value = num1 * num2;
                } else if (e.getSource() == divide) {
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "Number is invalid", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    value = num1 / num2;
                } else if (e.getSource() == clear) {
                    textField1.setText("");
                    textField2.setText("");
                    result.setText("");
                    return;
                }
                result.setText(String.valueOf(value));
            } catch (NumberFormatException ex) {
                result.setText("Invalid number.");
                JOptionPane.showMessageDialog(this, "Please enter a valid number");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == add) {
            add.setBackground(Color.LIGHT_GRAY);
        }
        else if (e.getSource() == sub) {
            sub.setBackground(Color.LIGHT_GRAY);
        }
        else if (e.getSource() == multiply) {
            multiply.setBackground(Color.LIGHT_GRAY);
        }
        else if (e.getSource() == divide) {
            divide.setBackground(Color.LIGHT_GRAY);
        }
        else if (e.getSource() == clear) {
            clear.setBackground(Color.LIGHT_GRAY);
        }
        else if (e.getSource() == themeToggle) {
//            if (themeToggle.isSelected()) {
                themeToggle.setBackground(Color.LIGHT_GRAY);
//            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == add) {
            add.setBackground(Color.WHITE);
        }
        else if (e.getSource() == sub) {
            sub.setBackground(Color.WHITE);
        }
        else if (e.getSource() == multiply) {
            multiply.setBackground(Color.WHITE);
        }
        else if (e.getSource() == divide) {
            divide.setBackground(Color.WHITE);
        }
        else if (e.getSource() == clear) {
            clear.setBackground(Color.WHITE);
        }
        else if (e.getSource() == themeToggle) {
//            if (themeToggle.isSelected()) {
                themeToggle.setBackground(Color.WHITE);
//            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == add) {
            add.setBackground(Color.darkGray);
        }
        else if (e.getSource() == sub) {
            sub.setBackground(Color.darkGray);
        }
        else if (e.getSource() == multiply) {
            multiply.setBackground(Color.darkGray);
        }
        else if (e.getSource() == divide) {
            divide.setBackground(Color.darkGray);
        }
        else if (e.getSource() == clear) {
            clear.setBackground(Color.darkGray);
        }
        else if (e.getSource() == themeToggle) {
//            if (themeToggle.isSelected()) {
                themeToggle.setBackground(Color.darkGray);
//            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == add) {
            add.setBackground(Color.WHITE);
        }
        else if (e.getSource() == sub) {
            sub.setBackground(Color.white);
        }
        else if (e.getSource() == multiply) {
            multiply.setBackground(Color.white);
        }
        else if (e.getSource() == divide) {
            divide.setBackground(Color.white);
        }
        else if (e.getSource() == clear) {
            clear.setBackground(Color.white);
        }
        else if (e.getSource() == themeToggle) {
//            if (themeToggle.isSelected()) {
                themeToggle.setBackground(Color.white);
//            }
        }
    }

}