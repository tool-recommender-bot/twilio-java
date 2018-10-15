/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.authy.v1.service.entity.factor;

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

public class ChallengeTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testCreateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.AUTHY.toString(),
                                          "/v1/Services/ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Entities/pathIdentity/Factors/YFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Challenges");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Challenge.creator("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pathIdentity", "YFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").create();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testCreateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"YCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"entity_sid\": \"YEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"identity\": \"ff483d1ff591898a9942916050d2ca3f\",\"factor_sid\": \"YFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"date_responded\": \"2015-07-30T20:00:00Z\",\"expiration_date\": \"2015-07-30T20:00:00Z\",\"verification_sid\": \"VEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"status\": \"pending\",\"reason\": \"none\",\"details\": \"Hi! Mr. John Doe, would you like to sign up?\",\"hidden_details\": \"Hidden details about the sign up\",\"type\": \"sms\",\"url\": \"https://authy.twilio.com/v1/Services/ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Entities/ff483d1ff591898a9942916050d2ca3f/Factors/YFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Challenges/YCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Challenge.creator("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pathIdentity", "YFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").create();
    }

    @Test
    public void testDeleteRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.DELETE,
                                          Domains.AUTHY.toString(),
                                          "/v1/Services/ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Entities/pathIdentity/Factors/YFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Challenges/pathSid");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Challenge.deleter("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pathIdentity", "YFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pathSid").delete();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testDeleteResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("null", TwilioRestClient.HTTP_STATUS_CODE_NO_CONTENT);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Challenge.deleter("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pathIdentity", "YFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pathSid").delete();
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.AUTHY.toString(),
                                          "/v1/Services/ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Entities/pathIdentity/Factors/YFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Challenges/pathSid");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Challenge.fetcher("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pathIdentity", "YFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pathSid").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchSidResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"YCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"entity_sid\": \"YEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"identity\": \"ff483d1ff591898a9942916050d2ca3f\",\"factor_sid\": \"YFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"date_responded\": \"2015-07-30T20:00:00Z\",\"expiration_date\": \"2015-07-30T20:00:00Z\",\"verification_sid\": \"VEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"status\": \"pending\",\"reason\": \"none\",\"details\": \"details\",\"hidden_details\": \"hidden_details\",\"type\": \"sms\",\"url\": \"https://authy.twilio.com/v1/Services/ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Entities/ff483d1ff591898a9942916050d2ca3f/Factors/YFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Challenges/YCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Challenge.fetcher("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pathIdentity", "YFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pathSid").fetch());
    }

    @Test
    public void testFetchLatestResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"YCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"entity_sid\": \"YEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"identity\": \"ff483d1ff591898a9942916050d2ca3f\",\"factor_sid\": \"YFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"date_responded\": \"2015-07-30T20:00:00Z\",\"expiration_date\": \"2015-07-30T20:00:00Z\",\"verification_sid\": \"VEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"status\": \"pending\",\"reason\": \"none\",\"details\": \"details\",\"hidden_details\": \"hidden_details\",\"type\": \"sms\",\"url\": \"https://authy.twilio.com/v1/Services/ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Entities/ff483d1ff591898a9942916050d2ca3f/Factors/YFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Challenges/YCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Challenge.fetcher("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pathIdentity", "YFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pathSid").fetch());
    }

    @Test
    public void testUpdateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.AUTHY.toString(),
                                          "/v1/Services/ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Entities/pathIdentity/Factors/YFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Challenges/pathSid");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Challenge.updater("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pathIdentity", "YFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pathSid").update();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testVerifySidResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"YCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"entity_sid\": \"YEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"identity\": \"ff483d1ff591898a9942916050d2ca3f\",\"factor_sid\": \"YFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"date_responded\": \"2015-07-30T20:00:00Z\",\"expiration_date\": \"2015-07-30T20:00:00Z\",\"verification_sid\": \"VEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"status\": \"approved\",\"reason\": \"none\",\"details\": \"Hi! Mr. John Doe, would you like to sign up?\",\"hidden_details\": \"Hidden details about the sign up\",\"type\": \"sms\",\"url\": \"https://authy.twilio.com/v1/Services/ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Entities/ff483d1ff591898a9942916050d2ca3f/Factors/YFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Challenges/YCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Challenge.updater("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pathIdentity", "YFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pathSid").update();
    }

    @Test
    public void testVerifyLatestResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"YCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"entity_sid\": \"YEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"identity\": \"ff483d1ff591898a9942916050d2ca3f\",\"factor_sid\": \"YFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"date_responded\": \"2015-07-30T20:00:00Z\",\"expiration_date\": \"2015-07-30T20:00:00Z\",\"verification_sid\": \"VEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"status\": \"approved\",\"reason\": \"none\",\"details\": \"Hi! Mr. John Doe, would you like to sign up?\",\"hidden_details\": \"Hidden details about the sign up\",\"type\": \"sms\",\"url\": \"https://authy.twilio.com/v1/Services/ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Entities/ff483d1ff591898a9942916050d2ca3f/Factors/YFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Challenges/YCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Challenge.updater("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pathIdentity", "YFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pathSid").update();
    }
}