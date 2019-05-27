include dpdk.inc

SRCREV = "a5dce55556286cc56655320d975c67b0dbe08693"

LICENSE = "BSD-3-Clause & LGPLv2.1 & GPLv2"
LIC_FILES_CHKSUM = "file://license/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://license/lgpl-2.1.txt;md5=4b54a1fd55a448865a0b32d41598759d \
                    file://license/bsd-3-clause.txt;md5=0f00d99239d922ffd13cabef83b33444"

SRC_URI += "\
            file://dpdk-16.04-dpdk-enable-ip_fragmentation-in-common_base-config.patch \
            file://0001-examples-Fix-maybe-uninitialized-warning.patch \
            "
