package com.brainydroid.daydreaming.db;

import android.util.Log;
import com.brainydroid.daydreaming.ui.Config;

// FIXME: adapt doc imported from LocationPoint
public abstract class StatusModel<T extends StatusModel<T,S>,
        S extends StatusModelStorage<T,S>> extends Model<T,S> {

    private static String TAG = "StatusModel";

    public static final String COL_STATUS = "status";

    // These members don't need to be serialized
    private transient String status;

    /**
     * Set the status of the {@code LocationPoint}, and persist to database
     * if necessary.
     * <p/>
     * A value of {@code LocationPoint.STATUS_COLLECTING} means the {@code
     * LocationPoint} is either waiting for its timestamp or still has a
     * listener registered on a location provider,
     * receiving location updates. A value of {@code
     * LocationPoint.STATUS_COMPLETED} means the instance has finished
     * collecting its relevant data and has been closed,
     * but not necessarily persisted to the database (that is an independent
     * property).
     *
     * @param status Status to set, should be one of {@code
     *               LocationPoint.STATUS_COLLECTING} or {@code
     *               LocationPoint.STATUS_COMPLETED}
     */
    public void setStatus(String status) {

        // Debug
        if (Config.LOGD) {
            Log.d(TAG, "[fn] setStatus");
        }

        this.status = status;
        saveIfSync();
    }

    /**
     * Get the status of the {@code LocationPoint}.
     * <p/>
     * See {@code setStatus()} for details on the meaning of this status.
     *
     * @return Current status of the {@code LocationPoint}
     */
    public String getStatus() {

        // Verbose
        if (Config.LOGV) {
            Log.v(TAG, "[fn] getStatus");
        }

        return status;
    }

}
