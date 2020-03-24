package GUI;

import Strategies.Strategy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.InitGUI.showCorrelationTwoInstruments;
import static GUI.InitGUI.showFxrCorrelation;


public class Listeners
    {
        public static class DataFromCorrelationTwoInstruments implements ActionListener
            {
                @Override
                public void actionPerformed(ActionEvent e)
                    {
                        var dta = Strategy.correlationTwoInstruments();
                        if (dta <= -30)
                            {
                                showCorrelationTwoInstruments.setText("" + Strategy.correlationTwoInstruments());
                                showCorrelationTwoInstruments.setFont(new Font("ComicSans", Font.BOLD, 50));
                                showCorrelationTwoInstruments.setForeground(Color.RED);

                            } else if (dta > -30)
                            {
                                showCorrelationTwoInstruments.setText("" + Strategy.correlationTwoInstruments());
                                showCorrelationTwoInstruments.setFont(new Font("ComicSans", Font.BOLD, 50));
                                showCorrelationTwoInstruments.setForeground(Color.GREEN);
                            }
                    }
            }
        public static class DataFromFxrCorrelation implements ActionListener
            {
                @Override
                public void actionPerformed(ActionEvent e)
                    {
                        var dta = Strategy.correlationTwoInstruments();
                        if (dta <= -30)
                            {
                                showFxrCorrelation.setText("" + Strategy.correlationTwoInstruments());
                                showFxrCorrelation.setFont(new Font("ComicSans", Font.BOLD, 50));
                                showFxrCorrelation.setForeground(Color.RED);

                            } else if (dta > -30)
                            {
                                showFxrCorrelation.setText("" + Strategy.correlationTwoInstruments());
                                showFxrCorrelation.setFont(new Font("ComicSans", Font.BOLD, 50));
                                showFxrCorrelation.setForeground(Color.GREEN);
                            }
                    }
            }


    }
