package com.ehamutcu.gloriouspermissions.permission

/**
 * Created by Egemen Hamutçu on 2019-12-27.
 *
 * This class is a reflection of Android's permissions remaining on the application's settings menu.
 *
 * Values are multiplied by 2 with the previous value so this approach enables us to do bitwise
 *
 * operations.
 *
 * @author Egemen Hamutçu
 */
enum class PermissionRequest(val request: Int) {
    CAMERA(1),
    STORAGE(2),
    LOCATION(4),
    MICROPHONE(8),
    PHONE(16);

    /**
     * It reflects native [Manifest.permission]s. It is used to define what [Manifest.permission]s
     *
     * are needed to take permission according to [PermissionRequest]
     *
     * @return an [Array] of [String]s which contains [Manifest.permission]s for [PermissionRequest]
     *
     * @author Egemen Hamutçu
     */
    fun getPermissionTextArray(): Array<String> {
        return when (this) {
            CAMERA -> arrayOf(Manifest.permission.CAMERA)
            STORAGE -> arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            LOCATION -> arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
            MICROPHONE -> arrayOf(Manifest.permission.RECORD_AUDIO, Manifest.permission.MODIFY_AUDIO_SETTINGS)
            PHONE -> arrayOf(Manifest.permission.READ_PHONE_STATE)
        }
    }

    companion object {
        /**
         * It is reverse of [getPermissionTextArray] method. It checks [permission] and defines what
         *
         * [PermissionRequest] reflects given [Manifest.permission].
         *
         * @param permission must be one of [Manifest.permission]'s [String] value.
         *
         * @return a [PermissionRequest] value according to [permission]. If [permission] is not
         *
         * one of [Manifest.permission]'s value or it is not used to take permissions by any of
         *
         * [PermissionRequest], it will return null.
         *
         * @see [Manifest.permission]
         *
         * @author Egemen Hamutçu
         */
        fun getPermissionRequestFromText(permission: String): PermissionRequest? {
            return when (permission) {
                Manifest.permission.CAMERA -> CAMERA
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE -> STORAGE
                Manifest.permission.ACCESS_FINE_LOCATION -> LOCATION
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.MODIFY_AUDIO_SETTINGS -> MICROPHONE
                Manifest.permission.READ_PHONE_STATE -> PHONE
                else -> null
            }
        }
    }
}
