package com.trilead.ssh2;

import com.trilead.ssh2.sftp.ErrorCodes;
import defpackage.ak;
import defpackage.fb$1;
import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class SFTPException extends IOException {
    private static final long serialVersionUID = 578654644222421811L;
    private final int sftpErrorCode;
    private final String sftpErrorMessage;

    public SFTPException(String str, int i) {
        super(constructMessage(str, i));
        this.sftpErrorMessage = str;
        this.sftpErrorCode = i;
    }

    private static String constructMessage(String str, int i) {
        String[] description = ErrorCodes.getDescription(i);
        if (description == null) {
            return ak.j(str, " (UNKNOW SFTP ERROR CODE)");
        }
        StringBuilder sbO = ak.o(str, " (");
        sbO.append(description[0]);
        sbO.append(": ");
        return fb$1.m(sbO, description[1], ")");
    }

    public int getServerErrorCode() {
        return this.sftpErrorCode;
    }

    public String getServerErrorCodeSymbol() {
        String[] description = ErrorCodes.getDescription(this.sftpErrorCode);
        if (description != null) {
            return description[0];
        }
        return "UNKNOW SFTP ERROR CODE " + this.sftpErrorCode;
    }

    public String getServerErrorCodeVerbose() {
        String[] description = ErrorCodes.getDescription(this.sftpErrorCode);
        if (description != null) {
            return description[1];
        }
        return "The error code " + this.sftpErrorCode + " is unknown.";
    }

    public String getServerErrorMessage() {
        return this.sftpErrorMessage;
    }
}
