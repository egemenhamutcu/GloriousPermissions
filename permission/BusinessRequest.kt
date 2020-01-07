package com.ehamutcu.gloriouspermissions.permission

/**
 * Created by Egemen Hamutçu on 2019-12-27.
 *
 * # 'What are you going to do with these permissions?'
 * Each one of this enum class values is an answer to this question.
 *
 * It reflects your business needs.
 *
 * @author Egemen Hamutçu
 */
enum class BusinessRequest {
    ADD_PHOTO_TO_ADVERT_FROM_CAMERA,
    READ_QR_FROM_CAMERA,
    TAKE_PHOTO_FOR_FIRM_LOGO_FROM_CAMERA,
    ADD_PHOTO_TO_ADVERT_FROM_GALLERY,
    PICK_PHOTO_FOR_FIRM_LOGO_FROM_GALLERY,
    LOCATION_TO_SHOW_ON_MAP,
    VIDEO_CALL;
}
