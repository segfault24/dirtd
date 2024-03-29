# SearchApi

All URIs are relative to *https://esi.evetech.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCharactersCharacterIdSearch**](SearchApi.md#getCharactersCharacterIdSearch) | **GET** /v3/characters/{character_id}/search/ | Search on a string


<a name="getCharactersCharacterIdSearch"></a>
# **getCharactersCharacterIdSearch**
> GetCharactersCharacterIdSearchOk getCharactersCharacterIdSearch(categories, characterId, search, acceptLanguage, datasource, ifNoneMatch, language, strict, token)

Search on a string

Search for entities that match a given sub-string.  ---  This route is cached for up to 3600 seconds

### Example
```java
// Import classes:
//import net.evetech.ApiClient;
//import net.evetech.ApiException;
//import net.evetech.Configuration;
//import net.evetech.auth.*;
//import net.evetech.esi.SearchApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: evesso
OAuth evesso = (OAuth) defaultClient.getAuthentication("evesso");
evesso.setAccessToken("YOUR ACCESS TOKEN");

SearchApi apiInstance = new SearchApi();
List<String> categories = Arrays.asList("categories_example"); // List<String> | Type of entities to search for
Integer characterId = 56; // Integer | An EVE character ID
String search = "search_example"; // String | The string to search on
String acceptLanguage = "en"; // String | Language to use in the response
String datasource = "tranquility"; // String | The server name you would like data from
String ifNoneMatch = "ifNoneMatch_example"; // String | ETag from a previous request. A 304 will be returned if this matches the current ETag
String language = "en"; // String | Language to use in the response, takes precedence over Accept-Language
Boolean strict = false; // Boolean | Whether the search should be a strict match
String token = "token_example"; // String | Access token to use if unable to set a header
try {
    GetCharactersCharacterIdSearchOk result = apiInstance.getCharactersCharacterIdSearch(categories, characterId, search, acceptLanguage, datasource, ifNoneMatch, language, strict, token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#getCharactersCharacterIdSearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **categories** | [**List&lt;String&gt;**](String.md)| Type of entities to search for | [enum: agent, alliance, character, constellation, corporation, faction, inventory_type, region, solar_system, station, structure]
 **characterId** | **Integer**| An EVE character ID |
 **search** | **String**| The string to search on |
 **acceptLanguage** | **String**| Language to use in the response | [optional] [default to en] [enum: en, en-us, de, fr, ja, ru, zh, ko, es]
 **datasource** | **String**| The server name you would like data from | [optional] [default to tranquility] [enum: tranquility]
 **ifNoneMatch** | **String**| ETag from a previous request. A 304 will be returned if this matches the current ETag | [optional]
 **language** | **String**| Language to use in the response, takes precedence over Accept-Language | [optional] [default to en] [enum: en, en-us, de, fr, ja, ru, zh, ko, es]
 **strict** | **Boolean**| Whether the search should be a strict match | [optional] [default to false]
 **token** | **String**| Access token to use if unable to set a header | [optional]

### Return type

[**GetCharactersCharacterIdSearchOk**](GetCharactersCharacterIdSearchOk.md)

### Authorization

[evesso](../README.md#evesso)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

