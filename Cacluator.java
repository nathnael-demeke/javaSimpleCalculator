import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Cacluator implements ActionListener{
    JFrame window;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionsButtons = new JButton[9];
    JButton addButton,subButton, multipyButton , divideButton;
    JButton decButton, equalButton , deleteButton , clrButton , negButton;
    JPanel panel;

    Font myfont = new Font("Ink Free", Font.BOLD, 30);

    double num1 = 0;
    double num2 = 0;
    double result = 0;

    char operator;

    Cacluator() {
        window = new JFrame("Calculator");
        window.setLayout(null);


        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myfont);
        textField.setEditable(false);
        negButton = new JButton("(-)");

        addButton = new JButton("+");
        subButton = new JButton("-");
        multipyButton = new JButton("X");
        divideButton = new JButton("/");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        deleteButton = new JButton("Delete");
        clrButton = new JButton("C");


        functionsButtons[0] = addButton;
        functionsButtons[1] = subButton;
        functionsButtons[2] = multipyButton;
        functionsButtons[3] = divideButton;
        functionsButtons[4] = decButton;
        functionsButtons[5] = equalButton;
        functionsButtons[6] = deleteButton;
        functionsButtons[7] = clrButton;
        functionsButtons[8] = negButton;

        for (int i = 0; i < 8 ; i++) {
            functionsButtons[i].addActionListener(this);
            functionsButtons[i].setFont(myfont);
            functionsButtons[i].setFocusable(false);

        }

        negButton.setBounds(50,430, 100, 50);
        deleteButton.setBounds(150, 430, 120, 50);
        clrButton.setBounds(250, 430, 100, 50);



        for (int i = 0; i <= 9; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);

        }
         negButton.addActionListener(this);
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        // panel.setBackground(Color.black);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multipyButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divideButton);

        
        
       negButton.setFocusable(false);
       
        window.add(panel);

        window.add(negButton);
        window.add(deleteButton);
        window.add(clrButton);
        window.add(textField);
        window.setSize(420, 500);
        window.setVisible(true);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
         Cacluator calc = new Cacluator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       for (int i = 0; i < 10 ; i++) {
        if (e.getSource() == numberButtons[i]) {
            textField.setText(textField.getText().concat(String.valueOf(i)));
        }
        
       }
       if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        } 
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
            
        }
         if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
            
        }
         if (e.getSource() == multipyButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
            
        }
         if (e.getSource() == divideButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
            
        }
        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+' :
                    result = num1 + num2; 
                    break;
                case '-' :
                    result = num1 - num2; 
                    break;
                case '*' :
                    result = num1 * num2; 
                    break;
                case '/' :
                    result = num1 / num2; 
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
            
            
        }
       if (e.getSource() == clrButton) {
            num1 = 0;
            num2 = 0;
            textField.setText("");
            
        }
        if (e.getSource() == deleteButton) {
           String str = textField.getText();
           textField.setText("");
           for (int i=0; i < str.length() -1 ; i++) {
            textField.setText(textField.getText() + str.charAt(i));
           }

    }
    if (e.getSource() == negButton) {
        System.out.println(textField.getText());
        if (textField.getText() != " ") {
        double temp = Double.parseDouble(textField.getText());
        temp *= -1;
        textField.setText(String.valueOf(temp));
        System.out.println("you have pressed me");
        }
        
    }
}
}
