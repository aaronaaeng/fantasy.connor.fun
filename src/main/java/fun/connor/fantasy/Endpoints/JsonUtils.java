package fun.connor.fantasy.Endpoints;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * This method provides JSON conversions for the endpoints.
 */

// This implementation was taken from https://dzone.com/articles/building-simple-restful-api
class JsonUtils {
    /**
     * Returns the json encoding of the object
     * @param object The object to be encoded
     * @return The JSON string of the object
     */
    static String toJson(Object object)
    {
        return new Gson().toJson(object);
    }

    /**
     * This returns a function pointer to the {@link JsonUtils#toJson(Object)} method
     * @return A function pointer to {@link JsonUtils#toJson(Object)}
     */
    static ResponseTransformer json()
    {
        return JsonUtils::toJson;
    }
}
