/*
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 *
 * OpenAPI spec version: 1.10.1
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
import net.evetech.esi.models.GetCharactersCharacterIdFittings200Ok;
import net.evetech.esi.models.InternalServerError;
import net.evetech.esi.models.PostCharactersCharacterIdFittingsCreated;
import net.evetech.esi.models.PostCharactersCharacterIdFittingsFitting;
import net.evetech.esi.models.ServiceUnavailable;
import net.evetech.esi.models.Unauthorized;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FittingsApi {
    private ApiClient apiClient;

    public FittingsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public FittingsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for deleteCharactersCharacterIdFittingsFittingId
     * @param characterId An EVE character ID (required)
     * @param fittingId ID for a fitting of this character (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param token Access token to use if unable to set a header (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteCharactersCharacterIdFittingsFittingIdCall(Integer characterId, Integer fittingId, String datasource, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/characters/{character_id}/fittings/{fitting_id}/"
            .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()))
            .replaceAll("\\{" + "fitting_id" + "\\}", apiClient.escapeString(fittingId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (datasource != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("datasource", datasource));
        if (token != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("token", token));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

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
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteCharactersCharacterIdFittingsFittingIdValidateBeforeCall(Integer characterId, Integer fittingId, String datasource, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException("Missing the required parameter 'characterId' when calling deleteCharactersCharacterIdFittingsFittingId(Async)");
        }
        
        // verify the required parameter 'fittingId' is set
        if (fittingId == null) {
            throw new ApiException("Missing the required parameter 'fittingId' when calling deleteCharactersCharacterIdFittingsFittingId(Async)");
        }
        

        com.squareup.okhttp.Call call = deleteCharactersCharacterIdFittingsFittingIdCall(characterId, fittingId, datasource, token, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete fitting
     * Delete a fitting from a character  --- 
     * @param characterId An EVE character ID (required)
     * @param fittingId ID for a fitting of this character (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param token Access token to use if unable to set a header (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteCharactersCharacterIdFittingsFittingId(Integer characterId, Integer fittingId, String datasource, String token) throws ApiException {
        deleteCharactersCharacterIdFittingsFittingIdWithHttpInfo(characterId, fittingId, datasource, token);
    }

    /**
     * Delete fitting
     * Delete a fitting from a character  --- 
     * @param characterId An EVE character ID (required)
     * @param fittingId ID for a fitting of this character (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param token Access token to use if unable to set a header (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteCharactersCharacterIdFittingsFittingIdWithHttpInfo(Integer characterId, Integer fittingId, String datasource, String token) throws ApiException {
        com.squareup.okhttp.Call call = deleteCharactersCharacterIdFittingsFittingIdValidateBeforeCall(characterId, fittingId, datasource, token, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete fitting (asynchronously)
     * Delete a fitting from a character  --- 
     * @param characterId An EVE character ID (required)
     * @param fittingId ID for a fitting of this character (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param token Access token to use if unable to set a header (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteCharactersCharacterIdFittingsFittingIdAsync(Integer characterId, Integer fittingId, String datasource, String token, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteCharactersCharacterIdFittingsFittingIdValidateBeforeCall(characterId, fittingId, datasource, token, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for getCharactersCharacterIdFittings
     * @param characterId An EVE character ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param token Access token to use if unable to set a header (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCharactersCharacterIdFittingsCall(Integer characterId, String datasource, String ifNoneMatch, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v2/characters/{character_id}/fittings/"
            .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (datasource != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("datasource", datasource));
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
    private com.squareup.okhttp.Call getCharactersCharacterIdFittingsValidateBeforeCall(Integer characterId, String datasource, String ifNoneMatch, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException("Missing the required parameter 'characterId' when calling getCharactersCharacterIdFittings(Async)");
        }
        

        com.squareup.okhttp.Call call = getCharactersCharacterIdFittingsCall(characterId, datasource, ifNoneMatch, token, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get fittings
     * Return fittings of a character  ---  This route is cached for up to 300 seconds
     * @param characterId An EVE character ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param token Access token to use if unable to set a header (optional)
     * @return List&lt;GetCharactersCharacterIdFittings200Ok&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<GetCharactersCharacterIdFittings200Ok> getCharactersCharacterIdFittings(Integer characterId, String datasource, String ifNoneMatch, String token) throws ApiException {
        ApiResponse<List<GetCharactersCharacterIdFittings200Ok>> resp = getCharactersCharacterIdFittingsWithHttpInfo(characterId, datasource, ifNoneMatch, token);
        return resp.getData();
    }

    /**
     * Get fittings
     * Return fittings of a character  ---  This route is cached for up to 300 seconds
     * @param characterId An EVE character ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param token Access token to use if unable to set a header (optional)
     * @return ApiResponse&lt;List&lt;GetCharactersCharacterIdFittings200Ok&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<GetCharactersCharacterIdFittings200Ok>> getCharactersCharacterIdFittingsWithHttpInfo(Integer characterId, String datasource, String ifNoneMatch, String token) throws ApiException {
        com.squareup.okhttp.Call call = getCharactersCharacterIdFittingsValidateBeforeCall(characterId, datasource, ifNoneMatch, token, null, null);
        Type localVarReturnType = new TypeToken<List<GetCharactersCharacterIdFittings200Ok>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get fittings (asynchronously)
     * Return fittings of a character  ---  This route is cached for up to 300 seconds
     * @param characterId An EVE character ID (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param token Access token to use if unable to set a header (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCharactersCharacterIdFittingsAsync(Integer characterId, String datasource, String ifNoneMatch, String token, final ApiCallback<List<GetCharactersCharacterIdFittings200Ok>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getCharactersCharacterIdFittingsValidateBeforeCall(characterId, datasource, ifNoneMatch, token, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<GetCharactersCharacterIdFittings200Ok>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCharactersCharacterIdFittings
     * @param characterId An EVE character ID (required)
     * @param fitting Details about the new fitting (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param token Access token to use if unable to set a header (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCharactersCharacterIdFittingsCall(Integer characterId, PostCharactersCharacterIdFittingsFitting fitting, String datasource, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = fitting;

        // create path and map variables
        String localVarPath = "/v2/characters/{character_id}/fittings/"
            .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (datasource != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("datasource", datasource));
        if (token != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("token", token));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postCharactersCharacterIdFittingsValidateBeforeCall(Integer characterId, PostCharactersCharacterIdFittingsFitting fitting, String datasource, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException("Missing the required parameter 'characterId' when calling postCharactersCharacterIdFittings(Async)");
        }
        
        // verify the required parameter 'fitting' is set
        if (fitting == null) {
            throw new ApiException("Missing the required parameter 'fitting' when calling postCharactersCharacterIdFittings(Async)");
        }
        

        com.squareup.okhttp.Call call = postCharactersCharacterIdFittingsCall(characterId, fitting, datasource, token, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Create fitting
     * Save a new fitting for a character  --- 
     * @param characterId An EVE character ID (required)
     * @param fitting Details about the new fitting (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param token Access token to use if unable to set a header (optional)
     * @return PostCharactersCharacterIdFittingsCreated
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PostCharactersCharacterIdFittingsCreated postCharactersCharacterIdFittings(Integer characterId, PostCharactersCharacterIdFittingsFitting fitting, String datasource, String token) throws ApiException {
        ApiResponse<PostCharactersCharacterIdFittingsCreated> resp = postCharactersCharacterIdFittingsWithHttpInfo(characterId, fitting, datasource, token);
        return resp.getData();
    }

    /**
     * Create fitting
     * Save a new fitting for a character  --- 
     * @param characterId An EVE character ID (required)
     * @param fitting Details about the new fitting (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param token Access token to use if unable to set a header (optional)
     * @return ApiResponse&lt;PostCharactersCharacterIdFittingsCreated&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PostCharactersCharacterIdFittingsCreated> postCharactersCharacterIdFittingsWithHttpInfo(Integer characterId, PostCharactersCharacterIdFittingsFitting fitting, String datasource, String token) throws ApiException {
        com.squareup.okhttp.Call call = postCharactersCharacterIdFittingsValidateBeforeCall(characterId, fitting, datasource, token, null, null);
        Type localVarReturnType = new TypeToken<PostCharactersCharacterIdFittingsCreated>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create fitting (asynchronously)
     * Save a new fitting for a character  --- 
     * @param characterId An EVE character ID (required)
     * @param fitting Details about the new fitting (required)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param token Access token to use if unable to set a header (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCharactersCharacterIdFittingsAsync(Integer characterId, PostCharactersCharacterIdFittingsFitting fitting, String datasource, String token, final ApiCallback<PostCharactersCharacterIdFittingsCreated> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = postCharactersCharacterIdFittingsValidateBeforeCall(characterId, fitting, datasource, token, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PostCharactersCharacterIdFittingsCreated>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
