import pro.xstore.api.message.command.APICommandFactory;
import pro.xstore.api.message.error.APICommandConstructionException;
import pro.xstore.api.message.error.APICommunicationException;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.response.APIErrorResponse;
import pro.xstore.api.message.response.SymbolResponse;

public class DowVsNasdaqStrategy
    {
        static double dowVsNasdaqStrategy()
            {
                while (true)
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

                        try
                            {
                                Thread.sleep(1000);
                            }
                        catch (InterruptedException e)
                            {
                                e.printStackTrace();
                            }
                        //prices for DOW JONES
                        var ask_DOW = symbolResponseDow.getSymbol().getAsk();
                        var bid_DOW = symbolResponseDow.getSymbol().getBid();
                        var spread_DOW = ask_DOW - bid_DOW;

                        //prices for NASDAQ
                        var ask_NASDAQ = symbolResponseNASDAQ.getSymbol().getAsk();
                        var bid_NASDAQ = symbolResponseNASDAQ.getSymbol().getBid();
                        var spread_NASDAQ = ask_NASDAQ - bid_NASDAQ;

                        //System.out.println("Ask -> " + ask_DOW + "   " + "Bid -> " + bid_DOW + "   " + "Spread -> " + spread_DOW + "|||" + "Ask -> " + ask_NASDAQ + "   " + "Bid -> " + bid_NASDAQ + "   " + "Spread -> " + spread_NASDAQ);

                        double pips = (bid_DOW * 0.3672446) - bid_NASDAQ;
                        System.out.println(pips);
                        //return pips;

                    }


            }
    }
