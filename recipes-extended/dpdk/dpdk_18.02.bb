include dpdk.inc

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
