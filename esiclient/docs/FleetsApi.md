# FleetsApi

All URIs are relative to *https://esi.evetech.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteFleetsFleetIdMembersMemberId**](FleetsApi.md#deleteFleetsFleetIdMembersMemberId) | **DELETE** /v1/fleets/{fleet_id}/members/{member_id}/ | Kick fleet member
[**deleteFleetsFleetIdSquadsSquadId**](FleetsApi.md#deleteFleetsFleetIdSquadsSquadId) | **DELETE** /v1/fleets/{fleet_id}/squads/{squad_id}/ | Delete fleet squad
[**deleteFleetsFleetIdWingsWingId**](FleetsApi.md#deleteFleetsFleetIdWingsWingId) | **DELETE** /v1/fleets/{fleet_id}/wings/{wing_id}/ | Delete fleet wing
[**getCharactersCharacterIdFleet**](FleetsApi.md#getCharactersCharacterIdFleet) | **GET** /v1/characters/{character_id}/fleet/ | Get character fleet info
[**getFleetsFleetId**](FleetsApi.md#getFleetsFleetId) | **GET** /v1/fleets/{fleet_id}/ | Get fleet information
[**getFleetsFleetIdMembers**](FleetsApi.md#getFleetsFleetIdMembers) | **GET** /v1/fleets/{fleet_id}/members/ | Get fleet members
[**getFleetsFleetIdWings**](FleetsApi.md#getFleetsFleetIdWings) | **GET** /v1/fleets/{fleet_id}/wings/ | Get fleet wings
[**postFleetsFleetIdMembers**](FleetsApi.md#postFleetsFleetIdMembers) | **POST** /v1/fleets/{fleet_id}/members/ | Create fleet invitation
[**postFleetsFleetIdWings**](FleetsApi.md#postFleetsFleetIdWings) | **POST** /v1/fleets/{fleet_id}/wings/ | Create fleet wing
[**postFleetsFleetIdWingsWingIdSquads**](FleetsApi.md#postFleetsFleetIdWingsWingIdSquads) | **POST** /v1/fleets/{fleet_id}/wings/{wing_id}/squads/ | Create fleet squad
[**putFleetsFleetId**](FleetsApi.md#putFleetsFleetId) | **PUT** /v1/fleets/{fleet_id}/ | Update fleet
[**putFleetsFleetIdMembersMemberId**](FleetsApi.md#putFleetsFleetIdMembersMemberId) | **PUT** /v1/fleets/{fleet_id}/members/{member_id}/ | Move fleet member
[**putFleetsFleetIdSquadsSquadId**](FleetsApi.md#putFleetsFleetIdSquadsSquadId) | **PUT** /v1/fleets/{fleet_id}/squads/{squad_id}/ | Rename fleet squad
[**putFleetsFleetIdWingsWingId**](FleetsApi.md#putFleetsFleetIdWingsWingId) | **PUT** /v1/fleets/{fleet_id}/wings/{wing_id}/ | Rename fleet wing


<a name="deleteFleetsFleetIdMembersMemberId"></a>
# **deleteFleetsFleetIdMembersMemberId**
> deleteFleetsFleetIdMembersMemberId(fleetId, memberId, datasource, token)

Kick fleet member

Kick a fleet member  --- 

### Example
```java
// Import classes:
//import net.evetech.ApiClient;
//import net.evetech.ApiException;
//import net.evetech.Configuration;
//import net.evetech.auth.*;
//import net.evetech.esi.FleetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: evesso
OAuth evesso = (OAuth) defaultClient.getAuthentication("evesso");
evesso.setAccessToken("YOUR ACCESS TOKEN");

FleetsApi apiInstance = new FleetsApi();
Long fleetId = 789L; // Long | ID for a fleet
Integer memberId = 56; // Integer | The character ID of a member in this fleet
String datasource = "tranquility"; // String | The server name you would like data from
String token = "token_example"; // String | Access token to use if unable to set a header
try {
    apiInstance.deleteFleetsFleetIdMembersMemberId(fleetId, memberId, datasource, token);
} catch (ApiException e) {
    System.err.println("Exception when calling FleetsApi#deleteFleetsFleetIdMembersMemberId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fleetId** | **Long**| ID for a fleet |
 **memberId** | **Integer**| The character ID of a member in this fleet |
 **datasource** | **String**| The server name you would like data from | [optional] [default to tranquility] [enum: tranquility]
 **token** | **String**| Access token to use if unable to set a header | [optional]

### Return type

null (empty response body)

### Authorization

[evesso](../README.md#evesso)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteFleetsFleetIdSquadsSquadId"></a>
# **deleteFleetsFleetIdSquadsSquadId**
> deleteFleetsFleetIdSquadsSquadId(fleetId, squadId, datasource, token)

Delete fleet squad

Delete a fleet squad, only empty squads can be deleted  --- 

### Example
```java
// Import classes:
//import net.evetech.ApiClient;
//import net.evetech.ApiException;
//import net.evetech.Configuration;
//import net.evetech.auth.*;
//import net.evetech.esi.FleetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: evesso
OAuth evesso = (OAuth) defaultClient.getAuthentication("evesso");
evesso.setAccessToken("YOUR ACCESS TOKEN");

FleetsApi apiInstance = new FleetsApi();
Long fleetId = 789L; // Long | ID for a fleet
Long squadId = 789L; // Long | The squad to delete
String datasource = "tranquility"; // String | The server name you would like data from
String token = "token_example"; // String | Access token to use if unable to set a header
try {
    apiInstance.deleteFleetsFleetIdSquadsSquadId(fleetId, squadId, datasource, token);
} catch (ApiException e) {
    System.err.println("Exception when calling FleetsApi#deleteFleetsFleetIdSquadsSquadId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fleetId** | **Long**| ID for a fleet |
 **squadId** | **Long**| The squad to delete |
 **datasource** | **String**| The server name you would like data from | [optional] [default to tranquility] [enum: tranquility]
 **token** | **String**| Access token to use if unable to set a header | [optional]

### Return type

null (empty response body)

### Authorization

[evesso](../README.md#evesso)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteFleetsFleetIdWingsWingId"></a>
# **deleteFleetsFleetIdWingsWingId**
> deleteFleetsFleetIdWingsWingId(fleetId, wingId, datasource, token)

Delete fleet wing

Delete a fleet wing, only empty wings can be deleted. The wing may contain squads, but the squads must be empty  --- 

### Example
```java
// Import classes:
//import net.evetech.ApiClient;
//import net.evetech.ApiException;
//import net.evetech.Configuration;
//import net.evetech.auth.*;
//import net.evetech.esi.FleetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: evesso
OAuth evesso = (OAuth) defaultClient.getAuthentication("evesso");
evesso.setAccessToken("YOUR ACCESS TOKEN");

FleetsApi apiInstance = new FleetsApi();
Long fleetId = 789L; // Long | ID for a fleet
Long wingId = 789L; // Long | The wing to delete
String datasource = "tranquility"; // String | The server name you would like data from
String token = "token_example"; // String | Access token to use if unable to set a header
try {
    apiInstance.deleteFleetsFleetIdWingsWingId(fleetId, wingId, datasource, token);
} catch (ApiException e) {
    System.err.println("Exception when calling FleetsApi#deleteFleetsFleetIdWingsWingId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fleetId** | **Long**| ID for a fleet |
 **wingId** | **Long**| The wing to delete |
 **datasource** | **String**| The server name you would like data from | [optional] [default to tranquility] [enum: tranquility]
 **token** | **String**| Access token to use if unable to set a header | [optional]

### Return type

null (empty response body)

### Authorization

[evesso](../README.md#evesso)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCharactersCharacterIdFleet"></a>
# **getCharactersCharacterIdFleet**
> GetCharactersCharacterIdFleetOk getCharactersCharacterIdFleet(characterId, datasource, ifNoneMatch, token)

Get character fleet info

Return the fleet ID the character is in, if any.  ---  This route is cached for up to 60 seconds  --- Warning: This route has an upgrade available  --- [Diff of the upcoming changes](https://esi.evetech.net/diff/latest/dev/#GET-/characters/{character_id}/fleet/)

### Example
```java
// Import classes:
//import net.evetech.ApiClient;
//import net.evetech.ApiException;
//import net.evetech.Configuration;
//import net.evetech.auth.*;
//import net.evetech.esi.FleetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: evesso
OAuth evesso = (OAuth) defaultClient.getAuthentication("evesso");
evesso.setAccessToken("YOUR ACCESS TOKEN");

FleetsApi apiInstance = new FleetsApi();
Integer characterId = 56; // Integer | An EVE character ID
String datasource = "tranquility"; // String | The server name you would like data from
String ifNoneMatch = "ifNoneMatch_example"; // String | ETag from a previous request. A 304 will be returned if this matches the current ETag
String token = "token_example"; // String | Access token to use if unable to set a header
try {
    GetCharactersCharacterIdFleetOk result = apiInstance.getCharactersCharacterIdFleet(characterId, datasource, ifNoneMatch, token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FleetsApi#getCharactersCharacterIdFleet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **characterId** | **Integer**| An EVE character ID |
 **datasource** | **String**| The server name you would like data from | [optional] [default to tranquility] [enum: tranquility]
 **ifNoneMatch** | **String**| ETag from a previous request. A 304 will be returned if this matches the current ETag | [optional]
 **token** | **String**| Access token to use if unable to set a header | [optional]

### Return type

[**GetCharactersCharacterIdFleetOk**](GetCharactersCharacterIdFleetOk.md)

### Authorization

[evesso](../README.md#evesso)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFleetsFleetId"></a>
# **getFleetsFleetId**
> GetFleetsFleetIdOk getFleetsFleetId(fleetId, datasource, ifNoneMatch, token)

Get fleet information

Return details about a fleet  ---  This route is cached for up to 5 seconds

### Example
```java
// Import classes:
//import net.evetech.ApiClient;
//import net.evetech.ApiException;
//import net.evetech.Configuration;
//import net.evetech.auth.*;
//import net.evetech.esi.FleetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: evesso
OAuth evesso = (OAuth) defaultClient.getAuthentication("evesso");
evesso.setAccessToken("YOUR ACCESS TOKEN");

FleetsApi apiInstance = new FleetsApi();
Long fleetId = 789L; // Long | ID for a fleet
String datasource = "tranquility"; // String | The server name you would like data from
String ifNoneMatch = "ifNoneMatch_example"; // String | ETag from a previous request. A 304 will be returned if this matches the current ETag
String token = "token_example"; // String | Access token to use if unable to set a header
try {
    GetFleetsFleetIdOk result = apiInstance.getFleetsFleetId(fleetId, datasource, ifNoneMatch, token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FleetsApi#getFleetsFleetId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fleetId** | **Long**| ID for a fleet |
 **datasource** | **String**| The server name you would like data from | [optional] [default to tranquility] [enum: tranquility]
 **ifNoneMatch** | **String**| ETag from a previous request. A 304 will be returned if this matches the current ETag | [optional]
 **token** | **String**| Access token to use if unable to set a header | [optional]

### Return type

[**GetFleetsFleetIdOk**](GetFleetsFleetIdOk.md)

### Authorization

[evesso](../README.md#evesso)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFleetsFleetIdMembers"></a>
# **getFleetsFleetIdMembers**
> List&lt;GetFleetsFleetIdMembers200Ok&gt; getFleetsFleetIdMembers(fleetId, acceptLanguage, datasource, ifNoneMatch, language, token)

Get fleet members

Return information about fleet members  ---  This route is cached for up to 5 seconds

### Example
```java
// Import classes:
//import net.evetech.ApiClient;
//import net.evetech.ApiException;
//import net.evetech.Configuration;
//import net.evetech.auth.*;
//import net.evetech.esi.FleetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: evesso
OAuth evesso = (OAuth) defaultClient.getAuthentication("evesso");
evesso.setAccessToken("YOUR ACCESS TOKEN");

FleetsApi apiInstance = new FleetsApi();
Long fleetId = 789L; // Long | ID for a fleet
String acceptLanguage = "en"; // String | Language to use in the response
String datasource = "tranquility"; // String | The server name you would like data from
String ifNoneMatch = "ifNoneMatch_example"; // String | ETag from a previous request. A 304 will be returned if this matches the current ETag
String language = "en"; // String | Language to use in the response, takes precedence over Accept-Language
String token = "token_example"; // String | Access token to use if unable to set a header
try {
    List<GetFleetsFleetIdMembers200Ok> result = apiInstance.getFleetsFleetIdMembers(fleetId, acceptLanguage, datasource, ifNoneMatch, language, token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FleetsApi#getFleetsFleetIdMembers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fleetId** | **Long**| ID for a fleet |
 **acceptLanguage** | **String**| Language to use in the response | [optional] [default to en] [enum: en, en-us, de, fr, ja, ru, zh, ko, es]
 **datasource** | **String**| The server name you would like data from | [optional] [default to tranquility] [enum: tranquility]
 **ifNoneMatch** | **String**| ETag from a previous request. A 304 will be returned if this matches the current ETag | [optional]
 **language** | **String**| Language to use in the response, takes precedence over Accept-Language | [optional] [default to en] [enum: en, en-us, de, fr, ja, ru, zh, ko, es]
 **token** | **String**| Access token to use if unable to set a header | [optional]

### Return type

[**List&lt;GetFleetsFleetIdMembers200Ok&gt;**](GetFleetsFleetIdMembers200Ok.md)

### Authorization

[evesso](../README.md#evesso)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFleetsFleetIdWings"></a>
# **getFleetsFleetIdWings**
> List&lt;GetFleetsFleetIdWings200Ok&gt; getFleetsFleetIdWings(fleetId, acceptLanguage, datasource, ifNoneMatch, language, token)

Get fleet wings

Return information about wings in a fleet  ---  This route is cached for up to 5 seconds

### Example
```java
// Import classes:
//import net.evetech.ApiClient;
//import net.evetech.ApiException;
//import net.evetech.Configuration;
//import net.evetech.auth.*;
//import net.evetech.esi.FleetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: evesso
OAuth evesso = (OAuth) defaultClient.getAuthentication("evesso");
evesso.setAccessToken("YOUR ACCESS TOKEN");

FleetsApi apiInstance = new FleetsApi();
Long fleetId = 789L; // Long | ID for a fleet
String acceptLanguage = "en"; // String | Language to use in the response
String datasource = "tranquility"; // String | The server name you would like data from
String ifNoneMatch = "ifNoneMatch_example"; // String | ETag from a previous request. A 304 will be returned if this matches the current ETag
String language = "en"; // String | Language to use in the response, takes precedence over Accept-Language
String token = "token_example"; // String | Access token to use if unable to set a header
try {
    List<GetFleetsFleetIdWings200Ok> result = apiInstance.getFleetsFleetIdWings(fleetId, acceptLanguage, datasource, ifNoneMatch, language, token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FleetsApi#getFleetsFleetIdWings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fleetId** | **Long**| ID for a fleet |
 **acceptLanguage** | **String**| Language to use in the response | [optional] [default to en] [enum: en, en-us, de, fr, ja, ru, zh, ko, es]
 **datasource** | **String**| The server name you would like data from | [optional] [default to tranquility] [enum: tranquility]
 **ifNoneMatch** | **String**| ETag from a previous request. A 304 will be returned if this matches the current ETag | [optional]
 **language** | **String**| Language to use in the response, takes precedence over Accept-Language | [optional] [default to en] [enum: en, en-us, de, fr, ja, ru, zh, ko, es]
 **token** | **String**| Access token to use if unable to set a header | [optional]

### Return type

[**List&lt;GetFleetsFleetIdWings200Ok&gt;**](GetFleetsFleetIdWings200Ok.md)

### Authorization

[evesso](../README.md#evesso)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postFleetsFleetIdMembers"></a>
# **postFleetsFleetIdMembers**
> postFleetsFleetIdMembers(fleetId, invitation, datasource, token)

Create fleet invitation

Invite a character into the fleet. If a character has a CSPA charge set it is not possible to invite them to the fleet using ESI  --- 

### Example
```java
// Import classes:
//import net.evetech.ApiClient;
//import net.evetech.ApiException;
//import net.evetech.Configuration;
//import net.evetech.auth.*;
//import net.evetech.esi.FleetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: evesso
OAuth evesso = (OAuth) defaultClient.getAuthentication("evesso");
evesso.setAccessToken("YOUR ACCESS TOKEN");

FleetsApi apiInstance = new FleetsApi();
Long fleetId = 789L; // Long | ID for a fleet
PostFleetsFleetIdMembersInvitation invitation = new PostFleetsFleetIdMembersInvitation(); // PostFleetsFleetIdMembersInvitation | Details of the invitation
String datasource = "tranquility"; // String | The server name you would like data from
String token = "token_example"; // String | Access token to use if unable to set a header
try {
    apiInstance.postFleetsFleetIdMembers(fleetId, invitation, datasource, token);
} catch (ApiException e) {
    System.err.println("Exception when calling FleetsApi#postFleetsFleetIdMembers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fleetId** | **Long**| ID for a fleet |
 **invitation** | [**PostFleetsFleetIdMembersInvitation**](PostFleetsFleetIdMembersInvitation.md)| Details of the invitation |
 **datasource** | **String**| The server name you would like data from | [optional] [default to tranquility] [enum: tranquility]
 **token** | **String**| Access token to use if unable to set a header | [optional]

### Return type

null (empty response body)

### Authorization

[evesso](../README.md#evesso)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postFleetsFleetIdWings"></a>
# **postFleetsFleetIdWings**
> PostFleetsFleetIdWingsCreated postFleetsFleetIdWings(fleetId, datasource, token)

Create fleet wing

Create a new wing in a fleet  --- 

### Example
```java
// Import classes:
//import net.evetech.ApiClient;
//import net.evetech.ApiException;
//import net.evetech.Configuration;
//import net.evetech.auth.*;
//import net.evetech.esi.FleetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: evesso
OAuth evesso = (OAuth) defaultClient.getAuthentication("evesso");
evesso.setAccessToken("YOUR ACCESS TOKEN");

FleetsApi apiInstance = new FleetsApi();
Long fleetId = 789L; // Long | ID for a fleet
String datasource = "tranquility"; // String | The server name you would like data from
String token = "token_example"; // String | Access token to use if unable to set a header
try {
    PostFleetsFleetIdWingsCreated result = apiInstance.postFleetsFleetIdWings(fleetId, datasource, token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FleetsApi#postFleetsFleetIdWings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fleetId** | **Long**| ID for a fleet |
 **datasource** | **String**| The server name you would like data from | [optional] [default to tranquility] [enum: tranquility]
 **token** | **String**| Access token to use if unable to set a header | [optional]

### Return type

[**PostFleetsFleetIdWingsCreated**](PostFleetsFleetIdWingsCreated.md)

### Authorization

[evesso](../README.md#evesso)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postFleetsFleetIdWingsWingIdSquads"></a>
# **postFleetsFleetIdWingsWingIdSquads**
> PostFleetsFleetIdWingsWingIdSquadsCreated postFleetsFleetIdWingsWingIdSquads(fleetId, wingId, datasource, token)

Create fleet squad

Create a new squad in a fleet  --- 

### Example
```java
// Import classes:
//import net.evetech.ApiClient;
//import net.evetech.ApiException;
//import net.evetech.Configuration;
//import net.evetech.auth.*;
//import net.evetech.esi.FleetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: evesso
OAuth evesso = (OAuth) defaultClient.getAuthentication("evesso");
evesso.setAccessToken("YOUR ACCESS TOKEN");

FleetsApi apiInstance = new FleetsApi();
Long fleetId = 789L; // Long | ID for a fleet
Long wingId = 789L; // Long | The wing_id to create squad in
String datasource = "tranquility"; // String | The server name you would like data from
String token = "token_example"; // String | Access token to use if unable to set a header
try {
    PostFleetsFleetIdWingsWingIdSquadsCreated result = apiInstance.postFleetsFleetIdWingsWingIdSquads(fleetId, wingId, datasource, token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FleetsApi#postFleetsFleetIdWingsWingIdSquads");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fleetId** | **Long**| ID for a fleet |
 **wingId** | **Long**| The wing_id to create squad in |
 **datasource** | **String**| The server name you would like data from | [optional] [default to tranquility] [enum: tranquility]
 **token** | **String**| Access token to use if unable to set a header | [optional]

### Return type

[**PostFleetsFleetIdWingsWingIdSquadsCreated**](PostFleetsFleetIdWingsWingIdSquadsCreated.md)

### Authorization

[evesso](../README.md#evesso)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="putFleetsFleetId"></a>
# **putFleetsFleetId**
> putFleetsFleetId(fleetId, newSettings, datasource, token)

Update fleet

Update settings about a fleet  --- 

### Example
```java
// Import classes:
//import net.evetech.ApiClient;
//import net.evetech.ApiException;
//import net.evetech.Configuration;
//import net.evetech.auth.*;
//import net.evetech.esi.FleetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: evesso
OAuth evesso = (OAuth) defaultClient.getAuthentication("evesso");
evesso.setAccessToken("YOUR ACCESS TOKEN");

FleetsApi apiInstance = new FleetsApi();
Long fleetId = 789L; // Long | ID for a fleet
PutFleetsFleetIdNewSettings newSettings = new PutFleetsFleetIdNewSettings(); // PutFleetsFleetIdNewSettings | What to update for this fleet
String datasource = "tranquility"; // String | The server name you would like data from
String token = "token_example"; // String | Access token to use if unable to set a header
try {
    apiInstance.putFleetsFleetId(fleetId, newSettings, datasource, token);
} catch (ApiException e) {
    System.err.println("Exception when calling FleetsApi#putFleetsFleetId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fleetId** | **Long**| ID for a fleet |
 **newSettings** | [**PutFleetsFleetIdNewSettings**](PutFleetsFleetIdNewSettings.md)| What to update for this fleet |
 **datasource** | **String**| The server name you would like data from | [optional] [default to tranquility] [enum: tranquility]
 **token** | **String**| Access token to use if unable to set a header | [optional]

### Return type

null (empty response body)

### Authorization

[evesso](../README.md#evesso)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="putFleetsFleetIdMembersMemberId"></a>
# **putFleetsFleetIdMembersMemberId**
> putFleetsFleetIdMembersMemberId(fleetId, memberId, movement, datasource, token)

Move fleet member

Move a fleet member around  --- 

### Example
```java
// Import classes:
//import net.evetech.ApiClient;
//import net.evetech.ApiException;
//import net.evetech.Configuration;
//import net.evetech.auth.*;
//import net.evetech.esi.FleetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: evesso
OAuth evesso = (OAuth) defaultClient.getAuthentication("evesso");
evesso.setAccessToken("YOUR ACCESS TOKEN");

FleetsApi apiInstance = new FleetsApi();
Long fleetId = 789L; // Long | ID for a fleet
Integer memberId = 56; // Integer | The character ID of a member in this fleet
PutFleetsFleetIdMembersMemberIdMovement movement = new PutFleetsFleetIdMembersMemberIdMovement(); // PutFleetsFleetIdMembersMemberIdMovement | Details of the invitation
String datasource = "tranquility"; // String | The server name you would like data from
String token = "token_example"; // String | Access token to use if unable to set a header
try {
    apiInstance.putFleetsFleetIdMembersMemberId(fleetId, memberId, movement, datasource, token);
} catch (ApiException e) {
    System.err.println("Exception when calling FleetsApi#putFleetsFleetIdMembersMemberId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fleetId** | **Long**| ID for a fleet |
 **memberId** | **Integer**| The character ID of a member in this fleet |
 **movement** | [**PutFleetsFleetIdMembersMemberIdMovement**](PutFleetsFleetIdMembersMemberIdMovement.md)| Details of the invitation |
 **datasource** | **String**| The server name you would like data from | [optional] [default to tranquility] [enum: tranquility]
 **token** | **String**| Access token to use if unable to set a header | [optional]

### Return type

null (empty response body)

### Authorization

[evesso](../README.md#evesso)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="putFleetsFleetIdSquadsSquadId"></a>
# **putFleetsFleetIdSquadsSquadId**
> putFleetsFleetIdSquadsSquadId(fleetId, naming, squadId, datasource, token)

Rename fleet squad

Rename a fleet squad  --- 

### Example
```java
// Import classes:
//import net.evetech.ApiClient;
//import net.evetech.ApiException;
//import net.evetech.Configuration;
//import net.evetech.auth.*;
//import net.evetech.esi.FleetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: evesso
OAuth evesso = (OAuth) defaultClient.getAuthentication("evesso");
evesso.setAccessToken("YOUR ACCESS TOKEN");

FleetsApi apiInstance = new FleetsApi();
Long fleetId = 789L; // Long | ID for a fleet
PutFleetsFleetIdSquadsSquadIdNaming naming = new PutFleetsFleetIdSquadsSquadIdNaming(); // PutFleetsFleetIdSquadsSquadIdNaming | New name of the squad
Long squadId = 789L; // Long | The squad to rename
String datasource = "tranquility"; // String | The server name you would like data from
String token = "token_example"; // String | Access token to use if unable to set a header
try {
    apiInstance.putFleetsFleetIdSquadsSquadId(fleetId, naming, squadId, datasource, token);
} catch (ApiException e) {
    System.err.println("Exception when calling FleetsApi#putFleetsFleetIdSquadsSquadId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fleetId** | **Long**| ID for a fleet |
 **naming** | [**PutFleetsFleetIdSquadsSquadIdNaming**](PutFleetsFleetIdSquadsSquadIdNaming.md)| New name of the squad |
 **squadId** | **Long**| The squad to rename |
 **datasource** | **String**| The server name you would like data from | [optional] [default to tranquility] [enum: tranquility]
 **token** | **String**| Access token to use if unable to set a header | [optional]

### Return type

null (empty response body)

### Authorization

[evesso](../README.md#evesso)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="putFleetsFleetIdWingsWingId"></a>
# **putFleetsFleetIdWingsWingId**
> putFleetsFleetIdWingsWingId(fleetId, naming, wingId, datasource, token)

Rename fleet wing

Rename a fleet wing  --- 

### Example
```java
// Import classes:
//import net.evetech.ApiClient;
//import net.evetech.ApiException;
//import net.evetech.Configuration;
//import net.evetech.auth.*;
//import net.evetech.esi.FleetsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: evesso
OAuth evesso = (OAuth) defaultClient.getAuthentication("evesso");
evesso.setAccessToken("YOUR ACCESS TOKEN");

FleetsApi apiInstance = new FleetsApi();
Long fleetId = 789L; // Long | ID for a fleet
PutFleetsFleetIdWingsWingIdNaming naming = new PutFleetsFleetIdWingsWingIdNaming(); // PutFleetsFleetIdWingsWingIdNaming | New name of the wing
Long wingId = 789L; // Long | The wing to rename
String datasource = "tranquility"; // String | The server name you would like data from
String token = "token_example"; // String | Access token to use if unable to set a header
try {
    apiInstance.putFleetsFleetIdWingsWingId(fleetId, naming, wingId, datasource, token);
} catch (ApiException e) {
    System.err.println("Exception when calling FleetsApi#putFleetsFleetIdWingsWingId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fleetId** | **Long**| ID for a fleet |
 **naming** | [**PutFleetsFleetIdWingsWingIdNaming**](PutFleetsFleetIdWingsWingIdNaming.md)| New name of the wing |
 **wingId** | **Long**| The wing to rename |
 **datasource** | **String**| The server name you would like data from | [optional] [default to tranquility] [enum: tranquility]
 **token** | **String**| Access token to use if unable to set a header | [optional]

### Return type

null (empty response body)

### Authorization

[evesso](../README.md#evesso)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

