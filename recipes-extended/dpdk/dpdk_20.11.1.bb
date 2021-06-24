include dpdk.inc

SRC_URI += " \
            file://0001-meson.build-march-and-mcpu-already-passed-by-Yocto.patch \
            file://0001-ifpga-meson-Fix-finding-librt-using-find_library.patch \
"

STABLE = "-stable"
BRANCH = "20.11"
SRCREV = "b1e71cf43153cca07db6cbb69fdca030ccf52234"
S = "${WORKDIR}/git"

# kernel module is provide by dpdk-module recipe, so disable here
EXTRA_OEMESON = " -Denable_kmods=false \
                -Dexamples=all \
"

COMPATIBLE_MACHINE = "null"
COMPATIBLE_HOST_libc-musl_class-target = "null"
COMPATIBLE_HOST_linux-gnux32 = "null"

PACKAGECONFIG ??= " "
PACKAGECONFIG[afxdp] = ",,libbpf"
PACKAGECONFIG[libvirt] = ",,libvirt"

RDEPENDS_${PN} += "pciutils python3-core"
RDEPENDS_${PN}-examples += "bash"
DEPENDS = "numactl"

inherit meson

INSTALL_PATH = "${prefix}/share/dpdk"

do_install_append(){
    # remove  source files
    rm -rf ${D}/${INSTALL_PATH}/examples/*

    # Install examples
    install -m 0755 -d ${D}/${INSTALL_PATH}/examples/
    for dirname in ${B}/examples/dpdk-*
    do
        if [ ! -d ${dirname} ] && [ -x ${dirname} ]; then
            install -m 0755 ${dirname} ${D}/${INSTALL_PATH}/examples/
        fi
    done

}

PACKAGES =+ "${PN}-examples ${PN}-tools"

FILES_${PN} = " ${bindir}/dpdk-testpmd \
		 ${bindir}/dpdk-proc-info \
		 ${libdir}/*.so* \
		 ${libdir}/dpdk/pmds-21.0/*.so* \
		 "
FILES_${PN}-examples = " \
	${prefix}/share/dpdk/examples/* \
	"

FILES_${PN}-tools = " \
    ${bindir}/dpdk-pdump \
    ${bindir}/dpdk-test \
    ${bindir}/dpdk-test-* \
    ${bindir}/dpdk-*.py \
    "

CVE_PRODUCT = "data_plane_development_kit"

INSANE_SKIP_${PN} = "dev-so"
