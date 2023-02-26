//import org.apache.commons.lang3.StringUtils.isNumericSpace;

import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Window extends JFrame{
    public String message;
    JLabel titleLable = new JLabel("Neural Network");
    JLabel learning_rate_Lable = new JLabel("Learning rate:");
    JLabel layers_Lable = new JLabel("Hidden layers:");
    JLabel he_Lable = new JLabel("Height:");
    JLabel wi_Lable = new JLabel("Width:");
    JLabel epoch_Lable = new JLabel("Epoch:");
    JTextField learning_rate = new JTextField();
    //JTextField he = new JTextField();
    //JTextField wi = new JTextField();
    JTextField epoch = new JTextField();
    JTextField layers = new JTextField();
    JButton start = new JButton("Start");
    JButton exit = new JButton("Exit");
    public Window() {
        super("NN");
        this.setBounds(400, 280, 560, 390);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        Container mainPanel = this.getContentPane();
        mainPanel.setLayout(new GridLayout(3,2,2,2));

        mainPanel.add(titleLable);
        mainPanel.add(learning_rate_Lable);
        mainPanel.add(layers_Lable);
        //mainPanel.add(he_Lable);
        //mainPanel.add(wi_Lable);
        mainPanel.add(epoch_Lable);
        mainPanel.add(learning_rate);
        mainPanel.add(layers);
        //mainPanel.add(he);
        //mainPanel.add(wi);
        mainPanel.add(epoch);

        ButtonGroup b_group = new ButtonGroup();
        b_group.add(start);
        b_group.add(exit);
        mainPanel.add(start);
        mainPanel.add(exit);
        mainPanel.setLayout(null);
        start.addActionListener(new ButtonStart());
        exit.addActionListener(e -> {System.exit(1);});

        // Пользовательский размер и размещение компонента
        titleLable.setBounds(120, 40, 340, 35);
        // Установить шрифт, параметры: шрифт, статус, размер
        titleLable.setFont(new Font("Полужирный", Font.BOLD, 30));

        learning_rate_Lable.setBounds(94, 124, 90, 30);
        //nameLable.setFont(new Font("Полужирный", Font.BOLD, 24));

        layers_Lable.setBounds(94, 174, 90, 30);
        //passwordLable.setFont(new Font("Полужирный", Font.BOLD, 24));

        //he_Lable.setBounds(94, 224, 90, 30);
        //nameLable.setFont(new Font("Полужирный", Font.BOLD, 24));

        //wi_Lable.setBounds(94, 274, 90, 30);
        //passwordLable.setFont(new Font("Полужирный", Font.BOLD, 24));

        epoch_Lable.setBounds(94, 224, 90, 30);
        //passwordLable.setFont(new Font("Полужирный", Font.BOLD, 24));

        learning_rate.setBounds(204, 124, 260, 30);
        //text.setFont(new Font("Полужирный", Font.BOLD, 24));

        layers.setBounds(204, 174, 260, 30);
        //password.setFont(new Font("Полужирный", Font.BOLD, 24));

        epoch.setBounds(204, 224, 260, 30);
        //password.setFont(new Font("Полужирный", Font.BOLD, 24));

        //he.setBounds(204, 224, 260, 30);
        //text.setFont(new Font("Полужирный", Font.BOLD, 24));

        //wi.setBounds(204, 274, 260, 30);
        //password.setFont(new Font("Полужирный", Font.BOLD, 24));

        start.setBounds(157, 282, 100, 30);
        //login.setFont(new Font("Bold", Font.BOLD, 22));

        exit.setBounds(304, 282, 100, 30);
        //exit.setFont(new Font("Полужирный", Font.BOLD, 22));

        // Установить цвет фона формы
        mainPanel.setBackground(Color.WHITE);

    }
    class ButtonStart implements ActionListener {

        public static void dots(Integer port1,Integer port2,String message, Integer epoch) throws IOException {
            FormDots f = new FormDots(port1,port2, message, epoch);
            new Thread(f).start();
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            try{
                if(       (StringUtils.isNumericSpace(layers.getText())
                        | (layers.getText().replace(" ", "").equals("")))
                        & StringUtils.isNumericSpace(learning_rate.getText().replaceFirst("\\.",""))
                        & !(learning_rate.getText().replaceFirst("\\.","").equals(""))
                        & StringUtils.isNumericSpace(epoch.getText())
                        & !(epoch.getText().equals(""))
                ){
                    double lr = Double.parseDouble(learning_rate.getText().replace(" ",""));
                    if(lr>0){
                        String layer = layers.getText().replace("  "," ").replace(" ", ">");
                        System.out.println(layer);
                        message =(lr+">"+0+">"+ 2 + ">"+ layer +">" + 2).replace(">>", ">");

                        //Integer w = Integer.parseInt(wi.getText());
                        //Integer h = Integer.parseInt(he.getText());
                        Integer epo = Integer.parseInt(epoch.getText().replace(" ", ""));

                        setVisible(false);
                        System.out.println(message);
                        System.out.println("connect to server");
                        dots(50005,50006,message, epo);
                    }else{
                        System.out.println("learning rate должен быть > 0");
                    }
                }else{
                    System.out.println("False");
                }
            }catch (IOException ex){
                System.out.println("Server is not available");
                setVisible(true);
                JOptionPane.showMessageDialog(null, "Похоже сервер недоступен", "No connection", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
