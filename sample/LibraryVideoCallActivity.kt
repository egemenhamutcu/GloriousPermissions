package com.ehamutcu.gloriouspermissions.sample

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

@RuntimePermissions
class LibraryVideoCallActivity: AppCompatActivity() {

    private var isComingFromSettings = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_call)
        
        makeVideoCall()
    }
    
    @NeedsPermission(Manifest.permission.CAMERA,
    Manifest.permission.RECORD_AUDIO,
    Manifest.permission.MODIFY_AUDIO_SETTINGS,
    Manifest.permission.READ_PHONE_STATE)
    fun makeVideoCall() {
        // continue process
    }
    
    @OnShowRationale(Manifest.permission.CAMERA,
    Manifest.permission.RECORD_AUDIO,
    Manifest.permission.MODIFY_AUDIO_SETTINGS,
    Manifest.permission.READ_PHONE_STATE)
    fun showRationaleForVideoCall(request: PermissionRequest) {
        showPermissionRationaleDialog(this)
    }

    @OnNeverAskAgain(Manifest.permission.CAMERA,
    Manifest.permission.RECORD_AUDIO,
    Manifest.permission.MODIFY_AUDIO_SETTINGS,
    Manifest.permission.READ_PHONE_STATE)
    fun onPermissionsNeverAskAgain() {
        showPermissionPermanentDenialDialog(this)
    }
    
    private fun showPermissionRationaleDialog(activity: Activity) {
        if (!activity.isFinishing) {
            AlertDialog.Builder(activity)
                    .setTitle(R.string.permission_title_application)
                    .setMessage(R.string.permission_rationale_video_call)
                    .setCancelable(false)
                    .setPositiveButton(R.string.retry) { _, _ ->
                        checkPermission()
                    }
                    .setNegativeButton(R.string.cancel) { dialog, _ ->
                        if (!activity.isFinishing) {
                            dialog.dismiss()
                            finish()
                        }
                    }
                    .show()
        }
    }
    
    private fun showPermissionPermanentDenialDialog(activity: Activity) {
        if (!activity.isFinishing) {
            AlertDialog.Builder(activity)
                    .setTitle(R.string.permission_title_application)
                    .setMessage(R.string.permission_permanent_denial_video_call)
                    .setCancelable(false)
                    .setPositiveButton(R.string.settings) { _, _ ->
                        isComingFromSettings = true
                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", packageName, null))
                        startActivity(intent)
                    }
                    .setNegativeButton(R.string.cancel) { dialog, _ ->
                        if (!activity.isFinishing) {
                            dialog.dismiss()
                            finish()
                        }
                    }
                    .show()
        }
    }
    
    override fun onResume() {
        super.onResume()f
        if (isComingFromSettings) {
            isComingFromSettings = false
            if (!activity.isFinishing) {
                AlertDialog.Builder(activity)
                        .setTitle(R.string.retry)
                        .setMessage(R.string.retry_business)
                        .setCancelable(false)
                        .setPositiveButton(R.string.yes) { _, _ ->
                            checkPermission()
                        }
                        .setNegativeButton(R.string.no) { dialog, _ ->
                            if (!activity.isFinishing) {
                                dialog.dismiss()
                                finish()
                            }
                        }
                        .show()
            }
        }
    }
    
    companion object {
        private const val VIDEO_CALL_PERMISSION_REQUEST = 1
    }
}
