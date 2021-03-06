#
# Copyright (C) 2019 Wind River Systems, Inc.
#
#  Licensed under the Apache License, Version 2.0 (the "License");
#  you may not use this file except in compliance with the License.
#  You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License.

DESCRIPTION = "This RPM contains code and support files for installing start menu"
HOMEPAGE = "https://gerrit.akraino.org/r/ta/start-menu"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PROTOCOL = "https"
BRANCH = "master"
SRCREV = "b375099e93d04ad442dc74dedba26facbaf48c62"
S = "${WORKDIR}/git/"

SRC_URI = "git://gerrit.akraino.org/r/ta/start-menu.git;protocol=${PROTOCOL};rev=${SRCREV};branch=${BRANCH}"

inherit akraino-version systemd 

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "start-menu.service"

DEPENDS = "rsync-native"

do_install() {
       install -d ${D}/opt/start-menu/
       install -d ${D}${sysconfdir}/userconfig/
       install -d ${D}${systemd_system_unitdir}

       rsync -rlpD ${S}/src/* ${D}/opt/start-menu
       rsync -rlpD ${S}/services/start-menu.service ${D}${systemd_system_unitdir}/start-menu.service

       sed -i -e "s,${bindir}/systemctl,${base_bindir}/systemctl," \
              -e "s/syslog-ng/rsyslog/" \
              ${D}${systemd_system_unitdir}/start-menu.service

       sed -i -e "s,${base_bindir}/os-net-config,${bindir}/os-net-config," \
              ${D}/opt/start-menu/start_menu.sh
}

FILES_${PN} += "/opt"

RDEPENDS_${PN} = " \
    dialog \
    bash \
    ipcalc \
"
