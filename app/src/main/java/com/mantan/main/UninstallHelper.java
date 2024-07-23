package com.mantan2.main;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;

public class UninstallHelper {

    public static void uninstallSelf(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String packageName = context.getPackageName();
            Uri packageURI = Uri.parse("package:" + packageName);
            Intent intent = new Intent(Intent.ACTION_DELETE, packageURI);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } else {
            throw new UnsupportedOperationException("Uninstalling self is not supported on devices below Lollipop.");
        }
    }
}