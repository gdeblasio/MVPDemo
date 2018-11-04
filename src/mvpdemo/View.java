package mvpdemo;

import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class View {
    private Presenter presenter;
    private JLabel statusLabel;
    private JTextField inputField;

    public View() {
        createUI();
    }

    private void createUI() {
        JFrame frame = new JFrame("Java 8 Passive MVP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        statusLabel = new JLabel("Introducir password");
        inputField = new JTextField(20);
        JButton loginButton = new JButton("login");
        loginButton.addActionListener(((ae) -> {
            presenter.login(inputField.getText());
        }));
        
        Box topBox  = Box.createHorizontalBox();
        topBox.add(statusLabel);
        topBox.add(Box.createHorizontalStrut(5));
        topBox.add(inputField);
        topBox.add(Box.createHorizontalStrut(5));
        topBox.add(loginButton);
        
        frame.add(topBox,BorderLayout.NORTH);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // Se centra el Frame en la ventana
        frame.pack();
    }

    public void setPresenter(Presenter p) {
        this.presenter = p;
    }
    
    public void updateStatusLabel(String text) {
        statusLabel.setText(text);
    }
    
    public void hideInputField() {
        inputField.setVisible(false);
    }
}
