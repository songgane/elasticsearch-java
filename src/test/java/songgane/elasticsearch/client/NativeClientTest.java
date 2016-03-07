package songgane.elasticsearch.client;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.junit.Test;
import songgane.elasticsearch.client.http.LocalClient;

import java.io.IOException;

/**
 * Created by songgane on 2016. 1. 14..
 */
public class NativeClientTest {

    @Test
    public void testNativeClient() throws IOException {
        // on startup
        Client client = new NativeClient().getClient("songgane", "localhost", 9300);

        // Get
        GetResponse res01 = client.prepareGet("customers", "customer", "1").get();
        System.out.println(res01.getSourceAsString());

        // on shutdown
        client.close();
    }
}
