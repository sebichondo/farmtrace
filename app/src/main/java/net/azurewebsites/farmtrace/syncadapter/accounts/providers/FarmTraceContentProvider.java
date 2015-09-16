package net.azurewebsites.farmtrace.syncadapter.accounts.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/**
 * Created by sebichondo on 9/11/15.
 */
public class FarmTraceContentProvider extends ContentProvider {

    public static final String CONTENT_AUTHORITY = "net.azurewebsites.farmtrace.provider";
    //"com.nobledesignlabs.AfyaBand.syncadapter.providers.AfyaBandContentProvider"
    //com.nobledesignlabs.AfyaBand.syncadapter.providers.AfyaBandContentProvider
    //com.nobledesignlabs.AfyaBand.syncprovider.providers.AfyaBandContentProvider
    public static final Uri CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
