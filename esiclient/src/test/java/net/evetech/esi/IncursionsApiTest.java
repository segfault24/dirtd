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
import net.evetech.esi.models.GetIncursions200Ok;
import net.evetech.esi.models.InternalServerError;
import net.evetech.esi.models.ServiceUnavailable;
import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for IncursionsApi
 */
@Ignore
public class IncursionsApiTest {

    private final IncursionsApi api = new IncursionsApi();

    
    /**
     * List incursions
     *
     * Return a list of current incursions  ---  This route is cached for up to 300 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getIncursionsTest() throws Exception {
        String datasource = null;
        String ifNoneMatch = null;
        List<GetIncursions200Ok> response = api.getIncursions(datasource, ifNoneMatch);

        // TODO: test validations
    }
    
}
