package net.lingala.zip4j.tasks;

import defpackage.d;
import java.io.IOException;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.io.outputstream.SplitOutputStream;
import net.lingala.zip4j.model.EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class SetCommentTask extends AsyncZipTask<SetCommentTaskTaskParameters> {
    private final ZipModel zipModel;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class SetCommentTaskTaskParameters extends AbstractZipTaskParameters {
        private String comment;

        public SetCommentTaskTaskParameters(String str, Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.comment = str;
        }
    }

    public SetCommentTask(ZipModel zipModel, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.zipModel = zipModel;
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public long calculateTotalWork(SetCommentTaskTaskParameters setCommentTaskTaskParameters) {
        return 0L;
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public void executeTask(SetCommentTaskTaskParameters setCommentTaskTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        if (setCommentTaskTaskParameters.comment == null) {
            d.AnonymousClass0.m$5("comment is null, cannot update Zip file with comment");
            return;
        }
        EndOfCentralDirectoryRecord endOfCentralDirectoryRecord = this.zipModel.getEndOfCentralDirectoryRecord();
        endOfCentralDirectoryRecord.setComment(setCommentTaskTaskParameters.comment);
        SplitOutputStream splitOutputStream = new SplitOutputStream(this.zipModel.getZipFile());
        try {
            splitOutputStream.seek(this.zipModel.isZip64Format() ? this.zipModel.getZip64EndOfCentralDirectoryRecord().getOffsetStartCentralDirectoryWRTStartDiskNumber() : endOfCentralDirectoryRecord.getOffsetOfStartOfCentralDirectory());
            new HeaderWriter().finalizeZipFileWithoutValidations(this.zipModel, splitOutputStream, setCommentTaskTaskParameters.zip4jConfig.getCharset());
            splitOutputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    splitOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public ProgressMonitor.Task getTask() {
        return ProgressMonitor.Task.SET_COMMENT;
    }
}
