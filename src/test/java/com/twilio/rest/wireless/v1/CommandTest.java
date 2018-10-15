/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.wireless.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static com.twilio.TwilioTest.serialize;
import static org.junit.Assert.*;

public class CommandTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.WIRELESS.toString(),
                                          "/v1/Commands/DCXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Command.fetcher("DCXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchCommandSmsResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"command\": \"command\",\"command_mode\": \"text\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"delivery_receipt_requested\": true,\"sim_sid\": \"DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"direction\": \"from_sim\",\"sid\": \"DCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"status\": \"queued\",\"transport\": \"sms\",\"url\": \"https://wireless.twilio.com/v1/Commands/DCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Command.fetcher("DCXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch());
    }

    @Test
    public void testFetchCommandIpResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"command\": \"command\",\"command_mode\": \"text\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"delivery_receipt_requested\": false,\"sim_sid\": \"DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"direction\": \"to_sim\",\"sid\": \"DCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"status\": \"queued\",\"transport\": \"ip\",\"url\": \"https://wireless.twilio.com/v1/Commands/DCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Command.fetcher("DCXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch());
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.WIRELESS.toString(),
                                          "/v1/Commands");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Command.reader().read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"commands\": [],\"meta\": {\"first_page_url\": \"https://wireless.twilio.com/v1/Commands?PageSize=50&Page=0\",\"key\": \"commands\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://wireless.twilio.com/v1/Commands?PageSize=50&Page=0\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Command.reader().read());
    }

    @Test
    public void testReadFullResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"commands\": [{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"command\": \"command\",\"command_mode\": \"text\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"delivery_receipt_requested\": true,\"sim_sid\": \"DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"direction\": \"from_sim\",\"sid\": \"DCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"status\": \"queued\",\"transport\": \"sms\",\"url\": \"https://wireless.twilio.com/v1/Commands/DCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}],\"meta\": {\"first_page_url\": \"https://wireless.twilio.com/v1/Commands?PageSize=50&Page=0\",\"key\": \"commands\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://wireless.twilio.com/v1/Commands?PageSize=50&Page=0\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Command.reader().read());
    }

    @Test
    public void testReadIpResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"commands\": [{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"command\": \"command\",\"command_mode\": \"not_confirmable\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"delivery_receipt_requested\": true,\"sim_sid\": \"DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"direction\": \"to_sim\",\"sid\": \"DCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"status\": \"queued\",\"transport\": \"ip\",\"url\": \"https://wireless.twilio.com/v1/Commands/DCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}],\"meta\": {\"first_page_url\": \"https://wireless.twilio.com/v1/Commands?PageSize=50&Page=0\",\"key\": \"commands\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://wireless.twilio.com/v1/Commands?PageSize=50&Page=0\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Command.reader().read());
    }

    @Test
    public void testCreateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.WIRELESS.toString(),
                                          "/v1/Commands");
            request.addPostParam("Command", serialize("command"));
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Command.creator("command").create();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testCreateCommandSmsResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"command\": \"command\",\"command_mode\": \"text\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"delivery_receipt_requested\": true,\"sim_sid\": \"DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"direction\": \"from_sim\",\"sid\": \"DCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"status\": \"queued\",\"transport\": \"sms\",\"url\": \"https://wireless.twilio.com/v1/Commands/DCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Command.creator("command").create();
    }

    @Test
    public void testCreateCommandIpResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"command\": \"command\",\"command_mode\": \"binary\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"delivery_receipt_requested\": true,\"direction\": \"to_sim\",\"sid\": \"DCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"sim_sid\": \"DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"status\": \"queued\",\"transport\": \"ip\",\"url\": \"https://wireless.twilio.com/v1/Commands/DCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Command.creator("command").create();
    }
}