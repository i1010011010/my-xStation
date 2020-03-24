package Strategies;

import pro.xstore.api.message.command.APICommandFactory;
import pro.xstore.api.message.error.APICommandConstructionException;
import pro.xstore.api.message.error.APICommunicationException;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.response.APIErrorResponse;
import pro.xstore.api.message.response.SymbolResponse;
import server.ServerConnector;

public class Strategy
    {
        public static double correlationTwoInstruments()
            {
                SymbolResponse symbolResponseDow = null;
                try
                    {
                        symbolResponseDow = APICommandFactory.executeSymbolCommand(ServerConnector.apiConnector, ServerConnector.symbol_DOW);
                    }
                catch (APICommandConstructionException e)
                    {
                        e.printStackTrace();
                    }
                catch (APIReplyParseException e)
                    {
                        e.printStackTrace();
                    }
                catch (APIErrorResponse apiErrorResponse)
                    {
                        apiErrorResponse.printStackTrace();
                    }
                catch (APICommunicationException e)
                    {
                        e.printStackTrace();
                    }
                SymbolResponse symbolResponseNASDAQ = null;
                try
                    {
                        symbolResponseNASDAQ = APICommandFactory.executeSymbolCommand(ServerConnector.apiConnector, ServerConnector.symbol_NASDAQ);
                    }
                catch (APICommandConstructionException e)
                    {
                        e.printStackTrace();
                    }
                catch (APIReplyParseException e)
                    {
                        e.printStackTrace();
                    }
                catch (APIErrorResponse apiErrorResponse)
                    {
                        apiErrorResponse.printStackTrace();
                    }
                catch (APICommunicationException e)
                    {
                        e.printStackTrace();
                    }
                //prices for DOW JONES
                var bid_DOW = symbolResponseDow.getSymbol().getBid();

                //prices for NASDAQ
                var bid_NASDAQ = symbolResponseNASDAQ.getSymbol().getBid();

                double bidNasdaqOpenDay = 7086.27;
                double bidDowOpenDay = 18812;

                //multiplier
                double  multiplier = bidNasdaqOpenDay/bidDowOpenDay;

                double pips = (bid_DOW * multiplier) - bid_NASDAQ;
                int dec = 0;
                int multi = (int) Math.pow(10, dec);
                int temp = (int) Math.round(pips * multi);
                return (double) temp / multi;
            }
        public static double fxrCorrelationIndicator()
            {
                SymbolResponse symbolResponseDow = null;
                try
                    {
                        symbolResponseDow = APICommandFactory.executeSymbolCommand(ServerConnector.apiConnector, ServerConnector.symbol_DOW);
                    }
                catch (APICommandConstructionException e)
                    {
                        e.printStackTrace();
                    }
                catch (APIReplyParseException e)
                    {
                        e.printStackTrace();
                    }
                catch (APIErrorResponse apiErrorResponse)
                    {
                        apiErrorResponse.printStackTrace();
                    }
                catch (APICommunicationException e)
                    {
                        e.printStackTrace();
                    }
                SymbolResponse symbolResponseNASDAQ = null;
                try
                    {
                        symbolResponseNASDAQ = APICommandFactory.executeSymbolCommand(ServerConnector.apiConnector, ServerConnector.symbol_NASDAQ);
                    }
                catch (APICommandConstructionException e)
                    {
                        e.printStackTrace();
                    }
                catch (APIReplyParseException e)
                    {
                        e.printStackTrace();
                    }
                catch (APIErrorResponse apiErrorResponse)
                    {
                        apiErrorResponse.printStackTrace();
                    }
                catch (APICommunicationException e)
                    {
                        e.printStackTrace();
                    }

                //create correlation function
                //prices for DOW JONES

                var bid_DOW = symbolResponseDow.getSymbol().getBid();

                //prices for NASDAQ
                var bid_NASDAQ = symbolResponseNASDAQ.getSymbol().getBid();

                //in this place i finished - problem NOT solved :)
                double multiplier = bid_NASDAQ/bid_DOW;
                double dupa = bid_DOW*multiplier;
                System.out.println(dupa);
                return dupa;
            }
    }






