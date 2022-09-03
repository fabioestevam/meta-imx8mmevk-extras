SUMMARY = "An image with various examples and demos"

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL:append_imx8mmevk = " \
	kernel-modules u-boot-default-env libubootenv-bin \
	ca-certificates iw linux-firmware-iwlwifi  linux-firmware-ibt \
	i2c-tools canutils systemd-conf openssl-engines rng-tools \
	devmem2 \
	swupdate swupdate-www swupdate-tools u-boot-fw-utils \
	"
