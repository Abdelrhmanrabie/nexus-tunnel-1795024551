package renz.javacodez.v2ray.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.reflect.TypeToken;
import defpackage.n70;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class JsonUtil {
    public static final JsonUtil INSTANCE = new JsonUtil();
    private static Gson gson = new Gson();

    private JsonUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonElement toJsonPretty$lambda$0(Double d, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(d != null ? Integer.valueOf((int) d.doubleValue()) : null);
    }

    public final <T> T fromJson(String str, Class<T> cls) {
        return (T) gson.fromJson(str, (Class) cls);
    }

    public final JsonObject parseString(String str) {
        if (str == null) {
            return null;
        }
        try {
            return JsonParser.parseString(str).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public final String toJsonPretty(Object obj) {
        if (obj == null) {
            return null;
        }
        return new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().registerTypeAdapter(new TypeToken<Double>() { // from class: renz.javacodez.v2ray.util.JsonUtil$toJsonPretty$gsonPre$1
        }.getType(), new n70(0)).create().toJson(obj);
    }
}
