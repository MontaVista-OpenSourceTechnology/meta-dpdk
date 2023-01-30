include dpdk.inc

STABLE = "-stable"
BRANCH = "18.02"
SRCREV = "92924b207b124c156f7b6dff75110d6af83d971f"

LICENSE = "BSD & LGPLv2 & GPLv2"
LIC_FILES_CHKSUM = "file://license/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://license/lgpl-2.1.txt;md5=4b54a1fd55a448865a0b32d41598759d \
                    file://license/bsd-3-clause.txt;md5=0f00d99239d922ffd13cabef83b33444"

SRC_URI += "\
            file://dpdk-16.04-dpdk-enable-ip_fragmentation-in-common_base-config.patch \
            file://0001-examples-Fix-maybe-uninitialized-warning.patch \
            file://CVE-2022-0669.patch \
            file://0001-dpdk-failed-to-build-with-vhost_user.c-error.patch \
            file://0001-dpdk-failed-to-build-with-vhost_user.c-error-01.patch \
            "
