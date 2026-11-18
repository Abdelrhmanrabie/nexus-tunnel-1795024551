package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Handler;
import android.os.SystemClock;
import android.text.InputFilter;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.view.menu.f;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.b;
import androidx.emoji2.text.c;
import com.android.volley.Cache$Entry;
import com.android.volley.ClientError;
import com.android.volley.NoConnectionError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet$Rounding;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import com.google.crypto.tink.subtle.Hex;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.common.BitMatrix;
import com.jcraft.jzlib.GZIPHeader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import net.lingala.zip4j.util.InternalZipConstants;
import org.xmlpull.v1.XmlPullParserException;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class g implements a4, IHighlighter, y1.a, xb0$c, jj0, ld, wc {
    public final /* synthetic */ int G0;
    public Object a;
    public Object b;
    public static final int[] P_orig = {608135816, -2052912941, 320440878, 57701188, -1542899678, 698298832, 137296536, -330404727, 1160258022, 953160567, -1101764913, 887688300, -1062458953, -914599715, 1065670069, -1253635817, -1843997223, -1988494565};
    public static final int[] S_orig = {-785314906, -1730169428, 805139163, -803545161, -1193168915, 1780907670, -1166241723, -248741991, 614570311, -1282315017, 134345442, -2054226922, 1667834072, 1901547113, -1537671517, -191677058, 227898511, 1921955416, 1904987480, -2112533778, 2069144605, -1034266187, -1674521287, 720527379, -976113629, 677414384, -901678824, -1193592593, -1904616272, 1614419982, 1822297739, -1340175810, -686458943, -1120842969, 2024746970, 1432378464, -430627341, -1437226092, 1464375394, 1676153920, 1439316330, 715854006, -1261675468, 289532110, -1588296017, 2087905683, -1276242927, 1668267050, 732546397, 1947742710, -832815594, -1685613794, -1344882125, 1814351708, 2050118529, 680887927, 999245976, 1800124847, -994056165, 1713906067, 1641548236, -81679983, 1216130144, 1575780402, -276538019, -377129551, -601480446, -345695352, 596196993, -745100091, 258830323, -2081144263, 772490370, -1534844924, 1774776394, -1642095778, 566650946, -152474470, 1728879713, -1412200208, 1783734482, -665571480, -1777359064, -1420741725, 1861159788, 326777828, -1170476976, 2130389656, -1578015459, 967770486, 1724537150, -2109534584, -1930525159, 1164943284, 2105845187, 998989502, -529566248, -2050940813, 1075463327, 1455516326, 1322494562, 910128902, 469688178, 1117454909, 936433444, -804646328, -619713837, 1240580251, 122909385, -2137449605, 634681816, -152510729, -469872614, -1233564613, -1754472259, 79693498, -1045868618, 1084186820, 1583128258, 426386531, 1761308591, 1047286709, 322548459, 995290223, 1845252383, -1691314900, -863943356, -1352745719, -1092366332, -567063811, 1712269319, 422464435, -1060394921, 1170764815, -771006663, -1177289765, 1434042557, 442511882, -694091578, 1076654713, 1738483198, -81812532, -1901729288, -617471240, 1014306527, -43947243, 793779912, -1392160085, 842905082, -48003232, 1395751752, 1040244610, -1638115397, -898659168, 445077038, -552113701, -717051658, 679411651, -1402522938, -1940957837, 1767581616, -1144366904, -503340195, -1192226400, 284835224, -48135240, 1258075500, 768725851, -1705778055, -1225243291, -762426948, 1274779536, -505548070, -1530167757, 1660621633, -823867672, -283063590, 913787905, -797008130, 737222580, -1780753843, -1366257256, -357724559, 1804850592, -795946544, -1345903136, -1908647121, -1904896841, -1879645445, -233690268, -2004305902, -1878134756, 1336762016, 1754252060, -774901359, -1280786003, 791618072, -1106372745, -361419266, -1962795103, -442446833, -1250986776, 413987798, -829824359, -1264037920, -49028937, 2093235073, -760370983, 375366246, -2137688315, -1815317740, 555357303, -424861595, 2008414854, -950779147, -73583153, -338841844, 2067696032, -700376109, -1373733303, 2428461, 544322398, 577241275, 1471733935, 610547355, -267798242, 1432588573, 1507829418, 2025931657, -648391809, 545086370, 48609733, -2094660746, 1653985193, 298326376, 1316178497, -1287180854, 2064951626, 458293330, -1705826027, -703637697, -1130641692, 727753846, -2115603456, 146436021, 1461446943, -224990101, 705550613, -1235000031, -407242314, -13368018, -981117340, 1404054877, -1449160799, 146425753, 1854211946, 1266315497, -1246549692, -613086930, -1004984797, -1385257296, 1235738493, -1662099272, -1880247706, -324367247, 1771706367, 1449415276, -1028546847, 422970021, 1963543593, -1604775104, -468174274, 1062508698, 1531092325, 1804592342, -1711849514, -1580033017, -269995787, 1294809318, -265986623, 1289560198, -2072974554, 1669523910, 35572830, 157838143, 1052438473, 1016535060, 1802137761, 1753167236, 1386275462, -1214491899, -1437595849, 1040679964, 2145300060, -1904392980, 1461121720, -1338320329, -263189491, -266592508, 33600511, -1374882534, 1018524850, 629373528, -603381315, -779021319, 2091462646, -1808644237, 586499841, 988145025, 935516892, -927631820, -1695294041, -1455136442, 265290510, -322386114, -1535828415, -499593831, 1005194799, 847297441, 406762289, 1314163512, 1332590856, 1866599683, -167115585, 750260880, 613907577, 1450815602, -1129346641, -560302305, -644675568, -1282691566, -590397650, 1427272223, 778793252, 1343938022, -1618686585, 2052605720, 1946737175, -1130390852, -380928628, -327488454, -612033030, 1661551462, -1000029230, -283371449, 840292616, -582796489, 616741398, 312560963, 711312465, 1351876610, 322626781, 1910503582, 271666773, -2119403562, 1594956187, 70604529, -677132437, 1007753275, 1495573769, -225450259, -1745748998, -1631928532, 504708206, -2031925904, -353800271, -2045878774, 1514023603, 1998579484, 1312622330, 694541497, -1712906993, -2143385130, 1382467621, 776784248, -1676627094, -971698502, -1797068168, -1510196141, 503983604, -218673497, 907881277, 423175695, 432175456, 1378068232, -149744970, -340918674, -356311194, -474200683, -1501837181, -1317062703, 26017576, -1020076561, -1100195163, 1700274565, 1756076034, -288447217, -617638597, 720338349, 1533947780, 354530856, 688349552, -321042571, 1637815568, 332179504, -345916010, 53804574, -1442618417, -1250730864, 1282449977, -711025141, -877994476, -288586052, 1617046695, -1666491221, -1292663698, 1686838959, 431878346, -1608291911, 1700445008, 1080580658, 1009431731, 832498133, -1071531785, -1688990951, -2023776103, -1778935426, 1648197032, -130578278, -1746719369, 300782431, 375919233, 238389289, -941219882, -1763778655, 2019080857, 1475708069, 455242339, -1685863425, 448939670, -843904277, 1395535956, -1881585436, 1841049896, 1491858159, 885456874, -30872223, -293847949, 1565136089, -396052509, 1108368660, 540939232, 1173283510, -1549095958, -613658859, -87339056, -951913406, -278217803, 1699691293, 1103962373, -669091426, -2038084153, -464828566, 1031889488, -815619598, 1535977030, -58162272, -1043876189, 2132092099, 1774941330, 1199868427, 1452454533, 157007616, -1390851939, 342012276, 595725824, 1480756522, 206960106, 497939518, 591360097, 863170706, -1919713727, -698356495, 1814182875, 2094937945, -873565088, 1082520231, -831049106, -1509457788, 435703966, -386934699, 1641649973, -1452693590, -989067582, 1510255612, -2146710820, -1639679442, -1018874748, -36346107, 236887753, -613164077, 274041037, 1734335097, -479771840, -976997275, 1899903192, 1026095262, -244449504, 356393447, -1884275382, -421290197, -612127241, -381855128, -1803468553, -162781668, -1805047500, 1091903735, 1979897079, -1124832466, -727580568, -737663887, 857797738, 1136121015, 1342202287, 507115054, -1759230650, 337727348, -1081374656, 1301675037, -1766485585, 1895095763, 1721773893, -1078195732, 62756741, 2142006736, 835421444, -1762973773, 1442658625, -635090970, -1412822374, 676362277, 1392781812, 170690266, -373920261, 1759253602, -683120384, 1745797284, 664899054, 1329594018, -393761396, -1249058810, 2062866102, -1429332356, -751345684, -830954599, 1080764994, 553557557, -638351943, -298199125, 991055499, 499776247, 1265440854, 648242737, -354183246, 980351604, -581221582, 1749149687, -898096901, -83167922, -654396521, 1161844396, -1169648345, 1431517754, 545492359, -26498633, -795437749, 1437099964, -1592419752, -861329053, -1713251533, -1507177898, 1060185593, 1593081372, -1876348548, -34019326, 69676912, -2135222948, 86519011, -1782508216, -456757982, 1220612927, -955283748, 133810670, 1090789135, 1078426020, 1569222167, 845107691, -711212847, -222510705, 1091646820, 628848692, 1613405280, -537335645, 526609435, 236106946, 48312990, -1352249391, -892239595, 1797494240, 859738849, 992217954, -289490654, -2051890674, -424014439, -562951028, 765654824, -804095931, -1783130883, 1685915746, -405998096, 1414112111, -2021832454, -1013056217, -214004450, 172450625, -1724973196, 980381355, -185008841, -1475158944, -1578377736, -1726226100, -613520627, -964995824, 1835478071, 660984891, -590288892, -248967737, -872349789, -1254551662, 1762651403, 1719377915, -824476260, -1601057013, -652910941, -1156370552, 1364962596, 2073328063, 1983633131, 926494387, -871278215, -2144935273, -198299347, 1749200295, -966120645, 309677260, 2016342300, 1779581495, -1215147545, 111262694, 1274766160, 443224088, 298511866, 1025883608, -488520759, 1145181785, 168956806, -653464466, -710153686, 1689216846, -628709281, -1094719096, 1692713982, -1648590761, -252198778, 1618508792, 1610833997, -771914938, -164094032, 2001055236, -684262196, -2092799181, -266425487, -1333771897, 1006657119, 2006996926, -1108824540, 1430667929, -1084739999, 1314452623, -220332638, -193663176, -2021016126, 1399257539, -927756684, -1267338667, 1190975929, 2062231137, -1960976508, -2073424263, -1856006686, 1181637006, 548689776, -1932175983, -922558900, -1190417183, -1149106736, 296247880, 1970579870, -1216407114, -525738999, 1714227617, -1003338189, -396747006, 166772364, 1251581989, 493813264, 448347421, 195405023, -1584991729, 677966185, -591930749, 1463355134, -1578971493, 1338867538, 1343315457, -1492745222, -1610435132, 233230375, -1694987225, 2000651841, -1017099258, 1638401717, -266896856, -1057650976, 6314154, 819756386, 300326615, 590932579, 1405279636, -1027467724, -1144263082, -1866680610, -335774303, -833020554, 1862657033, 1266418056, 963775037, 2089974820, -2031914401, 1917689273, 448879540, -744572676, -313240200, 150775221, -667058989, 1303187396, 508620638, -1318983944, -1568336679, 1817252668, 1876281319, 1457606340, 908771278, -574175177, -677760460, -1838972398, 1729034894, 1080033504, 976866871, -738527793, -1413318857, 1522871579, 1555064734, 1336096578, -746444992, -1715692610, -720269667, -1089506539, -701686658, -956251013, -1215554709, 564236357, -1301368386, 1781952180, 1464380207, -1131123079, -962365742, 1699332808, 1393555694, 1183702653, -713881059, 1288719814, 691649499, -1447410096, -1399511320, -1101077756, -1577396752, 1781354906, 1676643554, -1702433246, -1064713544, 1126444790, -1524759638, -1661808476, -2084544070, -1679201715, -1880812208, -1167828010, 673620729, -1489356063, 1269405062, -279616791, -953159725, -145557542, 1057255273, 2012875353, -2132498155, -2018474495, -1693849939, 993977747, -376373926, -1640704105, 753973209, 36408145, -1764381638, 25011837, -774947114, 2088578344, 530523599, -1376601957, 1524020338, 1518925132, -534139791, -535190042, 1202760957, -309069157, -388774771, 674977740, -120232407, 2031300136, 2019492241, -311074731, -141160892, -472686964, 352677332, -1997247046, 60907813, 90501309, -1007968747, 1016092578, -1759044884, -1455814870, 457141659, 509813237, -174299397, 652014361, 1966332200, -1319764491, 55981186, -1967506245, 676427537, -1039476232, -1412673177, -861040033, 1307055953, 942726286, 933058658, -1826555503, -361066302, -79791154, 1361170020, 2001714738, -1464409218, -1020707514, 1222529897, 1679025792, -1565652976, -580013532, 1770335741, 151462246, -1281735158, 1682292957, 1483529935, 471910574, 1539241949, 458788160, -858652289, 1807016891, -576558466, 978976581, 1043663428, -1129001515, 1927990952, -94075717, -1922690386, -1086558393, -761535389, 1412390302, -1362987237, -162634896, 1947078029, -413461673, -126740879, -1353482915, 1077988104, 1320477388, 886195818, 18198404, -508558296, -1785185763, 112762804, -831610808, 1866414978, 891333506, 18488651, 661792760, 1628790961, -409780260, -1153795797, 876946877, -1601685023, 1372485963, 791857591, -1608533303, -534984578, -1127755274, -822013501, -1578587449, 445679433, -732971622, -790962485, -720709064, 54117162, -963561881, -1913048708, -525259953, -140617289, 1140177722, -220915201, 668550556, -1080614356, 367459370, 261225585, -1684794075, -85617823, -826893077, -1029151655, 314222801, -1228863650, -486184436, 282218597, -888953790, -521376242, 379116347, 1285071038, 846784868, -1625320142, -523005217, -744475605, -1989021154, 453669953, 1268987020, -977374944, -1015663912, -550133875, -1684459730, -435458233, 266596637, -447948204, 517658769, -832407089, -851542417, 370717030, -47440635, -2070949179, -151313767, -182193321, -1506642397, -1817692879, 1456262402, -1393524382, 1517677493, 1846949527, -1999473716, -560569710, -2118563376, 1280348187, 1908823572, -423180355, 846861322, 1172426758, -1007518822, -911584259, 1655181056, -1155153950, 901632758, 1897031941, -1308360158, -1228157060, -847864789, 
    1393639104, 373351379, 950779232, 625454576, -1170726756, -146354570, 2007998917, 544563296, -2050228658, -1964470824, 2058025392, 1291430526, 424198748, 50039436, 29584100, -689184263, -1865090967, -1503863136, 1057563949, -1039604065, -1219600078, -831004069, 1469046755, 985887462};
    public static final int[] openbsd_iv = {1333295459, 1752330093, 1635019107, 1114402679, 1718186856, 1400332660, 1148808801, 1835627621};
    public static final int[] c = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends m6 {
        public a(xg0 xg0Var) {
            super(g.this, xg0Var);
        }

        public final hg c(int i, dd ddVar, at0 at0Var) {
            xg0 xg0Var = new xg0(((xg0) this.a).a + '@' + i);
            g gVar = g.this;
            HashMap map = (HashMap) gVar.b;
            List arrayList = (List) map.get(xg0Var);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(xg0Var, arrayList);
            }
            List list = arrayList;
            v8 v8Var = (v8) gVar.a;
            if (e21.a.contains(ddVar)) {
                return null;
            }
            return new hg(v8Var, e4.c((ji0) v8Var.c, ddVar, (oo) v8Var.d), ddVar, list, at0Var);
        }
    }

    public /* synthetic */ g(int i) {
        this.G0 = i;
    }

    public g(int i, int i2) {
        this.G0 = 18;
        this.a = new int[]{i, i2};
        this.b = new float[]{0.0f, 1.0f};
    }

    public g(int i, int i2, int i3) {
        this.G0 = 18;
        this.a = new int[]{i, i2, i3};
        this.b = new float[]{0.0f, 0.5f, 1.0f};
    }

    public /* synthetic */ g(int i, Object obj) {
        this.G0 = i;
        this.b = obj;
        this.a = null;
    }

    public /* synthetic */ g(int i, Object obj, Object obj2) {
        this.G0 = i;
        this.b = obj;
        this.a = obj2;
    }

    public /* synthetic */ g(int i, Object obj, boolean z) {
        this.G0 = i;
        this.a = obj;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0071  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public g(final Context context, int i) {
        this.G0 = 29;
        this.a = new SparseArray();
        this.b = new SparseArray();
        final XmlResourceParser xml = context.getResources().getXml(i);
        try {
            int eventType = xml.getEventType();
            yg$a yg_a = null;
            while (true) {
                byte b = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (!name.equals("ConstraintSet")) {
                                b = -1;
                            } else {
                                b = 4;
                            }
                            break;
                        case 80204913:
                            if (!name.equals("State")) {
                                b = -1;
                            } else {
                                b = 2;
                            }
                            break;
                        case 1382829617:
                            if (!name.equals("StateSet")) {
                                b = -1;
                            }
                            break;
                        case 1657696882:
                            if (!name.equals("layoutDescription")) {
                                b = -1;
                            } else {
                                b = 0;
                            }
                            break;
                        case 1901439077:
                            if (!name.equals("Variant")) {
                                b = -1;
                            } else {
                                b = 3;
                            }
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    if (b == 2) {
                        yg$a yg_a2 = new yg$a(context, xml);
                        ((SparseArray) this.a).put(yg_a2.a, yg_a2);
                        yg_a = yg_a2;
                    } else if (b == 3) {
                        Object obj = new Object(context, xml) { // from class: yg$b
                            public final float a;
                            public final float b;
                            public final float c;
                            public final float d;
                            public final int e;

                            {
                                this.a = Float.NaN;
                                this.b = Float.NaN;
                                this.c = Float.NaN;
                                this.d = Float.NaN;
                                this.e = -1;
                                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xml), ak.I);
                                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                                for (int i2 = 0; i2 < indexCount; i2++) {
                                    int index = typedArrayObtainStyledAttributes.getIndex(i2);
                                    if (index == 0) {
                                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.e);
                                        this.e = resourceId;
                                        String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                                        context.getResources().getResourceName(resourceId);
                                        if ("layout".equals(resourceTypeName)) {
                                            new b().e((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                                        }
                                    } else if (index == 1) {
                                        this.d = typedArrayObtainStyledAttributes.getDimension(index, this.d);
                                    } else if (index == 2) {
                                        this.b = typedArrayObtainStyledAttributes.getDimension(index, this.b);
                                    } else if (index == 3) {
                                        this.c = typedArrayObtainStyledAttributes.getDimension(index, this.c);
                                    } else if (index == 4) {
                                        this.a = typedArrayObtainStyledAttributes.getDimension(index, this.a);
                                    }
                                }
                                typedArrayObtainStyledAttributes.recycle();
                            }
                        };
                        if (yg_a != null) {
                            ((ArrayList) yg_a.b).add(obj);
                        }
                    } else if (b == 4) {
                        a(context, xml);
                    }
                }
                eventType = xml.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    public g(Animation animation) {
        this.G0 = 15;
        this.a = animation;
        this.b = null;
    }

    public g(EditText editText, int i) {
        this.G0 = i;
        this.a = editText;
        if (i == 20) {
            this.b = new bj(editText);
            return;
        }
        mq mqVar = new mq(editText);
        this.b = mqVar;
        editText.addTextChangedListener(mqVar);
        if (fq.b == null) {
            synchronized (fq.a) {
                try {
                    if (fq.b == null) {
                        fq fqVar = new fq();
                        try {
                            fq.c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, fq.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        fq.b = fqVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        editText.setEditableFactory(fq.b);
    }

    public g(TextView textView) {
        this.G0 = 21;
        this.a = textView;
        this.b = new bj(textView);
    }

    public g(HurlStack hurlStack) {
        this.G0 = 2;
        yd ydVar = new yd();
        this.a = hurlStack;
        this.b = ydVar;
    }

    public g(BarLineChartBase barLineChartBase) {
        this.G0 = 5;
        this.b = new ArrayList();
        this.a = barLineChartBase;
    }

    public g(gi0 gi0Var, oo ooVar, q9 q9Var) {
        this.G0 = 1;
        this.a = q9Var;
        this.b = new g(gi0Var, ooVar, 13, false);
    }

    public g(Object obj) {
        this.G0 = 24;
        this.a = obj;
        this.b = Thread.currentThread();
    }

    public /* synthetic */ g(Object obj, Object obj2, int i, boolean z) {
        this.G0 = i;
        this.a = obj;
        this.b = obj2;
    }

    public g(String str) {
        this.G0 = 8;
        System.currentTimeMillis();
        this.b = str;
        this.a = null;
    }

    public g(ArrayList arrayList, ArrayList arrayList2) {
        this.G0 = 18;
        int size = arrayList.size();
        this.a = new int[size];
        this.b = new float[size];
        for (int i = 0; i < size; i++) {
            ((int[]) this.a)[i] = ((Integer) arrayList.get(i)).intValue();
            ((float[]) this.b)[i] = ((Float) arrayList2.get(i)).floatValue();
        }
    }

    public g(xp0 xp0Var) {
        this.G0 = 28;
        this.b = xp0Var;
    }

    public static float getMinimumDistance(List list, float f, YAxis.AxisDependency axisDependency) {
        float f2 = Float.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            Highlight highlight = (Highlight) list.get(i);
            if (highlight.axis == axisDependency) {
                float fAbs = Math.abs(highlight.mYPx - f);
                if (fAbs < f2) {
                    f2 = fAbs;
                }
            }
        }
        return f2;
    }

    public static int streamtoword(byte[] bArr, int[] iArr) {
        int length = iArr[0];
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i = (i << 8) | (bArr[length] & GZIPHeader.OS_UNKNOWN);
            length = (length + 1) % bArr.length;
        }
        iArr[0] = length;
        return i;
    }

    @Override // defpackage.ld
    public cc1 A(ArrayList arrayList) {
        return e4.E(arrayList);
    }

    @Override // defpackage.ld
    public da1 B(cc1 cc1Var) {
        return e4.i(cc1Var);
    }

    @Override // defpackage.ld
    public ca1 C(vk0 vk0Var) {
        return e4.e0(vk0Var);
    }

    @Override // defpackage.ld
    public v91 D(b91 b91Var, int i) {
        return e4.q(b91Var, i);
    }

    @Override // defpackage.ld
    public boolean E(w01 w01Var, w01 w01Var2) {
        return e4.D(w01Var, w01Var2);
    }

    @Override // defpackage.ld
    public boolean F(w01 w01Var) {
        return e4.N(w01Var);
    }

    @Override // defpackage.ld
    public ca1 G(w01 w01Var, int i) {
        if (i < 0 || i >= O(w01Var)) {
            return null;
        }
        return J(w01Var, i);
    }

    @Override // defpackage.ld
    public boolean H(b91 b91Var) {
        return e4.P(b91Var);
    }

    @Override // defpackage.ld
    public boolean I(b91 b91Var) {
        return e4.H(b91Var);
    }

    @Override // defpackage.ld
    public ca1 J(jc0 jc0Var, int i) {
        return e4.n(jc0Var, i);
    }

    @Override // defpackage.ld
    public cc1 M(cc1 cc1Var) {
        return e4.m0(this, cc1Var);
    }

    @Override // defpackage.ld
    public boolean N(v91 v91Var, a91 a91Var) {
        return e4.C(v91Var, a91Var);
    }

    @Override // defpackage.ld
    public int O(jc0 jc0Var) {
        return e4.b(jc0Var);
    }

    @Override // defpackage.ld
    public boolean P(ca1 ca1Var) {
        return e4.T(ca1Var);
    }

    @Override // defpackage.ld
    public w81 R(w01 w01Var) {
        return e4.c(w01Var);
    }

    @Override // defpackage.ld
    public void S(w01 w01Var) {
        e4.V(w01Var);
    }

    @Override // defpackage.ld
    public vk0 T(rb rbVar) {
        return e4.i0(rbVar);
    }

    @Override // defpackage.ld
    public boolean U(w01 w01Var) {
        return e4.G(e4.j0(w01Var));
    }

    @Override // defpackage.ld
    public u01 V(jc0 jc0Var) {
        zt ztVarE0 = e0(jc0Var);
        return ztVarE0 == null ? a(jc0Var) : d(ztVarE0);
    }

    @Override // defpackage.ld
    public Collection W(a91 a91Var) {
        return e4.h0(a91Var);
    }

    @Override // defpackage.ld
    public boolean X(b91 b91Var) {
        return e4.I(b91Var);
    }

    @Override // defpackage.ld
    public void Y(w01 w01Var) {
        e4.U(w01Var);
    }

    @Override // defpackage.ld
    public boolean Z(w01 w01Var) {
        return H(f0(w01Var)) && !e4.Q(w01Var);
    }

    public KeyListener a(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        ((g) ((bj) this.b).a).getClass();
        if (keyListener instanceof iq) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return new iq(keyListener);
    }

    public h4 a(yq0 yq0Var, jj0 jj0Var) {
        Map mapJ;
        uc ucVar;
        ai0 ai0VarC = e4.c((gi0) this.a, e.x(jj0Var, yq0Var.d), (oo) this.b);
        if (yq0Var.f.size() == 0 || pr.h(ai0VarC) || !xm.n(ai0VarC, 5) || (ucVar = (uc) he.b1(ai0VarC.i())) == null) {
            mapJ = vq.b;
        } else {
            List listF = ucVar.f();
            int iE = ye1.e(ae.y0(listF));
            if (iE < 16) {
                iE = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iE);
            for (Object obj : listF) {
                linkedHashMap.put(((wc1) obj).getName(), obj);
            }
            List<yq0.b> list = yq0Var.f;
            ArrayList arrayList = new ArrayList();
            for (yq0.b bVar : list) {
                wc1 wc1Var = (wc1) linkedHashMap.get(ij0.d(jj0Var.getString(bVar.d)));
                Object jo0Var = null;
                if (wc1Var != null) {
                    ij0 ij0VarD = ij0.d(jj0Var.getString(bVar.d));
                    fc0 type = wc1Var.getType();
                    yq0.b.c cVar = bVar.f;
                    qg qgVarC = c(type, cVar, jj0Var);
                    jo0Var = b(qgVarC, type, cVar) ? qgVarC : null;
                    if (jo0Var == null) {
                        jo0Var = new rr$a("Unexpected argument value: actual type " + cVar.d + " != expected type " + type);
                    }
                    jo0Var = new jo0(ij0VarD, jo0Var);
                }
                if (jo0Var != null) {
                    arrayList.add(jo0Var);
                }
            }
            mapJ = ye1.j(arrayList);
        }
        return new h4(ai0VarC.n(), mapJ, t11.a);
    }

    public ig0$a a() {
        if (((ig0$a) this.b) == null) {
            this.b = new ig0$a(this);
        }
        return (ig0$a) this.b;
    }

    @Override // defpackage.a4
    public List a(dg0 dg0Var, b0 b0Var, x3 x3Var) {
        return uq.b;
    }

    @Override // defpackage.ld
    public u01 a(jc0 jc0Var) {
        return e4.h(jc0Var);
    }

    @Override // defpackage.wc
    public vc a(dd ddVar) {
        qz qzVarC = ((ku0) this.a).c(ddVar);
        ju0 ju0Var = qzVarC == null ? null : (ju0) qzVarC.a;
        if (ju0Var == null) {
            return null;
        }
        bt0.a(ju0Var.a).equals(ddVar);
        return ((tn) this.b).f(ju0Var);
    }

    @Override // defpackage.xb0$c
    /* JADX INFO: renamed from: a */
    public void mo4a() {
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x01ac A[Catch: IOException -> 0x0084, XmlPullParserException -> 0x0087, TryCatch #2 {IOException -> 0x0084, XmlPullParserException -> 0x0087, blocks: (B:18:0x0056, B:114:0x0224, B:25:0x0068, B:26:0x0076, B:50:0x00b3, B:28:0x007a, B:35:0x008a, B:38:0x0094, B:41:0x009e, B:51:0x00c1, B:52:0x00c9, B:89:0x013e, B:90:0x0145, B:91:0x015d, B:93:0x0160, B:94:0x016b, B:95:0x0183, B:97:0x0186, B:98:0x0191, B:99:0x01a9, B:101:0x01ac, B:102:0x01b6, B:103:0x01ce, B:105:0x01d1, B:106:0x01db, B:107:0x01f3, B:108:0x01f4, B:110:0x0202, B:111:0x020f, B:112:0x0218, B:54:0x00ce, B:57:0x00d9, B:60:0x00e4, B:63:0x00ed, B:66:0x00f8, B:69:0x0102, B:72:0x010c, B:75:0x0116, B:78:0x0120, B:81:0x012a, B:113:0x0221), top: B:122:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x01cf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:105:0x01d1 A[Catch: IOException -> 0x0084, XmlPullParserException -> 0x0087, TryCatch #2 {IOException -> 0x0084, XmlPullParserException -> 0x0087, blocks: (B:18:0x0056, B:114:0x0224, B:25:0x0068, B:26:0x0076, B:50:0x00b3, B:28:0x007a, B:35:0x008a, B:38:0x0094, B:41:0x009e, B:51:0x00c1, B:52:0x00c9, B:89:0x013e, B:90:0x0145, B:91:0x015d, B:93:0x0160, B:94:0x016b, B:95:0x0183, B:97:0x0186, B:98:0x0191, B:99:0x01a9, B:101:0x01ac, B:102:0x01b6, B:103:0x01ce, B:105:0x01d1, B:106:0x01db, B:107:0x01f3, B:108:0x01f4, B:110:0x0202, B:111:0x020f, B:112:0x0218, B:54:0x00ce, B:57:0x00d9, B:60:0x00e4, B:63:0x00ed, B:66:0x00f8, B:69:0x0102, B:72:0x010c, B:75:0x0116, B:78:0x0120, B:81:0x012a, B:113:0x0221), top: B:122:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x01f4 A[Catch: IOException -> 0x0084, XmlPullParserException -> 0x0087, TryCatch #2 {IOException -> 0x0084, XmlPullParserException -> 0x0087, blocks: (B:18:0x0056, B:114:0x0224, B:25:0x0068, B:26:0x0076, B:50:0x00b3, B:28:0x007a, B:35:0x008a, B:38:0x0094, B:41:0x009e, B:51:0x00c1, B:52:0x00c9, B:89:0x013e, B:90:0x0145, B:91:0x015d, B:93:0x0160, B:94:0x016b, B:95:0x0183, B:97:0x0186, B:98:0x0191, B:99:0x01a9, B:101:0x01ac, B:102:0x01b6, B:103:0x01ce, B:105:0x01d1, B:106:0x01db, B:107:0x01f3, B:108:0x01f4, B:110:0x0202, B:111:0x020f, B:112:0x0218, B:54:0x00ce, B:57:0x00d9, B:60:0x00e4, B:63:0x00ed, B:66:0x00f8, B:69:0x0102, B:72:0x010c, B:75:0x0116, B:78:0x0120, B:81:0x012a, B:113:0x0221), top: B:122:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0202 A[Catch: IOException -> 0x0084, XmlPullParserException -> 0x0087, TryCatch #2 {IOException -> 0x0084, XmlPullParserException -> 0x0087, blocks: (B:18:0x0056, B:114:0x0224, B:25:0x0068, B:26:0x0076, B:50:0x00b3, B:28:0x007a, B:35:0x008a, B:38:0x0094, B:41:0x009e, B:51:0x00c1, B:52:0x00c9, B:89:0x013e, B:90:0x0145, B:91:0x015d, B:93:0x0160, B:94:0x016b, B:95:0x0183, B:97:0x0186, B:98:0x0191, B:99:0x01a9, B:101:0x01ac, B:102:0x01b6, B:103:0x01ce, B:105:0x01d1, B:106:0x01db, B:107:0x01f3, B:108:0x01f4, B:110:0x0202, B:111:0x020f, B:112:0x0218, B:54:0x00ce, B:57:0x00d9, B:60:0x00e4, B:63:0x00ed, B:66:0x00f8, B:69:0x0102, B:72:0x010c, B:75:0x0116, B:78:0x0120, B:81:0x012a, B:113:0x0221), top: B:122:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x020f A[Catch: IOException -> 0x0084, XmlPullParserException -> 0x0087, TryCatch #2 {IOException -> 0x0084, XmlPullParserException -> 0x0087, blocks: (B:18:0x0056, B:114:0x0224, B:25:0x0068, B:26:0x0076, B:50:0x00b3, B:28:0x007a, B:35:0x008a, B:38:0x0094, B:41:0x009e, B:51:0x00c1, B:52:0x00c9, B:89:0x013e, B:90:0x0145, B:91:0x015d, B:93:0x0160, B:94:0x016b, B:95:0x0183, B:97:0x0186, B:98:0x0191, B:99:0x01a9, B:101:0x01ac, B:102:0x01b6, B:103:0x01ce, B:105:0x01d1, B:106:0x01db, B:107:0x01f3, B:108:0x01f4, B:110:0x0202, B:111:0x020f, B:112:0x0218, B:54:0x00ce, B:57:0x00d9, B:60:0x00e4, B:63:0x00ed, B:66:0x00f8, B:69:0x0102, B:72:0x010c, B:75:0x0116, B:78:0x0120, B:81:0x012a, B:113:0x0221), top: B:122:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x0218 A[Catch: IOException -> 0x0084, XmlPullParserException -> 0x0087, TryCatch #2 {IOException -> 0x0084, XmlPullParserException -> 0x0087, blocks: (B:18:0x0056, B:114:0x0224, B:25:0x0068, B:26:0x0076, B:50:0x00b3, B:28:0x007a, B:35:0x008a, B:38:0x0094, B:41:0x009e, B:51:0x00c1, B:52:0x00c9, B:89:0x013e, B:90:0x0145, B:91:0x015d, B:93:0x0160, B:94:0x016b, B:95:0x0183, B:97:0x0186, B:98:0x0191, B:99:0x01a9, B:101:0x01ac, B:102:0x01b6, B:103:0x01ce, B:105:0x01d1, B:106:0x01db, B:107:0x01f3, B:108:0x01f4, B:110:0x0202, B:111:0x020f, B:112:0x0218, B:54:0x00ce, B:57:0x00d9, B:60:0x00e4, B:63:0x00ed, B:66:0x00f8, B:69:0x0102, B:72:0x010c, B:75:0x0116, B:78:0x0120, B:81:0x012a, B:113:0x0221), top: B:122:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x0145 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x016b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x0191 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x01b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x01db A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x0224 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:84:0x0134  */
    /* JADX WARN: Code duplicated, block: B:88:0x013c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x013e A[Catch: IOException -> 0x0084, XmlPullParserException -> 0x0087, TRY_ENTER, TryCatch #2 {IOException -> 0x0084, XmlPullParserException -> 0x0087, blocks: (B:18:0x0056, B:114:0x0224, B:25:0x0068, B:26:0x0076, B:50:0x00b3, B:28:0x007a, B:35:0x008a, B:38:0x0094, B:41:0x009e, B:51:0x00c1, B:52:0x00c9, B:89:0x013e, B:90:0x0145, B:91:0x015d, B:93:0x0160, B:94:0x016b, B:95:0x0183, B:97:0x0186, B:98:0x0191, B:99:0x01a9, B:101:0x01ac, B:102:0x01b6, B:103:0x01ce, B:105:0x01d1, B:106:0x01db, B:107:0x01f3, B:108:0x01f4, B:110:0x0202, B:111:0x020f, B:112:0x0218, B:54:0x00ce, B:57:0x00d9, B:60:0x00e4, B:63:0x00ed, B:66:0x00f8, B:69:0x0102, B:72:0x010c, B:75:0x0116, B:78:0x0120, B:81:0x012a, B:113:0x0221), top: B:122:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x015e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x0160 A[Catch: IOException -> 0x0084, XmlPullParserException -> 0x0087, TryCatch #2 {IOException -> 0x0084, XmlPullParserException -> 0x0087, blocks: (B:18:0x0056, B:114:0x0224, B:25:0x0068, B:26:0x0076, B:50:0x00b3, B:28:0x007a, B:35:0x008a, B:38:0x0094, B:41:0x009e, B:51:0x00c1, B:52:0x00c9, B:89:0x013e, B:90:0x0145, B:91:0x015d, B:93:0x0160, B:94:0x016b, B:95:0x0183, B:97:0x0186, B:98:0x0191, B:99:0x01a9, B:101:0x01ac, B:102:0x01b6, B:103:0x01ce, B:105:0x01d1, B:106:0x01db, B:107:0x01f3, B:108:0x01f4, B:110:0x0202, B:111:0x020f, B:112:0x0218, B:54:0x00ce, B:57:0x00d9, B:60:0x00e4, B:63:0x00ed, B:66:0x00f8, B:69:0x0102, B:72:0x010c, B:75:0x0116, B:78:0x0120, B:81:0x012a, B:113:0x0221), top: B:122:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0184 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x0186 A[Catch: IOException -> 0x0084, XmlPullParserException -> 0x0087, TryCatch #2 {IOException -> 0x0084, XmlPullParserException -> 0x0087, blocks: (B:18:0x0056, B:114:0x0224, B:25:0x0068, B:26:0x0076, B:50:0x00b3, B:28:0x007a, B:35:0x008a, B:38:0x0094, B:41:0x009e, B:51:0x00c1, B:52:0x00c9, B:89:0x013e, B:90:0x0145, B:91:0x015d, B:93:0x0160, B:94:0x016b, B:95:0x0183, B:97:0x0186, B:98:0x0191, B:99:0x01a9, B:101:0x01ac, B:102:0x01b6, B:103:0x01ce, B:105:0x01d1, B:106:0x01db, B:107:0x01f3, B:108:0x01f4, B:110:0x0202, B:111:0x020f, B:112:0x0218, B:54:0x00ce, B:57:0x00d9, B:60:0x00e4, B:63:0x00ed, B:66:0x00f8, B:69:0x0102, B:72:0x010c, B:75:0x0116, B:78:0x0120, B:81:0x012a, B:113:0x0221), top: B:122:0x0056 }] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(Context context, XmlResourceParser xmlResourceParser) {
        b.a aVarG;
        byte b;
        b bVar = new b();
        int attributeCount = xmlResourceParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlResourceParser.getAttributeName(i);
            String attributeValue = xmlResourceParser.getAttributeValue(i);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains(InternalZipConstants.ZIP_FILE_SEPARATOR) ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1 && attributeValue.length() > 1) {
                    identifier = Integer.parseInt(attributeValue.substring(1));
                }
                try {
                    int eventType = xmlResourceParser.getEventType();
                    b.a aVar = null;
                    while (eventType != 1) {
                        if (eventType != 0) {
                            byte b2 = 3;
                            if (eventType == 2) {
                                String name = xmlResourceParser.getName();
                                switch (name.hashCode()) {
                                    case -2025855158:
                                        if (name.equals("Layout")) {
                                            b2 = 6;
                                        } else {
                                            b2 = -1;
                                        }
                                        switch (b2) {
                                            case 0:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                break;
                                            case 1:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), true);
                                                break;
                                            case 2:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.a = true;
                                                break;
                                            case 3:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.i0 = 1;
                                                break;
                                            case 4:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.c.a(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 5:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.f.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 6:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.e.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 7:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.d.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 8:
                                            case 9:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                wg.d(context, xmlResourceParser, aVar.g);
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            default:
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                        }
                                        aVar = aVarG;
                                        break;
                                    case -1984451626:
                                        if (name.equals("Motion")) {
                                            b2 = 7;
                                        } else {
                                            b2 = -1;
                                        }
                                        switch (b2) {
                                            case 0:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                break;
                                            case 1:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), true);
                                                break;
                                            case 2:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.a = true;
                                                break;
                                            case 3:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.i0 = 1;
                                                break;
                                            case 4:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.c.a(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 5:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.f.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 6:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.e.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 7:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.d.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 8:
                                            case 9:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                wg.d(context, xmlResourceParser, aVar.g);
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            default:
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                        }
                                        aVar = aVarG;
                                        break;
                                    case -1962203927:
                                        if (name.equals("ConstraintOverride")) {
                                            b2 = 1;
                                        } else {
                                            b2 = -1;
                                        }
                                        switch (b2) {
                                            case 0:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                break;
                                            case 1:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), true);
                                                break;
                                            case 2:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.a = true;
                                                break;
                                            case 3:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.i0 = 1;
                                                break;
                                            case 4:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.c.a(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 5:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.f.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 6:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.e.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 7:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.d.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 8:
                                            case 9:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                wg.d(context, xmlResourceParser, aVar.g);
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            default:
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                        }
                                        aVar = aVarG;
                                        break;
                                    case -1269513683:
                                        if (name.equals("PropertySet")) {
                                            b2 = 4;
                                        } else {
                                            b2 = -1;
                                        }
                                        switch (b2) {
                                            case 0:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                break;
                                            case 1:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), true);
                                                break;
                                            case 2:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.a = true;
                                                break;
                                            case 3:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.i0 = 1;
                                                break;
                                            case 4:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.c.a(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 5:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.f.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 6:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.e.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 7:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.d.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 8:
                                            case 9:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                wg.d(context, xmlResourceParser, aVar.g);
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            default:
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                        }
                                        aVar = aVarG;
                                        break;
                                    case -1238332596:
                                        if (name.equals("Transform")) {
                                            b2 = 5;
                                        } else {
                                            b2 = -1;
                                        }
                                        switch (b2) {
                                            case 0:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                break;
                                            case 1:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), true);
                                                break;
                                            case 2:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.a = true;
                                                break;
                                            case 3:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.i0 = 1;
                                                break;
                                            case 4:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.c.a(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 5:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.f.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 6:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.e.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 7:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.d.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 8:
                                            case 9:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                wg.d(context, xmlResourceParser, aVar.g);
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            default:
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                        }
                                        aVar = aVarG;
                                        break;
                                    case -71750448:
                                        if (name.equals("Guideline")) {
                                            b2 = 2;
                                        } else {
                                            b2 = -1;
                                        }
                                        switch (b2) {
                                            case 0:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                break;
                                            case 1:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), true);
                                                break;
                                            case 2:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.a = true;
                                                break;
                                            case 3:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.i0 = 1;
                                                break;
                                            case 4:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.c.a(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 5:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.f.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 6:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.e.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 7:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.d.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 8:
                                            case 9:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                wg.d(context, xmlResourceParser, aVar.g);
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            default:
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                        }
                                        aVar = aVarG;
                                        break;
                                    case 366511058:
                                        if (name.equals("CustomMethod")) {
                                            b2 = 9;
                                        } else {
                                            b2 = -1;
                                        }
                                        switch (b2) {
                                            case 0:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                break;
                                            case 1:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), true);
                                                break;
                                            case 2:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.a = true;
                                                break;
                                            case 3:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.i0 = 1;
                                                break;
                                            case 4:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.c.a(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 5:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.f.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 6:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.e.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 7:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.d.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 8:
                                            case 9:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                wg.d(context, xmlResourceParser, aVar.g);
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            default:
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                        }
                                        aVar = aVarG;
                                        break;
                                    case 1331510167:
                                        if (!name.equals("Barrier")) {
                                            b2 = -1;
                                        }
                                        switch (b2) {
                                            case 0:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                break;
                                            case 1:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), true);
                                                break;
                                            case 2:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.a = true;
                                                break;
                                            case 3:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.i0 = 1;
                                                break;
                                            case 4:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.c.a(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 5:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.f.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 6:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.e.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 7:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.d.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 8:
                                            case 9:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                wg.d(context, xmlResourceParser, aVar.g);
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            default:
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                        }
                                        aVar = aVarG;
                                        break;
                                    case 1791837707:
                                        if (name.equals("CustomAttribute")) {
                                            b2 = 8;
                                        } else {
                                            b2 = -1;
                                        }
                                        switch (b2) {
                                            case 0:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                break;
                                            case 1:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), true);
                                                break;
                                            case 2:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.a = true;
                                                break;
                                            case 3:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.i0 = 1;
                                                break;
                                            case 4:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.c.a(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 5:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.f.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 6:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.e.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 7:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.d.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 8:
                                            case 9:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                wg.d(context, xmlResourceParser, aVar.g);
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            default:
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                        }
                                        aVar = aVarG;
                                        break;
                                    case 1803088381:
                                        if (name.equals("Constraint")) {
                                            b2 = 0;
                                        } else {
                                            b2 = -1;
                                        }
                                        switch (b2) {
                                            case 0:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                break;
                                            case 1:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), true);
                                                break;
                                            case 2:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.a = true;
                                                break;
                                            case 3:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.i0 = 1;
                                                break;
                                            case 4:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.c.a(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 5:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.f.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 6:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.e.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 7:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.d.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 8:
                                            case 9:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                wg.d(context, xmlResourceParser, aVar.g);
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            default:
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                        }
                                        aVar = aVarG;
                                        break;
                                    default:
                                        b2 = -1;
                                        switch (b2) {
                                            case 0:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                break;
                                            case 1:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), true);
                                                break;
                                            case 2:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.a = true;
                                                break;
                                            case 3:
                                                aVarG = b.g(context, Xml.asAttributeSet(xmlResourceParser), false);
                                                aVarG.e.i0 = 1;
                                                break;
                                            case 4:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.c.a(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 5:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.f.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 6:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.e.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 7:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                aVar.d.b(context, Xml.asAttributeSet(xmlResourceParser));
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            case 8:
                                            case 9:
                                                if (aVar == null) {
                                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                                }
                                                wg.d(context, xmlResourceParser, aVar.g);
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                break;
                                            default:
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                        }
                                        aVar = aVarG;
                                        break;
                                }
                            } else if (eventType == 3) {
                                String lowerCase = xmlResourceParser.getName().toLowerCase(Locale.ROOT);
                                switch (lowerCase.hashCode()) {
                                    case -2075718416:
                                        if (lowerCase.equals("guideline")) {
                                            b = 3;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case -190376483:
                                        if (lowerCase.equals("constraint")) {
                                            b = 1;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 426575017:
                                        if (lowerCase.equals("constraintoverride")) {
                                            b = 2;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 2146106725:
                                        if (lowerCase.equals("constraintset")) {
                                            b = 0;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    default:
                                        b = -1;
                                        break;
                                }
                                if (b == 0) {
                                    ((SparseArray) this.b).put(identifier, bVar);
                                    return;
                                } else if (b == 1 || b == 2 || b == 3) {
                                    bVar.e.put(Integer.valueOf(aVar.a), aVar);
                                    aVar = null;
                                }
                            }
                        } else {
                            xmlResourceParser.getName();
                        }
                        eventType = xmlResourceParser.next();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e2) {
                    e2.printStackTrace();
                }
                ((SparseArray) this.b).put(identifier, bVar);
                return;
            }
        }
    }

    public void a(AttributeSet attributeSet, int i) {
        AbsSeekBar absSeekBar = (AbsSeekBar) this.a;
        m6 m6VarM = m6.m(absSeekBar.getContext(), attributeSet, c, i);
        Drawable drawableF = m6VarM.f(0);
        if (drawableF != null) {
            if (drawableF instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) drawableF;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                AnimationDrawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i2 = 0; i2 < numberOfFrames; i2++) {
                    Drawable drawableB = b(animationDrawable.getFrame(i2), true);
                    drawableB.setLevel(10000);
                    animationDrawable2.addFrame(drawableB, animationDrawable.getDuration(i2));
                }
                animationDrawable2.setLevel(10000);
                drawableF = animationDrawable2;
            }
            absSeekBar.setIndeterminateDrawable(drawableF);
        }
        Drawable drawableF2 = m6VarM.f(1);
        if (drawableF2 != null) {
            absSeekBar.setProgressDrawable(b(drawableF2, false));
        }
        m6VarM.n();
    }

    public void a(String str, nw nwVar) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) ((bj) this.b).a;
        j01$a$a j01_a_a = new j01$a$a(this, str);
        nwVar.invoke(j01_a_a);
        String str2 = (String) this.a;
        ArrayList arrayList = j01_a_a.b;
        ArrayList arrayList2 = new ArrayList(ae.y0(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((String) ((jo0) it.next()).b);
        }
        String str3 = (String) j01_a_a.c.b;
        StringBuilder sb = new StringBuilder();
        sb.append(j01_a_a.a);
        sb.append('(');
        sb.append(he.R0(arrayList2, AppConfig.CUSTOM, null, null, ba.b$11, 30));
        sb.append(')');
        if (str3.length() > 1) {
            str3 = "L" + str3 + ';';
        }
        sb.append(str3);
        String str4 = str2 + '.' + sb.toString();
        j91 j91Var = (j91) j01_a_a.c.c;
        ArrayList arrayList3 = new ArrayList(ae.y0(arrayList));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList3.add((j91) ((jo0) it2.next()).c);
        }
        linkedHashMap.put(str4, new op0(j91Var, arrayList3));
    }

    public void a(uu.a aVar) {
        int i = aVar.b;
        boolean z = false;
        int i2 = 1;
        boolean z2 = i == 0;
        Handler handler = (Handler) this.b;
        ta1.a aVar2 = (ta1.a) this.a;
        if (z2) {
            handler.post(new f2(aVar2, aVar.a, 8, z));
        } else {
            handler.post(new df(aVar2, i, i2));
        }
    }

    @Override // defpackage.jj0
    public boolean a(int i) {
        return ((Boolean) c(i).d).booleanValue();
    }

    @Override // y1.a
    public boolean a(y1 y1Var, f fVar) {
        ViewGroup viewGroup = ((f5) this.b).B;
        WeakHashMap weakHashMap = qd1.a;
        viewGroup.requestApplyInsets();
        return ((y1.a) this.a).a(y1Var, fVar);
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        lq$c lq_c = (lq$c) ((bj) this.b).a;
        lq_c.getClass();
        return c.j != null ? lq_c.a.a(inputFilterArr) : inputFilterArr;
    }

    @Override // defpackage.ld
    public int a0(v91 v91Var) {
        return e4.z(v91Var);
    }

    public Drawable b(Drawable drawable, boolean z) {
        if (!(drawable instanceof LayerDrawable)) {
            if (!(drawable instanceof BitmapDrawable)) {
                return drawable;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (((Bitmap) this.b) == null) {
                this.b = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        Drawable[] drawableArr = new Drawable[numberOfLayers];
        for (int i = 0; i < numberOfLayers; i++) {
            int id = layerDrawable.getId(i);
            drawableArr[i] = b(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            layerDrawable2.setId(i2, layerDrawable.getId(i2));
            layerDrawable2.setLayerGravity(i2, layerDrawable.getLayerGravity(i2));
            layerDrawable2.setLayerWidth(i2, layerDrawable.getLayerWidth(i2));
            layerDrawable2.setLayerHeight(i2, layerDrawable.getLayerHeight(i2));
            layerDrawable2.setLayerInsetLeft(i2, layerDrawable.getLayerInsetLeft(i2));
            layerDrawable2.setLayerInsetRight(i2, layerDrawable.getLayerInsetRight(i2));
            layerDrawable2.setLayerInsetTop(i2, layerDrawable.getLayerInsetTop(i2));
            layerDrawable2.setLayerInsetBottom(i2, layerDrawable.getLayerInsetBottom(i2));
            layerDrawable2.setLayerInsetStart(i2, layerDrawable.getLayerInsetStart(i2));
            layerDrawable2.setLayerInsetEnd(i2, layerDrawable.getLayerInsetEnd(i2));
        }
        return layerDrawable2;
    }

    @Override // defpackage.jj0
    public String b(int i) {
        j81 j81VarC = c(i);
        List list = (List) j81VarC.b;
        String strR0 = he.R0((List) j81VarC.c, ".", null, null, null, 62);
        if (list.isEmpty()) {
            return strR0;
        }
        return he.R0(list, InternalZipConstants.ZIP_FILE_SEPARATOR, null, null, null, 62) + '/' + strR0;
    }

    @Override // defpackage.a4
    public List b(dg0 dg0Var, b0 b0Var, x3 x3Var, int i, rr0 rr0Var) {
        Iterable iterable = (List) rr0Var.g(((q9) this.a).j);
        if (iterable == null) {
            iterable = uq.b;
        }
        ArrayList arrayList = new ArrayList(ae.y0(iterable));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((g) this.b).a((yq0) it.next(), (jj0) dg0Var.a));
        }
        return arrayList;
    }

    @Override // defpackage.ld
    public u01 b(w01 w01Var, boolean z) {
        return e4.n0(w01Var, z);
    }

    @Override // defpackage.xb0$c
    public xb0$a b(dd ddVar, at0 at0Var) {
        v8 v8Var = (v8) this.a;
        ArrayList arrayList = (ArrayList) this.b;
        if (e21.a.contains(ddVar)) {
            return null;
        }
        return new hg(v8Var, e4.c((ji0) v8Var.c, ddVar, (oo) v8Var.d), ddVar, arrayList, at0Var);
    }

    public void b(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = ((EditText) this.a).getContext().obtainStyledAttributes(attributeSet, b2.i, i, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            mq mqVar = (mq) ((g) ((bj) this.b).a).b;
            if (mqVar.f != z) {
                if (mqVar.d != null) {
                    c cVarA = c.a();
                    mq.a aVar = mqVar.d;
                    cVarA.getClass();
                    if (aVar == null) {
                        d.AnonymousClass0.m$1("initCallback cannot be null");
                        return;
                    }
                    ReentrantReadWriteLock reentrantReadWriteLock = cVarA.a;
                    reentrantReadWriteLock.writeLock().lock();
                    try {
                        cVarA.b.remove(aVar);
                        reentrantReadWriteLock.writeLock().unlock();
                    } catch (Throwable th) {
                        reentrantReadWriteLock.writeLock().unlock();
                        throw th;
                    }
                }
                mqVar.f = z;
                if (z) {
                    mq.a(mqVar.b, c.a().b());
                }
            }
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public boolean b(qg qgVar, fc0 fc0Var, yq0.b.c cVar) {
        int iNextInt;
        yq0.b.c.EnumC0048c enumC0048c = cVar.d;
        int i = enumC0048c == null ? -1 : i4$a.a[enumC0048c.ordinal()];
        if (i == 10) {
            od odVarB = fc0Var.L0().b();
            ai0 ai0Var = odVarB instanceof ai0 ? (ai0) odVarB : null;
            if (ai0Var != null) {
                ij0 ij0Var = ub0.e;
                if (!ub0.c(ai0Var, m21.a.O)) {
                    return false;
                }
            }
            return true;
        }
        gi0 gi0Var = (gi0) this.a;
        if (i != 13) {
            return e4.a(qgVar.a(gi0Var), fc0Var);
        }
        if (qgVar instanceof h7) {
            Object obj = ((h7) qgVar).a;
            List list = (List) obj;
            if (list.size() == cVar.q.size()) {
                fc0 fc0VarG = gi0Var.k().g(fc0Var);
                Iterable y20Var = new y20(0, ((Collection) obj).size() - 1, 1);
                if (!(y20Var instanceof Collection) || !((Collection) y20Var).isEmpty()) {
                    Iterator it = y20Var.iterator();
                    do {
                        x20 x20Var = (x20) it;
                        if (x20Var.d) {
                            iNextInt = x20Var.nextInt();
                        }
                    } while (b((qg) list.get(iNextInt), fc0VarG, (yq0.b.c) cVar.q.get(iNextInt)));
                    return false;
                }
                return true;
            }
        }
        throw new IllegalStateException(e4.j("Deserialized ArrayValue should have the same number of elements as the original array value: ", qgVar).toString());
    }

    @Override // y1.a
    public boolean b(y1 y1Var, f fVar) {
        return ((y1.a) this.a).b(y1Var, fVar);
    }

    @Override // defpackage.ld
    public cc1 b0(cc1 cc1Var) {
        return e.d1(cc1Var);
    }

    public ArrayList buildHighlights(IDataSet iDataSet, int i, float f) {
        Entry entryForXValue;
        DataSet$Rounding dataSet$Rounding = DataSet$Rounding.CLOSEST;
        ArrayList arrayList = new ArrayList();
        LineDataSet lineDataSet = (LineDataSet) iDataSet;
        ArrayList<Entry> entriesForXValue = lineDataSet.getEntriesForXValue(f);
        if (entriesForXValue.size() == 0 && (entryForXValue = lineDataSet.getEntryForXValue(f, Float.NaN, dataSet$Rounding)) != null) {
            entriesForXValue = lineDataSet.getEntriesForXValue(entryForXValue.x);
        }
        if (entriesForXValue.size() != 0) {
            for (Entry entry : entriesForXValue) {
                MPPointD pixelForValues = ((BarLineChartBase) this.a).getTransformer(lineDataSet.mAxisDependency).getPixelForValues(entry.x, entry.y);
                arrayList.add(new Highlight(entry.x, entry.y, (float) pixelForValues.x, (float) pixelForValues.y, i, lineDataSet.mAxisDependency));
            }
        }
        return arrayList;
    }

    @Override // defpackage.ld
    public a91 c(w01 w01Var) {
        return e4.j0(w01Var);
    }

    public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
        bj bjVar = (bj) this.b;
        if (inputConnection == null) {
            bjVar.getClass();
            return null;
        }
        g gVar = (g) bjVar.a;
        gVar.getClass();
        return inputConnection instanceof gq ? inputConnection : new gq((EditText) gVar.a, inputConnection, editorInfo);
    }

    public j81 c(int i) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        while (i != -1) {
            lr0.c cVar = (lr0.c) ((lr0) this.b).c.get(i);
            String str = (String) ((mr0) this.a).c.get(cVar.f);
            int iOrdinal = cVar.g.ordinal();
            if (iOrdinal == 0) {
                linkedList2.addFirst(str);
            } else if (iOrdinal == 1) {
                linkedList.addFirst(str);
            } else if (iOrdinal == 2) {
                linkedList2.addFirst(str);
                z = true;
            }
            i = cVar.d;
        }
        return new j81(linkedList, linkedList2, Boolean.valueOf(z));
    }

    @Override // defpackage.a4
    public ArrayList c(nr0 nr0Var, jj0 jj0Var) {
        Iterable iterable = (List) nr0Var.g(((q9) this.a).k);
        if (iterable == null) {
            iterable = uq.b;
        }
        ArrayList arrayList = new ArrayList(ae.y0(iterable));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((g) this.b).a((yq0) it.next(), jj0Var));
        }
        return arrayList;
    }

    public qg c(fc0 fc0Var, yq0.b.c cVar, jj0 jj0Var) {
        boolean zI = e.i(xt.M, cVar.s);
        yq0.b.c.EnumC0048c enumC0048c = cVar.d;
        switch (enumC0048c == null ? -1 : i4$a.a[enumC0048c.ordinal()]) {
            case 1:
                byte b = (byte) cVar.f;
                return zI ? new fb1(b) : new ga(b);
            case 2:
                return new ec(Character.valueOf((char) cVar.f));
            case 3:
                short s = (short) cVar.f;
                return zI ? new fb1(s) : new a01(s);
            case 4:
                int i = (int) cVar.f;
                return zI ? new fb1(i) : new b30(i);
            case 5:
                long j = cVar.f;
                return zI ? new fb1(j) : new rf0(j);
            case 6:
                return new bp(cVar.g);
            case 7:
                return new bp(cVar.i);
            case 8:
                return new bp(Boolean.valueOf(cVar.f != 0));
            case 9:
                return new h31(jj0Var.getString(cVar.j));
            case 10:
                return new m90(e.x(jj0Var, cVar.n), cVar.r);
            case 11:
                return new kr(e.x(jj0Var, cVar.n), ij0.d(jj0Var.getString(cVar.o)));
            case 12:
                return new r4(a(cVar.p, jj0Var));
            case 13:
                List list = cVar.q;
                ArrayList arrayList = new ArrayList(ae.y0(list));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(c(((gi0) this.a).k().f(), (yq0.b.c) it.next(), jj0Var));
                }
                return new kn(arrayList, fc0Var);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + cVar.d + " (expected " + fc0Var + ')').toString());
        }
    }

    public void c(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = ((TextView) this.a).getContext().obtainStyledAttributes(attributeSet, b2.i, i, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            lq$c lq_c = (lq$c) ((bj) this.b).a;
            lq_c.getClass();
            boolean z2 = c.j != null;
            lq$a lq_a = lq_c.a;
            lq_a.c = z;
            if (z2) {
                TextView textView = lq_a.a;
                textView.setTransformationMethod(lq_a.e(textView.getTransformationMethod()));
                textView.setFilters(lq_a.a(textView.getFilters()));
            }
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // y1.a
    public boolean c(y1 y1Var, MenuItem menuItem) {
        return ((y1.a) this.a).c(y1Var, menuItem);
    }

    @Override // defpackage.ld
    public boolean c0(w01 w01Var) {
        u01 u01VarH = e4.h(w01Var);
        return (u01VarH == null ? null : e4.d(this, u01VarH)) != null;
    }

    @Override // defpackage.a4
    public List d(dg0 dg0Var, b0 b0Var, x3 x3Var) {
        yx.c cVar;
        yx.e eVar;
        boolean z = b0Var instanceof ar0;
        q9 q9Var = (q9) this.a;
        if (z) {
            cVar = (ar0) b0Var;
            eVar = q9Var.b;
        } else if (b0Var instanceof fr0) {
            cVar = (fr0) b0Var;
            eVar = q9Var.d;
        } else {
            if (!(b0Var instanceof kr0)) {
                throw new IllegalStateException(e4.j("Unknown message: ", b0Var).toString());
            }
            int iOrdinal = x3Var.ordinal();
            if (iOrdinal == 1) {
                cVar = (kr0) b0Var;
                eVar = q9Var.e;
            } else if (iOrdinal == 2) {
                cVar = (kr0) b0Var;
                eVar = q9Var.f;
            } else {
                if (iOrdinal != 3) {
                    d.AnonymousClass0.m("Unsupported callable kind with property proto");
                    return null;
                }
                cVar = (kr0) b0Var;
                eVar = q9Var.g;
            }
        }
        Iterable iterable = (List) cVar.g(eVar);
        if (iterable == null) {
            iterable = uq.b;
        }
        ArrayList arrayList = new ArrayList(ae.y0(iterable));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((g) this.b).a((yq0) it.next(), (jj0) dg0Var.a));
        }
        return arrayList;
    }

    @Override // defpackage.ld
    public u01 d(zt ztVar) {
        return e4.X(ztVar);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [a5, java.lang.Object] */
    @Override // y1.a
    public void d(y1 y1Var) {
        ((y1.a) this.a).d(y1Var);
        f5 f5Var = (f5) this.b;
        if (f5Var.w != null) {
            f5Var.i.getDecorView().removeCallbacks(f5Var.x);
        }
        if (f5Var.v != null) {
            je1 je1Var = f5Var.y;
            if (je1Var != null) {
                je1Var.b();
            }
            je1 je1VarA = qd1.a(f5Var.v);
            je1VarA.a(0.0f);
            f5Var.y = je1VarA;
            je1VarA.d(new j5(1, this));
        }
        f5Var.n.onSupportActionModeFinished(f5Var.u);
        f5Var.u = null;
        ViewGroup viewGroup = f5Var.B;
        WeakHashMap weakHashMap = qd1.a;
        viewGroup.requestApplyInsets();
    }

    public void d(boolean z) {
        lq$c lq_c = (lq$c) ((bj) this.b).a;
        lq_c.getClass();
        if (c.j != null) {
            lq$a lq_a = lq_c.a;
            if (!z) {
                lq_a.getClass();
            } else {
                TextView textView = lq_a.a;
                textView.setTransformationMethod(lq_a.e(textView.getTransformationMethod()));
            }
        }
    }

    @Override // defpackage.ld
    public boolean d0(b91 b91Var, b91 b91Var2) {
        if (!(b91Var instanceof a91) || !(b91Var2 instanceof a91)) {
            d.AnonymousClass0.m$2("Failed requirement.");
            return false;
        }
        if (e4.a(b91Var, b91Var2)) {
            return true;
        }
        a91 a91Var = (a91) b91Var;
        a91 a91Var2 = (a91) b91Var2;
        if (((gc0.a) this.a).a(a91Var, a91Var2)) {
            return true;
        }
        HashMap map = (HashMap) this.b;
        if (map != null) {
            a91 a91Var3 = (a91) map.get(a91Var);
            a91 a91Var4 = (a91) map.get(a91Var2);
            if (a91Var3 != null && a91Var3.equals(a91Var2)) {
                return true;
            }
            if (a91Var4 != null && a91Var4.equals(a91Var)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.a4
    public ArrayList e(pr0 pr0Var, jj0 jj0Var) {
        Iterable iterable = (List) pr0Var.g(((q9) this.a).l);
        if (iterable == null) {
            iterable = uq.b;
        }
        ArrayList arrayList = new ArrayList(ae.y0(iterable));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((g) this.b).a((yq0) it.next(), jj0Var));
        }
        return arrayList;
    }

    @Override // defpackage.ld
    public rb e(w01 w01Var) {
        return e4.d(this, w01Var);
    }

    @Override // defpackage.ld
    public zt e0(jc0 jc0Var) {
        return e4.g(jc0Var);
    }

    public void encipher(int[] iArr, int i) {
        int i2 = iArr[i];
        int i3 = i + 1;
        int i4 = iArr[i3];
        int i5 = 0;
        int i6 = ((int[]) this.a)[0];
        while (true) {
            i2 ^= i6;
            if (i5 > 14) {
                iArr[i] = i4 ^ ((int[]) this.a)[17];
                iArr[i3] = i2;
                return;
            }
            int[] iArr2 = (int[]) this.b;
            int i7 = ((iArr2[(i2 >> 24) & 255] + iArr2[((i2 >> 16) & 255) | 256]) ^ iArr2[((i2 >> 8) & 255) | 512]) + iArr2[(i2 & 255) | 768];
            int[] iArr3 = (int[]) this.a;
            i4 ^= i7 ^ iArr3[i5 + 1];
            i5 += 2;
            i6 = iArr3[i5] ^ (((iArr2[(i4 >> 24) & 255] + iArr2[((i4 >> 16) & 255) | 256]) ^ iArr2[((i4 >> 8) & 255) | 512]) + iArr2[(i4 & 255) | 768]);
        }
    }

    @Override // defpackage.a4
    public List f(dg0 dg0Var, kr0 kr0Var) {
        return uq.b;
    }

    @Override // defpackage.ld
    public u01 f(zt ztVar) {
        return e4.k0(ztVar);
    }

    @Override // defpackage.ld
    public a91 f0(jc0 jc0Var) {
        u01 u01VarH = e4.h(jc0Var);
        if (u01VarH == null) {
            zt ztVarE0 = e0(jc0Var);
            u01VarH = ztVarE0 == null ? a(jc0Var) : d(ztVarE0);
        }
        return e4.j0(u01VarH);
    }

    @Override // defpackage.a4
    public ArrayList g(vr0$a vr0_a) {
        Iterable iterable = (List) vr0_a.d.g(((q9) this.a).c);
        if (iterable == null) {
            iterable = uq.b;
        }
        ArrayList arrayList = new ArrayList(ae.y0(iterable));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((g) this.b).a((yq0) it.next(), (jj0) vr0_a.a));
        }
        return arrayList;
    }

    @Override // defpackage.ld
    public boolean g0(a91 a91Var) {
        return e4.L(a91Var);
    }

    public File get() {
        if (((File) this.a) == null) {
            this.a = new File(((Context) this.b).getCacheDir(), "volley");
        }
        return (File) this.a;
    }

    public BitMatrix getBlackMatrix() throws NotFoundException {
        int[] iArr;
        if (((BitMatrix) this.b) == null) {
            m6 m6Var = (m6) this.a;
            xt.c cVar = (xt.c) m6Var.a;
            int i = cVar.b;
            int i2 = cVar.a;
            BitMatrix bitMatrix = new BitMatrix(i, i2);
            if (((byte[]) m6Var.c).length < i) {
                m6Var.c = new byte[i];
            }
            int i3 = 0;
            while (true) {
                iArr = (int[]) m6Var.b;
                if (i3 >= 32) {
                    break;
                }
                iArr[i3] = 0;
                i3++;
            }
            for (int i4 = 1; i4 < 5; i4++) {
                byte[] row = cVar.getRow((byte[]) m6Var.c, (i2 * i4) / 5);
                int i5 = (i << 2) / 5;
                for (int i6 = i / 5; i6 < i5; i6++) {
                    int i7 = (row[i6] & GZIPHeader.OS_UNKNOWN) >> 3;
                    iArr[i7] = iArr[i7] + 1;
                }
            }
            int length = iArr.length;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                int i12 = iArr[i11];
                if (i12 > i8) {
                    i10 = i11;
                    i8 = i12;
                }
                if (i12 > i9) {
                    i9 = i12;
                }
            }
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < length; i15++) {
                int i16 = i15 - i10;
                int i17 = iArr[i15] * i16 * i16;
                if (i17 > i14) {
                    i13 = i15;
                    i14 = i17;
                }
            }
            if (i10 <= i13) {
                int i18 = i10;
                i10 = i13;
                i13 = i18;
            }
            if (i10 - i13 <= length / 16) {
                throw NotFoundException.INSTANCE;
            }
            int i19 = i10 - 1;
            int i20 = -1;
            int i21 = i19;
            while (i19 > i13) {
                int i22 = i19 - i13;
                int i23 = (i9 - iArr[i19]) * (i10 - i19) * i22 * i22;
                if (i23 > i20) {
                    i21 = i19;
                    i20 = i23;
                }
                i19--;
            }
            int i24 = i21 << 3;
            byte[] matrix = cVar.getMatrix();
            for (int i25 = 0; i25 < i2; i25++) {
                int i26 = i25 * i;
                for (int i27 = 0; i27 < i; i27++) {
                    if ((matrix[i26 + i27] & GZIPHeader.OS_UNKNOWN) < i24) {
                        bitMatrix.set(i27, i25);
                    }
                }
            }
            this.b = bitMatrix;
        }
        return (BitMatrix) this.b;
    }

    public LineData getData() {
        return ((BarLineChartBase) this.a).mData;
    }

    public float getDistance(float f, float f2, float f3, float f4) {
        return (float) Math.hypot(f - f3, f2 - f4);
    }

    public Highlight getHighlight(float f, float f2) {
        MPPointD valuesByTouchPoint = ((BarLineChartBase) this.a).getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(f, f2);
        float f3 = (float) valuesByTouchPoint.x;
        MPPointD.recycleInstance(valuesByTouchPoint);
        return getHighlightForX(f3, f, f2);
    }

    public Highlight getHighlightForX(float f, float f2, float f3) {
        List highlightsAtXValue = getHighlightsAtXValue(f);
        Highlight highlight = null;
        if (highlightsAtXValue.isEmpty()) {
            return null;
        }
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        float minimumDistance = getMinimumDistance(highlightsAtXValue, f3, axisDependency);
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        if (minimumDistance >= getMinimumDistance(highlightsAtXValue, f3, axisDependency2)) {
            axisDependency = axisDependency2;
        }
        float f4 = ((BarLineChartBase) this.a).mMaxHighlightDistance;
        for (int i = 0; i < highlightsAtXValue.size(); i++) {
            Highlight highlight2 = (Highlight) highlightsAtXValue.get(i);
            if (highlight2.axis == axisDependency) {
                float distance = getDistance(f2, f3, highlight2.mXPx, highlight2.mYPx);
                if (distance < f4) {
                    highlight = highlight2;
                    f4 = distance;
                }
            }
        }
        return highlight;
    }

    public List getHighlightsAtXValue(float f) {
        ArrayList arrayList = (ArrayList) this.b;
        arrayList.clear();
        LineData data = getData();
        if (data != null) {
            ArrayList arrayList2 = data.mDataSets;
            int size = arrayList2 == null ? 0 : arrayList2.size();
            for (int i = 0; i < size; i++) {
                IDataSet dataSetByIndex = data.getDataSetByIndex(i);
                if (((LineDataSet) dataSetByIndex).mHighlightEnabled) {
                    DataSet$Rounding[] dataSet$RoundingArr = DataSet$Rounding.$VALUES;
                    arrayList.addAll(buildHighlights(dataSetByIndex, i, f));
                }
            }
        }
        return arrayList;
    }

    @Override // defpackage.jj0
    public String getString(int i) {
        return (String) ((mr0) this.a).c.get(i);
    }

    @Override // defpackage.a4
    public List h(vr0$a vr0_a, dr0 dr0Var) {
        Iterable iterable = (List) dr0Var.g(((q9) this.a).h);
        if (iterable == null) {
            iterable = uq.b;
        }
        ArrayList arrayList = new ArrayList(ae.y0(iterable));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((g) this.b).a((yq0) it.next(), (jj0) vr0_a.a));
        }
        return arrayList;
    }

    @Override // defpackage.ld
    public boolean h(rb rbVar) {
        return rbVar instanceof jb;
    }

    @Override // defpackage.ld
    public u01 h0(ml mlVar) {
        return mlVar.c;
    }

    public void hash(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.a = (int[]) P_orig.clone();
        int[] iArr = (int[]) S_orig.clone();
        this.b = iArr;
        int[] iArr2 = {0};
        int[] iArr3 = {0};
        int[] iArr4 = {0, 0};
        int length = ((int[]) this.a).length;
        int length2 = iArr.length;
        for (int i = 0; i < length; i++) {
            int[] iArr5 = (int[]) this.a;
            iArr5[i] = iArr5[i] ^ streamtoword(bArr, iArr2);
        }
        for (int i2 = 0; i2 < length; i2 += 2) {
            iArr4[0] = iArr4[0] ^ streamtoword(bArr2, iArr3);
            iArr4[1] = iArr4[1] ^ streamtoword(bArr2, iArr3);
            encipher(iArr4, 0);
            int[] iArr6 = (int[]) this.a;
            iArr6[i2] = iArr4[0];
            iArr6[i2 + 1] = iArr4[1];
        }
        for (int i3 = 0; i3 < length2; i3 += 2) {
            iArr4[0] = iArr4[0] ^ streamtoword(bArr2, iArr3);
            iArr4[1] = iArr4[1] ^ streamtoword(bArr2, iArr3);
            encipher(iArr4, 0);
            int[] iArr7 = (int[]) this.b;
            iArr7[i3] = iArr4[0];
            iArr7[i3 + 1] = iArr4[1];
        }
        for (int i4 = 0; i4 < 64; i4++) {
            key(bArr2);
            key(bArr);
        }
        int[] iArr8 = new int[8];
        System.arraycopy(openbsd_iv, 0, iArr8, 0, 8);
        for (int i5 = 0; i5 < 8; i5 += 2) {
            for (int i6 = 0; i6 < 64; i6++) {
                encipher(iArr8, i5);
            }
        }
        int i7 = 0;
        for (int i8 = 0; i8 < 8; i8++) {
            int i9 = iArr8[i8];
            bArr3[i7] = (byte) (i9 & 255);
            bArr3[i7 + 1] = (byte) ((i9 >> 8) & 255);
            int i10 = i7 + 3;
            bArr3[i7 + 2] = (byte) ((i9 >> 16) & 255);
            i7 += 4;
            bArr3[i10] = (byte) ((i9 >> 24) & 255);
        }
    }

    @Override // defpackage.ld
    public int i(w81 w81Var) {
        return e4.f0(this, w81Var);
    }

    @Override // defpackage.a4
    public List i(dg0 dg0Var, kr0 kr0Var) {
        return uq.b;
    }

    @Override // defpackage.ld
    public boolean i0(a91 a91Var) {
        return e4.F(a91Var);
    }

    @Override // defpackage.a4
    public Object j(dg0 dg0Var, kr0 kr0Var, fc0 fc0Var) {
        yq0.b.c cVar = (yq0.b.c) e.z(kr0Var, ((q9) this.a).i);
        if (cVar == null) {
            return null;
        }
        return ((g) this.b).c(fc0Var, cVar, (jj0) dg0Var.a);
    }

    @Override // defpackage.ld
    public boolean j(jc0 jc0Var) {
        zt ztVarG = e4.g(jc0Var);
        return (ztVarG == null ? null : e4.f(ztVarG)) != null;
    }

    @Override // defpackage.ld
    public boolean j0(rb rbVar) {
        return e4.S(rbVar);
    }

    @Override // defpackage.ld
    public cc1 k(ca1 ca1Var) {
        return e4.v(ca1Var);
    }

    @Override // defpackage.ld
    public ca1 k0(w81 w81Var, int i) {
        return e4.m(this, w81Var, i);
    }

    public void key(byte[] bArr) {
        int[] iArr = {0};
        int[] iArr2 = {0, 0};
        int length = ((int[]) this.a).length;
        int length2 = ((int[]) this.b).length;
        for (int i = 0; i < length; i++) {
            int[] iArr3 = (int[]) this.a;
            iArr3[i] = iArr3[i] ^ streamtoword(bArr, iArr);
        }
        for (int i2 = 0; i2 < length; i2 += 2) {
            encipher(iArr2, 0);
            int[] iArr4 = (int[]) this.a;
            iArr4[i2] = iArr2[0];
            iArr4[i2 + 1] = iArr2[1];
        }
        for (int i3 = 0; i3 < length2; i3 += 2) {
            encipher(iArr2, 0);
            int[] iArr5 = (int[]) this.b;
            iArr5[i3] = iArr2[0];
            iArr5[i3 + 1] = iArr2[1];
        }
    }

    @Override // defpackage.ld
    public boolean l(a91 a91Var) {
        return e4.M(a91Var);
    }

    @Override // defpackage.ld
    public int l0(ca1 ca1Var) {
        return e4.y(ca1Var);
    }

    @Override // defpackage.ld
    public boolean m(b91 b91Var) {
        return e4.G(b91Var);
    }

    @Override // defpackage.ld
    public cc1 m0(u01 u01Var, u01 u01Var2) {
        return e4.l(this, u01Var, u01Var2);
    }

    @Override // defpackage.ld
    public ml n0(w01 w01Var) {
        return e4.e(w01Var);
    }

    @Override // defpackage.ld
    public cc1 o(rb rbVar) {
        return e4.Z(rbVar);
    }

    @Override // defpackage.ld
    public Set p(w01 w01Var) {
        return e4.d0(this, w01Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [yd] */
    /* JADX WARN: Type inference failed for: r10v11, types: [yd] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r12v11, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.io.InputStream] */
    public Response performRequest(StringRequest stringRequest) throws Throwable {
        Response response;
        int i;
        int i2;
        ?? ExecuteRequest;
        ?? InputStreamToBytes;
        g gVar;
        Map map;
        int i3;
        List listUnmodifiableList;
        ?? r12;
        String str = stringRequest.mUrl;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            int i4 = 3;
            try {
                Cache$Entry cache$Entry = stringRequest.mCacheEntry;
                if (cache$Entry == null) {
                    map = Collections.EMPTY_MAP;
                    response = null;
                } else {
                    HashMap map2 = new HashMap();
                    String str2 = cache$Entry.etag;
                    if (str2 != null) {
                        map2.put("If-None-Match", str2);
                    }
                    long j = cache$Entry.lastModified;
                    if (j > 0) {
                        response = null;
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                        map2.put("If-Modified-Since", simpleDateFormat.format(new Date(j)));
                    } else {
                        response = null;
                    }
                    map = map2;
                }
                try {
                    ((HurlStack) this.a).getClass();
                    ExecuteRequest = HurlStack.executeRequest(stringRequest, map);
                    try {
                        i3 = ExecuteRequest.c;
                        listUnmodifiableList = Collections.unmodifiableList((ArrayList) ExecuteRequest.d);
                        if (i3 == 304) {
                            SystemClock.elapsedRealtime();
                            return Hex.getNotModifiedNetworkResponse(stringRequest, listUnmodifiableList);
                        }
                        InputStream inputStream = (InputStream) ExecuteRequest.a;
                        if (inputStream == null) {
                            r12 = inputStream;
                            r12 = response;
                        }
                        if (r12 != 0) {
                            try {
                                InputStreamToBytes = Hex.inputStreamToBytes(r12, ExecuteRequest.b, (yd) this.b);
                            } catch (IOException e) {
                                e = e;
                                InputStreamToBytes = response;
                            }
                        } else {
                            InputStreamToBytes = new byte[0];
                        }
                        try {
                            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                            if (!VolleyLog.DEBUG && jElapsedRealtime2 <= 3000) {
                                break;
                            }
                            i = 1;
                            try {
                                i2 = 2;
                                try {
                                    VolleyLog.buildMessage("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", stringRequest, Long.valueOf(jElapsedRealtime2), InputStreamToBytes != 0 ? Integer.valueOf(InputStreamToBytes.length) : "null", Integer.valueOf(i3), Integer.valueOf(stringRequest.mRetryPolicy.a));
                                    break;
                                } catch (IOException e2) {
                                    e = e2;
                                }
                            } catch (IOException e3) {
                                e = e3;
                                i2 = 2;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            i = 1;
                        }
                        e = e;
                        InputStreamToBytes = response;
                        i = 1;
                        i2 = 2;
                    } catch (IOException e5) {
                        e = e5;
                        i = 1;
                        i2 = 2;
                        InputStreamToBytes = response;
                    }
                } catch (IOException e6) {
                    e = e6;
                    i = 1;
                    i2 = 2;
                    ExecuteRequest = response;
                    InputStreamToBytes = ExecuteRequest;
                }
            } catch (IOException e7) {
                e = e7;
                response = null;
            }
            if (e instanceof SocketTimeoutException) {
                gVar = new g(i4, "socket", new ServerError());
            } else {
                if (e instanceof MalformedURLException) {
                    d.AnonymousClass0.m("Bad URL ", (Object) str, (Throwable) e);
                    return response;
                }
                if (ExecuteRequest == 0) {
                    throw new NoConnectionError(e);
                }
                int i5 = ExecuteRequest.c;
                Object[] objArr = new Object[i2];
                objArr[0] = Integer.valueOf(i5);
                objArr[i] = str;
                VolleyLog.buildMessage("Unexpected response code %d for %s", objArr);
                if (InputStreamToBytes != 0) {
                    List listUnmodifiableList2 = Collections.unmodifiableList((ArrayList) ExecuteRequest.d);
                    SystemClock.elapsedRealtime();
                    new Response(InputStreamToBytes, false, listUnmodifiableList2);
                    if (i5 != 401 && i5 != 403) {
                        if (i5 < 400 || i5 > 499) {
                            throw new ServerError();
                        }
                        throw new ClientError();
                    }
                    gVar = new g(i4, "auth", new ServerError());
                } else {
                    gVar = new g(i4, "network", new ServerError());
                }
            }
            String str3 = (String) gVar.b;
            hk0 hk0Var = stringRequest.mRetryPolicy;
            int i6 = hk0Var.b;
            try {
                VolleyError volleyError = (VolleyError) gVar.a;
                int i7 = hk0Var.a + 1;
                hk0Var.a = i7;
                hk0Var.b = ((int) (i6 * 1.0f)) + i6;
                if (i7 > i) {
                    throw volleyError;
                }
                stringRequest.addMarker(str3 + "-retry [timeout=" + i6 + "]");
            } catch (VolleyError e8) {
                stringRequest.addMarker(str3 + "-timeout-giveup [timeout=" + i6 + "]");
                throw e8;
            }
        }
        if (i3 < 200 || i3 > 299) {
            throw new IOException();
        }
        SystemClock.elapsedRealtime();
        return new Response(InputStreamToBytes, false, listUnmodifiableList);
    }

    public void putMetadata(ResultMetadataType resultMetadataType, Object obj) {
        if (((EnumMap) this.a) == null) {
            this.a = new EnumMap(ResultMetadataType.class);
        }
        ((EnumMap) this.a).put(resultMetadataType, obj);
    }

    @Override // defpackage.ld
    public boolean q(w01 w01Var) {
        return e4.J(w01Var);
    }

    @Override // defpackage.ld
    public ib r(rb rbVar) {
        return e4.k(rbVar);
    }

    @Override // defpackage.ld
    public boolean s(cc1 cc1Var) {
        return F(V(cc1Var)) != F(z(cc1Var));
    }

    @Override // defpackage.ld
    public boolean t(jc0 jc0Var) {
        u01 u01VarH = e4.h(jc0Var);
        return (u01VarH == null ? null : e4.e(u01VarH)) != null;
    }

    public String toString() {
        int i = this.G0;
        if (i == 7) {
            try {
                return getBlackMatrix().toString();
            } catch (NotFoundException unused) {
                return AppConfig.CUSTOM;
            }
        }
        if (i == 8) {
            return (String) this.b;
        }
        if (i != 28) {
            return super.toString();
        }
        String string = "[ ";
        if (((q11) this.a) != null) {
            for (int i2 = 0; i2 < 9; i2++) {
                StringBuilder sbD = e.d(string);
                sbD.append(((q11) this.a).n[i2]);
                sbD.append(" ");
                string = sbD.toString();
            }
        }
        StringBuilder sbO = ak.o(string, "] ");
        sbO.append((q11) this.a);
        return sbO.toString();
    }

    @Override // defpackage.ld
    public md u(w01 w01Var) {
        return e4.g0(this, w01Var);
    }

    @Override // defpackage.ld
    public boolean w(w01 w01Var) {
        return e4.L(e4.j0(w01Var));
    }

    @Override // defpackage.ld
    public u01 x(w01 w01Var) {
        return e4.j(w01Var);
    }

    @Override // defpackage.ld
    public int y(a91 a91Var) {
        return e4.c0(a91Var);
    }

    @Override // defpackage.ld
    public u01 z(jc0 jc0Var) {
        zt ztVarE0 = e0(jc0Var);
        return ztVarE0 == null ? a(jc0Var) : f(ztVarE0);
    }
}
