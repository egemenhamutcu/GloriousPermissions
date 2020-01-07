package com.ehamutcu.gloriouspermissions.permission

/**
 * Created by Egemen Hamutçu on 2020-01-02.
 *
 * # The Messenger of [PermissionManager]
 *
 * This interface works for invoking essential events performed by [PermissionManager]. This class
 *
 * **MUST** only be implemented by [PermissionActivity], [PermissionFragment] and
 *
 * [PermissionDialogFragment]. It enables them to take necessary actions according to user choices.
 *
 * @author Egemen Hamutçu
 */
interface PermissionListener {
    /**
     * This event is invoked when Android's native permissions are ready to be requested.
     */
    fun onNativePermissionRequestReady(permissions: Array<String>, requestCode: Int)

    /**
     * This event is invoked when all permissions required by [businessRequest] are granted to
     *
     * process the rest of the work.
     */
    fun grantPermissions(businessRequest: BusinessRequest)

    /**
     * This event is invoked when user permanently denied any permissions and should grant
     *
     * those permissions in settings menu by him/her self.
     */
    fun navigateToSettings()

    /**
     * This event is invoked when user denies any permissions or does not want to go further in the
     *
     * process.
     */
    fun deny()

    /**
     * This event is invoked when user faces a rationale dialog or came from settings menu to try
     *
     * again to grant permissions.
     */
    fun retry()
}
