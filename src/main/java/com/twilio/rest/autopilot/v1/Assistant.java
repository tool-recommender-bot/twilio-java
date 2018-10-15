/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.autopilot.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Assistant extends Resource {
    private static final long serialVersionUID = 17320483220293L;

    /**
     * Create a AssistantFetcher to execute fetch.
     * 
     * @param pathSid The sid
     * @return AssistantFetcher capable of executing the fetch
     */
    public static AssistantFetcher fetcher(final String pathSid) {
        return new AssistantFetcher(pathSid);
    }

    /**
     * Create a AssistantReader to execute read.
     * 
     * @return AssistantReader capable of executing the read
     */
    public static AssistantReader reader() {
        return new AssistantReader();
    }

    /**
     * Create a AssistantCreator to execute create.
     * 
     * @return AssistantCreator capable of executing the create
     */
    public static AssistantCreator creator() {
        return new AssistantCreator();
    }

    /**
     * Create a AssistantUpdater to execute update.
     * 
     * @param pathSid The sid
     * @return AssistantUpdater capable of executing the update
     */
    public static AssistantUpdater updater(final String pathSid) {
        return new AssistantUpdater(pathSid);
    }

    /**
     * Create a AssistantDeleter to execute delete.
     * 
     * @param pathSid The sid
     * @return AssistantDeleter capable of executing the delete
     */
    public static AssistantDeleter deleter(final String pathSid) {
        return new AssistantDeleter(pathSid);
    }

    /**
     * Converts a JSON String into a Assistant object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Assistant object represented by the provided JSON
     */
    public static Assistant fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Assistant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Assistant object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Assistant object represented by the provided JSON
     */
    public static Assistant fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Assistant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String friendlyName;
    private final String latestModelBuildSid;
    private final Map<String, String> links;
    private final Boolean logQueries;
    private final String sid;
    private final String uniqueName;
    private final URI url;
    private final URI callbackUrl;
    private final String callbackEvents;

    @JsonCreator
    private Assistant(@JsonProperty("account_sid")
                      final String accountSid, 
                      @JsonProperty("date_created")
                      final String dateCreated, 
                      @JsonProperty("date_updated")
                      final String dateUpdated, 
                      @JsonProperty("friendly_name")
                      final String friendlyName, 
                      @JsonProperty("latest_model_build_sid")
                      final String latestModelBuildSid, 
                      @JsonProperty("links")
                      final Map<String, String> links, 
                      @JsonProperty("log_queries")
                      final Boolean logQueries, 
                      @JsonProperty("sid")
                      final String sid, 
                      @JsonProperty("unique_name")
                      final String uniqueName, 
                      @JsonProperty("url")
                      final URI url, 
                      @JsonProperty("callback_url")
                      final URI callbackUrl, 
                      @JsonProperty("callback_events")
                      final String callbackEvents) {
        this.accountSid = accountSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.latestModelBuildSid = latestModelBuildSid;
        this.links = links;
        this.logQueries = logQueries;
        this.sid = sid;
        this.uniqueName = uniqueName;
        this.url = url;
        this.callbackUrl = callbackUrl;
        this.callbackEvents = callbackEvents;
    }

    /**
     * Returns The The unique ID of the Account that created this Assistant..
     * 
     * @return The unique ID of the Account that created this Assistant.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The date that this resource was created.
     * 
     * @return The date that this resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date that this resource was last updated.
     * 
     * @return The date that this resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The A text description for the Assistant. It is non-unique and can be
     * up to 255 characters long..
     * 
     * @return A text description for the Assistant. It is non-unique and can be up
     *         to 255 characters long.
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The The unique ID (Sid) of the latest model build. Null if no model
     * has been built..
     * 
     * @return The unique ID (Sid) of the latest model build. Null if no model has
     *         been built.
     */
    public final String getLatestModelBuildSid() {
        return this.latestModelBuildSid;
    }

    /**
     * Returns The The links.
     * 
     * @return The links
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    /**
     * Returns The A boolean that specifies whether queries should be logged for 30
     * days further training. If false, no queries will be stored, if true, queries
     * will be stored for 30 days and deleted thereafter..
     * 
     * @return A boolean that specifies whether queries should be logged for 30
     *         days further training. If false, no queries will be stored, if true,
     *         queries will be stored for 30 days and deleted thereafter.
     */
    public final Boolean getLogQueries() {
        return this.logQueries;
    }

    /**
     * Returns The A 34 character string that uniquely identifies this resource..
     * 
     * @return A 34 character string that uniquely identifies this resource.
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The A user-provided string that uniquely identifies this resource as
     * an alternative to the sid. You can use the unique name in the URL path.
     * Unique up to 64 characters long..
     * 
     * @return A user-provided string that uniquely identifies this resource as an
     *         alternative to the sid. You can use the unique name in the URL path.
     *         Unique up to 64 characters long.
     */
    public final String getUniqueName() {
        return this.uniqueName;
    }

    /**
     * Returns The The url.
     * 
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The The callback_url.
     * 
     * @return The callback_url
     */
    public final URI getCallbackUrl() {
        return this.callbackUrl;
    }

    /**
     * Returns The The callback_events.
     * 
     * @return The callback_events
     */
    public final String getCallbackEvents() {
        return this.callbackEvents;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Assistant other = (Assistant) o;

        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(latestModelBuildSid, other.latestModelBuildSid) && 
               Objects.equals(links, other.links) && 
               Objects.equals(logQueries, other.logQueries) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(uniqueName, other.uniqueName) && 
               Objects.equals(url, other.url) && 
               Objects.equals(callbackUrl, other.callbackUrl) && 
               Objects.equals(callbackEvents, other.callbackEvents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            dateCreated,
                            dateUpdated,
                            friendlyName,
                            latestModelBuildSid,
                            links,
                            logQueries,
                            sid,
                            uniqueName,
                            url,
                            callbackUrl,
                            callbackEvents);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("friendlyName", friendlyName)
                          .add("latestModelBuildSid", latestModelBuildSid)
                          .add("links", links)
                          .add("logQueries", logQueries)
                          .add("sid", sid)
                          .add("uniqueName", uniqueName)
                          .add("url", url)
                          .add("callbackUrl", callbackUrl)
                          .add("callbackEvents", callbackEvents)
                          .toString();
    }
}