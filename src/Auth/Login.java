package Auth;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    // VAR TEM QUE SER EM ESCOBO GLOBAL PQ PEGA NO VERIFICAR LOGIN
    private JFormattedTextField emailField;  
    private JFormattedTextField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 100, 450, 300);
        
//        JFrame frame = new JFrame("Login");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 200);
//        frame.setLayout(new FlowLayout());

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel h1Label = new JLabel("Login");
        h1Label.setFont(new Font("Arial", Font.BOLD, 32));
        h1Label.setForeground(Color.BLACK);
        h1Label.setBounds(59, 0, 300, 70);
        
        contentPane.add(h1Label);
        contentPane.setVisible(true);

        RoundedButton button = new RoundedButton("Login", 10);
        button.setBounds(59, 175, 68, 27);
        button.addActionListener(e -> verificarLogin());
        contentPane.add(button);

        // Campo de e-mail arredondado
        emailField = new RoundedFormattedTextField(10);
        emailField.setToolTipText("Digite seu e-mail");
        emailField.setText("E-mail");
        emailField.setBounds(59, 77, 324, 27);
        emailField.setBackground(Color.WHITE);
        emailField.setForeground(Color.BLACK);
        contentPane.add(emailField);

        // Campo de senha arredondado
        passwordField = new RoundedFormattedTextField(10);
        passwordField.setToolTipText("Digite sua senha");
        passwordField.setText("Senha");
        passwordField.setBounds(59, 124, 324, 27);
        passwordField.setBackground(Color.WHITE);
        passwordField.setForeground(Color.BLACK);
        contentPane.add(passwordField);
        

        // Centralizar a janela
        setLocationRelativeTo(null);
    }
    
    //VERIFICAR LOGIN
    private void verificarLogin() {
        String usuario = emailField.getText();
        String senha = passwordField.getText();

        if (usuario.equals("eovine") && senha.equals("1234")) {
            abrirHomeUsuario();
        } else if (usuario.equals("admin") && senha.equals("admin123")) {
            abrirHomeAdmin();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
  //TELA DE HOME
    private void abrirHomeUsuario() {
        JFrame homeUser = new JFrame("Home Usuário");
        homeUser.setSize(400, 300);
        homeUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeUser.setLocationRelativeTo(null);

        JLabel mensagem = new JLabel("Bem-vindo, Usuário!", SwingConstants.CENTER);
        mensagem.setFont(new Font("Arial", Font.BOLD, 20));
        homeUser.add(mensagem);

        homeUser.setVisible(true);
        this.dispose();
    }

    //TELA DE USUARIO
    private void abrirHomeAdmin() {
        JFrame homeAdmin = new JFrame("Home Admin");
        homeAdmin.setSize(400, 300);
        homeAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeAdmin.setLocationRelativeTo(null);

        JLabel mensagem = new JLabel("Bem-vindo, Admin!", SwingConstants.CENTER);
        mensagem.setFont(new Font("Arial", Font.BOLD, 20));
        homeAdmin.add(mensagem);

        homeAdmin.setVisible(true);
        this.dispose();
    }

    // Classe personalizada para criar campos arredondados
    class RoundedFormattedTextField extends JFormattedTextField {
        private int radius;

        public RoundedFormattedTextField(int radius) {
            this.radius = radius;
            setOpaque(false);
            setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Adiciona um padding interno
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Cor de fundo arredondada
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

            // Cor da borda arredondada
            g2.setColor(Color.GRAY);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

            g2.dispose();
            super.paintComponent(g);
        }
    }
    
    class RoundedButton extends JButton {
        private int radius;

        public RoundedButton(String text, int radius) {
            super(text);
            this.radius = radius;
            setContentAreaFilled(false); 
            setFocusPainted(false); 
            setBorderPainted(false); 
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Fundo do botão
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

            // Borda do botão
            g2.setColor(getForeground());
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

            g2.dispose();
            super.paintComponent(g);
        }
    }
}
