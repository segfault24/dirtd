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
import net.evetech.esi.models.GatewayTimeout;
import net.evetech.esi.models.GetRouteOriginDestinationNotFound;
import net.evetech.esi.models.InternalServerError;
import net.evetech.esi.models.ServiceUnavailable;
import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for RoutesApi
 */
@Ignore
public class RoutesApiTest {

    private final RoutesApi api = new RoutesApi();

    
    /**
     * Get route
     *
     * Get the systems between origin and destination  ---  This route is cached for up to 86400 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getRouteOriginDestinationTest() throws Exception {
        Integer destination = null;
        Integer origin = null;
        List<Integer> avoid = null;
        List<List<Integer>> connections = null;
        String datasource = null;
        String flag = null;
        String ifNoneMatch = null;
        List<Integer> response = api.getRouteOriginDestination(destination, origin, avoid, connections, datasource, flag, ifNoneMatch);

        // TODO: test validations
    }
    
}
