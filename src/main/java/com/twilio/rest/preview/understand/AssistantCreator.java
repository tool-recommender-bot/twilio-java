/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.understand;

import com.twilio.base.Creator;
import com.twilio.converter.Converter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.net.URI;
import java.util.Map;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class AssistantCreator extends Creator<Assistant> {
    private String friendlyName;
    private Boolean logQueries;
    private String uniqueName;
    private URI callbackUrl;
    private String callbackEvents;
    private Map<String, Object> fallbackActions;
    private Map<String, Object> initiationActions;
    private Map<String, Object> styleSheet;

    /**
     * A text description for the Assistant. It is non-unique and can up to 255
     * characters long..
     * 
     * @param friendlyName A text description for the Assistant. It is non-unique
     *                     and can up to 255 characters long.
     * @return this
     */
    public AssistantCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * A boolean that specifies whether queries should be logged for 30 days further
     * training. If false, no queries will be stored, if true, queries will be
     * stored for 30 days and deleted thereafter. Defaults to true if no value is
     * provided..
     * 
     * @param logQueries A boolean that specifies whether queries should be logged
     *                   for 30 days further training. If false, no queries will be
     *                   stored, if true, queries will be stored for 30 days and
     *                   deleted thereafter. Defaults to true if no value is
     *                   provided.
     * @return this
     */
    public AssistantCreator setLogQueries(final Boolean logQueries) {
        this.logQueries = logQueries;
        return this;
    }

    /**
     * A user-provided string that uniquely identifies this resource as an
     * alternative to the sid. Unique up to 64 characters long..
     * 
     * @param uniqueName A user-provided string that uniquely identifies this
     *                   resource as an alternative to the sid. Unique up to 64
     *                   characters long.
     * @return this
     */
    public AssistantCreator setUniqueName(final String uniqueName) {
        this.uniqueName = uniqueName;
        return this;
    }

    /**
     * A user-provided URL to send event callbacks to..
     * 
     * @param callbackUrl A user-provided URL to send event callbacks to.
     * @return this
     */
    public AssistantCreator setCallbackUrl(final URI callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    /**
     * A user-provided URL to send event callbacks to..
     * 
     * @param callbackUrl A user-provided URL to send event callbacks to.
     * @return this
     */
    public AssistantCreator setCallbackUrl(final String callbackUrl) {
        return setCallbackUrl(Promoter.uriFromString(callbackUrl));
    }

    /**
     * Space-separated list of callback events that will trigger callbacks..
     * 
     * @param callbackEvents Space-separated list of callback events that will
     *                       trigger callbacks.
     * @return this
     */
    public AssistantCreator setCallbackEvents(final String callbackEvents) {
        this.callbackEvents = callbackEvents;
        return this;
    }

    /**
     * The JSON actions to be executed when the user's input is not recognized as
     * matching any Task..
     * 
     * @param fallbackActions The JSON actions to be executed when the user's input
     *                        is not recognized as matching any Task.
     * @return this
     */
    public AssistantCreator setFallbackActions(final Map<String, Object> fallbackActions) {
        this.fallbackActions = fallbackActions;
        return this;
    }

    /**
     * The JSON actions to be executed on inbound phone calls when the Assistant has
     * to say something first..
     * 
     * @param initiationActions The JSON actions to be executed on inbound phone
     *                          calls when the Assistant has to say something first.
     * @return this
     */
    public AssistantCreator setInitiationActions(final Map<String, Object> initiationActions) {
        this.initiationActions = initiationActions;
        return this;
    }

    /**
     * The JSON object that holds the style sheet for the assistant.
     * 
     * @param styleSheet The JSON object that holds the style sheet for the
     *                   assistant
     * @return this
     */
    public AssistantCreator setStyleSheet(final Map<String, Object> styleSheet) {
        this.styleSheet = styleSheet;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Assistant
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Assistant create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.PREVIEW.toString(),
            "/understand/Assistants",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Assistant creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Assistant.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (logQueries != null) {
            request.addPostParam("LogQueries", logQueries.toString());
        }

        if (uniqueName != null) {
            request.addPostParam("UniqueName", uniqueName);
        }

        if (callbackUrl != null) {
            request.addPostParam("CallbackUrl", callbackUrl.toString());
        }

        if (callbackEvents != null) {
            request.addPostParam("CallbackEvents", callbackEvents);
        }

        if (fallbackActions != null) {
            request.addPostParam("FallbackActions", Converter.mapToJson(fallbackActions));
        }

        if (initiationActions != null) {
            request.addPostParam("InitiationActions", Converter.mapToJson(initiationActions));
        }

        if (styleSheet != null) {
            request.addPostParam("StyleSheet", Converter.mapToJson(styleSheet));
        }
    }
}