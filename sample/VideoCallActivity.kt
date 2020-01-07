package com.ehamutcu.gloriouspermissions.sample

import android.os.Bundle
import com.ehamutcu.gloriouspermissions.ui.PermissionActivity
import com.ehamutcu.gloriouspermissions.sample.permission.BusinessRequest

class VideoCallActivity: PermissionActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_call)
        checkPermissionsAreGranted(BusinessRequest.VIDEO_CALL, true)
    }

    override fun onPermissionsGranted(businessRequest: BusinessRequest) {
        makeVideoCall()
    }
    
    fun makeVideoCall() {
        // continue process
    }
}
