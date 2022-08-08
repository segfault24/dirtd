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
import net.evetech.esi.models.GetCharactersCharacterIdContracts200Ok;
import net.evetech.esi.models.GetCharactersCharacterIdContractsContractIdBids200Ok;
import net.evetech.esi.models.GetCharactersCharacterIdContractsContractIdBidsNotFound;
import net.evetech.esi.models.GetCharactersCharacterIdContractsContractIdItems200Ok;
import net.evetech.esi.models.GetCharactersCharacterIdContractsContractIdItemsNotFound;
import net.evetech.esi.models.GetContractsPublicBidsContractId200Ok;
import net.evetech.esi.models.GetContractsPublicBidsContractIdForbidden;
import net.evetech.esi.models.GetContractsPublicBidsContractIdNotFound;
import net.evetech.esi.models.GetContractsPublicItemsContractId200Ok;
import net.evetech.esi.models.GetContractsPublicItemsContractIdForbidden;
import net.evetech.esi.models.GetContractsPublicItemsContractIdNotFound;
import net.evetech.esi.models.GetContractsPublicRegionId200Ok;
import net.evetech.esi.models.GetContractsPublicRegionIdNotFound;
import net.evetech.esi.models.GetCorporationsCorporationIdContracts200Ok;
import net.evetech.esi.models.GetCorporationsCorporationIdContractsContractIdBids200Ok;
import net.evetech.esi.models.GetCorporationsCorporationIdContractsContractIdBidsNotFound;
import net.evetech.esi.models.GetCorporationsCorporationIdContractsContractIdItems200Ok;
import net.evetech.esi.models.GetCorporationsCorporationIdContractsContractIdItemsError520;
import net.evetech.esi.models.GetCorporationsCorporationIdContractsContractIdItemsNotFound;
import net.evetech.esi.models.InternalServerError;
import net.evetech.esi.models.ServiceUnavailable;
import net.evetech.esi.models.Unauthorized;
import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ContractsApi
 */
@Ignore
public class ContractsApiTest {

    private final ContractsApi api = new ContractsApi();

    
    /**
     * Get contracts
     *
     * Returns contracts available to a character, only if the character is issuer, acceptor or assignee. Only returns contracts no older than 30 days, or if the status is \&quot;in_progress\&quot;.  ---  This route is cached for up to 300 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdContractsTest() throws Exception {
        Integer characterId = null;
        String datasource = null;
        String ifNoneMatch = null;
        Integer page = null;
        String token = null;
        List<GetCharactersCharacterIdContracts200Ok> response = api.getCharactersCharacterIdContracts(characterId, datasource, ifNoneMatch, page, token);

        // TODO: test validations
    }
    
    /**
     * Get contract bids
     *
     * Lists bids on a particular auction contract  ---  This route is cached for up to 300 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdContractsContractIdBidsTest() throws Exception {
        Integer characterId = null;
        Integer contractId = null;
        String datasource = null;
        String ifNoneMatch = null;
        String token = null;
        List<GetCharactersCharacterIdContractsContractIdBids200Ok> response = api.getCharactersCharacterIdContractsContractIdBids(characterId, contractId, datasource, ifNoneMatch, token);

        // TODO: test validations
    }
    
    /**
     * Get contract items
     *
     * Lists items of a particular contract  ---  This route is cached for up to 3600 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdContractsContractIdItemsTest() throws Exception {
        Integer characterId = null;
        Integer contractId = null;
        String datasource = null;
        String ifNoneMatch = null;
        String token = null;
        List<GetCharactersCharacterIdContractsContractIdItems200Ok> response = api.getCharactersCharacterIdContractsContractIdItems(characterId, contractId, datasource, ifNoneMatch, token);

        // TODO: test validations
    }
    
    /**
     * Get public contract bids
     *
     * Lists bids on a public auction contract  ---  This route is cached for up to 300 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getContractsPublicBidsContractIdTest() throws Exception {
        Integer contractId = null;
        String datasource = null;
        String ifNoneMatch = null;
        Integer page = null;
        List<GetContractsPublicBidsContractId200Ok> response = api.getContractsPublicBidsContractId(contractId, datasource, ifNoneMatch, page);

        // TODO: test validations
    }
    
    /**
     * Get public contract items
     *
     * Lists items of a public contract  ---  This route is cached for up to 3600 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getContractsPublicItemsContractIdTest() throws Exception {
        Integer contractId = null;
        String datasource = null;
        String ifNoneMatch = null;
        Integer page = null;
        List<GetContractsPublicItemsContractId200Ok> response = api.getContractsPublicItemsContractId(contractId, datasource, ifNoneMatch, page);

        // TODO: test validations
    }
    
    /**
     * Get public contracts
     *
     * Returns a paginated list of all public contracts in the given region  ---  This route is cached for up to 1800 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getContractsPublicRegionIdTest() throws Exception {
        Integer regionId = null;
        String datasource = null;
        String ifNoneMatch = null;
        Integer page = null;
        List<GetContractsPublicRegionId200Ok> response = api.getContractsPublicRegionId(regionId, datasource, ifNoneMatch, page);

        // TODO: test validations
    }
    
    /**
     * Get corporation contracts
     *
     * Returns contracts available to a corporation, only if the corporation is issuer, acceptor or assignee. Only returns contracts no older than 30 days, or if the status is \&quot;in_progress\&quot;.  ---  This route is cached for up to 300 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCorporationsCorporationIdContractsTest() throws Exception {
        Integer corporationId = null;
        String datasource = null;
        String ifNoneMatch = null;
        Integer page = null;
        String token = null;
        List<GetCorporationsCorporationIdContracts200Ok> response = api.getCorporationsCorporationIdContracts(corporationId, datasource, ifNoneMatch, page, token);

        // TODO: test validations
    }
    
    /**
     * Get corporation contract bids
     *
     * Lists bids on a particular auction contract  ---  This route is cached for up to 3600 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCorporationsCorporationIdContractsContractIdBidsTest() throws Exception {
        Integer contractId = null;
        Integer corporationId = null;
        String datasource = null;
        String ifNoneMatch = null;
        Integer page = null;
        String token = null;
        List<GetCorporationsCorporationIdContractsContractIdBids200Ok> response = api.getCorporationsCorporationIdContractsContractIdBids(contractId, corporationId, datasource, ifNoneMatch, page, token);

        // TODO: test validations
    }
    
    /**
     * Get corporation contract items
     *
     * Lists items of a particular contract  ---  This route is cached for up to 3600 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCorporationsCorporationIdContractsContractIdItemsTest() throws Exception {
        Integer contractId = null;
        Integer corporationId = null;
        String datasource = null;
        String ifNoneMatch = null;
        String token = null;
        List<GetCorporationsCorporationIdContractsContractIdItems200Ok> response = api.getCorporationsCorporationIdContractsContractIdItems(contractId, corporationId, datasource, ifNoneMatch, token);

        // TODO: test validations
    }
    
}
