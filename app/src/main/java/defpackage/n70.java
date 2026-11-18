package defpackage;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import renz.javacodez.v2ray.dto.V2rayConfig;
import renz.javacodez.v2ray.util.JsonUtil;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n70 implements JsonSerializer {
    public final /* synthetic */ int G0;

    public /* synthetic */ n70(int i) {
        this.G0 = i;
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonSerializationContext) {
        Double d = (Double) obj;
        return this.G0 != 0 ? V2rayConfig.toPrettyPrinting$lambda$2(d, type, jsonSerializationContext) : JsonUtil.toJsonPretty$lambda$0(d, type, jsonSerializationContext);
    }
}
