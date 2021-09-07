OpenEmbedded demo extras layer for the i.MX8MM EVK
==================================================

This layer provides demo extras and examples for
the i.MX8MM EVK.

Dependencies
------------

This layer depends on:

* URI: git://git.yoctoproject.org/poky
  - branch: dunfell
  - layers: meta

* meta-imx8mmevk-bsp
  - branch: dunfell

Building image
--------------

A good starting point for setting up the build environment is is the official
Yocto Project wiki.

* https://www.yoctoproject.org/docs/3.1/brief-yoctoprojectqs/brief-yoctoprojectqs.html

Before attempting the build, the following metalayer git repositories shall
be cloned into a location accessible to the build system and a branch listed
below shall be checked out. The examples below will use /path/to/OE/ as a
location of the metalayers.

* git://git.yoctoproject.org/poky					(branch: dunfell)
* https://source.denx.de/denx/meta-mainline-common.git		(branch: dunfell-3.1)
* https://github.com/sbabic/meta-swupdate.git				(branch: dunfell)
* https://github.com/fabioestevam/meta-imx8mmevk-bsp.git		(branch: dunfell)
* https://github.com/fabioestevam/meta-imx8mmevk-extras.git		(branch: dunfell)

Additional optional layers handled by means of dynamic layers:
* git://github.com/openembedded/meta-openembedded.git		(branch: dunfell)
* git://git.openembedded.org/meta-python2				(branch: dunfell)

With all the source artifacts in place, proceed with setting up the build
using oe-init-build-env as specified in the Yocto Project wiki.

In addition to the content in the wiki, the aforementioned metalayers shall
be referenced in bblayers.conf in this order:

```
BBLAYERS ?= " \
   /path/to/OE/poky/meta \
   /path/to/OE/meta-python2 \
   /path/to/OE/meta-openembedded/meta-oe \
   /path/to/OE/meta-openembedded/meta-networking \
   /path/to/OE/meta-openembedded/meta-python \
   /path/to/OE/meta-mainline-common \
   /path/to/OE/meta-imx8mmevk-bsp \
   /path/to/OE/meta-imx8mmevk-extras \
   "
```

The following specifics should be placed into local.conf:

```
MACHINE = "imx8mmevk"
DISTRO ?= "imx8mmevklinux"
```

Both local.conf and bblayers.conf are included verbatim in full at the end
of this readme.

Once the configuration is complete, a full demo system image suitable for
evaluation can be built using:

```
$ bitbake imx8mmevk-image-demo
```

Once the build completes, the images are available in:

```
tmp/deploy/images/imx8mmevk/
```

The SD card image is specifically in:

```
imx8mmevk-image-demo-imx8mmevk.wic.gz
```

And shall be written to the SD card using dd:

```
$ gunzip imx8mmevk-image-demo-imx8mmevk.wic.gz
$ dd if=imx8mmevk-image-demo-imx8mmevk.wic of=/dev/sdX; sync
```

Example local.conf
------------------
```
MACHINE = "imx8mmevk"
DL_DIR = "/path/to/OE/downloads"
DISTRO ?= "imx8mmevklinux"
PACKAGE_CLASSES ?= "package_rpm"
EXTRA_IMAGE_FEATURES = "debug-tweaks"
USER_CLASSES ?= "buildstats image-mklibs image-prelink"
PATCHRESOLVE = "noop"
BB_DISKMON_DIRS = "\
    STOPTASKS,${TMPDIR},1G,100K \
    STOPTASKS,${DL_DIR},1G,100K \
    STOPTASKS,${SSTATE_DIR},1G,100K \
    STOPTASKS,/tmp,100M,100K \
    ABORT,${TMPDIR},100M,1K \
    ABORT,${DL_DIR},100M,1K \
    ABORT,${SSTATE_DIR},100M,1K \
    ABORT,/tmp,10M,1K"
PACKAGECONFIG_append_pn-qemu-native = " sdl"
PACKAGECONFIG_append_pn-nativesdk-qemu = " sdl"
CONF_VERSION = "1"
```

Example bblayers.conf
---------------------
```
# LAYER_CONF_VERSION is increased each time build/conf/bblayers.conf
# changes incompatibly
POKY_BBLAYERS_CONF_VERSION = "2"

BBPATH = "${TOPDIR}"
BBFILES ?= ""

BBLAYERS ?= " \
	/path/to/OE/poky/meta \
	/path/to/OE/meta-python2 \
	/path/to/OE/meta-openembedded/meta-oe \
	/path/to/OE/meta-openembedded/meta-networking \
	/path/to/OE/meta-openembedded/meta-python \
	/path/to/OE/meta-mainline-common \
	/path/to/OE/meta-swupdate \
	/path/to/OE/meta-imx8mmevk-bsp \
	/path/to/OE/meta-imx8mmevk-extras \
	"

```
