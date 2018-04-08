include dpdk.inc

LICENSE = "LGPLv2 & GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.GPL;md5=751419260aa954499f7abaabaa882bbe\
                    file://LICENSE.LGPL;md5=4fbd65380cdd255951079008b364516c"

SRC_URI[dpdk.md5sum] = "75a2f0922baadc19dc8a222a7547798a"
SRC_URI[dpdk.sha256sum] = "47f43a3ef66cc351ab639ae313830dc08760089c7d227e5f73daa0d6df38b201"

S = "${WORKDIR}/${BPN}-stable-${PV}"
export EXAMPLES_BUILD_DIR = "${RTE_TARGET}"
export ARCHDIR = "generic"

do_configure_prepend () {
	sed -e "s#CONFIG_RTE_LIBRTE_POWER=y#CONFIG_RTE_LIBRTE_POWER=${CONFIG_EXAMPLE_VM_POWER_MANAGER}#" -i ${S}/config/common_linuxapp
}

COMPATIBLE_HOST_linux-gnux32 = "null"
COMPATIBLE_HOST_libc-musl_class-target = "null"
