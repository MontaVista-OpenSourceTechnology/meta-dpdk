include dpdk.inc

STABLE = "-stable"
BRANCH = "17.11"
SRCREV = "01dc7ba3ef05afe7e1e52514a8f5d476b1bf67f1"

LICENSE = "LGPLv2 & GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.GPL;md5=751419260aa954499f7abaabaa882bbe\
                    file://LICENSE.LGPL;md5=4fbd65380cdd255951079008b364516c"

SRC_URI += "\
        file://dpdk-16.07-dpdk-fix-for-parellel-make-issue.patch \
        file://dpdk-17.02-dpdk-fix-installation-warning-and-issue.patch \
        file://dpdk-17.11-Fix-strncpy-error-for-GCC8.patch \
"
