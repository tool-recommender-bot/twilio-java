/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.autopilot.v1.assistant.task;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class SampleUpdater extends Updater<Sample> {
    private final String pathAssistantSid;
    private final String pathTaskSid;
    private final String pathSid;
    private String language;
    private String taggedText;
    private String sourceChannel;

    /**
     * Construct a new SampleUpdater.
     * 
     * @param pathAssistantSid The assistant_sid
     * @param pathTaskSid The task_sid
     * @param pathSid The sid
     */
    public SampleUpdater(final String pathAssistantSid, 
                         final String pathTaskSid, 
                         final String pathSid) {
        this.pathAssistantSid = pathAssistantSid;
        this.pathTaskSid = pathTaskSid;
        this.pathSid = pathSid;
    }

    /**
     * An ISO language-country string that specifies the language used for this
     * sample. For example: en-US..
     * 
     * @param language An ISO language-country string that specifies the language
     *                 used for this sample. For example: en-US.
     * @return this
     */
    public SampleUpdater setLanguage(final String language) {
        this.language = language;
        return this;
    }

    /**
     * The text example of how end-users may express this task. The sample may
     * contain Field tag blocks..
     * 
     * @param taggedText The text example of how end-users may express this task.
     *                   The sample may contain Field tag blocks.
     * @return this
     */
    public SampleUpdater setTaggedText(final String taggedText) {
        this.taggedText = taggedText;
        return this;
    }

    /**
     * The communication channel from which the sample was captured. It can be:
     * *voice*, *sms*, *chat*, *alexa*, *google-assistant*, or *slack*. If not
     * included the value will be null.
     * 
     * @param sourceChannel The communication channel from which the sample was
     *                      captured. It can be: voice, sms, chat, alexa,
     *                      google-assistant, or slack. If not included the value
     *                      will be null
     * @return this
     */
    public SampleUpdater setSourceChannel(final String sourceChannel) {
        this.sourceChannel = sourceChannel;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Sample
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Sample update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.AUTOPILOT.toString(),
            "/v1/Assistants/" + this.pathAssistantSid + "/Tasks/" + this.pathTaskSid + "/Samples/" + this.pathSid + "",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Sample update failed: Unable to connect to server");
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

        return Sample.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (language != null) {
            request.addPostParam("Language", language);
        }

        if (taggedText != null) {
            request.addPostParam("TaggedText", taggedText);
        }

        if (sourceChannel != null) {
            request.addPostParam("SourceChannel", sourceChannel);
        }
    }
}