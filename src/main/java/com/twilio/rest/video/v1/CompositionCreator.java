/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.video.v1;

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
import java.util.List;
import java.util.Map;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class CompositionCreator extends Creator<Composition> {
    private String roomSid;
    private Map<String, Object> videoLayout;
    private List<String> audioSources;
    private List<String> audioSourcesExcluded;
    private String resolution;
    private Composition.Format format;
    private URI statusCallback;
    private HttpMethod statusCallbackMethod;
    private Boolean trim;

    /**
     * Group Room SID owning the media tracks to be used as Composition sources..
     * 
     * @param roomSid Twilio Room SID.
     * @return this
     */
    public CompositionCreator setRoomSid(final String roomSid) {
        this.roomSid = roomSid;
        return this;
    }

    /**
     * A JSON object defining the video layout of the Composition in terms of
     * regions. See the section [Managing Video Layouts](#managing-video-layouts)
     * below for further information..
     * 
     * @param videoLayout The JSON video layout description.
     * @return this
     */
    public CompositionCreator setVideoLayout(final Map<String, Object> videoLayout) {
        this.videoLayout = videoLayout;
        return this;
    }

    /**
     * An array of audio sources to merge. All the specified sources must belong to
     * the same Group Room. It can include: 
     * 
     * * Zero or more `RecordingTrackSid`
     * * Zero or more `MediaTrackSid`
     * * Zero or more `ParticipantSid`
     * * Zero or more Track names. These can be specified using wildcards (e.g.
     * `student*`). The use of `[*]` has semantics "all if any" meaning zero or more
     * (i.e. all) depending on whether the target room had audio tracks..
     * 
     * @param audioSources A list of audio sources related to this Composition.
     * @return this
     */
    public CompositionCreator setAudioSources(final List<String> audioSources) {
        this.audioSources = audioSources;
        return this;
    }

    /**
     * An array of audio sources to merge. All the specified sources must belong to
     * the same Group Room. It can include: 
     * 
     * * Zero or more `RecordingTrackSid`
     * * Zero or more `MediaTrackSid`
     * * Zero or more `ParticipantSid`
     * * Zero or more Track names. These can be specified using wildcards (e.g.
     * `student*`). The use of `[*]` has semantics "all if any" meaning zero or more
     * (i.e. all) depending on whether the target room had audio tracks..
     * 
     * @param audioSources A list of audio sources related to this Composition.
     * @return this
     */
    public CompositionCreator setAudioSources(final String audioSources) {
        return setAudioSources(Promoter.listOfOne(audioSources));
    }

    /**
     * An array of audio sources to exclude from the Composition. Any new
     * Composition shall include all audio sources specified in `AudioSources`
     * except for the ones specified in `AudioSourcesExcluded`. This parameter may
     * include: 
     * 
     * * Zero or more `RecordingTrackSid`
     * * Zero or more `MediaTrackSid`
     * * Zero or more `ParticipantSid`
     * * Zero or more Track names. These can be specified using wildcards (e.g.
     * `student*`).
     * 
     * @param audioSourcesExcluded A list of audio sources excluded related to this
     *                             Composition.
     * @return this
     */
    public CompositionCreator setAudioSourcesExcluded(final List<String> audioSourcesExcluded) {
        this.audioSourcesExcluded = audioSourcesExcluded;
        return this;
    }

    /**
     * An array of audio sources to exclude from the Composition. Any new
     * Composition shall include all audio sources specified in `AudioSources`
     * except for the ones specified in `AudioSourcesExcluded`. This parameter may
     * include: 
     * 
     * * Zero or more `RecordingTrackSid`
     * * Zero or more `MediaTrackSid`
     * * Zero or more `ParticipantSid`
     * * Zero or more Track names. These can be specified using wildcards (e.g.
     * `student*`).
     * 
     * @param audioSourcesExcluded A list of audio sources excluded related to this
     *                             Composition.
     * @return this
     */
    public CompositionCreator setAudioSourcesExcluded(final String audioSourcesExcluded) {
        return setAudioSourcesExcluded(Promoter.listOfOne(audioSourcesExcluded));
    }

    /**
     * A string representing the number of pixels for rows (width) and columns
     * (height) of the generated composed video. This string must have the format
     * `{width}x{height}`. This parameter must comply with the following
     * constraints: 
     * 
     * * `width &gt;= 16 &amp;&amp; width &lt;= 1280`
     * * `height &gt;= 16 &amp;&amp; height &lt;= 1280`
     * * `width * height &lt;= 921,600`
     * 
     * Typical values are: 
     * 
     * * HD = `1280x720`
     * * PAL = `1024x576`
     * * VGA = `640x480`
     * * CIF = `320x240`
     * 
     * Note that the `Resolution` implicitly imposes an aspect ratio to the
     * resulting composition. When the original video tracks get constrained by this
     * aspect ratio they are scaled-down to fit. You can find detailed information
     * in the [Managing Video Layouts](#managing-video-layouts) section. Defaults to
     * `640x480`..
     * 
     * @param resolution Pixel resolution of the composed video.
     * @return this
     */
    public CompositionCreator setResolution(final String resolution) {
        this.resolution = resolution;
        return this;
    }

    /**
     * Container format of the Composition media file. Can be any of the following:
     * `mp4`, `webm`. The use of `mp4` or `webm` makes mandatory the specification
     * of `AudioSources` and/or one `VideoLayout` element containing a valid
     * `video_sources` list, otherwise an error is fired. Defaults to `webm`..
     * 
     * @param format Container format of the Composition media file. Any of the
     *               following: `mp4`, `webm`.
     * @return this
     */
    public CompositionCreator setFormat(final Composition.Format format) {
        this.format = format;
        return this;
    }

    /**
     * A URL that Twilio sends asynchronous webhook requests to on every composition
     * event. If not provided, status callback events will not be dispatched..
     * 
     * @param statusCallback A URL that Twilio sends asynchronous webhook requests
     *                       to on every composition event.
     * @return this
     */
    public CompositionCreator setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * A URL that Twilio sends asynchronous webhook requests to on every composition
     * event. If not provided, status callback events will not be dispatched..
     * 
     * @param statusCallback A URL that Twilio sends asynchronous webhook requests
     *                       to on every composition event.
     * @return this
     */
    public CompositionCreator setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    /**
     * HTTP method Twilio should use when requesting the above URL. Defaults to
     * `POST`..
     * 
     * @param statusCallbackMethod HTTP method Twilio should use when requesting
     *                             the above URL.
     * @return this
     */
    public CompositionCreator setStatusCallbackMethod(final HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    /**
     * When activated, clips all the Composition intervals where there is no active
     * media. This results in shorter compositions in cases when the Room was
     * created but no Participant joined for some time, or if all the Participants
     * left the room and joined at a later stage, as those gaps will be removed. You
     * can find further information in the [Managing Video
     * Layouts](#managing-video-layouts) section. Defaults to `true`..
     * 
     * @param trim Boolean flag for clipping intervals that have no media.
     * @return this
     */
    public CompositionCreator setTrim(final Boolean trim) {
        this.trim = trim;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Composition
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Composition create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.VIDEO.toString(),
            "/v1/Compositions",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Composition creation failed: Unable to connect to server");
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

        return Composition.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (roomSid != null) {
            request.addPostParam("RoomSid", roomSid);
        }

        if (videoLayout != null) {
            request.addPostParam("VideoLayout", Converter.mapToJson(videoLayout));
        }

        if (audioSources != null) {
            for (String prop : audioSources) {
                request.addPostParam("AudioSources", prop);
            }
        }

        if (audioSourcesExcluded != null) {
            for (String prop : audioSourcesExcluded) {
                request.addPostParam("AudioSourcesExcluded", prop);
            }
        }

        if (resolution != null) {
            request.addPostParam("Resolution", resolution);
        }

        if (format != null) {
            request.addPostParam("Format", format.toString());
        }

        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
        }

        if (statusCallbackMethod != null) {
            request.addPostParam("StatusCallbackMethod", statusCallbackMethod.toString());
        }

        if (trim != null) {
            request.addPostParam("Trim", trim.toString());
        }
    }
}