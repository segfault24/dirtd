/*
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 *
 * OpenAPI spec version: 1.12
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package net.evetech.esi;

import net.evetech.esi.models.BadRequest;
import net.evetech.esi.models.ErrorLimited;
import net.evetech.esi.models.Forbidden;
import net.evetech.esi.models.GatewayTimeout;
import net.evetech.esi.models.GetCharactersCharacterIdCalendar200Ok;
import net.evetech.esi.models.GetCharactersCharacterIdCalendarEventIdAttendees200Ok;
import net.evetech.esi.models.GetCharactersCharacterIdCalendarEventIdAttendeesNotFound;
import net.evetech.esi.models.GetCharactersCharacterIdCalendarEventIdNotFound;
import net.evetech.esi.models.GetCharactersCharacterIdCalendarEventIdOk;
import net.evetech.esi.models.InternalServerError;
import net.evetech.esi.models.PutCharactersCharacterIdCalendarEventIdResponse;
import net.evetech.esi.models.ServiceUnavailable;
import net.evetech.esi.models.Unauthorized;
import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CalendarApi
 */
@Ignore
public class CalendarApiTest {

    private final CalendarApi api = new CalendarApi();

    
    /**
     * List calendar event summaries
     *
     * Get 50 event summaries from the calendar. If no from_event ID is given, the resource will return the next 50 chronological event summaries from now. If a from_event ID is specified, it will return the next 50 chronological event summaries from after that event  ---  This route is cached for up to 5 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdCalendarTest() throws Exception {
        Integer characterId = null;
        String datasource = null;
        Integer fromEvent = null;
        String ifNoneMatch = null;
        String token = null;
        List<GetCharactersCharacterIdCalendar200Ok> response = api.getCharactersCharacterIdCalendar(characterId, datasource, fromEvent, ifNoneMatch, token);

        // TODO: test validations
    }
    
    /**
     * Get an event
     *
     * Get all the information for a specific event  ---  This route is cached for up to 5 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdCalendarEventIdTest() throws Exception {
        Integer characterId = null;
        Integer eventId = null;
        String datasource = null;
        String ifNoneMatch = null;
        String token = null;
        GetCharactersCharacterIdCalendarEventIdOk response = api.getCharactersCharacterIdCalendarEventId(characterId, eventId, datasource, ifNoneMatch, token);

        // TODO: test validations
    }
    
    /**
     * Get attendees
     *
     * Get all invited attendees for a given event  ---  This route is cached for up to 600 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdCalendarEventIdAttendeesTest() throws Exception {
        Integer characterId = null;
        Integer eventId = null;
        String datasource = null;
        String ifNoneMatch = null;
        String token = null;
        List<GetCharactersCharacterIdCalendarEventIdAttendees200Ok> response = api.getCharactersCharacterIdCalendarEventIdAttendees(characterId, eventId, datasource, ifNoneMatch, token);

        // TODO: test validations
    }
    
    /**
     * Respond to an event
     *
     * Set your response status to an event  ---  This route is cached for up to 5 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void putCharactersCharacterIdCalendarEventIdTest() throws Exception {
        Integer characterId = null;
        Integer eventId = null;
        PutCharactersCharacterIdCalendarEventIdResponse response = null;
        String datasource = null;
        String token = null;
        api.putCharactersCharacterIdCalendarEventId(characterId, eventId, response, datasource, token);

        // TODO: test validations
    }
    
}
