package com.example.kessseller;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

import static android.content.ContentValues.TAG;

public class InterceptorClass implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
//        Request.Builder builder = original.newBuilder();
//        Request request = builder.build();
        int d = Log.d(TAG, "url: " + original.url());
        Log.d(TAG, "method: " + original.method());
        Log.d(TAG, "body: " + bodyToString(original.body()));
//        String responseBody = bindFakeData(original, chain);;
        Response response = new Response.Builder()
                .code(500)
                .message("Mock API")
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
//                .body(ResponseBody.create(MediaType.parse("application/json"), responseBody.getBytes()))
                .build();
        return response;
    }
    private String bodyToString(final RequestBody request) {
        try {
            final Buffer buffer = new Buffer();
            if (request != null)
                request.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }
//    private String bindFakeData(Request request, Chain chain) {
//        String responseBody = "";
//        if(request.method().equals("POST")){
//            return "{\n" +
//                    "  \"type\"😕"object\",\n" +
//                    "  \"properties\": {\n" +
//                    "    \"foo\": {\n" +
//                    "      \"type\": \"string\"\n" +
//                    "    },\n" +
//                    "    \"bar\": {\n" +
//                    "      \"type\": \"integer\"\n" +
//                    "    },\n" +
//                    "    \"baz\": {\n" +
//                    "      \"type\": \"boolean\"\n" +
//                    "    }\n" +
//                    "  }\n" +
//                    "}";
//        return responseBody;
}
