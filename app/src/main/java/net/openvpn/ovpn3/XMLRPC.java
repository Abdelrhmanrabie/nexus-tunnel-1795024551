package net.openvpn.ovpn3;

import android.util.Base64;
import defpackage.ak;
import defpackage.e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class XMLRPC {
    public static final String TAG = "rocket";
    public static final String TAG_DATA = "data";
    public static final String TAG_MEMBER = "member";
    public static final String TAG_NAME = "name";
    public static final String TAG_VALUE = "value";
    public static final String TYPE_ARRAY = "array";
    public static final String TYPE_BASE64 = "base64";
    public static final String TYPE_BOOLEAN = "boolean";
    public static final String TYPE_DATE_TIME_ISO8601 = "dateTime.iso8601";
    public static final String TYPE_DOUBLE = "double";
    public static final String TYPE_I4 = "i4";
    public static final String TYPE_I8 = "i8";
    public static final String TYPE_INT = "int";
    public static final String TYPE_STRING = "string";
    public static final String TYPE_STRUCT = "struct";
    public static final String DATETIME_FORMAT = "yyyyMMdd'T'HH:mm:ss";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATETIME_FORMAT);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface Serializable {
        Object getSerializable();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class Tag {
        static final String FAULT = "fault";
        static final String FAULT_CODE = "faultCode";
        static final String FAULT_STRING = "faultString";
        static final String LOG = "XMLRPC";
        static final String METHOD_CALL = "methodCall";
        static final String METHOD_NAME = "methodName";
        static final String METHOD_RESPONSE = "methodResponse";
        static final String PARAM = "param";
        static final String PARAMS = "params";
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class XMLRPCException extends Exception {
        public XMLRPCException(Exception exc) {
            super(exc);
        }

        public XMLRPCException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class XMLRPCFault extends XMLRPCException {
        private int faultCode;
        private String faultString;

        public XMLRPCFault(String str, int i) {
            super("XMLRPC Fault: " + str + " [code " + i + "]");
            this.faultString = str;
            this.faultCode = i;
        }

        public int getFaultCode() {
            return this.faultCode;
        }

        public String getFaultString() {
            return this.faultString;
        }
    }

    public static Object deserialize(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String name;
        boolean z;
        Object objValueOf;
        xmlPullParser.require(2, null, TAG_VALUE);
        if (xmlPullParser.isEmptyElementTag()) {
            return AppConfig.CUSTOM;
        }
        try {
            xmlPullParser.nextTag();
            name = xmlPullParser.getName();
            try {
                if (name.equals(TAG_VALUE) && xmlPullParser.getEventType() == 3) {
                    return AppConfig.CUSTOM;
                }
                z = true;
                if (!z) {
                    objValueOf = xmlPullParser.getText();
                } else if (name.equals(TYPE_INT) || name.equals(TYPE_I4)) {
                    objValueOf = Integer.valueOf(Integer.parseInt(xmlPullParser.nextText()));
                } else if (name.equals(TYPE_I8)) {
                    objValueOf = Long.valueOf(Long.parseLong(xmlPullParser.nextText()));
                } else if (name.equals(TYPE_DOUBLE)) {
                    objValueOf = Double.valueOf(Double.parseDouble(xmlPullParser.nextText()));
                } else if (name.equals(TYPE_BOOLEAN)) {
                    objValueOf = xmlPullParser.nextText().equals("1") ? Boolean.TRUE : Boolean.FALSE;
                } else if (name.equals(TYPE_STRING)) {
                    objValueOf = xmlPullParser.nextText();
                } else if (name.equals(TYPE_DATE_TIME_ISO8601)) {
                    String strNextText = xmlPullParser.nextText();
                    try {
                        objValueOf = dateFormat.parseObject(strNextText);
                    } catch (ParseException unused) {
                        throw new IOException(ak.m("Cannot deserialize dateTime ", strNextText));
                    }
                } else if (name.equals(TYPE_BASE64)) {
                    BufferedReader bufferedReader = new BufferedReader(new StringReader(xmlPullParser.nextText()));
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        stringBuffer.append(line);
                    }
                    objValueOf = Base64.decode(stringBuffer.toString(), 0);
                } else if (name.equals(TYPE_ARRAY)) {
                    xmlPullParser.nextTag();
                    xmlPullParser.require(2, null, TAG_DATA);
                    xmlPullParser.nextTag();
                    ArrayList arrayList = new ArrayList();
                    while (xmlPullParser.getName().equals(TAG_VALUE)) {
                        arrayList.add(deserialize(xmlPullParser));
                        xmlPullParser.nextTag();
                    }
                    xmlPullParser.require(3, null, TAG_DATA);
                    xmlPullParser.nextTag();
                    xmlPullParser.require(3, null, TYPE_ARRAY);
                    objValueOf = arrayList.toArray();
                } else {
                    if (!name.equals(TYPE_STRUCT)) {
                        throw new IOException(ak.AnonymousClass0.m("Cannot deserialize ", xmlPullParser.getName()));
                    }
                    xmlPullParser.nextTag();
                    HashMap map = new HashMap();
                    while (xmlPullParser.getName().equals(TAG_MEMBER)) {
                        String strNextText2 = null;
                        Object objDeserialize = null;
                        while (true) {
                            xmlPullParser.nextTag();
                            String name2 = xmlPullParser.getName();
                            if (name2.equals(TAG_NAME)) {
                                strNextText2 = xmlPullParser.nextText();
                            } else {
                                if (!name2.equals(TAG_VALUE)) {
                                    break;
                                }
                                objDeserialize = deserialize(xmlPullParser);
                            }
                        }
                        if (strNextText2 != null && objDeserialize != null) {
                            map.put(strNextText2, objDeserialize);
                        }
                        xmlPullParser.require(3, null, TAG_MEMBER);
                        xmlPullParser.nextTag();
                    }
                    xmlPullParser.require(3, null, TYPE_STRUCT);
                    objValueOf = null;
                }
                xmlPullParser.nextTag();
                xmlPullParser.require(3, null, TAG_VALUE);
                return objValueOf;
            } catch (XmlPullParserException unused2) {
                z = false;
            }
        } catch (XmlPullParserException unused3) {
            name = null;
        }
    }

    public static Object parse_response(XmlPullParser xmlPullParser) throws XmlPullParserException, XMLRPCException, IOException {
        xmlPullParser.nextTag();
        xmlPullParser.require(2, null, "methodResponse");
        xmlPullParser.nextTag();
        String name = xmlPullParser.getName();
        if (name.equals("params")) {
            xmlPullParser.nextTag();
            xmlPullParser.require(2, null, "param");
            xmlPullParser.nextTag();
            return deserialize(xmlPullParser);
        }
        if (!name.equals("fault")) {
            throw new XMLRPCException(e.n("Bad tag <", name, "> in XMLRPC response - neither <params> nor <fault>"));
        }
        xmlPullParser.nextTag();
        Map map = (Map) deserialize(xmlPullParser);
        throw new XMLRPCFault((String) map.get("faultString"), ((Integer) map.get("faultCode")).intValue());
    }

    public static void serialize(XmlSerializer xmlSerializer, Object obj) throws IOException {
        String str;
        String string;
        XmlSerializer xmlSerializerStartTag;
        if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
            str = TYPE_I4;
        } else if (obj instanceof Long) {
            str = TYPE_I8;
        } else {
            if (!(obj instanceof Double) && !(obj instanceof Float)) {
                if (!(obj instanceof Boolean)) {
                    if (obj instanceof String) {
                        str = TYPE_STRING;
                    } else if ((obj instanceof Date) || (obj instanceof Calendar)) {
                        str = TYPE_DATE_TIME_ISO8601;
                        xmlSerializerStartTag = xmlSerializer.startTag(null, TYPE_DATE_TIME_ISO8601);
                        string = dateFormat.format(obj);
                    } else {
                        if (!(obj instanceof byte[])) {
                            if (obj instanceof List) {
                                xmlSerializer.startTag(null, TYPE_ARRAY).startTag(null, TAG_DATA);
                                for (Object obj2 : (List) obj) {
                                    xmlSerializer.startTag(null, TAG_VALUE);
                                    serialize(xmlSerializer, obj2);
                                    xmlSerializer.endTag(null, TAG_VALUE);
                                }
                            } else if (obj instanceof Object[]) {
                                xmlSerializer.startTag(null, TYPE_ARRAY).startTag(null, TAG_DATA);
                                for (Object obj3 : (Object[]) obj) {
                                    xmlSerializer.startTag(null, TAG_VALUE);
                                    serialize(xmlSerializer, obj3);
                                    xmlSerializer.endTag(null, TAG_VALUE);
                                }
                            } else {
                                if (!(obj instanceof Map)) {
                                    if (!(obj instanceof Serializable)) {
                                        throw new IOException("Cannot serialize " + obj);
                                    }
                                    serialize(xmlSerializer, ((Serializable) obj).getSerializable());
                                    return;
                                }
                                str = TYPE_STRUCT;
                                xmlSerializer.startTag(null, TYPE_STRUCT);
                                for (Map.Entry entry : ((Map) obj).entrySet()) {
                                    String str2 = (String) entry.getKey();
                                    Object value = entry.getValue();
                                    xmlSerializer.startTag(null, TAG_MEMBER);
                                    xmlSerializer.startTag(null, TAG_NAME).text(str2).endTag(null, TAG_NAME);
                                    xmlSerializer.startTag(null, TAG_VALUE);
                                    serialize(xmlSerializer, value);
                                    xmlSerializer.endTag(null, TAG_VALUE);
                                    xmlSerializer.endTag(null, TAG_MEMBER);
                                }
                            }
                            xmlSerializer.endTag(null, TAG_DATA).endTag(null, TYPE_ARRAY);
                            return;
                        }
                        str = TYPE_BASE64;
                        xmlSerializerStartTag = xmlSerializer.startTag(null, TYPE_BASE64);
                        string = Base64.encodeToString((byte[]) obj, 2);
                    }
                    xmlSerializer.endTag(null, str);
                }
                str = TYPE_BOOLEAN;
                xmlSerializerStartTag = xmlSerializer.startTag(null, TYPE_BOOLEAN);
                string = ((Boolean) obj).booleanValue() ? "1" : "0";
                xmlSerializer = xmlSerializerStartTag.text(string);
                xmlSerializer.endTag(null, str);
            }
            str = TYPE_DOUBLE;
        }
        xmlSerializerStartTag = xmlSerializer.startTag(null, str);
        string = obj.toString();
        xmlSerializer = xmlSerializerStartTag.text(string);
        xmlSerializer.endTag(null, str);
    }
}
