package net.lingala.zip4j.tasks;

import defpackage.d;
import java.util.concurrent.ExecutorService;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.progress.ProgressMonitor;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class AsyncZipTask<T> {
    private final ExecutorService executorService;
    private final ProgressMonitor progressMonitor;
    private final boolean runInThread;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class AsyncTaskParameters {
        private final ExecutorService executorService;
        private final ProgressMonitor progressMonitor;
        private final boolean runInThread;

        public AsyncTaskParameters(ExecutorService executorService, boolean z, ProgressMonitor progressMonitor) {
            this.executorService = executorService;
            this.runInThread = z;
            this.progressMonitor = progressMonitor;
        }
    }

    public AsyncZipTask(AsyncTaskParameters asyncTaskParameters) {
        this.progressMonitor = asyncTaskParameters.progressMonitor;
        this.runInThread = asyncTaskParameters.runInThread;
        this.executorService = asyncTaskParameters.executorService;
    }

    private void initProgressMonitor() {
        this.progressMonitor.fullReset();
        this.progressMonitor.setState(ProgressMonitor.State.BUSY);
        this.progressMonitor.setCurrentTask(getTask());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performTaskWithErrorHandling(T t, ProgressMonitor progressMonitor) throws ZipException {
        try {
            executeTask(t, progressMonitor);
            progressMonitor.endProgressMonitor();
        } catch (ZipException e) {
            progressMonitor.endProgressMonitor(e);
            throw e;
        } catch (Exception e2) {
            progressMonitor.endProgressMonitor(e2);
            throw new ZipException(e2);
        }
    }

    public abstract long calculateTotalWork(T t);

    public void execute(final T t) throws ZipException {
        if (this.runInThread && ProgressMonitor.State.BUSY.equals(this.progressMonitor.getState())) {
            d.AnonymousClass0.m$5("invalid operation - Zip4j is in busy state");
            return;
        }
        initProgressMonitor();
        if (!this.runInThread) {
            performTaskWithErrorHandling(t, this.progressMonitor);
            return;
        }
        this.progressMonitor.setTotalWork(calculateTotalWork(t));
        this.executorService.execute(new Runnable() { // from class: net.lingala.zip4j.tasks.AsyncZipTask.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AsyncZipTask asyncZipTask = AsyncZipTask.this;
                    asyncZipTask.performTaskWithErrorHandling(t, asyncZipTask.progressMonitor);
                } catch (ZipException unused) {
                } finally {
                    AsyncZipTask.this.executorService.shutdown();
                }
            }
        });
    }

    public abstract void executeTask(T t, ProgressMonitor progressMonitor);

    public abstract ProgressMonitor.Task getTask();

    public void verifyIfTaskIsCancelled() throws ZipException {
        if (this.progressMonitor.isCancelAllTasks()) {
            this.progressMonitor.setResult(ProgressMonitor.Result.CANCELLED);
            this.progressMonitor.setState(ProgressMonitor.State.READY);
            throw new ZipException("Task cancelled", ZipException.Type.TASK_CANCELLED_EXCEPTION);
        }
    }
}
