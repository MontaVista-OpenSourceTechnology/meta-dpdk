include dpdk.inc

STABLE = "-stable"
BRANCH = "17.11"
SRCREV = "63d5c53b845d8360c0106374ce76eef9b5478c60"

LICENSE = "LGPLv2 & GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.GPL;md5=751419260aa954499f7abaabaa882bbe\
                    file://LICENSE.LGPL;md5=4fbd65380cdd255951079008b364516c"

SRC_URI += "\
        file://dpdk-16.07-dpdk-fix-for-parellel-make-issue.patch \
        file://dpdk-17.11-mk-disable-warning-for-packed-member-pointer.patch \
"

do_install_append () {
        # Remove the unneeded dir
        rm -rf ${D}/${INSTALL_PATH}/${RTE_TARGET}/app
}
