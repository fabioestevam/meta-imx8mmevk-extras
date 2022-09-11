FILESEXTRAPATHS:append := "${THISDIR}/${PN}:"

SRC_URI:append = " \
     file://swupdate.cfg \
     file://defconfig \
     file://09-swupdate-args \
     file://hwrevision \
     "

do_install:append() {
    install -d ${D}${sysconfdir}
    install -m 644 ${WORKDIR}/09-swupdate-args ${D}${libdir}/swupdate/conf.d/
    install -m 644 ${WORKDIR}/swupdate.cfg ${D}${sysconfdir}
}
