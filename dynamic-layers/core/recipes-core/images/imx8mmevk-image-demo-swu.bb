require imx8mmevk-swu.inc
ROOTFS_IMAGE = "imx8mmevk-image-demo"

# images and files that will be included in the .swu image
SWUPDATE_IMAGES_FSTYPES[imx8mmevk-image-demo] = ".ext4.gz"

SWUPDATE_SIGNING = "RSA"
SWUPDATE_PRIVATE_KEY = "${KEYSTORAGE}/recipes-support/swupdate-keys/swupdate-keys/priv.pem"
SWUPDATE_PASSWORD_FILE ="${KEYSTORAGE}/recipes-support/swupdate-keys/swupdate-keys/passout"
