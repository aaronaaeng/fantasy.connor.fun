package fun.connor.fantasy.Endpoints;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Created by Aaron on 11/14/2018.
 */
public class JsonUtils {
    public static String toJson(Object object)
    {
        return new Gson().toJson(object);
    }

    public static ResponseTransformer json()
    {
        return JsonUtils::toJson;
    }
}
