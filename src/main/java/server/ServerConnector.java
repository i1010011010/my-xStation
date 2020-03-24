package server;

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

public class ServerConnector
    {
        public static long login = 10960080L;
        public static String password = "S2rtttsal";
        public static String symbol_DOW = "US30";
        public static String symbol_NASDAQ = "US100";
        public static SyncAPIConnector apiConnector;
        public static LoginResponse loginResponse;
        public static Credentials credentials = new Credentials(login, password);
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
                        loginResponse = APICommandFactory.executeLoginCommand(ServerConnector.apiConnector, ServerConnector.credentials);
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