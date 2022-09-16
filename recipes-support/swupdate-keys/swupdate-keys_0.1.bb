LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PROVIDES = "swupdate-keys"

SRC_URI = "file://public.pem \
          "

do_install() {
	install -d ${D}${sysconfdir}/system
	install -m 644 ${WORKDIR}/public.pem ${D}${sysconfdir}/swupdate-key.pem
}

FILES_${PN} = "${sysconfdir}"
