include recipes-extended/dpdk/dpdk.inc

STABLE = "-stable"
BRANCH = "18.11"
SRCREV = "e6f0c6c7debe7693e3b80d721842841d56be42e7"

LICENSE = "BSD-3-Clause & LGPLv2.1 & GPLv2"
LIC_FILES_CHKSUM = "file://license/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://license/lgpl-2.1.txt;md5=4b54a1fd55a448865a0b32d41598759d \
                    file://license/bsd-3-clause.txt;md5=0f00d99239d922ffd13cabef83b33444"
SRC_URI += "\
    file://dpdk-16.04-dpdk-enable-ip_fragmentation-in-common_base-config.patch \
    file://0001-examples-Fix-maybe-uninitialized-warning.patch \
    file://dpdk-18.11.4-dpdk-fix-for-parellel-make-issue.patch \
"

do_install_append () {
    # Remove the unneeded dir
    rm -rf ${D}/${INSTALL_PATH}/${RTE_TARGET}/app
}
