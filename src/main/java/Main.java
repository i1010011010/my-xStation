
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame
    {
        JLabel label = new JLabel("Pips: ");
        JPanel panel = new JPanel();
        JLabel dowVsNasdaq = new JLabel();


        public Main()
            {
                super("DOV VS NASDAQ");
                this.setBounds(250, 250, 250, 250);
                initComponents();
                setDefaultCloseOperation(3);
            }

        public void initComponents()
            {
                panel.add(label);
                panel.add(dowVsNasdaq);
                this.getContentPane().add(panel);

                ActionListener data = new DynamicData();
                label.setText("" + dowData);



            }

        static double dowData = DowVsNasdaqStrategy.dowVsNasdaqStrategy();

        private class DynamicData implements ActionListener
            {
                @Override
                public void actionPerformed(ActionEvent e)
                    {
                        label.setText("" + dowData);
                    }
            }

        public static void main(String[] args)
            {
                new Main().setVisible(true);
                DowVsNasdaqStrategy.dowVsNasdaqStrategy();
            }
    }
