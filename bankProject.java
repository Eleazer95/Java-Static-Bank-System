import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class bankProject implements ActionListener{
    double initialBalance=0.0;
    JFrame frame,dframe,wframe;
    JLabel name,balanceAmount,balanceBal,depositText,withdrawalText;
    JButton depositBtnW,withdrawBtnW,depositBtn,withdrawBtn;
    JTextField depositField,withdrawField;
    public bankProject(JLabel name,JLabel balanceAmount,JLabel balanceBal,JLabel depositText,JLabel withdrawalText,JButton depositBtnW,
    JButton withdrawBtnW,JButton depositBtn,JButton withdrawBtn,JTextField depositField,JTextField withdrawField){

        this.name=name;
        this.balanceAmount=balanceAmount;
        this.balanceBal=balanceBal;
        this.depositText=depositText;
        this.withdrawalText=withdrawalText;
        this.depositBtnW=depositBtnW;
        this.withdrawBtnW=withdrawBtnW;
        this.depositBtn=depositBtn;
        this.withdrawBtn=withdrawBtn;
        this.depositField=depositField;
        this.withdrawField=withdrawField;

    }

    public void mainScreen(){

        frame=new JFrame("Bank Project Main Screen");
        Font nameFont=new Font("Arial",Font.BOLD,50);
        Font balanceAmountFont=new Font("Arial",Font.BOLD,100);
        Font balanceTextFont=new Font("Arial",Font.BOLD,50);
        this.name=new JLabel("John Alex");
        this.name.setFont(nameFont);

        this.balanceAmount=new JLabel("$0.0");
        this.balanceAmount.setFont(balanceAmountFont);

        this.balanceBal=new JLabel("Balance..");
        this.balanceBal.setFont(balanceTextFont);

        JPanel panel1=new JPanel();
        panel1.add(this.name);
        panel1.add(this.balanceAmount);
        panel1.add(this.balanceBal);

        panel1.setBackground(Color.YELLOW);

        panel1.setLayout(new GridLayout(3, 1));

        
        Font depositFont=new Font("Arial",Font.BOLD,50);
        Font withdrawFont=new Font("Arial",Font.BOLD,50);

        this.depositBtn=new JButton("Deposit");
        this.depositBtn.setFont(depositFont);
        this.depositBtn.setBackground(Color.RED);

        this.depositBtn.addActionListener(this);

        this.withdrawBtn=new JButton("Withdraw");
        this.withdrawBtn.setFont(withdrawFont);
        this.withdrawBtn.setBackground(Color.RED);

        this.withdrawBtn.addActionListener(this);

        JPanel panel2=new JPanel();
        panel2.add(this.depositBtn);
        panel2.add(this.withdrawBtn);

        panel2.setBackground(Color.YELLOW);

        panel2.setLayout(new GridLayout(1,2,20,20));
        frame.add(panel1);
        frame.add(panel2);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.setSize(500,450);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event){

        if(event.getSource()==this.depositBtn){

            dframe=new JFrame("Deposit Screen");
            this.depositText=new JLabel("Deposit");
            Font depositFont=new Font("Arial",Font.BOLD,30);
            this.depositText.setFont(depositFont);

            this.depositField=new JTextField();
            this.depositField.setFont(depositFont);

            this.depositBtnW=new JButton("Deposit");
            this.depositBtnW.setFont(depositFont);

            this.depositBtnW.addActionListener(this);

            JPanel panel=new JPanel();
            panel.add(this.depositText);
            panel.add(this.depositField);
            panel.add(this.depositBtnW);

            panel.setLayout(new GridLayout(3, 1));

            dframe.add(panel);
            dframe.setLayout(new BoxLayout(dframe.getContentPane(), BoxLayout.Y_AXIS));
            dframe.setSize(300,250);
            dframe.setVisible(true);


        }

        try{
            if(event.getSource()==this.depositBtnW){

            String entry=this.depositField.getText();
            Double convert=Double.parseDouble(entry);

                if(convert>9999999){
                    JOptionPane.showMessageDialog(dframe,"John Alex Cant deposit up to 10m dollars in account","Account too Small",JOptionPane.WARNING_MESSAGE);
                }else{

                initialBalance=initialBalance+convert;

                String money=String.valueOf(initialBalance);
                this.balanceAmount.setText("$"+money);
                } 
            }
        }catch(Exception e){
                JOptionPane.showMessageDialog(wframe,"You have not entered an amount","No Money Entered", JOptionPane.WARNING_MESSAGE);
        }

        if(event.getSource()==this.withdrawBtn){
            
            wframe=new JFrame("Withdrawal Screen");
            this.withdrawalText=new JLabel("Withdraw");
            Font withdrawFont=new Font("Arial",Font.BOLD,30);
            this.withdrawalText.setFont(withdrawFont);

            this.withdrawField=new JTextField();
            this.withdrawField.setFont(withdrawFont);

            this.withdrawBtnW=new JButton("Withdraw");
            this.withdrawBtnW.setFont(withdrawFont);

            this.withdrawBtnW.addActionListener(this);

            JPanel panel=new JPanel();
            panel.add(this.withdrawalText);
            panel.add(this.withdrawField);
            panel.add(this.withdrawBtnW);

            panel.setLayout(new GridLayout(3, 1));

            wframe.add(panel);
            wframe.setLayout(new BoxLayout(wframe.getContentPane(), BoxLayout.Y_AXIS));
            wframe.setSize(300,250);
            wframe.setVisible(true);

        }

        try{
            if(event.getSource()==this.withdrawBtnW){

                String convert=this.withdrawField.getText();
                Double withTake=Double.parseDouble(convert);

                if(withTake>initialBalance){

                    JOptionPane.showMessageDialog(wframe,"Insufficient Funds...","Balance Low",JOptionPane.WARNING_MESSAGE);
                }else{
                    initialBalance=initialBalance-withTake;
                    String money=String.valueOf(initialBalance);
                    this.balanceAmount.setText("$"+money);
                }
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(wframe,"You have not entered an amount","No Money Entered", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        
        bankProject bProject=new bankProject(null, null, null, null, null, null, null, null, null,null,null);
        bProject.mainScreen();
    }
}
