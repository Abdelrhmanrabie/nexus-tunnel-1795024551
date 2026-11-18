package renz.javacodez.v2ray.plugin;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class PluginContract {
    public static final String ACTION_NATIVE_PLUGIN = "io.nekohasekai.sagernet.plugin.ACTION_NATIVE_PLUGIN";
    public static final String COLUMN_MODE = "mode";
    public static final String COLUMN_PATH = "path";
    public static final String EXTRA_ENTRY = "io.nekohasekai.sagernet.plugin.EXTRA_ENTRY";
    public static final PluginContract INSTANCE = new PluginContract();
    public static final String METADATA_KEY_EXECUTABLE_PATH = "io.nekohasekai.sagernet.plugin.executable_path";
    public static final String METADATA_KEY_ID = "io.nekohasekai.sagernet.plugin.id";
    public static final String METHOD_GET_EXECUTABLE = "sagernet:getExecutable";
    public static final String SCHEME = "plugin";

    private PluginContract() {
    }
}
