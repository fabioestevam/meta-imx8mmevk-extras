LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# images to build before building swupdate image
IMAGE_DEPENDS_append = " ${ROOTFS_IMAGE}"

inherit swupdate

SRC_URI += "\
    file://sw-description \
"

SWUPDATE_IMAGES_append = " ${ROOTFS_IMAGE}"
