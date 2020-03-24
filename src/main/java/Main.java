import GUI.InitGUI;
import Strategies.Strategy;

public class Main
    {
        public static void main(String[] args)
            {
                new InitGUI().setVisible(true);
                while (true)
                    {
                        Strategy.fxrCorrelationIndicator();
                    }
            }
    }
