SUMMARY = "An initramfs image"

LICENSE = "MIT"

inherit core-image
IMAGE_FSTYPES = "cpio.gz.u-boot  ext4.gz"
INITRAMFS_FSTYPES = "cpio.gz.u-boot"
INITRAMFS_MAXSIZE= "500000"

IMAGE_INSTALL:append:imx8mmevk = " \
	kernel-modules u-boot-default-env libubootenv-bin \
	swupdate swupdate-www swupdate-keys u-boot-fw-utils \
	"
