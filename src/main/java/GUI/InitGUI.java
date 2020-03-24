package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class InitGUI extends JFrame
    {
        JPanel panel1 = new JPanel();
        static JLabel showCorrelationTwoInstruments = new JLabel();
        static JLabel showFxrCorrelation = new JLabel();
        public InitGUI()
            {
                super("DOV VS NASDAQ");
                setBounds(0, 0, 120, 120);
                this.setAlwaysOnTop(true);
                initComponents();
                setDefaultCloseOperation(3);
            }
        public void initComponents()
            {
                panel1.add(showCorrelationTwoInstruments);
                this.getContentPane().add(panel1);

                //Listener for CorrelationTwoInstruments method
                ActionListener dataFromCorrelationTwoInstruments = new Listeners.DataFromCorrelationTwoInstruments();
                Timer fromServer1 = new Timer(75, dataFromCorrelationTwoInstruments);
                fromServer1.start();

                //Listener for FxrCorrelation method
                ActionListener dataFromFxrCorrelation = new Listeners.DataFromFxrCorrelation();
                Timer fxrCorrData = new Timer(100,dataFromFxrCorrelation);
            }
    }
