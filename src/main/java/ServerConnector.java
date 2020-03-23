import pro.xstore.api.message.command.APICommandFactory;
import pro.xstore.api.message.error.APICommandConstructionException;
import pro.xstore.api.message.error.APICommunicationException;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.response.APIErrorResponse;
import pro.xstore.api.message.response.LoginResponse;
import pro.xstore.api.sync.Credentials;
import pro.xstore.api.sync.ServerData;
import pro.xstore.api.sync.SyncAPIConnector;

import java.io.IOException;

class ServerConnector
    {
        static long login = 10960080L;
        static String password = "S2rtttsal";
        static String symbol_DOW = "US30";
        static String symbol_NASDAQ = "US100";
        static SyncAPIConnector apiConnector;
        static LoginResponse loginResponse;
        static Credentials credentials = new Credentials(login, password);
        static
            {
                try
                    {
                        apiConnector = new SyncAPIConnector(ServerData.ServerEnum.DEMO);
                    }
                catch (IOException e)
                    {
                        e.printStackTrace();
                    }
            }
        static
            {
                try
                    {
                        loginResponse = APICommandFactory.executeLoginCommand(ServerConnector.apiConnector,ServerConnector.credentials);
                    }
                catch (APICommandConstructionException e)
                    {
                        e.printStackTrace();
                    }
                catch (APICommunicationException e)
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
                catch (IOException e)
                    {
                        e.printStackTrace();
                    }
            }

        ServerConnector()
            {
            }
    }
