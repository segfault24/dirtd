# InsuranceApi

All URIs are relative to *https://esi.evetech.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getInsurancePrices**](InsuranceApi.md#getInsurancePrices) | **GET** /v1/insurance/prices/ | List insurance levels


<a name="getInsurancePrices"></a>
# **getInsurancePrices**
> List&lt;GetInsurancePrices200Ok&gt; getInsurancePrices(acceptLanguage, datasource, ifNoneMatch, language)

List insurance levels

Return available insurance levels for all ship types  ---  This route is cached for up to 3600 seconds

### Example
```java
// Import classes:
//import net.evetech.ApiException;
//import net.evetech.esi.InsuranceApi;


InsuranceApi apiInstance = new InsuranceApi();
String acceptLanguage = "en"; // String | Language to use in the response
String datasource = "tranquility"; // String | The server name you would like data from
String ifNoneMatch = "ifNoneMatch_example"; // String | ETag from a previous request. A 304 will be returned if this matches the current ETag
String language = "en"; // String | Language to use in the response, takes precedence over Accept-Language
try {
    List<GetInsurancePrices200Ok> result = apiInstance.getInsurancePrices(acceptLanguage, datasource, ifNoneMatch, language);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InsuranceApi#getInsurancePrices");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **acceptLanguage** | **String**| Language to use in the response | [optional] [default to en] [enum: en, en-us, de, fr, ja, ru, zh, ko, es]
 **datasource** | **String**| The server name you would like data from | [optional] [default to tranquility] [enum: tranquility]
 **ifNoneMatch** | **String**| ETag from a previous request. A 304 will be returned if this matches the current ETag | [optional]
 **language** | **String**| Language to use in the response, takes precedence over Accept-Language | [optional] [default to en] [enum: en, en-us, de, fr, ja, ru, zh, ko, es]

### Return type

[**List&lt;GetInsurancePrices200Ok&gt;**](GetInsurancePrices200Ok.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

