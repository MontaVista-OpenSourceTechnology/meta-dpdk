include dpdk.inc

SRCREV = "92924b207b124c156f7b6dff75110d6af83d971f"

LICENSE = "BSD & LGPLv2 & GPLv2"
LIC_FILES_CHKSUM = "file://license/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://license/lgpl-2.1.txt;md5=4b54a1fd55a448865a0b32d41598759d \
                    file://license/bsd-3-clause.txt;md5=0f00d99239d922ffd13cabef83b33444"

SRC_URI += "\
            file://dpdk-16.04-dpdk-enable-ip_fragmentation-in-common_base-config.patch \
            file://0001-examples-Fix-maybe-uninitialized-warning.patch \
            "

SRC_URI[dpdk.md5sum] = "49d08ced0a978a71cc3942af5cf51b95"
SRC_URI[dpdk.sha256sum] = "f1210310fd5f01a3babe3a09d9b3e5a9db791c2ec6ecfbf94ade9f893a0632b8"

export EXAMPLES_BUILD_DIR = "${RTE_TARGET}"
export ARCHDIR = "generic"

do_configure_prepend () {
	sed -e "s#CONFIG_RTE_LIBRTE_POWER=y#CONFIG_RTE_LIBRTE_POWER=${CONFIG_EXAMPLE_VM_POWER_MANAGER}#" -i ${S}/config/common_linuxapp
}

COMPATIBLE_HOST_linux-gnux32 = "null"
COMPATIBLE_HOST_libc-musl_class-target = "null"
