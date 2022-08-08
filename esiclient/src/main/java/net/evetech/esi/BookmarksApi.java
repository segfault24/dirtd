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

import net.evetech.ApiCallback;
import net.evetech.ApiClient;
import net.evetech.ApiException;
import net.evetech.ApiResponse;
import net.evetech.Configuration;
import net.evetech.Pair;
import net.evetech.ProgressRequestBody;
import net.evetech.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import net.evetech.esi.models.BadRequest;
import net.evetech.esi.models.ErrorLimited;
import net.evetech.esi.models.Forbidden;
import net.evetech.esi.models.GatewayTimeout;
import net.evetech.esi.models.GetCharactersCharacterIdBookmarks200Ok;
import net.evetech.esi.models.GetCharactersCharacterIdBookmarksFolders200Ok;
import net.evetech.esi.models.GetCorporationsCorporationIdBookmarks200Ok;
import net.evetech.esi.models.GetCorporationsCorporationIdBookmarksFolders200Ok;
import net.evetech.esi.models.InternalServerError;
import net.evetech.esi.models.ServiceUnavailable;
import net.evetech.esi.models.Unauthorized;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookmarksApi {
    private ApiClient apiClient;

    public BookmarksApi() {
        this(Configuration.getDefaultApiClient());
    }

    public BookmarksApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getCharactersCharacterIdBookmarks
     * @param characterId An EVE character ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param page Which page of results to return (optional, default to 1)
     * @param token Access token to use if unable to set a header (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCharactersCharacterIdBookmarksCall(Integer characterId, String datasource, String ifNoneMatch, Integer page, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v2/characters/{character_id}/bookmarks/"
            .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (datasource != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("datasource", datasource));
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
        if (token != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("token", token));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (ifNoneMatch != null)
        localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "evesso" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCharactersCharacterIdBookmarksValidateBeforeCall(Integer characterId, String datasource, String ifNoneMatch, Integer page, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException("Missing the required parameter 'characterId' when calling getCharactersCharacterIdBookmarks(Async)");
        }
        

        com.squareup.okhttp.Call call = getCharactersCharacterIdBookmarksCall(characterId, datasource, ifNoneMatch, page, token, progressListener, progressRequestListener);
        return call;

    }

    /**
     * List bookmarks
     * A list of your character&#39;s personal bookmarks  ---  This route is cached for up to 3600 seconds
     * @param characterId An EVE character ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param page Which page of results to return (optional, default to 1)
     * @param token Access token to use if unable to set a header (optional)
     * @return List&lt;GetCharactersCharacterIdBookmarks200Ok&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<GetCharactersCharacterIdBookmarks200Ok> getCharactersCharacterIdBookmarks(Integer characterId, String datasource, String ifNoneMatch, Integer page, String token) throws ApiException {
        ApiResponse<List<GetCharactersCharacterIdBookmarks200Ok>> resp = getCharactersCharacterIdBookmarksWithHttpInfo(characterId, datasource, ifNoneMatch, page, token);
        return resp.getData();
    }

    /**
     * List bookmarks
     * A list of your character&#39;s personal bookmarks  ---  This route is cached for up to 3600 seconds
     * @param characterId An EVE character ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param page Which page of results to return (optional, default to 1)
     * @param token Access token to use if unable to set a header (optional)
     * @return ApiResponse&lt;List&lt;GetCharactersCharacterIdBookmarks200Ok&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<GetCharactersCharacterIdBookmarks200Ok>> getCharactersCharacterIdBookmarksWithHttpInfo(Integer characterId, String datasource, String ifNoneMatch, Integer page, String token) throws ApiException {
        com.squareup.okhttp.Call call = getCharactersCharacterIdBookmarksValidateBeforeCall(characterId, datasource, ifNoneMatch, page, token, null, null);
        Type localVarReturnType = new TypeToken<List<GetCharactersCharacterIdBookmarks200Ok>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List bookmarks (asynchronously)
     * A list of your character&#39;s personal bookmarks  ---  This route is cached for up to 3600 seconds
     * @param characterId An EVE character ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param page Which page of results to return (optional, default to 1)
     * @param token Access token to use if unable to set a header (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCharactersCharacterIdBookmarksAsync(Integer characterId, String datasource, String ifNoneMatch, Integer page, String token, final ApiCallback<List<GetCharactersCharacterIdBookmarks200Ok>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getCharactersCharacterIdBookmarksValidateBeforeCall(characterId, datasource, ifNoneMatch, page, token, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<GetCharactersCharacterIdBookmarks200Ok>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getCharactersCharacterIdBookmarksFolders
     * @param characterId An EVE character ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param page Which page of results to return (optional, default to 1)
     * @param token Access token to use if unable to set a header (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCharactersCharacterIdBookmarksFoldersCall(Integer characterId, String datasource, String ifNoneMatch, Integer page, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v2/characters/{character_id}/bookmarks/folders/"
            .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (datasource != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("datasource", datasource));
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
        if (token != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("token", token));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (ifNoneMatch != null)
        localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "evesso" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCharactersCharacterIdBookmarksFoldersValidateBeforeCall(Integer characterId, String datasource, String ifNoneMatch, Integer page, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException("Missing the required parameter 'characterId' when calling getCharactersCharacterIdBookmarksFolders(Async)");
        }
        

        com.squareup.okhttp.Call call = getCharactersCharacterIdBookmarksFoldersCall(characterId, datasource, ifNoneMatch, page, token, progressListener, progressRequestListener);
        return call;

    }

    /**
     * List bookmark folders
     * A list of your character&#39;s personal bookmark folders  ---  This route is cached for up to 3600 seconds
     * @param characterId An EVE character ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param page Which page of results to return (optional, default to 1)
     * @param token Access token to use if unable to set a header (optional)
     * @return List&lt;GetCharactersCharacterIdBookmarksFolders200Ok&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<GetCharactersCharacterIdBookmarksFolders200Ok> getCharactersCharacterIdBookmarksFolders(Integer characterId, String datasource, String ifNoneMatch, Integer page, String token) throws ApiException {
        ApiResponse<List<GetCharactersCharacterIdBookmarksFolders200Ok>> resp = getCharactersCharacterIdBookmarksFoldersWithHttpInfo(characterId, datasource, ifNoneMatch, page, token);
        return resp.getData();
    }

    /**
     * List bookmark folders
     * A list of your character&#39;s personal bookmark folders  ---  This route is cached for up to 3600 seconds
     * @param characterId An EVE character ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param page Which page of results to return (optional, default to 1)
     * @param token Access token to use if unable to set a header (optional)
     * @return ApiResponse&lt;List&lt;GetCharactersCharacterIdBookmarksFolders200Ok&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<GetCharactersCharacterIdBookmarksFolders200Ok>> getCharactersCharacterIdBookmarksFoldersWithHttpInfo(Integer characterId, String datasource, String ifNoneMatch, Integer page, String token) throws ApiException {
        com.squareup.okhttp.Call call = getCharactersCharacterIdBookmarksFoldersValidateBeforeCall(characterId, datasource, ifNoneMatch, page, token, null, null);
        Type localVarReturnType = new TypeToken<List<GetCharactersCharacterIdBookmarksFolders200Ok>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List bookmark folders (asynchronously)
     * A list of your character&#39;s personal bookmark folders  ---  This route is cached for up to 3600 seconds
     * @param characterId An EVE character ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param page Which page of results to return (optional, default to 1)
     * @param token Access token to use if unable to set a header (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCharactersCharacterIdBookmarksFoldersAsync(Integer characterId, String datasource, String ifNoneMatch, Integer page, String token, final ApiCallback<List<GetCharactersCharacterIdBookmarksFolders200Ok>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getCharactersCharacterIdBookmarksFoldersValidateBeforeCall(characterId, datasource, ifNoneMatch, page, token, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<GetCharactersCharacterIdBookmarksFolders200Ok>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getCorporationsCorporationIdBookmarks
     * @param corporationId An EVE corporation ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param page Which page of results to return (optional, default to 1)
     * @param token Access token to use if unable to set a header (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCorporationsCorporationIdBookmarksCall(Integer corporationId, String datasource, String ifNoneMatch, Integer page, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/bookmarks/"
            .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (datasource != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("datasource", datasource));
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
        if (token != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("token", token));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (ifNoneMatch != null)
        localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "evesso" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCorporationsCorporationIdBookmarksValidateBeforeCall(Integer corporationId, String datasource, String ifNoneMatch, Integer page, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException("Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdBookmarks(Async)");
        }
        

        com.squareup.okhttp.Call call = getCorporationsCorporationIdBookmarksCall(corporationId, datasource, ifNoneMatch, page, token, progressListener, progressRequestListener);
        return call;

    }

    /**
     * List corporation bookmarks
     * A list of your corporation&#39;s bookmarks  ---  This route is cached for up to 3600 seconds
     * @param corporationId An EVE corporation ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param page Which page of results to return (optional, default to 1)
     * @param token Access token to use if unable to set a header (optional)
     * @return List&lt;GetCorporationsCorporationIdBookmarks200Ok&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<GetCorporationsCorporationIdBookmarks200Ok> getCorporationsCorporationIdBookmarks(Integer corporationId, String datasource, String ifNoneMatch, Integer page, String token) throws ApiException {
        ApiResponse<List<GetCorporationsCorporationIdBookmarks200Ok>> resp = getCorporationsCorporationIdBookmarksWithHttpInfo(corporationId, datasource, ifNoneMatch, page, token);
        return resp.getData();
    }

    /**
     * List corporation bookmarks
     * A list of your corporation&#39;s bookmarks  ---  This route is cached for up to 3600 seconds
     * @param corporationId An EVE corporation ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param page Which page of results to return (optional, default to 1)
     * @param token Access token to use if unable to set a header (optional)
     * @return ApiResponse&lt;List&lt;GetCorporationsCorporationIdBookmarks200Ok&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<GetCorporationsCorporationIdBookmarks200Ok>> getCorporationsCorporationIdBookmarksWithHttpInfo(Integer corporationId, String datasource, String ifNoneMatch, Integer page, String token) throws ApiException {
        com.squareup.okhttp.Call call = getCorporationsCorporationIdBookmarksValidateBeforeCall(corporationId, datasource, ifNoneMatch, page, token, null, null);
        Type localVarReturnType = new TypeToken<List<GetCorporationsCorporationIdBookmarks200Ok>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List corporation bookmarks (asynchronously)
     * A list of your corporation&#39;s bookmarks  ---  This route is cached for up to 3600 seconds
     * @param corporationId An EVE corporation ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param page Which page of results to return (optional, default to 1)
     * @param token Access token to use if unable to set a header (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCorporationsCorporationIdBookmarksAsync(Integer corporationId, String datasource, String ifNoneMatch, Integer page, String token, final ApiCallback<List<GetCorporationsCorporationIdBookmarks200Ok>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getCorporationsCorporationIdBookmarksValidateBeforeCall(corporationId, datasource, ifNoneMatch, page, token, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<GetCorporationsCorporationIdBookmarks200Ok>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getCorporationsCorporationIdBookmarksFolders
     * @param corporationId An EVE corporation ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param page Which page of results to return (optional, default to 1)
     * @param token Access token to use if unable to set a header (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCorporationsCorporationIdBookmarksFoldersCall(Integer corporationId, String datasource, String ifNoneMatch, Integer page, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/corporations/{corporation_id}/bookmarks/folders/"
            .replaceAll("\\{" + "corporation_id" + "\\}", apiClient.escapeString(corporationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (datasource != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("datasource", datasource));
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
        if (token != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("token", token));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (ifNoneMatch != null)
        localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "evesso" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCorporationsCorporationIdBookmarksFoldersValidateBeforeCall(Integer corporationId, String datasource, String ifNoneMatch, Integer page, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'corporationId' is set
        if (corporationId == null) {
            throw new ApiException("Missing the required parameter 'corporationId' when calling getCorporationsCorporationIdBookmarksFolders(Async)");
        }
        

        com.squareup.okhttp.Call call = getCorporationsCorporationIdBookmarksFoldersCall(corporationId, datasource, ifNoneMatch, page, token, progressListener, progressRequestListener);
        return call;

    }

    /**
     * List corporation bookmark folders
     * A list of your corporation&#39;s bookmark folders  ---  This route is cached for up to 3600 seconds
     * @param corporationId An EVE corporation ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param page Which page of results to return (optional, default to 1)
     * @param token Access token to use if unable to set a header (optional)
     * @return List&lt;GetCorporationsCorporationIdBookmarksFolders200Ok&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<GetCorporationsCorporationIdBookmarksFolders200Ok> getCorporationsCorporationIdBookmarksFolders(Integer corporationId, String datasource, String ifNoneMatch, Integer page, String token) throws ApiException {
        ApiResponse<List<GetCorporationsCorporationIdBookmarksFolders200Ok>> resp = getCorporationsCorporationIdBookmarksFoldersWithHttpInfo(corporationId, datasource, ifNoneMatch, page, token);
        return resp.getData();
    }

    /**
     * List corporation bookmark folders
     * A list of your corporation&#39;s bookmark folders  ---  This route is cached for up to 3600 seconds
     * @param corporationId An EVE corporation ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param page Which page of results to return (optional, default to 1)
     * @param token Access token to use if unable to set a header (optional)
     * @return ApiResponse&lt;List&lt;GetCorporationsCorporationIdBookmarksFolders200Ok&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<GetCorporationsCorporationIdBookmarksFolders200Ok>> getCorporationsCorporationIdBookmarksFoldersWithHttpInfo(Integer corporationId, String datasource, String ifNoneMatch, Integer page, String token) throws ApiException {
        com.squareup.okhttp.Call call = getCorporationsCorporationIdBookmarksFoldersValidateBeforeCall(corporationId, datasource, ifNoneMatch, page, token, null, null);
        Type localVarReturnType = new TypeToken<List<GetCorporationsCorporationIdBookmarksFolders200Ok>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List corporation bookmark folders (asynchronously)
     * A list of your corporation&#39;s bookmark folders  ---  This route is cached for up to 3600 seconds
     * @param corporationId An EVE corporation ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param page Which page of results to return (optional, default to 1)
     * @param token Access token to use if unable to set a header (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCorporationsCorporationIdBookmarksFoldersAsync(Integer corporationId, String datasource, String ifNoneMatch, Integer page, String token, final ApiCallback<List<GetCorporationsCorporationIdBookmarksFolders200Ok>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getCorporationsCorporationIdBookmarksFoldersValidateBeforeCall(corporationId, datasource, ifNoneMatch, page, token, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<GetCorporationsCorporationIdBookmarksFolders200Ok>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
