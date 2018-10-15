/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.autopilot.v1;

import com.twilio.base.Updater;
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
public class AssistantUpdater extends Updater<Assistant> {
    private final String pathSid;
    private String friendlyName;
    private Boolean logQueries;
    private String uniqueName;
    private URI callbackUrl;
    private String callbackEvents;
    private Map<String, Object> styleSheet;
    private Map<String, Object> defaults;

    /**
     * Construct a new AssistantUpdater.
     * 
     * @param pathSid The sid
     */
    public AssistantUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * A text description for the Assistant. It is non-unique and can be up to 255
     * characters long..
     * 
     * @param friendlyName A text description for the Assistant. It is non-unique
     *                     and can be up to 255 characters long.
     * @return this
     */
    public AssistantUpdater setFriendlyName(final String friendlyName) {
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
    public AssistantUpdater setLogQueries(final Boolean logQueries) {
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
    public AssistantUpdater setUniqueName(final String uniqueName) {
        this.uniqueName = uniqueName;
        return this;
    }

    /**
     * The callback_url.
     * 
     * @param callbackUrl The callback_url
     * @return this
     */
    public AssistantUpdater setCallbackUrl(final URI callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    /**
     * The callback_url.
     * 
     * @param callbackUrl The callback_url
     * @return this
     */
    public AssistantUpdater setCallbackUrl(final String callbackUrl) {
        return setCallbackUrl(Promoter.uriFromString(callbackUrl));
    }

    /**
     * The callback_events.
     * 
     * @param callbackEvents The callback_events
     * @return this
     */
    public AssistantUpdater setCallbackEvents(final String callbackEvents) {
        this.callbackEvents = callbackEvents;
        return this;
    }

    /**
     * A JSON object that defines the assistant style sheet.
     * 
     * @param styleSheet A JSON object that defines the assistant style sheet
     * @return this
     */
    public AssistantUpdater setStyleSheet(final Map<String, Object> styleSheet) {
        this.styleSheet = styleSheet;
        return this;
    }

    /**
     * A JSON object that defines the assistant's default tasks for various
     * scenarios.
     * 
     * @param defaults A JSON object that defines the assistant's default tasks for
     *                 various scenarios
     * @return this
     */
    public AssistantUpdater setDefaults(final Map<String, Object> defaults) {
        this.defaults = defaults;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Assistant
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Assistant update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.AUTOPILOT.toString(),
            "/v1/Assistants/" + this.pathSid + "",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Assistant update failed: Unable to connect to server");
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

        if (styleSheet != null) {
            request.addPostParam("StyleSheet", Converter.mapToJson(styleSheet));
        }

        if (defaults != null) {
            request.addPostParam("Defaults", Converter.mapToJson(defaults));
        }
    }
}